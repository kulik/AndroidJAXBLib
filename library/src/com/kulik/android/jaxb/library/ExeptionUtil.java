/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library;

/**
 * Created by kulik on 1/9/14.
 */
public class ExeptionUtil {
    public static void processInstantiationExceptions(Throwable e, Class clazz) throws IllegalAccessException {
        throw new IllegalAccessException(e.getMessage() + " class name:" +
                ((clazz != null) ? clazz.getName() : "") + " maybe you use this class as inner " +
                "class, so we cant instantiate that outer from that, or maybe private modifier exist");

    }
}
