package src.biz.kulik.android.jaxb.library.compouserTest.testWrapper;


import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

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
        private final String attrXmlNST = "http://schemas.microsoft.com/exchange/services/2006/types" ;

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
