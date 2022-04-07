package test;

/**
 * Created with IntelliJ IDEA.
 * User: mafayun
 * Date: 2018-11-10
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public enum ResultCodeEnum {
    SUCCEED("0", "成功"),
    FAILING("1", "失败");

    private final String name;
    private final String code;

    ResultCodeEnum(String code,String name ) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
