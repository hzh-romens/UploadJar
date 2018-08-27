package com.ifeng.uploadassitant;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * @author zhaogaofeng
 * @date 2018/8/22
 * @description
 */

public class MainActivity extends Activity {
    private TextView test;
    private PublishDialog mPublishDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.sample_text);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPublishDialog = new PublishDialog(MainActivity.this);
                mPublishDialog.show();
            }
        });
    }
}
