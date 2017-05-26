package com.xaqb.dongdongstaff;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {
    private Button mBtLogin;
    private TextView mTvFind;
    private LoginActivity instance;
    @Override
    public void initTitle() {
        setTitleB("登录");
        setBackVisibleB(View.INVISIBLE);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
        instance = this;
        mBtLogin = (Button) findViewById(R.id.bt_login_login);
        mTvFind = (TextView) findViewById(R.id.tv_find_login);
    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addEvent() {
        mBtLogin.setOnClickListener(this);
        mTvFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login_login://登录按钮
                intentB(instance,MainActivity.class);
                break;
            case R.id.tv_find_login://找回密码
                intentB(instance,FindActivity.class);
                break;
        }
    }
}
