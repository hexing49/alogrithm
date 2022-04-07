package test;

/**
 * Created with IntelliJ IDEA.
 * User: mafayun
 * Date: 2018-11-07
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public enum AoStatusEnum {

    INIT(1000, "新建"),
    INIT_STOCK(1010, "创建预占库存成功"),
    TRANSPORT(2000,"已下发库房"),
    SUCCESS(3000, "调整完成"),
    FAULT(4000,"调整失败"),
    POCOMPLETE(5000,"采购完成"),
    CACEL_SUCC(6000,"取消成功"),
    CACEL_FAIL(7000,"取消失败"),
    CACELING(8000,"取消中"),
    ;


    private final Integer code;
    private final String desc;


    private AoStatusEnum(Integer code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
