package com.ijustyce.scrollSuspend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class SubspendScrollView extends ScrollView {
	private OnScrollListener onScrollListener;
	
	public SubspendScrollView(Context context) {
		this(context, null);
	}
	
	public SubspendScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SubspendScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	
	/**
	 * ���ù����ӿ�
	 * @param onScrollListener
	 */
	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}
	

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if(onScrollListener != null){
			onScrollListener.ViewScroll(t);
		}
	}

	/**
	 * �����Ļص��ӿ�
	 */
	public interface OnScrollListener{
		/**
		 * �ص������� ����MyScrollView������Y�������
		 * @param scrollY
		 * 	
		 */
		public void ViewScroll(int scrollY);
	}
}
