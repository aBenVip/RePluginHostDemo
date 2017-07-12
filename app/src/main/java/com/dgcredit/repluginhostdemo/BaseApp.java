package com.dgcredit.repluginhostdemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginConfig;
import com.qihoo360.replugin.RePluginEventCallbacks;
import com.qihoo360.replugin.model.PluginInfo;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/7/6
 * 备注:
 */

public class BaseApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //-------------- 开发的时候不验证签名 -----------
        RePluginConfig config = new RePluginConfig();
        config.setVerifySign(!BuildConfig.DEBUG);
        config.setPrintDetailLog(BuildConfig.DEBUG);
        config.setUseHostClassIfNotFound(true);
        RePlugin.App.attachBaseContext(this, config);
        // ========================
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // ======= REPLUGIN =======
        RePlugin.App.onCreate();
        // ========================
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        // ======= REPLUGIN =======
        RePlugin.App.onLowMemory();
        // ========================
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        // ======= REPLUGIN =======
        RePlugin.App.onTrimMemory(level);
        // ========================
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // ======= REPLUGIN =======
        RePlugin.App.onConfigurationChanged(newConfig);
        // ========================
    }
}
