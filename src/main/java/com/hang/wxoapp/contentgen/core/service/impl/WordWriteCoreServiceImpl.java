package com.hang.wxoapp.contentgen.core.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.hang.wxoapp.contentgen.constants.CommonConstants;
import com.hang.wxoapp.contentgen.core.model.MovieTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.MusicTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.ShowTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.TvDramaTopListItemEntity;
import com.hang.wxoapp.contentgen.core.service.BaseCoreService;
import com.hang.wxoapp.contentgen.core.service.WordWriteCoreService;
import com.hang.wxoapp.contentgen.utils.DateUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import static com.hang.wxoapp.contentgen.utils.FileOperationUtil.isDirectoryOrCreate;

/**
 * @author 意修
 * @version \$Id: WordWriteCoreServiceImpl.java, v 0.1 2021-05-03 7:03 PM 意修 Exp $$
 */
@Service
public class WordWriteCoreServiceImpl extends BaseCoreService implements WordWriteCoreService {

    private static final String WORD_PREFIX = "/Users/zhuhang/Documents/公众号/内容素材/";

    private static final String MOVIE_TOP_LIST_FILE_NAME = "今日热门电影排行.docx";

    private static final String TV_DRAMA_TOP_LIST_FILE_NAME = "今日热门国内电视剧排行.docx";

    private static final String MUSIC_TOP_LIST_FILE_NAME = "今日热门单曲排行.docx";

    private static final String SHOW_TOP_LIST_FILE_NAME = "今日热门国内综艺排行.docx";

    @Override
    public String writeMovieTopListText(List<MovieTopListItemEntity> listItemEntities) {
        try{
            // 1 设置out
            int index = 1;
            XWPFDocument document= new XWPFDocument();
            FileOutputStream out;
            String fileName = WORD_PREFIX + DateUtil.getDateString(new Date()) + CommonConstants.SLASH;
            isDirectoryOrCreate(fileName);
            fileName += DateUtil.getDateString(new Date()) + MOVIE_TOP_LIST_FILE_NAME;
            out = new FileOutputStream(new File(fileName));
            // 2 设置内容格式
            for(MovieTopListItemEntity movieTopListItemEntity : listItemEntities){
                setMovieTopListItemIntoDocument(index, movieTopListItemEntity, document);
                index++;
            }
            // 3 输出到word
            document.write(out);
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String writeTVdramaTopListText(List<TvDramaTopListItemEntity> listItemEntities) {
        try{
            // 1 设置out
            int index = 1;
            XWPFDocument document= new XWPFDocument();
            FileOutputStream out;
            String fileName = WORD_PREFIX + DateUtil.getDateString(new Date()) + CommonConstants.SLASH;
            isDirectoryOrCreate(fileName);
            fileName += DateUtil.getDateString(new Date()) + TV_DRAMA_TOP_LIST_FILE_NAME;
            out = new FileOutputStream(new File(fileName));
            // 2 设置内容格式
            for(TvDramaTopListItemEntity tvDramaTopListItemEntity : listItemEntities){
                setTvDramaTopListItemIntoDocument(index, tvDramaTopListItemEntity, document);
                index++;
            }
            // 3 输出到word
            document.write(out);
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String writeMusicTopListText(List<MusicTopListItemEntity> listItemEntities) {
        try{
            // 1 设置out
            int index = 1;
            XWPFDocument document= new XWPFDocument();
            FileOutputStream out;
            String fileName = WORD_PREFIX + DateUtil.getDateString(new Date()) + CommonConstants.SLASH;
            isDirectoryOrCreate(fileName);
            fileName += DateUtil.getDateString(new Date()) + MUSIC_TOP_LIST_FILE_NAME;
            out = new FileOutputStream(new File(fileName));
            // 2 设置内容格式
            for(MusicTopListItemEntity musicTopListItemEntity : listItemEntities){
                setMusicTopListItemIntoDocument(index, musicTopListItemEntity, document);
                index++;
            }
            // 3 输出到word
            document.write(out);
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String writeShowTopListText(List<ShowTopListItemEntity> listItemEntities) {
        try{
            // 1 设置out
            int index = 1;
            XWPFDocument document= new XWPFDocument();
            FileOutputStream out;
            String fileName = WORD_PREFIX + DateUtil.getDateString(new Date()) + CommonConstants.SLASH;
            isDirectoryOrCreate(fileName);
            fileName += DateUtil.getDateString(new Date()) + SHOW_TOP_LIST_FILE_NAME;
            out = new FileOutputStream(new File(fileName));
            // 2 设置内容格式
            for(ShowTopListItemEntity showTopListItemEntity : listItemEntities){
                setShowTopListItemIntoDocument(index, showTopListItemEntity, document);
                index++;
            }
            // 3 输出到word
            document.write(out);
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

}
