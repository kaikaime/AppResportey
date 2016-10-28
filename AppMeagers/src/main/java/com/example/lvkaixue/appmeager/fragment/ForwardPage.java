package com.example.lvkaixue.appmeager.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.lvkaixue.appmeager.R;
import com.example.lvkaixue.appmeager.base.BaseFragment;
import com.example.lvkaixue.appmeager.base.BasePager;
import com.example.lvkaixue.appmeager.bean.ZhuanFa;
import com.example.lvkaixue.appmeager.protocol.childprotcol.ZhuanFaProtocol;
import com.example.lvkaixue.appmeager.utils.HandlerUtils;

/**
 * Created by lvkaixue on 2016/9/8.
 */
public class ForwardPage extends BaseFragment {
    private View mContextView;
    private ZhuanFa zhuanFa;

    @Override
    protected View initToolBarView() {
        return null;
    }

    @Override
    public BasePager.ResultState getResultState() {
        if(HandlerUtils.checkNetWork()){
            zhuanFa = new ZhuanFaProtocol("1").GetPost();
            if(zhuanFa != null && zhuanFa.object!=null){
                return BasePager.ResultState.SUCCESS;
            }else {
                return BasePager.ResultState.EMPTY;
            }
        }
        return BasePager.ResultState.ERROR;
    }

    @Override
    public View initSuccessView() {
        mContextView = View.inflate(mContext, R.layout.forword_item, null);
        TextView textView = (TextView) mContextView.findViewById(R.id.text_title);
        textView.setText("你暂时还没有任何人转发你的微薄!");
        return mContextView;
    }
}
