package com.dgcredit.repluginhostdemo;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qihoo360.loader2.FinderBuiltin;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                PluginInfo pluginInfo = RePlugin.install(absolutePath + "/aa.apk");
                if (pluginInfo != null) {
                    Toast.makeText(MainActivity.this, "插件安装成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "插件安装失败", Toast.LENGTH_SHORT).show();
                }


                //
//                RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("plugin01", "com.dgcredit.replugindemo01.MainActivity"));
//                boolean pluginInstalled = RePlugin.isPluginInstalled("plugin01");
//                if (pluginInstalled){
//                    Log.i("TAG","已安装");
//                }else {
//                    Log.i("TAG","未安装");
//                }
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("plugin01", "com.dgcredit.replugindemo01.MainActivity"));
            }
        });
    }
}
