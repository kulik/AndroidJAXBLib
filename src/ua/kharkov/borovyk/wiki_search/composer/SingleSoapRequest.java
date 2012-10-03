package ua.kharkov.borovyk.wiki_search.composer;

import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.ebooks.ebookreader.network.onlinesync.Errors.RequestError;

public abstract class SingleSoapRequest implements NetworkAction {
	
	public static final String KEY = "|f3MWiyq9XXHCcfM3HDqd96SMCALEtOS1OOfHCwzA6UAoqKW8Yb";
	private static final String TAG = "SinglePostRequest";
	public final static String URL = "http://64.34.164.229:81/sync/retailer.asmx";
	public static final String NAME_SPACE = "http://tempuri.org/";
	private static final String HASH_STANDARD = "MD5";
	public static final String PROPERTY_PARTNER_ID ="PartnerId";
	public static final String PROPERTY_SIGNATURE ="Signature";
	public static final String PARTNER_ID ="12";
	protected String mMethod;
	// private int mTimeout = NetworkAction.TIMEOUT_CONNECTION;
	// private HttpResponse mResponse;
	private SoapObject mSoapResponse;
	private EndNetworkActionListener mListener;
	private final String mID;
	protected Code mCode = Code.ERROR;

	/**
	 * result code of Network operation
	 * @return
	 */
	public Code getCode() {
		return mCode;
	}
	
	protected RequestError mRequestError;
	
	public RequestError getError() {
		return mRequestError;
	}

	public SingleSoapRequest(String ID, String method) {
		mMethod = method;
		mID = ID;
	}

	protected Code doExecute(String url) {
		SoapObject toSend = compose();
		//	Log.v("", "doExecute = " + toSend);
		try {
			mSoapResponse = doSoapRequest(toSend, url);
			parse(mSoapResponse);
		} catch (Exception e) {
			mCode = Code.TIMEOUT;
			//	Log.v(TAG, "TIMEOUT");
			e.printStackTrace();
			return mCode;
		}
		return Code.OK;
	}

	private SoapObject doSoapRequest(SoapObject request, String path) throws Exception {
		//	Log.v(request.getClass().getSimpleName(), request.toString());
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(path);
		androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		androidHttpTransport.call(NAME_SPACE + mMethod, envelope);
		
		SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
		String res = resultsRequestSOAP.toString();
		//	Log.v(request.getClass().getSimpleName(), res);

		return resultsRequestSOAP;
	}

