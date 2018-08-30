package com.gmcx.wpx.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wpx on 2017/8/8.
 */
public interface FileService {

    public String upLoadMakeDirImage(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file);

    public List<String> upLoadMakeDirImages(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile[] files);

}
