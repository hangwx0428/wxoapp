package com.hang.wxoapp.contentgen.core.processor.contentgen.base;

import java.util.List;

/**
 * 内容生成基础类
 * @author 意修
 * @version \$Id: BaseContentGenProcessor.java, v 0.1 2021-05-03 12:58 PM 意修 Exp $$
 */
public abstract class BaseContentGenProcessor<T>{

    /**
     * 生成内容
     */
    abstract public List<T> execute();

}
