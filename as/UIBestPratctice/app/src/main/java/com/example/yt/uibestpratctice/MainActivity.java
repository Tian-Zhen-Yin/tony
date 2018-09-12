package com.example.yt.uibestpratctice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<MSG> msgList=new ArrayList<>();
   private EditText inputText;
   private Button send;
   private RecyclerView msgRecylerView;
   private  MSGAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();//初始化消息数据；

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecylerView=(RecyclerView)findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecylerView.setLayoutManager(layoutManager);

        adapter = new MSGAdapter(msgList);
        msgRecylerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    MSG msg = new MSG(content, MSG.TYPE_SENT);
                    msgList.add(msg);

                    adapter.notifyItemInserted(msgList.size() - 1);//当有新消息时，刷新RecylerView中的显示
                    msgRecylerView.scrollToPosition(msgList.size() - 1);//将RecylerView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }


            }
        });
    }
    private  void initMsgs(){

        MSG msg1=new MSG("Hello guy",MSG.TYPE_RECEIVED);
        msgList.add(msg1);
        MSG msg2=new MSG("Hello.Who is that???????",MSG.TYPE_SENT);
        msgList.add(msg2);
        MSG msg3=new MSG("Oh,This is Tom.Nice talking to you.",MSG.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
