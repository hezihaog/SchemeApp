package com.zh.android.schemeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goDangDang = findViewById(R.id.go_dang_dang);
        goDangDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpAppFromUri("dangdang://product//pid=28549983", "未安装当当");
            }
        });
        Button goAlipayQrScanBtn = findViewById(R.id.go_alipay_qr_scan);
        goAlipayQrScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpAppFromUri("alipayqr://platformapi/startapp?said=10000007", "未安装支付宝");
            }
        });
        Button goCoSleepCombineAlbumBtn = findViewById(R.id.go_cosleep_combine_album);
        goCoSleepCombineAlbumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpAppFromUri("cosleep://deeplink?code=10064&id=1", "未安装小睡眠");
            }
        });
    }

    /**
     * 使用Uri跳转第三方App
     */
    private void jumpAppFromUri(String uriStr) {
        jumpAppFromUri(uriStr, "跳转失败，请检查是否有安装该App");
    }

    /**
     * 使用Uri跳转第三方App
     *
     * @param uriStr          深链地址
     * @param noInstallAppMsg 没有安装第三方App时，要显示的消息
     */
    private void jumpAppFromUri(String uriStr, String noInstallAppMsg) {
        try {
            Uri uri = Uri.parse(uriStr);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Throwable e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), noInstallAppMsg, Toast.LENGTH_SHORT).show();
        }
    }
}