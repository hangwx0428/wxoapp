package com.hang.wxoapp.contentgen.enums;

/**
 * 豆瓣榜单类型
 * @author 意修
 * @version \$Id: DoubanTopListTypeEnum.java, v 0.1 2021-05-03 12:15 PM 意修 Exp $$
 */
public enum DoubanTopListTypeEnum {

    /**
     * 电影
     */
    movie("movie", "电影榜单"),

    /**
     * 音乐
     */
    music("music", "音乐榜单"),


    ;


    /**
     * 枚举代码
     */
    private final String code;

    /**
     * 描述信息
     */
    private final String desc;

    /**
     * 构造器
     *
     * @param code 枚举代码
     * @param desc 描述信息
     */
    DoubanTopListTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据代码获取枚举
     *
     * @param code 枚举代码
     * @return 根据代码获取枚举
     */
    public static DoubanTopListTypeEnum getByCode(String code) {
        for (DoubanTopListTypeEnum e : DoubanTopListTypeEnum.values()) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 获取枚举代码
     *
     * @return 获取枚举代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取描述信息
     *
     * @return 获取描述信息
     */
    public String getDesc() {
        return desc;
    }
}
