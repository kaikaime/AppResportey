package com.example.lvkaixue.appmeager.bean;

import com.example.lvkaixue.appmeager.utils.JsonResponseParser;

import org.xutils.http.annotation.HttpResponse;

import java.util.ArrayList;

/**
 * Created by kaikaime on 2016/10/26.
 */
@HttpResponse(parser = JsonResponseParser.class)
public class ZhuanFa {
    public String ret;
    public String msg;
    public ArrayList<ZhuanFaBean> object;

    public class ZhuanFaBean {
        public String id;
        public String mName;
        public String mContent;
        public String mTime;
        public boolean mFlag;
        public String mAddress;
    }
}
