import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {

    @Test
    public void test1(){
        //读取resources里面的properties文件（国际化资源文件）
        //使用ResourceBundle
        //baseName=包名+文件名
        //默认读取中文（本机环境）
        //ResourceBundle rb = ResourceBundle.getBundle("resources.message");
        //指定读取某个国家的国际化数据
        ResourceBundle rb = ResourceBundle.getBundle("resources.message", Locale.US);
        System.out.println(rb.getString("login.username"));
        System.out.println(rb.getString("login.password"));
        System.out.println(rb.getString("login.submit"));
    }
}
