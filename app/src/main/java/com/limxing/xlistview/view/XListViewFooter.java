/**
 * @file XFooterView.java
 * @author Limxing
 * @description XListView's footer
 */
package com.limxing.xlistview.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.limxing.xlistview.R;


public class XListViewFooter extends LinearLayout {
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;

	private Context mContext;

	private View mContentView;
	private View mProgressBar;
	private TextView mHintView;
	private RelativeLayout xlistview_footer_state;
	private LoadView xlistview_footer_loadview;

	public XListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	public XListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}


	public void setState(int state) {
		mHintView.setVisibility(View.INVISIBLE);
		mProgressBar.setVisibility(View.INVISIBLE);
		mHintView.setVisibility(View.INVISIBLE);
		if (state == STATE_READY) {
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_ready);
		} else if (state == STATE_LOADING) {
			xlistview_footer_loadview.startLoad();
			mProgressBar.setVisibility(View.VISIBLE);
		} else {
			xlistview_footer_loadview.stopLoad();
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_normal);
		}
	}

	public void setBottomMargin(int height) {
		if (height < 0) return;
		LayoutParams lp = (LayoutParams) mContentView.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}

	public int getBottomMargin() {
		LayoutParams lp = (LayoutParams) mContentView.getLayoutParams();
		return lp.bottomMargin;
	}


	/**
	 * normal status
	 */
	public void normal() {
		mHintView.setVisibility(View.VISIBLE);
		mProgressBar.setVisibility(View.GONE);
	}


	/**
	 * loading status
	 */
	public void loading() {
		mHintView.setVisibility(View.GONE);
		mProgressBar.setVisibility(View.VISIBLE);
	}

	/**
	 * hide footer when disable pull load more
	 */
	public void hide() {
//		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
//		lp.height = 0;
//		mContentView.setLayoutParams(lp);
		mContentView.setVisibility(View.GONE);
	}

	/**
	 * show footer
	 */
	public void show() {
//		LayoutParams lp = (LayoutParams)mContentView.getLayoutParams();
//		lp.height = LayoutParams.WRAP_CONTENT;
//		mContentView.setLayoutParams(lp);
		mContentView.setVisibility(View.VISIBLE);
	}

	private void initView(Context context) {
		mContext = context;
		LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.xlistview_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		xlistview_footer_state = (RelativeLayout) moreView.findViewById(R.id.xlistview_footer_state);
		xlistview_footer_state.setVisibility(View.GONE);
		mContentView = moreView.findViewById(R.id.xlistview_footer_content);
		mProgressBar = moreView.findViewById(R.id.xlistview_footer_progressbar);
		mHintView = (TextView) moreView.findViewById(R.id.xlistview_footer_hint_textview);
		xlistview_footer_loadview = (LoadView) moreView.findViewById(R.id.xlistview_footer_loadview);
	}

	public TextView getmHintView() {
		return mHintView;
	}

	/**
	 * 设置是否显示有无数据有好提示
	 *
	 * @param isNone
	 */
	public void setNoneDataState(boolean isNone) {
		if (isNone) {
			xlistview_footer_state.setVisibility(View.VISIBLE);
		} else {
			xlistview_footer_state.setVisibility(View.GONE);
		}

	}
}
