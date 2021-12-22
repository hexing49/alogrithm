/*
package designPartten;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/7 10:26
 * @Description
 *//*

public class Test2 {
    private static String file = "d:\\test.txt";

    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(file)));
        User singleton = (User) objectInputStream.readObject();
        List<>
        System.out.println(singleton);
    }

    private Boolean sendEmailTotalReport(List<ClpsWarnOrderModel> clpsWarnOrderModels, Date start, Date end) {
        String startStr = DateUtil.format(start, "yyyy-MM-dd HH:mm:ss");
        String endStr = DateUtil.format(end, "yyyy-MM-dd HH:mm:ss");
        String timeName = DateConvertUtil.stampToString(System.currentTimeMillis(), "yyyyMMdd_HHmm");
        String subject = "仓库履约监控 " + timeName + "[" + startStr + "~" + endStr + "]";
        String fileName = "仓库履约数据统计表" + timeName + ".xlsx";
        List<String> recipientList = new ArrayList<>();
        recipientList.add("liangyinan3@jd.com");
        recipientList.add("dengshuangwei@jd.com");
        recipientList.add("gaohui@jd.com");
        recipientList.add("clp-omd@jd.com");
        String[] recipients = recipientList.toArray(new String[recipientList.size()]);
        String text = "<html lang='zh-CN'><head ><meta charset='utf-8'></head><body>" + subject + ",具体数据见附件</body></html>";
        File file = new File(fileName);
        EasyExcel.write(file, ClpsWarnOrderModel.class).sheet("sheet1").doWrite(clpsWarnOrderModels);
        try {
            Boolean res = SendMail.sendMailTxt(recipients, subject, text, fileName, file, true);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            file.delete();
        }
    }
}
*/
