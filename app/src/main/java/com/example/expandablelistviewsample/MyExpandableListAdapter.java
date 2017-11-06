package com.example.expandablelistviewsample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;

import java.util.List;

/**
 * アイテムのリストを用意し、ExpandableListViewの展開機能をアイテムの詳細表示として用いる。
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    private List<Item> itemList;
    private Activity activity;
    private LayoutInflater li;

    /**
     * ExpandableListViewを乗せるActivityを指定して初期化する。
     * @param activity ExpandableListViewを乗せるActivity
     */
    public MyExpandableListAdapter(Activity activity) {
        this.activity = activity;
        li = LayoutInflater.from(activity);
    }

    /**
     * アイテムのリストを設定する。
     * @param itemList 表示するアイテムのリスト
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getGroupCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return itemList == null ? null : itemList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemList == null ? null : itemList.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = li.inflate(R.layout.expandable_list_summary, parent, false);
        }
        Item item = itemList == null ? null : itemList.get(groupPosition);
        String itemName = item == null ? "" : item.getName();
        ((TextView)convertView.findViewById(R.id.nameView)).setText(itemName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = li.inflate(R.layout.expandable_list_details, parent, false);
            FrameLayout fl = (FrameLayout)convertView.findViewById(R.id.mapLayout);
            //fl.setId(View.generateViewId());
            FragmentManager fm = activity.getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            MapFragment mapFragment = new MapFragment();
            ft.add(fl.getId(), mapFragment);
            ft.commit();
        }
        Item item = itemList == null ? null : itemList.get(groupPosition);
        String itemInfo = item == null ? "" : item.getInfo();
        ((TextView)convertView.findViewById(R.id.infoView)).setText(itemInfo);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
