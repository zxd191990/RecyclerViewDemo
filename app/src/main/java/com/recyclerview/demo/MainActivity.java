package com.recyclerview.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
/**
 * 作者：zxd on 2016/7/28 13:59
 * 邮箱：xudong15950500210@163.com
 */
public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private HeaderBottomAdapter adapter;
	//布局管理器LayoutManager
	LinearLayoutManager layoutManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mRecyclerView = (RecyclerView)findViewById(R.id.rv_list);
		//List布局
		layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		//设置布局管理器
		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.setAdapter(adapter = new HeaderBottomAdapter(this));
		//设置Item增加、移除动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		//添加分割线
		//当我们调用mRecyclerView.addItemDecoration()方法添加decoration的时候，RecyclerView在绘制的时候，去会绘制decorator，即调用该类的onDraw和onDrawOver方法，
		mRecyclerView.addItemDecoration(new DividerItemDecoration(
				this, DividerItemDecoration.VERTICAL_LIST));
	}
}
