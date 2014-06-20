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
package com.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.Collections;
import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Response4 {
    @XmlElement(name = "data")
    public List<State> mStatesList;

    public static class State implements Value<Integer> {
        @XmlElement(name = "areaID")
        private final Integer mId;

        @XmlElement(name = "name")
        private final String mName;

        List<Subarea> mSubareas;

        public State() {
            this(0, "");
        }

        public State(int id, String name) {
            mId = id;
            mName = name;
            mSubareas = Collections.emptyList();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (getClass() != o.getClass()) return false;
            State state = (State) o;
            return mId.equals(state.mId);
        }

        @Override
        public Integer getValue() {
            return mId;
        }

        @Override
        public String getName() {
            return mName;
        }

        @Override
        public String toString() {
            return mName;
        }

        public List<Subarea> getSubareas() {
            return mSubareas;
        }

        public void setSubareas(List<Subarea> subareas) {
            mSubareas = subareas;
        }
    }

    public static class Subarea implements Value<Integer> {
        @XmlElement(name = "areaID")
        private final Integer mId;

        @XmlElement(name = "name")
        private final String mName;

        public Subarea() {
            this(0, "");
        }

        public Subarea(int value) {
            this(value, "");
        }

        public Subarea(int value, String name) {
            mId = value;
            mName = name;
        }

        @Override
        public Integer getValue() {
            return mId;
        }

        @Override
        public String getName() {
            return mName;
        }

        public String toString() {
            return mName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (getClass() != o.getClass()) return false;
            Subarea other = (Subarea) o;
            return mId.equals(other.mId);
        }
    }


}
