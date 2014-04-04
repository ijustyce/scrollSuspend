package com.ijustyce.scrollSuspend;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

import com.example.meituandemo.R;
import com.ijustyce.scrollSuspend.SubspendScrollView.OnScrollListener;

public class MainActivity extends Activity implements OnScrollListener{
	/**
	 * �Զ����MyScrollView
	 */
	private SubspendScrollView myScrollView;
	/**
	 * ��MyScrollView����Ĺ��򲼾�
	 */
	private LinearLayout mBuyLayout;
	/**
	 * λ�ڶ����Ĺ��򲼾�
	 */
	private LinearLayout mTopBuyLayout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);
		
		myScrollView = (SubspendScrollView) findViewById(R.id.scrollView);
		mBuyLayout = (LinearLayout) findViewById(R.id.buy);
		mTopBuyLayout = (LinearLayout) findViewById(R.id.top_buy_layout);
		
		myScrollView.setOnScrollListener(this);
		
		//�����ֵ�״̬���߿ؼ��Ŀɼ��Է����ı�ص��Ľӿ�
		findViewById(R.id.parent_layout).getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				//��һ������Ҫ��ʹ������Ĺ��򲼾ֺ�����Ĺ��򲼾��غ�
				ViewScroll(myScrollView.getScrollY());
				
				System.out.println(myScrollView.getScrollY());
			}
		});
	}

	@Override
	public void ViewScroll(int scrollY) {
		int mBuyLayout2ParentTop = Math.max(scrollY, mBuyLayout.getTop());
		mTopBuyLayout.layout(0, mBuyLayout2ParentTop, mTopBuyLayout.getWidth(), mBuyLayout2ParentTop + mTopBuyLayout.getHeight());
	}
}
