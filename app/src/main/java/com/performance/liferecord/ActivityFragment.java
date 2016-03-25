package com.performance.liferecord;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracker on 2016/3/22.
 */
public class ActivityFragment extends BaseFragment {
    private RecyclerView mRecyclerView ;
    private List<String> mDates;
    private List<String> mContents;

    public  ActivityFragment(){
        initData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment,null);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.activity_recycke_view);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置adapter
        initData();
        mRecyclerView.setAdapter(new ActivityAdapter());
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

    public static ActivityFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ActivityFragment fragment = new ActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    protected void initData()
    {
        mDates = new ArrayList<>();
        for (int i = 0; i < 30 ;  i++)
        {
            mDates.add("2016 年 3 月 " + i + " 号");
        }
        mContents = new ArrayList<>();
        for (int i = 0; i < 30 ;  i++)
        {
            mContents.add("看完了电视剧<看了又看>的第 " + i + " 集");
        }
    }

    class ActivityAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    getContext()).inflate(R.layout.activity_recycleview_item_with_date, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.date.setText(mDates.get(position));
            holder.content.setText(mContents.get(position));
        }

        @Override
        public int getItemCount() {
            return mContents.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date;
        ImageView type;
        TextView content;
        public MyViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.activity_recycke_item_date);
            type = (ImageView) itemView.findViewById(R.id.activity_recycke_item_type);
            content = (TextView) itemView.findViewById(R.id.activity_recycke_item_content);
        }
    }
}
