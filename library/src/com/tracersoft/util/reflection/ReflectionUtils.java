package com.tracersoft.util.reflection;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Stack;

/**
 * Alex Tracer (c) 2009
 */
public class ReflectionUtils {

    /**
     * Для некоторого класса (или интерфейса) определяет,
     * каким классом был параметризован один из его предков (реализующих классов) с generic-параметрами.
     *
     * @param actualClass    анализируемый класс
     * @param genericClass   класс (или интерфейс), для которого определяется значение параметра
     * @param parameterIndex номер параметра
     * @return класс, являющийся параметром с индексом parameterIndex в genericClass
     */
    public static Class getGenericParameterClass(final Class actualClass, final Class genericClass, final int parameterIndex) {
        // Прекращаем работу если genericClass не является предком actualClass.
        if (!genericClass.isAssignableFrom(actualClass) || genericClass.equals(actualClass)) {
            throw new IllegalArgumentException("Class " + genericClass.getName() + " is not a superclass of "
                    + actualClass.getName() + ".");
        }
        final boolean isInterface = genericClass.isInterface();

        // Нам нужно найти класс, для которого непосредственным родителем будет genericClass.
        // Мы будем подниматься вверх по иерархии, пока не найдем интересующий нас класс.
        // В процессе поднятия мы будем сохранять в genericClasses все классы - они нам понадобятся при спуске вниз.

        // Проейденные классы - используются для спуска вниз.
        Stack<ParameterizedType> genericClasses = new Stack<ParameterizedType>();

        // clazz - текущий рассматриваемый класс
        Class clazz = actualClass;

        while (true) {
            Type genericInterface = isInterface ? getGenericInterface(clazz, genericClass) : null;
            Type currentType = genericInterface != null ? genericInterface : clazz.getGenericSuperclass();

            boolean isParameterizedType = currentType instanceof ParameterizedType;
            if (isParameterizedType) {
                // Если предок - параметризованный класс, то запоминаем его - возможно он пригодится при спуске вниз.
                genericClasses.push((ParameterizedType) currentType);
            } else {
                // В иерархии встретился непараметризованный класс. Все ранее сохраненные параметризованные классы будут бесполезны.
                genericClasses.clear();
            }
            // Проверяем, дошли мы до нужного предка или нет.
            Type rawType = isParameterizedType ? ((ParameterizedType) currentType).getRawType() : currentType;
            if (!rawType.equals(genericClass)) {
                // genericClass не является непосредственным родителем для текущего класса.
                // Поднимаемся по иерархии дальше.
                clazz = (Class) rawType;
            } else {
                // Мы поднялись до нужного класса. Останавливаемся.
                break;
            }
        }

        // Нужный класс найден. Теперь мы можем узнать, какими типами он параметризован.
        Type result = genericClasses.pop().getActualTypeArguments()[parameterIndex];

        while (result instanceof TypeVariable && !genericClasses.empty()) {
            // Похоже наш параметр задан где-то ниже по иерархии, спускаемся вниз.

            // Получаем индекс параметра в том классе, в котором он задан.
            int actualArgumentIndex = getParameterTypeDeclarationIndex((TypeVariable) result);
            // Берем соответствующий класс, содержащий метаинформацию о нашем параметре.
            ParameterizedType type = genericClasses.pop();
            // Получаем информацию о значении параметра.
            result = type.getActualTypeArguments()[actualArgumentIndex];
        }

        if (result instanceof TypeVariable) {
            // Мы спустились до самого низа, но даже там нужный параметр не имеет явного задания.
            // Следовательно из-за "Type erasure" узнать класс для параметра невозможно.
            throw new IllegalStateException("Unable to resolve type variable " + result + "."
                    + " Try to replace instances of parametrized class with its non-parameterized subtype.");
        }

        if (result instanceof ParameterizedType) {
            // Сам параметр оказался параметризованным.
            // Отбросим информацию о его параметрах, она нам не нужна.
            result = ((ParameterizedType) result).getRawType();
        }

        if (result == null) {
            // Should never happen. :)
            throw new IllegalStateException("Unable to determine actual parameter type for "
                    + actualClass.getName() + ".");
        }

        if (!(result instanceof Class)) {
            // Похоже, что параметр - массив, примитивный типи, интерфейс или еще-что-то, что не является классом.
            throw new IllegalStateException("Actual parameter type for " + actualClass.getName() + " is not a Class.");
        }

        return (Class) result;
    }

    public static int getParameterTypeDeclarationIndex(final TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();

        // Ищем наш параметр среди всех параметров того класса, где определен нужный нам параметр.
        TypeVariable[] typeVariables = genericDeclaration.getTypeParameters();
        Integer actualArgumentIndex = null;
        for (int i = 0; i < typeVariables.length; i++) {
            if (typeVariables[i].equals(typeVariable)) {
                actualArgumentIndex = i;
                break;
            }
        }
        if (actualArgumentIndex != null) {
            return actualArgumentIndex;
        } else {
            throw new IllegalStateException("Argument " + typeVariable.toString() + " is not found in "
                    + genericDeclaration.toString() + ".");
        }
    }

    public static Type getGenericInterface(final Class sourceClass, final Class genericInterface) {
        Type[] types = sourceClass.getGenericInterfaces();
        for (Type type : types) {
            if (type instanceof Class) {
                if (genericInterface.isAssignableFrom((Class) type)) {
                    return type;
                }
            } else if (type instanceof ParameterizedType) {
                if (genericInterface.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
            }
        }
        return null;
    }
}
