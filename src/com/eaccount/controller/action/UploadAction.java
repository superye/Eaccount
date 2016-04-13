package com.eaccount.controller.action;

import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * Created by spzn on 16-3-14.
 */
public class UploadAction extends SuperAction{
    public String UploadImage() throws IOException {

        String file = request.getParameter("myFile");
        String username = request.getParameter("username");
        GenerateImage(file, username);

        return null;
    }

    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr, String username) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {//调整异常数据
                    b[i]+=256;
                }
            }
            InputStream input = new ByteArrayInputStream(b);


            // 设置上传文件目录
            String uploadPath = ServletActionContext.getServletContext()
                    .getRealPath("/upload");

            System.out.println(uploadPath);
            System.out.println(username);
            File toFile = new File(uploadPath, username + ".jpg");

            OutputStream out = new FileOutputStream(toFile);

            byte[] buffer = new byte[1024];

            int length = 0;

            //读取myFile文件输出到toFile文件中
            while ((length = input.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.flush();
            out.close();
            input.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
