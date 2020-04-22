package com.xxfc.marqueeview;

import com.sunfusheng.marqueeview.IMarqueeItem;


public class CustomModel implements IMarqueeItem {

    public int id;
    public String title;
    public String content;

    public CustomModel(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public CharSequence marqueeMessage() {
        return title + "\n" + content;
    }
}
