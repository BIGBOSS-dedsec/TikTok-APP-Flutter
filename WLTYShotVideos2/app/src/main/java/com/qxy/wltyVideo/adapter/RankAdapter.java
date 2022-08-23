package com.qxy.wltyVideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.qxy.wltyVideo.models.RankItemBean;

import java.util.List;

public class RankAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<RankItemBean> list;

    public RankAdapter(Context context, LayoutInflater inflater, int layoutId, int variableId, List<RankItemBean> list) {
        this.context = context;
        this.inflater = inflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding viewDataBinding;
        if (convertView == null) {
            viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, null, false);
        } else {
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }
        list.get(position).setIndex(position + 1);
        viewDataBinding.setVariable(variableId, list.get(position));
        return viewDataBinding.getRoot().getRootView();
    }
}
