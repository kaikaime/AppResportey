package com.example.lvkaixue.appmeager.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.lvkaixue.appmeager.R;
import com.example.lvkaixue.appmeager.base.BaseFragment;
import com.example.lvkaixue.appmeager.base.BasePager;
import com.example.lvkaixue.appmeager.bean.PingLun;
import com.example.lvkaixue.appmeager.bean.ZhuanFa;
import com.example.lvkaixue.appmeager.protocol.childprotcol.PingLunProtocel;
import com.example.lvkaixue.appmeager.protocol.childprotcol.ZhuanFaProtocol;
import com.example.lvkaixue.appmeager.utils.HandlerUtils;

/**
 * Created by lvkaixue on 2016/9/8.
 */
public class CommentPage extends BaseFragment {

    private View mContextView;
    private PingLun pingLun;

    @Override
    protected View initToolBarView() {
        return null;
    }

    @Override
    public BasePager.ResultState getResultState() {
        if(HandlerUtils.checkNetWork()){
            pingLun = new PingLunProtocel("1").GetPost();
            if(pingLun != null && pingLun.object!=null){
                return BasePager.ResultState.SUCCESS;
            }else {
                return BasePager.ResultState.EMPTY;
            }
        }
        return BasePager.ResultState.SUCCESS;
    }

    @Override
    public View initSuccessView() {
        mContextView = View.inflate(mContext, R.layout.comment_item, null);
        TextView textView = (TextView) mContextView.findViewById(R.id.text_title);
        textView.setText("你暂时还没有任何人评论你的微薄!");
        return mContextView;
    }
}
