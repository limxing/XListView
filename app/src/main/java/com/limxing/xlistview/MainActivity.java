package com.limxing.xlistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.limxing.xlistview.view.XListView;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private XListView listview;
    private boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (XListView) findViewById(R.id.listview);
        listview.setPullLoadEnable(true);
        listview.setXListViewListener(this);
        listview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView view1 = new TextView(MainActivity.this);
                view1.setText("leefeng.me" + i);
                view1.setHeight(100);
                return view1;
            }
        });

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listview.stopRefresh(b);
                b = !b;
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listview.stopLoadMore();
            }
        }, 2000);
    }
}
