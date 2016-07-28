package com.recyclerview.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布布局管理器
 * 作者：zxd on 2016/7/28 15:02
 * 邮箱：xudong15950500210@163.com
 */
public class StraggerGridLayoutActivity extends Activity {
	private RecyclerView mRecyclerView;
	private List<String> mDatas;
	private HomeAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridlayout);
		initData();

		mRecyclerView = (RecyclerView)findViewById(R.id.id_recyclerview);
		//设置Item增加、移除动画
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		//添加分割线
		//当我们调用mRecyclerView.addItemDecoration()方法添加decoration的时候，RecyclerView在绘制的时候，去会绘制decorator，即调用该类的onDraw和onDrawOver方法，
		mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
		mAdapter = new HomeAdapter();
		mRecyclerView.setAdapter(mAdapter);
		//设置布局管理器
		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
//		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
	}


	protected void initData()
	{
		mDatas = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++)
		{
			mDatas.add("" + (char) i);
		}
	}

	class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
	{

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
		{
			MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
					StraggerGridLayoutActivity.this).inflate(R.layout.item_home, parent,
					false));
			return holder;
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, int position)
		{
			holder.tv.setText(mDatas.get(position));
		}

		@Override
		public int getItemCount()
		{
			return mDatas.size();
		}

		class MyViewHolder extends RecyclerView.ViewHolder
		{

			TextView tv;

			public MyViewHolder(View view)
			{
				super(view);
				tv = (TextView) view.findViewById(R.id.id_num);
			}
		}
	}
}
