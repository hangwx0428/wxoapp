package com.hang.wxoapp.contentgen.core.processor.contentgen;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import com.hang.wxoapp.contentgen.core.model.MovieTopListItemEntity;
import com.hang.wxoapp.contentgen.core.processor.contentgen.base.BaseContentGenProcessor;
import com.hang.wxoapp.contentgen.core.service.HttpRequestCoreService;
import com.hang.wxoapp.contentgen.core.service.WordWriteCoreService;
import com.hang.wxoapp.contentgen.utils.DateUtil;
import com.hang.wxoapp.contentgen.utils.FileOperationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author 意修
 * @version \$Id: MovieTopListGenProcessor.java, v 0.1 2021-05-03 1:02 PM 意修 Exp $$
 */
@Service
public class MovieTopListGenProcessor extends BaseContentGenProcessor<MovieTopListItemEntity> {

    private static final String URL = "https://m.douban.com/rexxar/api/v2/subject_collection/movie_showing/items";

    @Autowired
    private HttpRequestCoreService httpRequestCoreService;

    @Autowired
    private WordWriteCoreService wordWriteCoreService;

    @Override
    public List<MovieTopListItemEntity> execute() {
        // 1 从豆瓣中获取榜单内容
        JSONObject requestJson = new JSONObject();
        requestJson.put("start", 0);
        requestJson.put("count", 15);
        requestJson.put("items_only", 1);
        requestJson.put("for_mobile", 0);
        JSONObject result = httpRequestCoreService.get(URL, requestJson);
        List<MovieTopListItemEntity> listItemEntities = JSONObject.parseArray(result.getString("subject_collection_items"), MovieTopListItemEntity.class);

        // 2 排版
        String content = "";
        int index = 1;
        for(MovieTopListItemEntity movieTopListItemEntity : listItemEntities){
            // 2.1 生成内容
            // 海报
            content += movieTopListItemEntity.getCover().getUrl();
            content += "\n";
            // 标题
            content += index + " " + movieTopListItemEntity.getTitle();
            content += "\n";
            // 上映时间
            content += "上映时间: " + movieTopListItemEntity.getYear() + "." + movieTopListItemEntity.getRelease_date();
            content += "\n";
            // 创作团队介绍
            content += movieTopListItemEntity.getCard_subtitle();
            content += "\n";
            // 豆瓣评分
            if(movieTopListItemEntity.getRating()!=null){
                content += "豆瓣评分: " + movieTopListItemEntity.getRating().getValue();
                content += "\n";
                content += "评价人数: " + movieTopListItemEntity.getRating().getCount();
                content += "\n";
            }
            // 热评
            if(!CollectionUtils.isEmpty(movieTopListItemEntity.getComments())){
                content += "热评: " + movieTopListItemEntity.getComments().get(0).getComment();
                content += "\n";
            }
            /*// 详情地址
            content += "详情请点击: " + movieTopListItemEntity.getUrl();
            content += "\n";*/

            // 2.2 结尾空一格
            content += "\n";
            index++;
        }
        System.out.println(content);

        // 3 生成txt文件
        String name = "今日热门电影排行" + DateUtil.getDateString(new Date()) + ".txt";
        String pathUrl = "/Users/zhuhang/Downloads/" + name;
        FileOperationUtil.contentToTxt(pathUrl, content);

        wordWriteCoreService.writeMovieTopListText(listItemEntities);

        return listItemEntities;
    }

}
