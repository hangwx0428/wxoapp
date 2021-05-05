package com.hang.wxoapp.contentgen.utils;

import com.alibaba.fastjson.JSONObject;

import org.junit.jupiter.api.Test;

/**
 * @author 意修
 * @version \$Id: CloseableHttpClientUtilTest.java, v 0.1 2021-05-03 2:12 PM 意修 Exp $$
 */
public class CloseableHttpClientUtilTest {

    @Test
    public void doGet() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("start", 0);
        jsonObject.put("count", 50);
        jsonObject.put("items_only", 1);
        jsonObject.put("for_mobile", 1);
        System.out.println(JSONObject.parseObject(CloseableHttpClientUtil.doGet("https://m.douban.com/rexxar/api/v2/subject_collection/movie_showing/items?",jsonObject.toJSONString())));
    }

    @Test
    public void doPost(){


    }
}