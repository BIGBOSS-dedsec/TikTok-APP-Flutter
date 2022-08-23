package com.qxy.wltyVideo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qxy.wltyVideo.adapter.RankAdapter;
import com.qxy.wltyVideo.callback.ClientTokenCallback;
import com.qxy.wltyVideo.models.ClientTokenResponse;
import com.qxy.wltyVideo.models.RankItemBean;
import com.qxy.wltyVideo.models.RankResponse;
import com.qxy.wltyVideo.network.Interface;
import com.qxy.wltyVideo.network.OkHttpRequestUtil;
import com.qxy.wltyVideo.room.MyDatabase;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 排行榜基础页面
 * 电影、综艺、剧集接口一样
 */

public abstract class RankActivity extends BaseActivity {

    protected ImageView ivBack;
    protected TextView tvTitle;
    protected TextView tvUpdateTime;
    protected ListView lvVideo;
    protected RankAdapter rankAdapter;
    protected List<RankItemBean> ranksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() != 0) {
            setContentView(getContentViewId());
        }


        initView();


    }

    private void initDataFromDataBase() {
        Observable.just(new doIOTask() {
            @Override
            public void doOnIOThread() {
                MyDatabase myDatabase = MyDatabase.getInstance(RankActivity.this);
                ranksList = myDatabase.videoDao().getRankByType(Integer.valueOf(getType()));
            }
        })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<doIOTask>() {
                    @Override
                    public void accept(doIOTask threadTask) throws Exception {
                        threadTask.doOnIOThread();
                    }
                });
        rankAdapter = new RankAdapter(RankActivity.this, getLayoutInflater(), getItemLayoutId(),
                BR.videoItem, ranksList);
        lvVideo.setAdapter(rankAdapter);
    }

    protected abstract int getContentViewId();

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(v -> finish());
        tvTitle = findViewById(R.id.tv_title);
        tvUpdateTime = findViewById(R.id.tv_update_time);
        tvTitle.setText(getCustomTitle());

        lvVideo = findViewById(R.id.lv_rank);

        initDataFromDataBase();

        getClientToken(new ClientTokenCallback() {
            @Override
            public void dataGet(String accessToken) {
                OkHttpRequestUtil.getInstance().setAccessToken(accessToken);
                getMovies(getType());
            }
        });
    }


    public void getMovies(String type) {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);//榜单类型： * 1 - 电影 * 2 - 电视剧 * 3 - 综艺
        map.put("version", "");

        OkHttpRequestUtil.getInstance().get(this, Interface.GET_RANK_ITEM, map, new OkHttpRequestUtil.ICallBack() {
            @Override
            public void onResponse(String result) {
                RankResponse response = new Gson().fromJson(result, RankResponse.class);
                ranksList = response.getData().getList();
                if (response.getData().getError_code() != 2190008) {
                    rankAdapter = new RankAdapter(RankActivity.this, getLayoutInflater(), getItemLayoutId(),
                            BR.videoItem, ranksList);
                    lvVideo.setAdapter(rankAdapter);
                    tvUpdateTime.setText("本榜单 | 更新于" + response.getData().getActive_time());
                    saveDataToDataBase(response.getData().getActive_time());
                } else {
//                    Toast.makeText(this,"Token 已经失效",Toast.LENGTH_LONG).show;
                    //Token已经失效
                    getClientToken(new ClientTokenCallback() {
                        @Override
                        public void dataGet(String accessToken) {
                            OkHttpRequestUtil.getInstance().setAccessToken(accessToken);
                            getMovies(getType());
                        }
                    });
                }
            }
        });


    }

    public void saveDataToDataBase(String activeTime) {

        Observable.just(new doIOTask() {
            @Override
            public void doOnIOThread() {
                MyDatabase myDatabase = MyDatabase.getInstance(RankActivity.this);
                //先把数据库中的对应type的删除再插入新的
                myDatabase.videoDao().deleteRankById(Integer.valueOf(getType()));

                try {
                    for (int i = 0; i < ranksList.size() - 1; i++) {
                        RankItemBean item = ranksList.get(i);
                        item.active_time = activeTime;
                        item.index_database = Integer.parseInt(getType() + item.id.substring(item.id.length() - 8, item.id.length() - 1));
                        myDatabase.videoDao().insertRank(item);
                    }
                }catch (Exception e){
                    //数据库插入失败

                }


            }
        })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<doIOTask>() {
                    @Override
                    public void accept(doIOTask threadTask) throws Exception {
                        threadTask.doOnIOThread();
                    }
                });
    }


    public interface doIOTask {
        void doOnIOThread();
    }

    public interface doMainTask {
        void doOnMainThread();
    }

    /**
     * 获取client_token
     */

    public void getClientToken(ClientTokenCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("client_secret", "896278fee5ccba74197ed65cdf8bbb1a");
        map.put("grant_type", "client_credential");
        map.put("client_key", "aw7kzca1kkr5kgxo");

        OkHttpRequestUtil.getInstance().formPost(this, Interface.GET_CLIENT_TOKEN, map, new OkHttpRequestUtil.ICallBack() {
            @Override
            public void onResponse(String result) {
                ClientTokenResponse response = new Gson().fromJson(result, ClientTokenResponse.class);
                callback.dataGet(response.getData().getAccess_token());

            }
        });

    }


    public abstract String getCustomTitle();

    public abstract String getType();

    public abstract int getItemLayoutId();

}
