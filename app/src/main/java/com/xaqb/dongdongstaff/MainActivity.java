package com.xaqb.dongdongstaff;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;

public class MainActivity extends BaseActivity {


    private MainActivity instance;
    @Override
    public void initTitle() {
        setTitleBarVisibleB(View.GONE);
    }

    private ImageView mImgUser;
    private DrawerLayout mLyDarg;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mMapView = (MapView) findViewById(R.id.map_map);
        mMapView.onCreate(savedInstanceState);

        //初始化地图控制器对象
        AMap aMap=null;
        if (aMap == null) {
            aMap = mMapView.getMap();
        }

        //显示蓝点
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        aMap.showIndoorMap(true);    //true：显示室内地图；false：不显示；
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_drag);
        instance = this;
        mImgUser = (ImageView) findViewById(R.id.iv_user_main);
        mLyDarg = (DrawerLayout) findViewById(R.id.activity_drag);

    }

    @Override
    public void initAvailable() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addEvent() {
        mImgUser.setOnClickListener(instance);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_user_main:
                mLyDarg.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
