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
package com.kulik.android.jaxb.library.compouserTest.testWrapper;


import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

/**
 * Created by kulik on 1/8/14.
 */
public class GetFolder implements EWSRequest {

    @XmlElement(name = "GetFolder")
    private Req request = new Req();

    public void setFolder(String folderId) {
        request.folderIDWrapper.folderId = folderId;
    }

    public GetFolder() {
    }

    public GetFolder(String folderId) {
        this.request.folderIDWrapper.folderId = folderId;
    }

    private class Req {
        @XmlAttribute(name = "xmlns")
        private final String attrXmlNS = "http://schemas.microsoft.com/exchange/services/2006/messages";
        @XmlAttribute(name = "xmlns:t")
        private final String attrXmlNST = "http://schemas.microsoft.com/exchange/services/2006/types";

        @XmlElementWrapper(name = "FolderShape")
        @XmlElement(name = "t:BaseShape")
        private String folderShape = "Default";

        @XmlElementWrapper(name = "FolderIds")
        @XmlElement(name = "t:DistinguishedFolderId")
        private FolderID folderIDWrapper = new FolderID();
    }

    private class FolderID {
        @XmlAttribute(name = "Id")
        public String folderId;
    }
}
