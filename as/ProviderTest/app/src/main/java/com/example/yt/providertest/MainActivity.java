package com.example.yt.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button add=(Button)findViewById(R.id.add_data);
        Button update = (Button) findViewById(R.id.updata_data);
        Button delete = (Button) findViewById(R.id.delete_data);
        Button query = (Button) findViewById(R.id.query_data);

        //添加
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri=Uri.parse("content://com.example.yt.databasetest.provider/book");
                ContentValues values=new ContentValues();//申请一个contentvalues 组装数据
                values.put("name","A Clash of Kings");
                values.put("author","George Martin");
                values.put("price",885.5);
                values.put("pages",1024);
                Uri newUri=getContentResolver().insert(uri,values);
                newId=newUri.getPathSegments().get(1);

            }
        });

        //查询
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.yt.databasetest.provider/book");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null)
                {
                    while(cursor.moveToNext()){
                        String NAME=cursor.getString(cursor.getColumnIndex("name"));
                        String AUTHOR=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity","book name is "+NAME);
                        Log.d("MainActivity","book author is "+AUTHOR);
                        Log.d("MainActivity","book pages is "+pages);
                        Log.d("MainActivity","book price is "+price);

                    }
                    cursor.close();
                }
            }
        });
        //更新
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.yt.databasetest.provider/book/"+newId);

                ContentValues values=new ContentValues();
                values.put("price",109);
                values.put("pages",1110);
                getContentResolver().update(uri,values,null,null);
            }
        });
        //删除
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("content://com.example.yt.databasetest.provider/book/"+newId);
                getContentResolver().delete(uri,null,null);
            }
        });
    }
}
