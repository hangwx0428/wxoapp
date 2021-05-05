package com.hang.wxoapp.contentgen.core.service;

import java.io.FileInputStream;

import com.hang.wxoapp.contentgen.core.model.MovieTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.MusicTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.ShowTopListItemEntity;
import com.hang.wxoapp.contentgen.core.model.TvDramaTopListItemEntity;
import com.hang.wxoapp.contentgen.utils.FileOperationUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.util.CollectionUtils;

/**
 * @author 意修
 * @version \$Id: BaseCoreService.java, v 0.1 2021-05-04 3:27 PM 意修 Exp $$
 */
public class BaseCoreService {

    private static final String MOVIE_FILE_PATH_PREFIX = "/Users/zhuhang/Documents/公众号/图片素材/电影/";

    private static final String TV_DRAMA_FILE_PATH_PREFIX = "/Users/zhuhang/Documents/公众号/图片素材/国内电视剧/";

    private static final String MUSIC_FILE_PATH_PREFIX = "/Users/zhuhang/Documents/公众号/图片素材/音乐/";

    private static final String SHOW_FILE_PATH_PREFIX = "/Users/zhuhang/Documents/公众号/图片素材/综艺/";

    /**
     * 电影item组装
     * @param index
     * @param movieTopListItemEntity
     * @param document
     */
    protected void setMovieTopListItemIntoDocument(int index, MovieTopListItemEntity movieTopListItemEntity, XWPFDocument document){
        try{
            // 1 设置海报
            String imagePath = FileOperationUtil.saveToFile(MOVIE_FILE_PATH_PREFIX, movieTopListItemEntity.getCover().getUrl());
            setImageParagraph(document, imagePath, 300, 450);

            // 2 设置标题
            XWPFRun titleRun = setTextParagraph(document, index + " " + movieTopListItemEntity.getTitle() + "\n");
            titleRun.setFontSize(20);
            titleRun.setColor("DC143C");

            // 3 设置上映时间
            setTextParagraph(document, "上映时间: " + movieTopListItemEntity.getYear() + "." + movieTopListItemEntity.getRelease_date() + "\n");

            // 4 创作团队介绍
            setTextParagraph(document, movieTopListItemEntity.getCard_subtitle() + "\n");

            // 5 豆瓣评分
            if(movieTopListItemEntity.getRating()!=null){
                setTextParagraph(document, "豆瓣评分: " + movieTopListItemEntity.getRating().getValue() + "\n");
                setTextParagraph(document, "评价人数: " + movieTopListItemEntity.getRating().getCount() + "\n");
            }
            // 热评
            if(!CollectionUtils.isEmpty(movieTopListItemEntity.getComments())){
                setTextParagraph(document, "热评: " + movieTopListItemEntity.getComments().get(0).getComment() + "\n");
            }

            // 6 结尾空一格
            setTextParagraph(document, "\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 电视剧item组装
     * @param index
     * @param tvDramaTopListItemEntity
     * @param document
     */
    protected void setTvDramaTopListItemIntoDocument(int index, TvDramaTopListItemEntity tvDramaTopListItemEntity, XWPFDocument document){
        try{
            // 1 设置海报
            String imagePath = FileOperationUtil.saveToFile(TV_DRAMA_FILE_PATH_PREFIX, tvDramaTopListItemEntity.getCover().getUrl());
            setImageParagraph(document, imagePath, 300,450);

            // 2 设置标题
            XWPFRun titleRun = setTextParagraph(document, index + " " + tvDramaTopListItemEntity.getTitle() + "\n");
            titleRun.setFontSize(20);
            titleRun.setColor("DC143C");

            // 3 设置上映时间
            setTextParagraph(document, "上映时间: " + tvDramaTopListItemEntity.getYear() + "." + tvDramaTopListItemEntity.getRelease_date() + "\n");

            // 4 创作团队介绍
            setTextParagraph(document, tvDramaTopListItemEntity.getCard_subtitle() + "\n");

            // 5 豆瓣评分
            if(tvDramaTopListItemEntity.getRating()!=null){
                setTextParagraph(document, "豆瓣评分: " + tvDramaTopListItemEntity.getRating().getValue() + "\n");
                setTextParagraph(document, "评价人数: " + tvDramaTopListItemEntity.getRating().getCount() + "\n");
            }
            // 6 热评
            setTextParagraph(document, "热评: " + tvDramaTopListItemEntity.getRecommend_comment() + "\n");

            // 7 更新集数
            setTextParagraph(document, tvDramaTopListItemEntity.getEpisodes_info() + "\n");

            // 8 结尾空一格
            setTextParagraph(document, "\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 音乐item组装
     * @param index
     * @param musicTopListItemEntity
     * @param document
     */
    protected void setMusicTopListItemIntoDocument(int index, MusicTopListItemEntity musicTopListItemEntity, XWPFDocument document){
        try{
            // 1 设置海报
            String imagePath = FileOperationUtil.saveToFile(MUSIC_FILE_PATH_PREFIX, musicTopListItemEntity.getCover().getUrl());
            setImageParagraph(document, imagePath, 300, 300);

            // 2 设置标题
            XWPFRun titleRun = setTextParagraph(document, index + " " + musicTopListItemEntity.getTitle() + "\n");
            titleRun.setFontSize(20);
            titleRun.setColor("DC143C");

            // 4 创作团队介绍
            setTextParagraph(document, musicTopListItemEntity.getCard_subtitle() + "\n");

            // 5 豆瓣评分
            if(musicTopListItemEntity.getRating()!=null){
                setTextParagraph(document, "豆瓣评分: " + musicTopListItemEntity.getRating().getValue() + "\n");
                setTextParagraph(document, "评价人数: " + musicTopListItemEntity.getRating().getCount() + "\n");
            }
            // 6 热评
            setTextParagraph(document, "热评: " + musicTopListItemEntity.getRecommend_comment() + "\n");

            // 7 结尾空一格
            setTextParagraph(document, "\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 综艺item组装
     * @param index
     * @param showTopListItemEntity
     * @param document
     */
    protected void setShowTopListItemIntoDocument(int index, ShowTopListItemEntity showTopListItemEntity, XWPFDocument document){
        try{
            // 1 设置海报
            String imagePath = FileOperationUtil.saveToFile(SHOW_FILE_PATH_PREFIX, showTopListItemEntity.getCover().getUrl());
            setImageParagraph(document, imagePath, 300, 450);

            // 2 设置标题
            XWPFRun titleRun = setTextParagraph(document, index + " " + showTopListItemEntity.getTitle() + "\n");
            titleRun.setFontSize(20);
            titleRun.setColor("DC143C");

            // 4 创作团队介绍
            setTextParagraph(document, showTopListItemEntity.getCard_subtitle() + "\n");

            // 5 豆瓣评分
            if(showTopListItemEntity.getRating()!=null){
                setTextParagraph(document, "豆瓣评分: " + showTopListItemEntity.getRating().getValue() + "\n");
                setTextParagraph(document, "评价人数: " + showTopListItemEntity.getRating().getCount() + "\n");
            }
            // 6 热评
            setTextParagraph(document, "热评: " + showTopListItemEntity.getRecommend_comment() + "\n");

            // 7 结尾空一格
            setTextParagraph(document, "\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected XWPFRun setTextParagraph(XWPFDocument document, String text){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        if(StringUtils.isNotBlank(text)){
            run.setText(text);
        }
        return run;
    }

    protected XWPFRun setImageParagraph(XWPFDocument document, String picPath, int width, int height){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        if(StringUtils.isNotBlank(picPath)){
            try{
                run.addPicture(new FileInputStream(picPath), XWPFDocument.PICTURE_TYPE_JPEG,
                    picPath,
                    Units.toEMU(width),
                    Units.toEMU(height));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return run;
    }


}
