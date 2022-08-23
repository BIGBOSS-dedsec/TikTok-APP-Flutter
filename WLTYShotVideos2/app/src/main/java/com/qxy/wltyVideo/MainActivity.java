package com.qxy.wltyVideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.qxy.wltyVideo.adapter.RankAdapter;
import com.qxy.wltyVideo.models.RankItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView getData;
    private TextView getTV;
    private TextView getVariety;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData = findViewById(R.id.tv_get_video);
        getTV = findViewById(R.id.tv_get_TV);
        getVariety = findViewById(R.id.tv_get_variety);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        getTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TvActivity.class);
                startActivity(intent);
            }
        });
        getVariety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VarietyActivity.class);
                startActivity(intent);
            }
        });

    }





//    public void getCode() {
//        //登录第一步
//        Map<String, String> map = new HashMap<>();
//        map.put("clientKey", "aw72tpl8ro82nzh7");
//        map.put("responseType", "code");
//        map.put("scope", "scope_example");
//        map.put("redirectUri", "https://www.bytedance.com/");
//        map.put("state", "state_example");
//        OkHttpRequestUtil.getInstance().get(this, Interface.GET_CODE, map, new OkHttpRequestUtil.ICallBack() {
//            @Override
//            public void onResponse(JsonResult result) {
//                String aaa = result.toString();
//            }
//        });
//    }
//
//
//    /**
//     * 获取access_token
//     */
//
//    public void getAccessToken() {
//
////        登录第二步，把code替换成上面code的结果
//        Map<String, String> map = new HashMap<>();
//        map.put("client_secret", "896278fee5ccba74197ed65cdf8bbb1a");
//        map.put("code", "1");
//        map.put("grant_type", "authorization_code");
//        map.put("client_key", "aw7kzca1kkr5kgxo");
//        OkHttpRequestUtil.getInstance().formPost(this, Interface.GET_ACCESS_TOKEN, map, new OkHttpRequestUtil.ICallBack() {
//            @Override
//            public void onResponse(JsonResult result) {
////AccessTokenResponse response=
//            }
//
//        });
//
//    }
}