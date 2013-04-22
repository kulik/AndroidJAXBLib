# AndroidJAXBLib
http://kulik.no-ip.org:8080/job/AndroidJAXBLib/

## Введение
В процессе паралельной работы с андроидом и серверными технологиями, 
было обнаруженно неудобство работы с маршалингом и демаршалингом в 
Андроиде (далее Андрюша).
Паралельно наблюдалось изящность маршалинга и демаршалинга данныех на серверной стороне 
при помощи JAXB. Особенно хорошей возможностью является однообразная работа как с JSON так и с XML.
Попробовав найти что-то подобное под Андрюшу, наткнулся на GSON (гугловская либа для работы с JSON), 
и Xstream (http://xstream.codehaus.org/). 
Далие была произведена попытка портировать JAXB с JavaEE под Андрюшу, нехватало классов из javax.*.
Добавив эти классы DEX сказал что мы пытаемся собрать Android core library.
If you really intend to build a core library -- which is only appropriate as
part of creating a full virtual machine binary, as opposed to compiling an
application -- then use the "--core-library" option to suppress this error
Все просто его нужно собирть с ключем --core-library как нам дружелюбно предлагает dex компоновщик.
При этом объем приложения с либой в комплекте сразуже вырос на 11.5 МВ. 
Както это многовато для простого маршалинга, в мобильном приложении.
Так выстрелила идея реализовать упрощенный стандарт JAXB для Андрюши.
Также родителем идеи были мысли о простом переносе серверных прокси классов в проект мобильного приложения, 
и изменив в них только импорт.

### Родоначальники идеи:
  [Yevgen Kulik](http://ua.linkedin.com/in/yevgenkulik)<br />
  [Dmytro Korablyov](http://ua.linkedin.com/in/dmytrokorablyov)

##Возможности

На данный момент поддерживаются следующие анотации:
<ol>
  <li> @XmlElement
  <li> @XmlAttribute
  <li> @XmlRootElement
</ol>
  

##План
<ol>
  <li> default для @XmlElement(default=25) @XmlAttribute(default=-1)
  <li> парсер для примитивных типов джава.(пока примитивные типы только компоузятся)
  <li> @XmlJavaTypeAdapter annotation implemntation;<br />
  <li> @XmlJavaTypeAdapters  anotation (class, package level annotation);<br />
  <li> создания парсера, который на этапе предкомпиляции будет генерить парсеры и компоузеры;<br />
  <li> Stream parser implementation;<br />
</ol>

##How to use
К примеру мы имеем иерархию классов в которую мы хотим демаршализировать XML.
К примеру возьмем АПИ Википедии и поиск "sun"
<code>
<SearchSuggestion xmlns="http://opensearch.org/searchsuggest2" version="2.0">
    <Query xml:space="preserve">sun</Query>
    <Section>

            <Item>
                <Image source="http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg" width="50" height="45"/>
                <Text xml:space="preserve">Sun1</Text>
                <Description xml:space="preserve">
                    The Sun is the star at the center of the Solar System. It is almost perfectly spherical and consists of hot plasma interwoven with magnetic fields.
                </Description>
                <Url xml:space="preserve">http://en.wikipedia.org/wiki/Sun</Url>
            </Item>
            <Item>
                <Image source="http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_1%2C_2010.jpg" width="50" height="45"/>
                <Text xml:space="preserve">Sun2</Text>
                <Description xml:space="preserve">
                            The Sun is the star at the center of the Solar System. It is almost perfectly spherical and consists of hot plasma interwoven with magnetic fields.
                </Description>
                <Url xml:space="preserve">http://en.wikipedia.org/wiki/Sun1111</Url>
            </Item>
            <Item>
              <Image source="http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/August_1%2C_2010.jpg" width="50" height="45"/>
              <Text xml:space="preserve">Sun3</Text>
              <Description xml:space="preserve">
                        The Sun is the star at the center of the Solar System. It is almost perfectly spherical and consists of hot plasma interwoven with magnetic fields.
              </Description>
              <Url xml:space="preserve">http://en.wikipedia.org/wiki/Sun2222</Url>
            </Item>

    </Section>
</SearchSuggestion>
</code>

Тогда прокси классы будут выглядеть
<code>
public class SearchSuggestion {

    @XmlElement(name="Section")
    public Section section;

    public static class Section {
        
        @XmlElement(name="Item")
        public List<Item> item;

        public static class Item {

            @XmlElement(name = "Text")
            public String title;
            
            @XmlElement(name = "Image")
            public Image image;

            @XmlElement(name = "Url")
            public String url;
        }
    }
}
</code>

Теперь остается вызвать сам процесс демаршалинга
<code>
  
        // получение стрима xml
        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_1_xml);
        // создание парсера для XML
        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);

        SearchSuggestion se;
        // собственно получение объекта демаршалинга
        //тут указывает в какой рут класс будем парсить, и инпут стрим с которого парсить
        se = parser.parse(SearchSuggestion.class, inputStream);
</code>

Теперь допустим нам надо отпарсить в такуюже структуру из JSON
~~~~~~
{
  "Query":{ },
   "Section":{
      "Item":[
         {
            "Image":{
               "source":"http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg"
            },
            "Text":"Sun1",
            "Description":"http://en.wikipedia.org/wiki/Sun",
            "Url":"http://en.wikipedia.org/wiki/Sun"
         },
         {
            "Image":{
               "source":"http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_1%2C_2010.jpg"
            },
            "Text":"Sun2",
            "Description":"http://en.wikipedia.org/wiki/SunDescription",
            "Url":"http://en.wikipedia.org/wiki/Sun1111"
         },
         {
            "Image":{
               "source":"http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/August_1%2C_2010.jpg"
            },
            "Text":"Sun3",
            "Description":"http://en.wikipedia.org/wiki/SunDescription",
            "Url":"http://en.wikipedia.org/wiki/Sun2222"
         }
      ]
   }
}
~~~~~~
</code>
</div>

в нашем коде меняется только одна инициализирующая константа<br/>
<code>UnMarshalerTypes.XMLAdapter > UnMarshalerTypes.JSONAdapter</code>

Другие примеры вы можете найти в JUnit Tests  (AndroidJAXBLib/Tests)

### Нет человека нет проблемы.
Частой ситуацией является "падание" парсера, при отсутствии необходимых данных. 
Все просто наш парсер выдаст установит значение null в переменную, и пойдет дальше.
Что же происходит с примитивными типами Java(не объектами). Как известно они не 
могут быть null. Для этого как и в Jersey у нас предусмотрен параметр в анатациях 
@XmlElement(default=25) @XmlAttribute(default=-1)



<del>## Comparing with gson
гсон работаер только с джсон, имеет свои собственные анотации, в то время как андроидджаксблиб практически полностью совместима с стандартом джахб. это означает что если вы имеете доступ к серверу который писали на джава с использованием джахб, то вы можете напрямую использовать серверные прокси классы изменив толко блок импорта. 
что касается скорости работы то джах б ли

<del>##Comparing with simple parsing using JSONObject, JSONArray,
сложность такого алгоритма, в том, что при изменении структуры данных, требуется менять как парсер, так и сторайдж в который мы парсим, при использовании
по сравнениюс гугл либой Гсон, андроидДжахБЛиб имеет такойже синтаксис как и джах б либ, но написан специально для мобильной платформы(размер ядра библиотеки джах б либ 9.5мб, что не сочитается с парадигмой мобильных платформ). на данный момент работает два типа анотаций @хмлелемент и @хмлатрибут</del>
