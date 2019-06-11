package cn.yb.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class UploadController {

    /**
     * 商品图片上传
     */
    @RequestMapping("itemspic")
    public void itemspic(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*
         * System.out.println(request);
         * 打印的request：org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest@33b35316
         * 由于我们在SprinMVC中配置了CommonsMultipartResolver文件上传解析器
         * 所以它自动把我们的request转成了MultipartHttpServletRequest类型（实现类）
         */
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        //1.获取图片数据
        MultipartFile mfile = multiRequest.getFile("itemspic1");

        //2.把图片保存在某个路径
        //2.1获取当前项目下upload文件夹的绝对路径
        String uploadFolder = request.getServletContext().getRealPath("/upload");
        //System.out.println("uploadFolder:" + uploadFolder);
        //将uploadFolder转成File对象
        File uploadFolderFile = new File(uploadFolder);
        if (!uploadFolderFile.exists()) {//如果文件夹不存在就创建
            //mkdir()创建单级目录
            //mkdirs()创建多级目录
            uploadFolderFile.mkdir();
        }
        //2.2格式化文件名
        /*
         * 获取上传的文件后缀
         * MultipartFile的getOriginalFilename()方法可以获取到传入文件的原本属性名（filename）
         * split()返回一个数组，取数组第二个元素就是"."后的字符，也就是后缀
         * 注："."需要转义
         * */
        //获取后缀
        String suffix = mfile.getOriginalFilename().split("\\.")[1];
        //格式化文件名+后缀
        String fileName = UUID.randomUUID().toString() + "." + suffix;
        //得到完整路径
        String totalPath = uploadFolderFile + "/" + fileName;
        //System.out.println("totalPath:" + totalPath);
        //将文件保存到自定义（已经创建好）目录
        FileCopyUtils.copy(mfile.getInputStream(), new FileOutputStream(new File(totalPath)));

        //3.返回数据给客户端
        String imgURL = "http://localhost/upload/"+fileName;
        //注意：imgURL这里不能用totalPath，totalPath默认加电脑盘符
        String responseJson = "{\"imgUrl\":\""+imgURL+"\"}";
        //告诉客户端响应数据格式，注意这里写text/json
        response.setHeader("content-type","text/json;charset=utf-8");
        response.getWriter().write(responseJson);
    }
}
