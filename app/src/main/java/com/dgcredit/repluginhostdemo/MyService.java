package com.dgcredit.repluginhostdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/7/7
 * 备注:
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
