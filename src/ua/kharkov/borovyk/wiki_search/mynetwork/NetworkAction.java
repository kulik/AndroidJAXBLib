package ua.kharkov.borovyk.wiki_search.mynetwork;

import java.io.InputStream;

public interface NetworkAction {
	int TIMEOUT_CONNECTION = 3000;
	int TIMEOUT_SOCKET = 5000; 

	void execute(String url);
	String getOperationID();
	//void setEndNetworkOperationListener(EndNetworkActionListener listener);
	String getContentAsString();
	InputStream getContentAsStream();
	
	public static enum Code {OK, ERROR, TIMEOUT, SERVER_MESSAGE, CERTIFICATE, NO_INTERNET_ESTABLISHED, NO_SPACE_ON_DEVICE, CANCELED_BY_USER };
}
