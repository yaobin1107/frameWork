package cn.yb.file.web.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.net.URLEncoder;

/**
 * 文件下载步骤：
 * 1.写个action
 * 2.在action中提供一个输入流，提供get方法
 * 3.写一个下载方法，给inputstream赋值
 * 4.配置struts.xml
 * 1.result中加上type=stream，表示以流的形式将数据返回给客户端
 * 2.在result配置三个参数
 * <param name="inputName">inputStream</param>
 * <param name="contentDisposition">attachment;filename=downloadTest.rar</param>
 * <param name="contentType">application/octet-stream</param
 */
public class DownloadAction extends ActionSupport {

    private InputStream inputStream;
    private String fileName;

    public String download() throws FileNotFoundException, UnsupportedEncodingException {

        fileName = "简历.docx";
        //路径
        String path = "C:\\Users\\10598\\Documents\\常用文件\\" + fileName;
        //给inputstream赋值
        inputStream = new FileInputStream(path);

        //解决文件中文乱码
        fileName = new String(fileName.getBytes(), "ISO8859-1");

        return SUCCESS;
    }

    public String getFileName() {
        return fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
