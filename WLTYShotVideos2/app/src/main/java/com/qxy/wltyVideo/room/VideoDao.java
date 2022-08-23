package com.qxy.wltyVideo.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.qxy.wltyVideo.models.RankItemBean;

import java.util.List;

@Dao
public interface VideoDao {
    @Insert
    void insertRank(RankItemBean rank);

    @Delete
    void deleteRank(RankItemBean rank);

    @Update
    void updateRank(RankItemBean rank);

    @Query("SELECT * FROM ranks")
    List<RankItemBean> getVideoList();

    @Query("SELECT * FROM ranks WHERE type = :type")
    List<RankItemBean>getRankByType(int type);

    @Query("DELETE FROM ranks WHERE type = :type")
    void deleteRankById(int type);
}
