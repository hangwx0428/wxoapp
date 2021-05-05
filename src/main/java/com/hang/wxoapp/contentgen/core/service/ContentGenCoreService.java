package com.hang.wxoapp.contentgen.core.service;

import com.hang.wxoapp.contentgen.enums.DoubanTopListTypeEnum;

/**
 * 内容生成核心服务
 * @author 意修
 * @version \$Id: ContentGenCoreService.java, v 0.1 2021-05-03 12:12 PM 意修 Exp $$
 */
public interface ContentGenCoreService {

    /**
     * 豆瓣榜单类文章自动生成
     */
    void doubanTopListGen(DoubanTopListTypeEnum type);


}
