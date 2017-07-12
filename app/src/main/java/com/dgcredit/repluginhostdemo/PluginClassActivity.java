package com.dgcredit.repluginhostdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.qihoo360.replugin.RePlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class PluginClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_class);
        TextView tvShow = (TextView) findViewById(R.id.textView);
        //加载宿主中的工具类
        ClassLoader classLoader = RePlugin.fetchClassLoader("plugin01");
        try {
            Class<?> aClass = classLoader.loadClass("com.dgcredit.replugindemo01.DateHelper");
            Method formatDate = aClass.getMethod("formatDate", Date.class);
            String invoke = (String) formatDate.invoke(null, new Date());
            tvShow.setText(invoke);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
