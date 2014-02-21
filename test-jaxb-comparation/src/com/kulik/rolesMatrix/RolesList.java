package com.kulik.rolesMatrix;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class RolesList {

    @XmlElement(name = "role")
    public List<Role> rolesList;

}
