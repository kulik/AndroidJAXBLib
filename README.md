# AndroidJAXBLib

Android JAXB - lightweight annotation based library of the JAX-B standart. This is not a build from javaEE libs. it is My own realezation of the popular standart. 

Now library supports two marshaller adapters JSON and XML. So you can switch parsing or compousing from one to other in simple way. 

Main Warn. The DOM model used in this library. So as for android main porpouses is a docs with size not more 9- 10 MB. So PAY Attantion that Android is lightwaight client.

## Gradle dependency

The simplest way to add AndroidJaxb to your project is via Gradle, you just need to add the following dependency to your build.gradle:

    dependencies {  
        repositories {
            mavenCentral()
        }
        compile 'com.github.kulik:android-jaxb:+'
    }
    
This means that you will always use the latest version available.

if you want to use Maven, you need other pice of your pom.xml

    <dependency>
       <groupId>com.github.kulik</groupId>
       <artifactId>android-jaxb</artifactId>
       <version>0.3</version>
       <type>aar</type>
    </dependency>
    
## Examples

This library has full test coverage. So TESTS - is a greatest examples. Also you can read other docs for JavaEE JAX-B implementations.
    
## Supported annotations

@XmlElement
@XmlElementWrapper
@XmlJavaTypeAdapter
@XmlAttribute
@XmlValue
@XmlRootElement



[Russian DOC](README_RU.md)



Available soon [English DOC](README_ENG.md)

