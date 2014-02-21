package com.kulik.rolesMatrix;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Role {

    @XmlAttribute(name = "role_id")
    Integer roleID;

    @XmlAttribute(name = "description")
    String role_description;

    @XmlElement(name = "url-pattern")
    List<String> urlPatternsList;
}
