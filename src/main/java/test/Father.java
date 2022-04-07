package test;

public class Father {
    public void eat() {
        System.out.println("爸爸喜欢吃");
    }

    public AoStatusEnum buildCancelStatus(String code) {
        AoStatusEnum aoStatusEnum = AoStatusEnum.INIT;
        if (ResultCodeEnum.SUCCEED.getCode().equals(code)) {
            aoStatusEnum = AoStatusEnum.CACEL_SUCC;
        } else if (ResultCodeEnum.FAILING.getCode().equals(code)) {
            aoStatusEnum = AoStatusEnum.CACEL_FAIL;
        }
        AoStatusEnum aoStatusEnum1 = aoStatusEnum;
        return aoStatusEnum1;
    }
}
