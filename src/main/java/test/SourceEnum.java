package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mafayun
 * Date: 2017/12/29
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
public enum SourceEnum {

    SELLER(1, "商家端"),
    VMI(2, "vmi"),
    JDVMI(3, "自营vmi"),
    HZTZ(4, "货主调整"),
    REVERSEAO(6, "逆向货主单"),
    DEPTSHARE(5, "事业部库存共享"),
    ;
    private static final Map<Integer, SourceEnum> SourceEnum_MAP = new HashMap<Integer, SourceEnum>();


    static {
        for (SourceEnum e : SourceEnum.values()) {
            SourceEnum_MAP.put(e.getCode(), e);
        }
    }
    private final String name;
    private final Integer code;

    private SourceEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public static String getDesc(int code){
        return SourceEnum_MAP.get(code).getName();
    }
}
