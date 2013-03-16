package com.kulik.rolesMatrix;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class RolesList {
	
	@XmlElement(name = "role")
	public List<Role> rolesList;

}
