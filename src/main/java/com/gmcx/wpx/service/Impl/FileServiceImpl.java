package com.gmcx.wpx.service.Impl;

import com.gmcx.wpx.service.FileService;
import com.gmcx.wpx.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wpx on 2017/8/8.
 */
@Service
public class FileServiceImpl implements FileService {

    public String upLoadMakeDirImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        String imageName = null;
        if (!file.isEmpty()) {
            //获取文件名，带扩展名
            String originFileName = file.getOriginalFilename();
            //获取文件扩展名
            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            System.out.println(extension);
            //获取项目根目录路径
            String testImagesPath = request.getServletContext().getInitParameter("imagesPath");
//            E:\IntelliJ IDEA\Maven\target\maven\images
            String realseImagesPath = request.getServletContext().getRealPath("/images");
            System.out.println(testImagesPath);
            System.out.println(realseImagesPath);
            //创建目录文件夹
            File makeDir = new File(realseImagesPath + "/" + "makeDir");
            if (!makeDir.exists()) {
                makeDir.mkdir();
            }
            //创建图片文件
            imageName = DateUtil.getCurrentDate(DateUtil.FILE_PATTERN) + extension;
            File image = new File(makeDir.getPath() + "/" + imageName);

            if (!image.exists()) {
                try {
                    file.transferTo(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String hostIp = request.getServletContext().getInitParameter("hostAddress");
        return hostIp + "images" + "/" + "makeDir" + "/" + imageName;
    }

    public List<String> upLoadMakeDirImages(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files) {
        List<String> pathList = new ArrayList<String>();
        String[] imageName = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty()) {
                //获取文件名，带扩展名
                String originFileName = files[i].getOriginalFilename();
                //获取文件扩展名
                String extension = originFileName.substring(originFileName.lastIndexOf("."));
                System.out.println(extension);
                //获取项目根目录路径
                String testImagesPath = request.getServletContext().getInitParameter("imagesPath");
                String realseImagesPath = request.getServletContext().getRealPath("/images");
                System.out.println(testImagesPath);
                System.out.println(realseImagesPath);
                //创建目录文件夹
                File makeDir = new File(realseImagesPath + "/" + "makeDirs");
                if (!makeDir.exists()) {
                    makeDir.mkdir();
                }
                //创建图片文件
                imageName[i] = DateUtil.getCurrentDate(DateUtil.FILE_PATTERN) + extension;
                File image = new File(makeDir.getPath() + File.separator + imageName[i]);

                if (!image.exists()) {
                    try {
                        files[i].transferTo(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            String hostIp = request.getServletContext().getInitParameter("hostAddress");
            pathList.add(hostIp + "images" + "/" + "makeDirs" + "/" + imageName[i]);

        }

        return pathList;
    }
}
