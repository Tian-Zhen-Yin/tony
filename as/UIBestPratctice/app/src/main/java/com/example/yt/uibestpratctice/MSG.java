package com.example.yt.uibestpratctice;

public class MSG
{public static final int TYPE_RECEIVED=0;
 public static final int TYPE_SENT=1;
 private String content;
 private  int type;
 public MSG(String content,int type){
     this.content=content;
     this.type=type;

 }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
