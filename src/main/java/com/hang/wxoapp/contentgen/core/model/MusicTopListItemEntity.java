package com.hang.wxoapp.contentgen.core.model;

import java.io.Serializable;
import java.util.List;

import com.hang.wxoapp.contentgen.core.model.object.CommentItem;
import com.hang.wxoapp.contentgen.core.model.object.Cover;
import com.hang.wxoapp.contentgen.core.model.object.Rating;
import lombok.Data;

/**
 * @author 意修
 * @version \$Id: MusicTopListItemEntity.java, v 0.1 2021-05-04 3:59 PM 意修 Exp $$
 */
@Data
public class MusicTopListItemEntity implements Serializable {

    private Rating rating;

    private Cover cover;

    private String card_subtitle;
    private String title;
    private List<String> pubdate;
    private String recommend_comment;
    private String url;
}
