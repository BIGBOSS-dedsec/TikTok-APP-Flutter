package com.qxy.wltyVideo.models;

import java.util.List;

public class RankData {
  private String  active_time;
  private String description;
  private int error_code;
  private List<RankItemBean> list;

    public String getActive_time() {
        return active_time;
    }

    public void setActive_time(String active_time) {
        this.active_time = active_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<RankItemBean> getList() {
        return list;
    }

    public void setList(List<RankItemBean> list) {
        this.list = list;
    }
}
