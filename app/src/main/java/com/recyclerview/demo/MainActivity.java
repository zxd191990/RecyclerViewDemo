package com.recyclerview.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

/**
 * 作者：zxd on 2016/7/28 13:59
 * 邮箱：xudong15950500210@163.com
 */
public class MainActivity extends Activity implements View.OnClickListener{
	private RecyclerView mRecyclerView;
	private HeaderBottomAdapter adapter;
	/**
	 *RecyclerView.LayoutManager，这是一个抽象类，好在系统提供了3个实现类：
	 * 1.LinearLayoutManager 现行管理器，支持横向、纵向。
	 * 2.GridLayoutManager 网格布局管理器
	 * 3.StaggeredGridLayoutManager 瀑布就式布局管理器
	 */
	//布局管理器LayoutManager
	LinearLayoutManager layoutManager;
	private Button gridLayoutButton;
	private Button staggeredGridLayoutButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridLayoutButton = (Button)findViewById(R.id.gridLayoutManager);
		gridLayoutButton.setOnClickListener(this);
		staggeredGridLayoutButton = (Button)findViewById(R.id.staggeredGridLayoutManager);
		staggeredGridLayoutButton.setOnClickListener(this);

		mRecyclerView = (RecyclerView)findViewById(R.id.rv_list);
		//List布局
		layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		adapter = new HeaderBottomAdapter(this);
		mRecyclerView.setAdapter(adapter);
		//设置Item增加、移除动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		//添加分割线
		//当我们调用mRecyclerView.addItemDecoration()方法添加decoration的时候，RecyclerView在绘制的时候，去会绘制decorator，即调用该类的onDraw和onDrawOver方法，
		mRecyclerView.addItemDecoration(new DividerItemDecoration(
				this, DividerItemDecoration.VERTICAL_LIST));
		//设置布局管理器
		mRecyclerView.setLayoutManager(layoutManager);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.gridLayoutManager:
				startActivity(new Intent(this,GridLayoutActivity.class));
				break;
			case R.id.staggeredGridLayoutManager:
				startActivity(new Intent(this, StraggerGridLayoutActivity.class));
				break;
		}
	}
}
