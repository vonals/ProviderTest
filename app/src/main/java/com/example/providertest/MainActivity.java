package com.example.providertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdd=(Button)findViewById(R.id.add_data);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("content://com.example.wordbook.provider/CAT");
                ContentValues values=new ContentValues();
                values.put("name","king");
                values.put("meaning","王");
                values.put("sentence","long live the king!");
                Uri newUri=getContentResolver().insert(uri,values);
//                newId=newUri.getPathSegments().get(1);
                Log.d("mint","long to go");
            }
        });
        Button buttonQue=(Button)findViewById(R.id.query_data);
        buttonQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("content://com.example.wordbook.provider/CAT");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null){
                    while(cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String meaning=cursor.getString(cursor.getColumnIndex("meaning"));
                        String sentence=cursor.getString(cursor.getColumnIndex("sentence"));
                        Log.d("mint","name:"+name);
                        Log.d("mint","meaning:"+meaning);
                        Log.d("mint","sentence:"+sentence);
                    }
                    cursor.close();
                }
            }
        });
        Button buttonUpdate=(Button)findViewById(R.id.update_data);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button buttonDel=(Button)findViewById(R.id.delete_data);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
