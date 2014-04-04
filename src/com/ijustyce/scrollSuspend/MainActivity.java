package com.ijustyce.scrollSuspend;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

import com.example.meituandemo.R;
import com.ijustyce.scrollSuspend.SubspendScrollView.OnScrollListener;

public class MainActivity extends Activity implements OnScrollListener{
	
	private SubspendScrollView scrollView;	
	private LinearLayout mBuyLayout;
	private LinearLayout mTopLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);
		
		scrollView = (SubspendScrollView) findViewById(R.id.scrollView);
		mBuyLayout = (LinearLayout) findViewById(R.id.user);
		mTopLayout = (LinearLayout) findViewById(R.id.user_top);
		
		scrollView.setOnScrollListener(this);
		
		//�����ֵ�״̬���߿ؼ��Ŀɼ��Է����ı�ص��Ľӿ�
		findViewById(R.id.parent_layout).getViewTreeObserver()
		.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				//  ʹ�����غ�
				ViewScroll(scrollView.getScrollY());
				
				System.out.println(scrollView.getScrollY());
			}
		});
	}

	@Override
	public void ViewScroll(int scrollY) {
		int mBuyLayout2ParentTop = Math.max(scrollY, mBuyLayout.getTop());
		mTopLayout.layout(0, mBuyLayout2ParentTop, mTopLayout.getWidth(),
				mBuyLayout2ParentTop + mTopLayout.getHeight());
	}
}
