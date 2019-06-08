package cn.yb.file.web.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

public class UploadAction2 extends ActionSupport {

    private String username;
    private String password;
    private File[] photo; //struts会自动把数据转成文件对象
    private String[] photoContentType;//文件类型
    private String[] photoFileName;//文件名称

    public String upload() {
        //遍历文件
        for (int i = 0; i < photo.length; i++) {
            //获取文件
            File file = photo[i];
            System.out.println("文件临时路径：" + file);
            System.out.println("文件类型：" + photoContentType[i]);
            System.out.println("文件名：" + photoFileName[i]);
        }
        return NONE;
    }

    public File[] getPhoto() {
        return photo;
    }

    public void setPhoto(File[] photo) {
        this.photo = photo;
    }

    public String[] getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String[] photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String[] getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String[] photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
