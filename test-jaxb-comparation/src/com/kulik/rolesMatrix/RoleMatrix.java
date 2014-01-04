package com.kulik.rolesMatrix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "rolesMatrix")
public class RoleMatrix {

	@XmlElement(name = "rolesList")
	@XmlJavaTypeAdapter(MatrixAdapter.class)
    public Map<Integer, List<String>> roles = new HashMap<Integer, List<String>>(0);

}
