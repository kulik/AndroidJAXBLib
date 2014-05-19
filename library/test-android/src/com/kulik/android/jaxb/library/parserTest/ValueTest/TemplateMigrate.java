package com.kulik.android.jaxb.library.parserTest.ValueTest;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import com.kulik.android.jaxb.library.Annotations.XmlValue;

import java.util.List;

public class TemplateMigrate {
    @XmlElementWrapper(name = "note_list")
    @XmlElement(name = "note")
    public List<NoteX> noteList;


    public static class NoteX {


        public NoteX() {
        }

        public NoteX(String fName) {
            this.fileName = fName;
        }

        @XmlAttribute(name = "DisplayName")
        public String displayName;

        @XmlAttribute(name = "Name")
        public String fileName;

        @XmlElement(name = "attachment")
        public List<Att> attachmentList;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NoteX noteX = (NoteX) o;

            if (fileName != null ? !fileName.equals(noteX.fileName) : noteX.fileName != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            return fileName != null ? fileName.hashCode() : 0;
        }

        public static class Att {
            @XmlValue
            String file;

            @XmlAttribute(name = "Location")
            String location;

            @XmlAttribute(name = "ContentId")
            String contentId;

            @XmlAttribute(name = "Type")
            String type;

            @XmlAttribute(name = "Name")
            String name;

            @XmlAttribute(name = "Description")
            String description;
        }
    }
}