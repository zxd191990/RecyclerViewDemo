package com.recyclerview.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * 作者：zxd on 2016/7/28 14:00
 * 邮箱：xudong15950500210@163.com
 */
public class HeaderBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	//item类型
	public static final int ITEM_TYPE_HEADER = 0;
	public static final int ITEM_TYPE_CONTENT = 1;
	public static final int ITEM_TYPE_BOTTOM = 2;
	//模拟数据
	public String [] texts={"java","python","C++","Php",".NET","js","Ruby","Swift","OC"};
	private LayoutInflater mLayoutInflater;
	private Context mContext;
	private int mHeaderCount=1;//头部View个数
	private int mBottomCount=1;//底部View个数

	public HeaderBottomAdapter(Context context) {
		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
	}

	//内容长度
	public int getContentItemCount(){
		return texts.length;
	}
	//判断当前item是否是HeadView
	public boolean isHeaderView(int position) {
		return mHeaderCount != 0 && position < mHeaderCount;
	}
	//判断当前item是否是FooterView
	public boolean isBottomView(int position) {
		return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
	}


	//判断当前item类型
	@Override
	public int getItemViewType(int position) {
		int dataItemCount = getContentItemCount();
		if (mHeaderCount != 0 && position < mHeaderCount) {
			//头部View
			return ITEM_TYPE_HEADER;
		} else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
			//底部View
			return ITEM_TYPE_BOTTOM;
		} else {
			//内容View
			return ITEM_TYPE_CONTENT;
		}
	}

	//内容 ViewHolder
	public static class ContentViewHolder extends RecyclerView.ViewHolder {
		private TextView textView;
		public ContentViewHolder(View itemView) {
			super(itemView);
			textView=(TextView)itemView.findViewById(R.id.tv_item_text);
		}
	}
	//头部 ViewHolder
	public static class HeaderViewHolder extends RecyclerView.ViewHolder {

		public HeaderViewHolder(View itemView) {
			super(itemView);
		}
	}
	//底部 ViewHolder
	public static class BottomViewHolder extends RecyclerView.ViewHolder {

		public BottomViewHolder(View itemView) {
			super(itemView);
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (viewType ==ITEM_TYPE_HEADER) {
			return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.rv_header, parent, false));
		} else if (viewType == mHeaderCount) {
			return  new ContentViewHolder(mLayoutInflater.inflate(R.layout.rv_item, parent, false));
		} else if (viewType == ITEM_TYPE_BOTTOM) {
			return new BottomViewHolder(mLayoutInflater.inflate(R.layout.rv_footer, parent, false));
		}
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if (holder instanceof HeaderViewHolder) {

		} else if (holder instanceof ContentViewHolder) {
			((ContentViewHolder) holder).textView.setText(texts[position - mHeaderCount]);

		} else if (holder instanceof BottomViewHolder) {

		}
	}

	@Override
	public int getItemCount() {
		return mHeaderCount + getContentItemCount() + mBottomCount;
	}



}
