package com.qxy.wltyVideo;

import com.qxy.wltyVideo.models.RankItemBean;

import java.util.ArrayList;

public class VideoActivity extends RankActivity {



    @Override
    protected int getContentViewId() {
        return R.layout.activity_video;
    }

    //后面从数据库获取数据
    private void initData() {
        ranksList = new ArrayList<>();
        RankItemBean bean = new RankItemBean("https://p3-dy.bytecdn.cn/obj/compass/9ac412ae054b57f69c0967a8eb5e25c9", "囧妈", 111);
        ranksList.add(bean);
        ranksList.add(bean);
    }




    @Override
    public String getCustomTitle() {
        return getString(R.string.video_rank);
    }

    @Override
    public String getType() {
        return "1";
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.layout_item_video;
    }


}