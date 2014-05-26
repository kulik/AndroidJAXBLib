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
package com.kulik.android.jaxb.library.parserTest.TestXMSNL;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;

public class EWSId {

    public EWSId() {
    }

    public EWSId(String id, String changeKey) {
        this.id = id;
        this.changeKey = changeKey;
    }

    @XmlAttribute(name = "Id")
    public String id;

    @XmlAttribute(name = "ChangeKey")
    public String changeKey;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EWSId folderID = (EWSId) o;

//        if (changeKey != null ? !changeKey.equals(folderID.changeKey) : folderID.changeKey != null)
//            return false;
        if (id != null ? !id.equals(folderID.id) : folderID.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (changeKey != null ? changeKey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{ id: " + id + "; changeKey: " + changeKey +  "}";
    }
}
