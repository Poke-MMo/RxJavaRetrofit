package com.xp.rxjavaretrofit.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xp.rxjavaretrofit.R;
import com.xp.rxjavaretrofit.model.BaseEntity;
import com.xp.rxjavaretrofit.model.DataEntity;
import com.xp.rxjavaretrofit.rx.ApiService;
import com.xp.rxjavaretrofit.rx.ApiSubscriber;
import com.xp.rxjavaretrofit.rx.DefaultTransformer;
import com.xp.rxjavaretrofit.rx.HttpMethods;

import java.util.HashMap;
import java.util.Map;

import rx.Subscription;

public class MainActivity extends BaseActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_content);
        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        Map<String, String> params = new HashMap<>();
        params.put("user_name", "");
        params.put("user_pwd", "");
        Subscription subscribe = HttpMethods.getInstance()
                .createService(ApiService.class)
                .getData(params)
                .compose(DefaultTransformer.<BaseEntity<DataEntity>>create())
                .subscribe(new ApiSubscriber<BaseEntity<DataEntity>>(this) {
                    @Override
                    public void onNext(BaseEntity<DataEntity> entity) {

                    }
                });
        addSubscription(subscribe);
    }
}
