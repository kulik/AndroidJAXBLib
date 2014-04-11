package com.kulik.android.jaxb.library.parserTest.TestXMSNL;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

import java.util.List;

/**
 * Created by kulik on 1/9/14.
 */
public class GetFolderResponse {
    public static final String NS_SOAP = "http://schemas.xmlsoap.org/soap/envelope/";
    public static final String NS_TYPE = "http://schemas.microsoft.com/exchange/services/2006/types";
    public static final String NS_MES = "http://schemas.microsoft.com/exchange/services/2006/messages";

    @XmlElementWrapper(name = "Body", namespace = NS_SOAP)
    @XmlElement(name = "GetFolderResponse", namespace = NS_MES)
    private Body body;

    public List<Folder> getFolderList() {
        if (body != null && body.response != null && body.response.folderList != null) {
            return body.response.folderList;
        }
        return null;
    }

    public String getResponseClass() {
        if (body != null && body.response != null) {
            return body.response.responseClass;
        }
        return null;
    }

    public String getResponseCode() {
        if (body != null && body.response != null) {
            return body.response.responseCode;
        }
        return null;
    }

    public static class Body {
        @XmlElementWrapper(name = "ResponseMessages", namespace = NS_MES)
        @XmlElement(name = "GetFolderResponseMessage", namespace = NS_MES)
        public FolderResponse response;
    }

    public static class FolderResponse {

        @XmlAttribute(name = "ResponseClass")
        public String responseClass;

        @XmlElement(name = "ResponseCode", namespace = NS_MES)
        public String responseCode;

        @XmlElementWrapper(name = "Folders", namespace = NS_MES)
        @XmlElement(name = "Folder", namespace = NS_TYPE)
        public List<Folder> folderList;
    }

    public static class Folder {

        @XmlElement(name = "FolderId", namespace = NS_TYPE)
        private EWSId folderID;

        public String getDisplayName() {
            return displayName;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getChildFolderCount() {
            return childFolderCount;
        }

        public int getUnreadCount() {
            return unreadCount;
        }

        public EWSId getFolderID() {
            return folderID;
        }

        @XmlElement(name = "DisplayName", namespace = NS_TYPE)
        private String displayName;

        @XmlElement(name = "TotalCount", namespace = NS_TYPE)
        private int totalCount;

        @XmlElement(name = "ChildFolderCount", namespace = NS_TYPE)
        private int childFolderCount;

        @XmlElement(name = "UnreadCount", namespace = NS_TYPE)
        private int unreadCount;
    }


}
