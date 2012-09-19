package ua.kharkov.borovyk.wiki_search;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/8/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BitmapDownloader extends AsyncTask<String, Void, Bitmap> {
    private String mUrl;
    private final WeakReference<ImageView> mImageViewReference;

    public BitmapDownloader(ImageView imageView) {
        mImageViewReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return downloadBitmap(params[0]);
    }

    static Bitmap downloadBitmap(String url) {
        final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
        final HttpGet getRequest = new HttpGet(url);
        InputStream inputStream = null;
        HttpEntity entity = null;

        try {
            HttpResponse response = client.execute(getRequest);
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.d("BitmapDownloader", "Error " + statusCode + " on getting bitmap from " + url);
                return null;
            }

            entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                entity.consumeContent();
                return bitmap;
            } else {
                return null;
            }
        } catch (IOException e) {
            getRequest.abort();
            Log.d("BitmapDownloader", "IOException on getting bitmap from " + url);
        } catch (IllegalStateException e) {
            getRequest.abort();
            Log.d("BitmapDownloader", "IllegalStateException on getting bitmap from " + url);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                Log.d("BitmapDownloader", "IOException while inputStream.close() while getting bitmap from " + url);
            }
            if (client != null) {
                client.close();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }
        // Once the image is downloaded, associate it to the imageView
        if (mImageViewReference != null) {
            ImageView imageView = mImageViewReference.get();
            if (imageView != null) {
                if (bitmap == null) {
                    imageView.setImageResource(R.drawable.result_ic_def);
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}