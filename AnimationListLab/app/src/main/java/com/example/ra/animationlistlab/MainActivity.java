package com.example.ra.animationlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mArrayList;
    ArrayAdapter<String> mArrayAdapter;
    EditText mEditText;
    ListView mListview;
    TextView mTextAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview=(ListView)findViewById(R.id.listView);
        mTextAnimation=(TextView)findViewById(R.id.textView);

        mArrayList= new ArrayList<String>();
        mArrayAdapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,mArrayList);
        mListview.setAdapter(mArrayAdapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_textview);
                mTextAnimation.startAnimation(animation);
            mEditText=(EditText)findViewById(R.id.ediText);
            String input=  mEditText.getText().toString();
                if(mEditText.length()==0){
                    Toast.makeText(MainActivity.this,"Add Something to List",Toast.LENGTH_SHORT).show();

                }
                mEditText.getText().clear();
                mArrayList.add(input);
                mTextAnimation.setText(input);
                mArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
