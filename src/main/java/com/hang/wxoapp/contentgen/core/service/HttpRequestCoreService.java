package com.hang.wxoapp.contentgen.core.service;

import com.alibaba.fastjson.JSONObject;

/**
 * http请求核心服务
 * @author 意修
 * @version \$Id: HttpRequestCoreService.java, v 0.1 2021-05-03 1:16 PM 意修 Exp $$
 */
public interface HttpRequestCoreService {

    /**
     * get请求
     * @return
     */
    JSONObject get(String url, JSONObject param);

    /**
     * posy请求
     * @return
     */
    JSONObject post();
}
