package com.eaccount.controller.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.List;

/**
 * Created by yehao on 16/3/14.
 */
public class UploadFilesAction extends SuperAction{

    /** 代表上传的文件内容的对象 */
    private File upload;

    /** Struts2约定的代表上传的文件的名 */
    private String uploadFileName;
    /** Struts2约定的代表上传文件的内容类型(MIME) */
    private String uploadContentType;

    public String execute() throws Exception{
        String realpath=ServletActionContext.getServletContext().getRealPath("/image");
        File file=new File(realpath);
        if(!file.exists()) {
            file.mkdir();
        }
        FileUtils.copyFile(upload,new File(file, uploadFileName));
        return SUCCESS;
    }
}
