# AndroidJAXBLib

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/kulik/AndroidJAXBLib?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

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

## Library Logs

Log level from the library can be configured by call 

    JaxbConfig.setLogLevel(Log.Level.ERROR); 
    
You can use different values for diagnosis the problem.

[Russian DOC](README_RU.md)
  


Available soon [English DOC](README_ENG.md)

## License

Copyright 2012-2014 Yevgen Kulik

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
