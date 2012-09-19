package ua.kharkov.borovyk.wiki_search;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/12/12
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class WikiSearch extends AsyncTask<Object, Void, ArrayList<Item>> {
    private static final String TAG = WikiSearch.class.getSimpleName();
    private String wiki_request =
            "http://en.wikipedia.org/w/api.php?action=opensearch&search=%s&prop=info&format=xml&inprop=url";
    private Context mContext;
    private ArrayList<Item> mItems;
    private ProgressDialog mDialog;
    private Handler mHandler;

    public ArrayList<Item> getItems() {
        return mItems;
    }

    public WikiSearch(Context applicationContext, Handler h) {
        mContext = applicationContext;
        mItems = new ArrayList<Item>();
        mDialog = new ProgressDialog(applicationContext);
        mHandler = h;
    }

    @Override
    protected void onPreExecute() {
        mDialog.setMessage("Please wait, loading information...");
        mDialog.setIndeterminate(true);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    @Override
    protected ArrayList<Item> doInBackground(Object... params) {
        return findArticlesInWiki(params[0].toString());
    }

    public ArrayList<Item> findArticlesInWiki(String url) {
        String requestString = makeRequestString(url);
        String resultString = execWikiSearch(requestString).toString();
        Document doc = toDocFromString(resultString);
        ArrayList<Item> items = toObjectListFromDocument(doc);
        return items;
    }

    public String makeRequestString(String text) {
        String reqText = text.trim().replace(" ", "%20");
        String reqStr = String.format(
                wiki_request,
                reqText);
        Log.d(TAG, String.format("reguest string: %s", reqStr));
        return reqStr;
    }

    public StringBuilder execWikiSearch(String request) {
        StringBuilder resXml = new StringBuilder();
        try {
            HttpGet uri = new HttpGet(request);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse resp = client.execute(uri);

            StatusLine status = resp.getStatusLine();
            if (status.getStatusCode() != 200) {
                Log.d(TAG, "HTTP error, invalid server status code: " + resp.getStatusLine());
                //return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            String line = "";
            while ((line = br.readLine()) != null) {
                resXml.append(line);
            }
            Log.d(TAG, "responce xml: " + resXml.toString());
        } catch (IOException e) {
            Log.d(TAG, "got IOException in execWikiSearch");
            e.printStackTrace();
        }
        return resXml;
    }

    public Document toDocFromString(String xml) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
        } catch (ParserConfigurationException e) {
            Log.d(TAG, "XML parse error in toDocFromString: " + e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.d(TAG, "Wrong XML file structure in toDocFromString: " + e.getMessage());
            return null;
        } catch (IOException e) {


            Log.d(TAG, "I/O exception in toDocFromString: " + e.getMessage());
            return null;
        }
        return doc;
    }

    public ArrayList<Item> toObjectListFromDocument(Document doc) {
        String title = "";
        String pic = null;
        String url = null;
        Node node = null;
        ArrayList<Item> objects = new ArrayList<Item>();
        NodeList items = doc.getElementsByTagName("Item");
        for (int i = 0; i < items.getLength(); i++) {
            Element itemNode = (Element) items.item(i);

            NodeList list = null;
            list = itemNode.getElementsByTagName("Image");
            if (list != null && list.getLength() > 0) {
                pic = ((Element) list.item(0)).getAttribute("source"); //attribute value by name
            } else {
                pic = "";
            }

            node = itemNode.getElementsByTagName("Text").item(0).getChildNodes().item(0);
            title = node.getNodeValue();

            node = itemNode.getElementsByTagName("Url").item(0).getChildNodes().item(0);
            url = node.getNodeValue();

            Item item = new Item(title, pic, url);
            objects.add(item);
            Log.d(TAG, "object item" + i + ": " + item.toString());
        }
        return objects;
    }

    @Override
    protected void onPostExecute(ArrayList<Item> result) {
        super.onPostExecute(result);
        mDialog.dismiss();
        if (result != null) {
            mItems = result;
            Message msg = Message.obtain();
            msg.obj = mItems;
            mHandler.sendMessage(msg);
        } else {
            Log.d(TAG, "no serch results");
            Toast.makeText(mContext, R.string.no_search_result, Toast.LENGTH_SHORT).show();
        }
    }

}
