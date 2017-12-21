package com.example.corsair_v.mytab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.corsair_v.mytab.R;

public class MainViewAdapter extends BaseAdapter {

    private Fragment[] fragmentArray;
    private FragmentManager fragmentManager;
    private int hasMsgIndex=0;

    public void setHasMsgIndex(int hasMsgIndex) {
        this.hasMsgIndex = hasMsgIndex;
    }

    public MainViewAdapter(FragmentManager fragmentManager, Fragment[] fragmentArray) {
        this.fragmentManager = fragmentManager;
        this.fragmentArray = fragmentArray;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int hasMsgIndex() {
        return hasMsgIndex;
    }


    @Override
    public String[] getTextArray() {
        return new String[] {"首页", "收藏",  "日记本","用户"};
    }
//"新建",
    @Override
    public Fragment[] getFragmentArray() {
        return fragmentArray;
    }

    @Override
    public int[] getIconImageArray() {
        return new int[] {R.mipmap.homepage, R.mipmap.collection,  R.mipmap.diary,R.mipmap.mine};
    }
//    R.mipmap.addition,
    @Override
    public int[] getSelectedIconImageArray() {
        return new int[] {R.mipmap.homepage_fill, R.mipmap.collection_fill, R.mipmap.diary_fill,R.mipmap.mine_fill};
    }
//    R.mipmap.addition_fill,
    @Override
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
