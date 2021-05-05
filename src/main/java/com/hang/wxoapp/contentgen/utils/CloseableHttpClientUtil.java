package com.hang.wxoapp.contentgen.utils;

import java.io.IOException;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.hang.wxoapp.contentgen.constants.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @author 意修
 * @version \$Id: CloseableHttpClientUtil.java, v 0.1 2021-05-03 1:21 PM 意修 Exp $$
 */
public class CloseableHttpClientUtil {

    private static CloseableHttpClient httpClient = null;

    /**
     * 以get方式调用第三方接口
     * @param url
     * @return
     */
    public static String doGet(String url, String jsonStr) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String queryParam = json2HttpParam(jsonStr);
        url += url.endsWith(CommonConstants.QUESTION_MARK) ? queryParam
            : CommonConstants.CHAR_AND + queryParam;
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Referer", "https://m.douban.com/subject_collection/music_single");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //返回json格式
                String res = EntityUtils.toString(response.getEntity());
                return res;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以post方式调用第三方接口
     * @param url
     * @param json
     * @return
     */
    public static String doPost(String url, JSONObject json) {
        if (null == httpClient) {
            httpClient = HttpClientBuilder.create().build();
        }
        HttpPost httpPost = new HttpPost(url);
        //api_gateway_auth_token自定义header头，用于token验证使用
        httpPost.addHeader("Referer", "https://m.douban.com/subject_collection/music_single");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        try {
            StringEntity se = new StringEntity(json.toString());
            se.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            se.setContentType("application/x-www-form-urlencoded");
            //设置请求参数
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //返回json格式
                String res = EntityUtils.toString(response.getEntity());
                return res;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * json转成Http 请求参数
     * Note:仅支持转第一层
     * @param jsonStr json参数
     * @return str
     */
    public static String json2HttpParam(String jsonStr) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        int size = jsonObject.entrySet().size();
        int i = 0;
        for (Entry<String, Object> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            sb.append(key);
            sb.append("=");
            sb.append(value);
            if (i < size-1) {
                sb.append("&");
                i ++ ;
            }
        }
        return sb.toString();
    }
}
