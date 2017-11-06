package com.example.expandablelistviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("剛力彩芽", "金曜24:00〜24:20", 35.675244, 139.760648));
        itemList.add(new Item("吉永小百合", "日曜22:30〜23:00", 35.671418, 139.734443));
        itemList.add(new Item("高城れに", "土曜17:00〜17:15", 35.656854, 139.757129));
        itemList.add(new Item("上坂すみれ", "木曜24:30〜25:00", 34.669581, 135.460767));

        MyExpandableListAdapter mela = new MyExpandableListAdapter(this);
        ExpandableListView mainList = (ExpandableListView) findViewById(R.id.mainList);
        mela.setItemList(itemList);
        mainList.setAdapter(mela);
    }
}
