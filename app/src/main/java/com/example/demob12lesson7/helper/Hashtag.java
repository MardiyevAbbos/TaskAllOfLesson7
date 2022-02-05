package com.example.demob12lesson7.helper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.demob12lesson7.activity.HashtagActivity;
import com.example.demob12lesson7.activity.WebViewActivity;

public class Hashtag extends ClickableSpan {

    HashtagActivity hashtagActivity;
    int check;

    public Hashtag(HashtagActivity hashtagActivity, int check) {
        super();
        this.hashtagActivity = hashtagActivity;
        this.check = check;
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        ds.setColor(Color.BLUE);
        ds.setARGB(255, 30, 144, 255);
    }

    @Override
    public void onClick(@NonNull View widget) {
        TextView tv = (TextView) widget;
        Spanned s = (Spanned) tv.getText();
        int start = s.getSpanStart(this);
        int end = s.getSpanEnd(this);
        String hashtag = s.subSequence(start, end).toString();
        if (check == 0) {
            Toast.makeText(hashtagActivity, String.format("Tag : %s", hashtag), Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(hashtagActivity, WebViewActivity.class);
            intent.putExtra("url", hashtag);
            hashtagActivity.openWebViewActivity(intent);
        }
    }

}
