package com.hang.wxoapp.contentgen.core.model;

import java.io.Serializable;
import java.util.List;

import com.hang.wxoapp.contentgen.core.model.object.CommentItem;
import com.hang.wxoapp.contentgen.core.model.object.Cover;
import com.hang.wxoapp.contentgen.core.model.object.Rating;
import lombok.Data;

/**
 * 电影表单模型
 * @author 意修
 * @version \$Id: MovieTopListItemEntity.java, v 0.1 2021-05-03 3:15 PM 意修 Exp $$
 */
@Data
public class MovieTopListItemEntity implements Serializable {


    private Rating rating;

    private Cover cover;

    private String card_subtitle;
    private String title;
    private String info;
    private String release_date;
    private String year;
    private List<CommentItem> comments;
    private String url;

}
