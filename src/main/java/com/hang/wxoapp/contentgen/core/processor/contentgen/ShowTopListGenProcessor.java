package com.hang.wxoapp.contentgen.core.processor.contentgen;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import com.hang.wxoapp.contentgen.core.model.ShowTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.TvDramaTopListItemEntity;
import com.hang.wxoapp.contentgen.core.processor.contentgen.base.BaseContentGenProcessor;
import com.hang.wxoapp.contentgen.core.service.HttpRequestCoreService;
import com.hang.wxoapp.contentgen.core.service.WordWriteCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 意修
 * @version \$Id: ShowTopListGenProcessor.java, v 0.1 2021-05-04 4:47 PM 意修 Exp $$
 */
@Service
public class ShowTopListGenProcessor extends BaseContentGenProcessor<ShowTopListItemEntity> {

    private static final String URL = "https://m.douban.com/rexxar/api/v2/subject_collection/show_domestic/items";

    @Autowired
    private HttpRequestCoreService httpRequestCoreService;

    @Autowired
    private WordWriteCoreService wordWriteCoreService;

    @Override
    public List<ShowTopListItemEntity> execute() {
        // 1 从豆瓣中获取榜单内容
        JSONObject requestJson = new JSONObject();
        requestJson.put("start", 0);
        requestJson.put("count", 15);
        requestJson.put("items_only", 1);
        requestJson.put("for_mobile", 0);
        JSONObject result = httpRequestCoreService.get(URL, requestJson);
        List<ShowTopListItemEntity> listItemEntities = JSONObject.parseArray(result.getString("subject_collection_items"), ShowTopListItemEntity.class);

        // 2 生成word文档
        wordWriteCoreService.writeShowTopListText(listItemEntities);

        return listItemEntities;
    }
}
