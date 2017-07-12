package com.dgcredit.repluginhostdemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.qihoo360.replugin.RePlugin;

public class PluginPicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_pic);
        ImageView ivShow = (ImageView) findViewById(R.id.iv_show);
        ///加载插件，并获取插件的资源信息
        Resources resources = RePlugin.fetchResources("plugin01");
        int identifier = resources.getIdentifier("bg_about", "drawable", "com.dgcredit.replugindemo01");
        ivShow.setImageResource(identifier);
    }
}
