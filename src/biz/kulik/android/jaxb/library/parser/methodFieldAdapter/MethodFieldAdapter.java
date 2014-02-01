package biz.kulik.android.jaxb.library.parser.methodFieldAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 5:07 PM
 */
public interface MethodFieldAdapter {

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType);

    public boolean isValidForProcessing();

    public <A extends Annotation> A getAnnotation(Class<A> annotationType);

    public void setAccessible(boolean flag);

    public Object put(Object receiver, Object args) throws InvocationTargetException, IllegalAccessException;

    public Type getGenericParameterTypes();

    public boolean equals(MethodFieldAdapter o1);

    public Class<?> getInputType();

    public Class<?> getOutputType();

    public Class<?> getClassClass();

    public Package getPackage();

    public String getSignature();

}