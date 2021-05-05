package com.hang.wxoapp.contentgen.core.model;

import java.io.Serializable;

import com.hang.wxoapp.contentgen.core.model.object.Cover;
import com.hang.wxoapp.contentgen.core.model.object.Rating;
import lombok.Data;

/**
 * @author 意修
 * @version \$Id: ShowTopListItemEntity.java, v 0.1 2021-05-04 4:37 PM 意修 Exp $$
 */
@Data
public class ShowTopListItemEntity implements Serializable {

    private Rating rating;

    private Cover cover;

    private String card_subtitle;
    private String title;
    private String info;
    private String release_date;
    private String year;
    private String recommend_comment;
    private String url;
}
