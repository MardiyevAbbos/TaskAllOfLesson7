package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demob12lesson7.R;
import com.example.demob12lesson7.helper.Hashtag;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashtagActivity extends AppCompatActivity {

    private TextInputLayout editText;
    private TextView textView;
    private Button button;

    private ForegroundColorSpan colorSpan;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String text = editText.getEditText().getText().toString();

            Pattern pattern = Pattern.compile(" #\\w+");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                colorSpan = new ForegroundColorSpan(Color.BLUE);
                editText.getEditText().getText().setSpan(colorSpan, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtag);

        initViews();

    }

    private void initViews() {
        editText = findViewById(R.id.edt_not_edited);
        editText.getEditText().addTextChangedListener(textWatcher);

        textView = findViewById(R.id.tv_edited_text);
        button = findViewById(R.id.btn_send_entered_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAndDisplayText();
            }
        });

    }


    private void editAndDisplayText() {
        String text = editText.getEditText().getText().toString();
        SpannableString hashtags = new SpannableString(text);
        setSpanComment(hashtags, getArrayHashtagSpans(text));
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textView.setText(hashtags);
    }


    private ArrayList<int[]> getArrayHashtagSpans(String text) {
        ArrayList<int[]> spans = new ArrayList<>();

        Pattern patternHashtag = Pattern.compile(" #\\w+");  // check Hashtag (#)
        Matcher matcherHashtag = patternHashtag.matcher(text);
        while (matcherHashtag.find()) {
            int[] currentHashtagSpans = new int[3];
            currentHashtagSpans[0] = matcherHashtag.start();
            currentHashtagSpans[1] = matcherHashtag.end();
            currentHashtagSpans[2] = 0;
            spans.add(currentHashtagSpans);
        }

        Pattern patternLink = Pattern.compile("\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                "|mil|biz|info|mobi|name|aero|jobs|museum" +
                "|travel|[a-z]{2}))(:[\\d]{1,5})?" +
                "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" +
                "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" +
                "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" +
                "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");   // check site link (https:, http:, www and others
        Matcher matcherLink = patternLink.matcher(text);
        while (matcherLink.find()) {
            int[] currentLinkSpans = new int[3];
            currentLinkSpans[0] = matcherLink.start();
            currentLinkSpans[1] = matcherLink.end();
            currentLinkSpans[2] = 1;
            spans.add(currentLinkSpans);
        }

        return spans;
    }


    private void setSpanComment(SpannableString hashtagContent, ArrayList<int[]> hashtagSpans) {
        for (int i = 0; i < hashtagSpans.size(); i++) {
            int[] span = hashtagSpans.get(i);
            int hashTagStart = span[0];
            int hashTagEnd = span[1];
            hashtagContent.setSpan(new Hashtag(this, span[2]), hashTagStart, hashTagEnd, 0);
        }
    }


    public void openWebViewActivity(Intent intent){
        startActivity(intent);
    }

}



/*    Pattern pattern = Pattern.compile(
            "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|www.)" +
                    "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" +
                    "|mil|biz|info|mobi|name|aero|jobs|museum" +
                    "|travel|[a-z]{2}))(:[\\d]{1,5})?" +
                    "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" +
                    "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                    "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" +
                    "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" +
                    "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" +
                    "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");

 */  // check site link (https:, http:, www and others)