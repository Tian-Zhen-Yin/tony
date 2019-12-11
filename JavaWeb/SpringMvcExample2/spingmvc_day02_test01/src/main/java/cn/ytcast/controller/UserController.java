package cn.ytcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");


        //使用fileupoad组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdir();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断，当前item对象是否上传文件项
            if (item.isFormField()) {
                //说明是普通表单项
            } else {
                //说明上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //b把文件名设置唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = filename + "_" + uuid;
                //完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * SpringMvc上传文件的方式
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传");


        //使用fileupoad组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdir();
        }
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //b把文件名设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = filename + "_" + uuid;
        //完成文件上传
        upload.transferTo(new File(filename));


        return "success";
    }


    /**
     * 跨服务器上传文件的方式
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("springmvc跨服务器文件上传");

        //定义上传服务器路径
        String path ="http://localhost:9090/fileuploadserver_war_exploded/uploads/";
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件名设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = filename + "_" + uuid;
        //创建客户端对象
        Client client =Client.create();
        //连接服务器
        WebResource webResource=client.resource(path+filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";

    }
}
