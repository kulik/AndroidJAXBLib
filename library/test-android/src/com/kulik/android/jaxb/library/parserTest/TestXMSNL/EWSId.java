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
