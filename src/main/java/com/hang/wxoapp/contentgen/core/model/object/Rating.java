package com.hang.wxoapp.contentgen.core.model.object;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 意修
 * @version \$Id: Rating.java, v 0.1 2021-05-04 3:19 PM 意修 Exp $$
 */
@Data
public class Rating implements Serializable {
    private String count;
    private String max;
    private String value;
    private String star_count;
}
