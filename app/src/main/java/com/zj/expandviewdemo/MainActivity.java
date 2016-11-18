package com.zj.expandviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zj.expandviewdemo.action.ExSubViewGravity;
import com.zj.expandviewdemo.view.ExpandTabView;
import com.zj.expandviewdemo.view.ExSubViewArea;
import com.zj.expandviewdemo.view.ExSubViewSingle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ExpandTabView tabView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabView = (ExpandTabView)findViewById(R.id.expandTabView);
        ExSubViewArea viewArea = new ExSubViewArea(this, ExSubViewGravity.LEFT);
        ExSubViewSingle viewType = new ExSubViewSingle(this,ExSubViewGravity.RIGHT,new String[]{"1","2","2","2"});
        ArrayList<View> mViewArray = new ArrayList<View>();
        ArrayList<String> mTextArray = new ArrayList<String>();
        mViewArray.add(viewArea);
        mViewArray.add(viewType);
        mTextArray.add("区域");
        mTextArray.add("tab2");
        tabView.setValue(mTextArray, mViewArray);
        tabView.setTitle("区域", 0);
        tabView.setTitle("tab2", 1);

        viewArea.setOnSelectListener(new ExSubViewArea.OnSelectListener() {
            @Override
            public void getValue(String value, String cityId) {
                tabView.onPressBack();
                Toast.makeText(MainActivity.this,"click:"+value+" "+cityId,Toast.LENGTH_SHORT).show();
            }
        });

        viewType.setOnSelectListener(new ExSubViewSingle.OnSelectListener() {
            @Override
            public void getValue(int position, String value) {
                tabView.onPressBack();
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"position:"+position+" value:"+value,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
