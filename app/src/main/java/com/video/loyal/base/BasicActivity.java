package com.video.loyal.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BasicActivity extends AppCompatActivity {
    public abstract
    @LayoutRes
    int getLayoutResID();

    public abstract void afterOnCreate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
    }

    protected void setStatusBar() {

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setStatusBar();//沉浸式状态栏
        afterOnCreate();
    }
}
