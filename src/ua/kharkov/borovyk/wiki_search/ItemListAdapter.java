package ua.kharkov.borovyk.wiki_search;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/6/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemListAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private final ArrayList<Item> values;

    public ItemListAdapter(Context context, ArrayList<Item> values) {
        super(context, R.layout.result, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.result, parent, false);
        setTitle(rowView,position);
        setImage(rowView,position);
        return rowView;
    }

    private void setTitle(View rowView, int position){
        TextView textView = (TextView) rowView.findViewById(R.id.title);
        textView.setText(values.get(position).getTitle());
    }

    private void setImage(View rowView, int position){
        ImageView imageView = (ImageView) rowView.findViewById(R.id.picture);
        String imgUrl = values.get(position).getPic();
        if (imgUrl != null) {
            BitmapDownloader task = new BitmapDownloader(imageView);
            task.execute(imgUrl);
        } else {
            imageView.setImageResource(R.drawable.result_ic_def);
        }
    }




}
