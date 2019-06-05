package cn.yb.struts.web.convert;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyDateConvert extends StrutsTypeConverter {
    /**
     * 把字符串转成对象
     *
     * @param map
     * @param strings 表单数据
     * @param aClass  要转化的对象的类型
     * @return
     */
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        if (strings != null && strings.length > 0) {
            //取数据
            String str = strings[0];
            if ("".equals(str)) {//空字符串
                return null;
            }
            //转换
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                return sdf.parse(str);
            } catch (ParseException e) {
                throw new RuntimeException(e);//转换异常
            }
        }
        return null;
    }

    /**
     * 把对象转成字符串
     *
     * @param map
     * @param o
     * @return
     */
    @Override
    public String convertToString(Map map, Object o) {
        return null;
    }
}
