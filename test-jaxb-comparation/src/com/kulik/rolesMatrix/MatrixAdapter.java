package com.kulik.rolesMatrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

//  XmlAdapter<ValueType,BoundType>
public class MatrixAdapter extends XmlAdapter<RolesList, Map<Integer, List<String>>> {

    @Override
    public RolesList marshal(Map<Integer, List<String>> objForMarshal) throws Exception {
        return null;
    }

    @Override
    public Map<Integer, List<String>> unmarshal(RolesList xmlValue) throws Exception {
        Map<Integer, List<String>> matrix = new HashMap<Integer, List<String>>();
        for (Role role : xmlValue.rolesList) {
            matrix.put(role.roleID, role.urlPatternsList);
        }
        return matrix;
    }

}
