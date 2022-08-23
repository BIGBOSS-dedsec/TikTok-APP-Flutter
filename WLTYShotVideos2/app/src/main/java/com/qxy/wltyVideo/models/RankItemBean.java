package com.qxy.wltyVideo.models;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.bumptech.glide.Glide;
import com.qxy.wltyVideo.R;
import com.qxy.wltyVideo.room.StringConverter;

import java.util.List;

@Entity(tableName = "ranks")
@TypeConverters(StringConverter.class)
public class RankItemBean extends BaseObservable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "index_database", typeAffinity = ColumnInfo.INTEGER)
    public int index_database;//标记是top几

    @ColumnInfo(name = "active_time", typeAffinity = ColumnInfo.TEXT)
    public String active_time;//更新时间，数据库用


    @ColumnInfo(name = "index", typeAffinity = ColumnInfo.INTEGER)
    public int index;//标记是top几

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;//片名

    @ColumnInfo(name = "name_en", typeAffinity = ColumnInfo.TEXT)
    public String name_en;//英语片名

    @ColumnInfo(name = "maoyan_id", typeAffinity = ColumnInfo.TEXT)
    public String maoyan_id;//猫眼id：只有电影榜返回，可能为空

    @ColumnInfo(name = "actors", typeAffinity = ColumnInfo.TEXT)
    public List<String> actors;//演员

    @ColumnInfo(name = "directors", typeAffinity = ColumnInfo.TEXT)
    public List<String> directors;//导演

    @ColumnInfo(name = "areas", typeAffinity = ColumnInfo.TEXT)
    public List<String> areas;//地区

    @ColumnInfo(name = "discussion_hot", typeAffinity = ColumnInfo.TEXT)
    public String discussion_hot;//视频讨论度


    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.TEXT)
    public String id;//	影片ID	6399487713065566465

    @ColumnInfo(name = "search_hot", typeAffinity = ColumnInfo.INTEGER)
    public long search_hot;//int64	搜索指数	684900

    @ColumnInfo(name = "influence_hot", typeAffinity = ColumnInfo.INTEGER)
    public long influence_hot;//	账号影响力	789200

    @ColumnInfo(name = "release_date", typeAffinity = ColumnInfo.TEXT)
    public String release_date;//	上映时间	2020-01-25

    @ColumnInfo(name = "topic_hot", typeAffinity = ColumnInfo.INTEGER)
    public long topic_hot;//	话题热度值	684900

    @ColumnInfo(name = "type", typeAffinity = ColumnInfo.INTEGER)
    public int type;//	类型：1=电影 2=电视剧 3=综艺	1

    @ColumnInfo(name = "hot", typeAffinity = ColumnInfo.INTEGER)
    public long hot;//	热度值	1.361e+06

    @ColumnInfo(name = "poster", typeAffinity = ColumnInfo.TEXT)
    public String poster;//	海报	https://p3-dy.bytecdn.cn/obj/compass/9ac412ae054b57f69c0967a8eb5e25c9

    @ColumnInfo(name = "tags", typeAffinity = ColumnInfo.TEXT)
    public List<String> tags;//类型【喜剧】

    public RankItemBean(String poster, String name, long topic_hot) {
        this.poster = poster;
        this.name = name;
        this.topic_hot = topic_hot;
    }

    @Bindable
    public String getIndex() {
        return "TOP" + index;
    }

    public void setIndex(int index) {
        this.index = index;
        notifyPropertyChanged(BR.index);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setTags(List<String> tags) {
        if (tags != null && tags.size() > 0) {
            this.tags = tags;
            notifyPropertyChanged(BR.tags);
        }
    }

    @Bindable
    public String getTags() {
        if (tags != null && tags.size() > 0) {
            return TextUtils.join(",", tags);
        } else {
            return "";
        }
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
        notifyPropertyChanged(BR.actors);
    }

    @Bindable
    public String getActors() {
        if (actors != null && actors.size() > 0) {
            if (actors.size() > 3) {
                actors = actors.subList(0, 3);
            }
            return TextUtils.join(" / ", actors);
        } else {
            return "";
        }
    }

    public void setSearch_hot(long search_hot) {
        this.search_hot = search_hot;
        notifyPropertyChanged(BR.search_hot);
    }

    //    search_hot
    @Bindable
    public String getSearch_hot() {
        if (search_hot > 10000) {
            return String.format("%.1f", search_hot / 10000.0) + " 万"
                    ;
        } else {
            return String.valueOf(search_hot);
        }
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
        notifyPropertyChanged(BR.release_date);
    }

    public void setType(int type) {
        this.type = type;
    }

    @Bindable
    public String getRelease_date() {
        if (type == 1) {
            return release_date + "  上映";
        } else {
            return release_date + "  播出";
        }
    }


    @Bindable
    public String getPoster() {
        return poster;
    }


    @BindingAdapter("app:poster")
    public static void setPoster(ImageView iv, String poster) {
        Glide.with(iv.getContext()).load(poster).into(iv);

    }


    public void cilck(View v) {
        Log.d("VideoItemBean", "点击事件");

    }

}
