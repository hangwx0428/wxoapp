package com.hang.wxoapp.contentgen.core.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.hang.wxoapp.contentgen.constants.CommonConstants;
import com.hang.wxoapp.contentgen.core.service.HttpRequestCoreService;
import com.hang.wxoapp.contentgen.utils.CloseableHttpClientUtil;
import org.springframework.stereotype.Service;

/**
 * @author 意修
 * @version \$Id: HttpRequestCoreServiceImpl.java, v 0.1 2021-05-03 1:17 PM 意修 Exp $$
 */
@Service
public class HttpRequestCoreServiceImpl implements HttpRequestCoreService {

    @Override
    public JSONObject get(String url, JSONObject param) {
        return JSONObject.parseObject(CloseableHttpClientUtil.doGet(url+ CommonConstants.QUESTION_MARK, param.toJSONString()));
    }

    @Override
    public JSONObject post() {
        return null;
    }
}
