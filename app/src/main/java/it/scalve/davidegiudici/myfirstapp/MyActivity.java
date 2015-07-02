package it.scalve.davidegiudici.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends Activity {

    /**
     * The Tag for the Log
     */
    private static final String TAG_LOG = "LIFECYCLE";
    
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_CREATE");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_DESTROY");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_LOG, "ACTIVITY_A -> ON_RESTART");
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);

        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
