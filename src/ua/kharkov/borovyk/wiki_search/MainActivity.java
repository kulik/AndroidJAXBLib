package ua.kharkov.borovyk.wiki_search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_ITEMS = "ua.kharkov.borovyk.wiki_search.items";
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ArrayList<Item> items = (ArrayList<Item>) msg.obj;
            startResultActivity(items);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.main);
    }

    public void startResultActivity(ArrayList<Item> items) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(EXTRA_ITEMS, items);
        startActivity(intent);
    }

    public void search(View view) {
        EditText vi = (EditText) findViewById(R.id.enter);
        String text = vi.getText().toString();
        if (text.length() == 0) {
            Toast.makeText(getApplicationContext(), R.string.no_search_req, Toast.LENGTH_LONG).show();
        } else {
            WikiSearch search = new WikiSearch(this, mHandler);
            search.execute(text);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