	public void execute(final String url) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				final Code result = doExecute(url);
				if (mListener != null) mListener.onEndNetworkOperation(SingleSoapRequest.this, result);
			}
		}).start();
	}

	public void setEndNetworkOperationListener(EndNetworkActionListener listener) {
		this.mListener = listener;
	}

	@Override
	public String getOperationID() {
		return mID;
	}

	@Override
	public String getContentAsString() {
		return mSoapResponse.toString();
	}

	@Override
	public abstract InputStream getContentAsStream();

	/**
	 * this annotation mast be implemented for each getters for date witch must send to server
	 * 
	 * @author kulik
	 * 
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ToSend {
		String name();
	}

	/**
	 * Must compose this request from inner field that was set in constructor
	 * 
	 * @return
	 */
	protected abstract SoapObject compose();

	protected SoapObject autoComposetoSOAPReqest(Object obj) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		SoapObject soap =new SoapObject(NAME_SPACE, mMethod);

		if (!isSatisfiesNamingConvention(obj)) {
			throw new IllegalArgumentException("Request class name must ends with \"Request\" word");
		}
		//	Log.v(TAG,"NamingConvention OK Class:"+ obj.getClass().getSimpleName());
		processObject(obj, soap);

		return soap;
	}

	protected void processObject(Object obj, SoapObject sobj) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		processFields(obj, sobj);
		processMethods(obj, sobj);
	}

	protected void processMethods(Object obj, SoapObject sobj) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Class<?> cl = obj.getClass();
		Method[] allMethods = cl.getDeclaredMethods();
		//	Log.v(TAG,"ProcessMethods quantity:" + allMethods.length);
		
		for (Method method : allMethods) {
			//	Log.v(TAG,"ProcessMethod field:" + method.getName()+ "; AnnotationPresent:" + method.isAnnotationPresent(ToSend.class));
			if (method.isAnnotationPresent(ToSend.class)) {
				method.setAccessible(true);
				String key = method.getAnnotation(ToSend.class).name();
				Object keyValue = method.invoke(obj);
				processValue(keyValue, key, sobj); //obj, 
			}
		}
	}

	protected void processFields(Object obj, SoapObject sobj) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Class<?> cl = obj.getClass();
		Field[] allFields = cl.getDeclaredFields();
		//	Log.v(TAG,"ProcessFields quantity:" + allFields.length);
		for (Field field : allFields) {
			//	Log.v(TAG,"ProcessFields field:" + field.getName()+ "; AnnotationPresent:" + field.isAnnotationPresent(ToSend.class));
			if (field.isAnnotationPresent(ToSend.class)) {
				field.setAccessible(true);
				String key = field.getAnnotation(ToSend.class).name();
				Object keyValue = field.get(obj);
				processValue(keyValue, key, sobj); //obj, 
			}
		}
	}

	protected void processValue(Object value, String key, SoapObject sobj) throws IllegalArgumentException, // Object obj, 
			IllegalAccessException, InvocationTargetException {
		if (value instanceof String) {
			sobj.addProperty(key, value);	//TODO isPrimitive
		} else if (value instanceof Integer) {		//not tested branche
			sobj.addProperty(key, (Integer) value);
		} else if (value instanceof Long) {			//not tested branche
			sobj.addProperty(key, (Long) value);
		} else if (value instanceof Float) {		//not tested branche
			sobj.addProperty(key, (Float) value);
		} else if (value instanceof Double) {		//not tested branche
			sobj.addProperty(key, (Double) value);
		} else if (value instanceof List) {			//not tested branche
			@SuppressWarnings("unchecked")
			List<Object> tmpList = (List<Object>) value;
			for (Object element : tmpList) {	
				processObject(element, sobj);
			}
		} else if (value.getClass().isArray()) { 	//not tested branche
			Object[] tmpList = (Object[]) value;
			for (Object element : tmpList) {
				SoapObject ssobj = new SoapObject(NAME_SPACE, key);
				sobj.addSoapObject(ssobj);
				processObject(element, ssobj);
			}
		} else if (value instanceof Object) {				//not tested branche
			//processObject(obj, sobj);
			processObject(value, sobj);
		}
	}

	private boolean isSatisfiesNamingConvention(Object obj) {
		return obj.getClass().getSimpleName().endsWith("Request");
	}

	/**
	 * Must parse response and set to inner field.
	 * 
	 * @return
	 */
	protected abstract void parse(SoapObject response);

	protected String getMD5Hash(String toMD5) {
		MessageDigest md;
		String result = null;
		try {
			md = MessageDigest.getInstance(HASH_STANDARD);
			result = new BigInteger(1, md.digest(toMD5.getBytes())).toString(16);
			 while (result.length() < 32) {
				 result = "0" +result;
		     }
			//	Log.v("MD5", result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected String getRequestFieldName(Object value) {
		if (value.getClass().isAnnotationPresent(ToSend.class)) {
			return value.getClass().getAnnotation(ToSend.class).name();
		}
		return null;
	}
	@Override
	public boolean isCanceled() {
		// TODO Auto-generated method stub
		return false;
	}
	// public void setTimeout(int timeout) {
	// mTimeout = timeout;
	// }	

	// private String httpPostRequest(String path, String toSend) throws Exception {
	// DefaultHttpClient httpclient = new DefaultHttpClient();
	// HttpPost httpost = new HttpPost(path);
	// HttpParams params = httpclient.getParams();
	// HttpConnectionParams.setConnectionTimeout(params, mTimeout);
	// HttpConnectionParams.setSoTimeout(params, mTimeout);
	//
	// StringEntity se = new StringEntity(toSend);
	// httpost.setEntity(se);
	// httpost.setHeader("Accept", "*/*");
	// httpost.setHeader("Content-type", "application/json");
	// ResponseHandler<String> responseHandler = new BasicResponseHandler();
	// String response = (String) httpclient.execute(httpost, responseHandler);
	// return response;
	// }

	// /**
	// * Grab JSON from field "result" and parse it to JSONObject
	// *
	// * @param response
	// * @return JSONObject from "result"
	// * @throws JSONException
	// */
	// private JSONObject RPC2JSON(String response) throws JSONException {
	// JSONObject json = null;
	// try {
	// json = new JSONObject(response);
	// } catch (JSONException e) {
	//	Log.e("JSONException" + mMethod, response);
	// throw e;
	// }
	// return json;
	// }

}
