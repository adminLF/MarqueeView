package com.xxfc.marqueeview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.Toast;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MarqueeView marqueeView;
    private MarqueeView marqueeView1;
    private MarqueeView marqueeView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marqueeView = findViewById(R.id.marqueeView);
        marqueeView1 = findViewById(R.id.marqueeView1);
        marqueeView2 = findViewById(R.id.marqueeView2);

        List<CharSequence> list = new ArrayList<>();
        SpannableString ss1 = new SpannableString("1、MarqueeView开源项目");
        ss1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 2, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss1);
        SpannableString ss2 = new SpannableString("2、GitHub：linfeng");
        ss2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 9, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss2);
        SpannableString ss3 = new SpannableString("3、个人博客：linfeng.com");
        ss3.setSpan(new URLSpan("http://linfeng.com/"), 7, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss3);
        list.add("4、新浪微博：@linfeng微博");
        //set Custom font
        marqueeView.setTypeface(ResourcesCompat.getFont(this, R.font.huawenxinwei));

        marqueeView.startWithList(list);
        marqueeView.setOnItemClickListener((position, textView) -> Toast.makeText(MainActivity.this, textView.getText() + "", Toast.LENGTH_SHORT).show());

        marqueeView1.startWithText(getString(R.string.marquee_texts), R.anim.anim_top_in, R.anim.anim_bottom_out);
        marqueeView1.setOnItemClickListener((position, textView) -> Toast.makeText(this, String.valueOf(position) + ". " + textView.getText(), Toast.LENGTH_SHORT).show());

        marqueeView2.startWithText(getString(R.string.marquee_text));
    }
}
