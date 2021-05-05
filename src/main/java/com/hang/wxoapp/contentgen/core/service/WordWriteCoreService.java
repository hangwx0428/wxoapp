package com.hang.wxoapp.contentgen.core.service;

import java.util.List;

import com.hang.wxoapp.contentgen.core.model.MovieTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.MusicTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.ShowTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.TvDramaTopListItemEntity;

/**
 * @author 意修
 * @version \$Id: WordWriteCoreService.java, v 0.1 2021-05-03 6:52 PM 意修 Exp $$
 */
public interface WordWriteCoreService {

    /**
     * 写入电影榜单内容到word
     * @param listItemEntities
     * @return
     */
    String writeMovieTopListText(List<MovieTopListItemEntity> listItemEntities);

    /**
     * 写入电视剧榜单内容到word
     * @param listItemEntities
     * @return
     */
    String writeTVdramaTopListText(List<TvDramaTopListItemEntity> listItemEntities);

    /**
     * 写入音乐榜单内容到word
     * @param listItemEntities
     * @return
     */
    String writeMusicTopListText(List<MusicTopListItemEntity> listItemEntities);

    /**
     * 写入综艺榜单内容到word
     * @param listItemEntities
     * @return
     */
    String writeShowTopListText(List<ShowTopListItemEntity> listItemEntities);

}
