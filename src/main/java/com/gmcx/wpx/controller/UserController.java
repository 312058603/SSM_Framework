package com.gmcx.wpx.controller;

import com.gmcx.wpx.model.*;
import com.gmcx.wpx.service.BookService;
import com.gmcx.wpx.service.FileService;
import com.gmcx.wpx.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wpx on 2017/7/31.
 */
@RestController
@RequestMapping("/UserController")
public class UserController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;
    @Resource
    private FileService fileService;

    //Get-路径参数
    @RequestMapping(method = RequestMethod.GET, value = "/httpGet/{name}/{age}")
    private String httpGet(@PathVariable("name") String name, @PathVariable("age") int age) {
        return "调用成功";
    }

    @ModelAttribute(value = "testUser") //在所有的UserController方法执行之前执行
    private String testModelAttribute() {
        return "调用成功 hello world1";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/testMap")
    private String testMap(@RequestParam Map map, @ModelAttribute(value = "testUser") User user) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("value=" + map.get(key));
            System.out.println("value=" + map.get(key).getClass());
        }
        return "OK";
    }

    //Post-表单参数 接收指定参数
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostForm")
    private Person httpPostForm(String name, int age) {
        System.out.println("httpPostForm");
        Person person = new Person();
        person.setName("wpx");
        person.setAge(20);
        return person;
    }

    //Post-查询字符串 参数可选择传递
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostQuaryParam")
    private String httpPostQuaryParam(@RequestParam(value = "name", required = true) String name) {
        System.out.println("httpPostQuaryParam");
        return "httpPostQuaryParam name=" + name;
    }

    //Post-表单参数Map 适合多对象Json传递 或者多种类型参数的传递
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostQuaryParam_map")
    private String httpPostQuaryParam_map(@RequestParam Map map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("value=" + map.get(key));
            System.out.println("value=" + map.get(key).getClass());
        }
        return "OK";
    }

    //Post-Json参数 示例添加User
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostJson_insert")
    private BaseResModel<String> httpPostJson_insert(@RequestBody UserToBooks userToBooks) {
        int count = 0;
        count = userService.insertUserToBooks(userToBooks);
        BaseResModel<String> model = new BaseResModel<String>();
        model.setCode(100);
        model.setMsg("添加数据成功");
        model.setData("受影响的行数" + (count));
        return model;
    }

    //Post-Json参数 示例添加UserList
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostJsonArray_insert")
    private BaseResModel<String> httpPostJsonArray_insert(@RequestBody List<User> userList) {
        int count = userService.insertUserList(userList);
        BaseResModel<String> model = new BaseResModel<String>();
        model.setCode(100);
        model.setMsg("添加UserList成功");
        model.setData("受影响的行数" + count);
        return model;
    }

    //Post-Map参数 示例删除User
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostQuaryParam_delete")
    private BaseResModel<String> httpPostQuaryParam_delete(@RequestBody User user) {
        int count = userService.deleteUser(user);
        BaseResModel<String> model = new BaseResModel<String>();
        model.setCode(100);
        model.setMsg("删除User成功");
        model.setData("受影响的行数" + count);
        return model;
    }

    //Post-Map参数 示例更新User
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostQuaryParam_update")
    private BaseResModel<String> httpPostQuaryParam_update(@RequestBody User user) {
        int count = userService.updateUser(user);
        BaseResModel<String> model = new BaseResModel<String>();
        model.setCode(100);
        model.setMsg("更新User成功");
        model.setData("受影响的行数" + count);
        return model;
    }

    //Post-Map参数 一对多关联查询
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostSelectUser")
    private BaseResModel<User> httpPostSelectUser(int user_Id) {
        User user = userService.selectUser(user_Id);
        BaseResModel<User> model = new BaseResModel<User>();
        model.setCode(100);
        model.setMsg("查询成功");
        model.setData(user);
        return model;
    }

    //Post-Map参数 一对多关联查询
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostSelectUserToBooks")
    private BaseResModel<UserToBooks> httpPostSelectUserToBooks(int user_Id) {
        UserToBooks userToBooks = userService.selectUserToBooks(user_Id);
        BaseResModel<UserToBooks> model = new BaseResModel<UserToBooks>();
        model.setCode(100);
        model.setMsg("更新User成功");
        model.setData(userToBooks);
        return model;
    }

    //Post-Map参数 一堆一关联查询
    @RequestMapping(method = RequestMethod.POST, value = "/httpPostSelectUserToRole")
    private BaseResModel<UserToRole> httpPostSelectUserToRole(int user_Id) {
        UserToRole userToRole = userService.selectUserToRole(user_Id);
        BaseResModel<UserToRole> model = new BaseResModel<UserToRole>();
        model.setCode(100);
        model.setMsg("查询UserToRole成功");
        model.setData(userToRole);
        return model;
    }

    //单文件上传
    @RequestMapping("uploadFile")
    private BaseResModel<String> upLoadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
        BaseResModel<String> model = new BaseResModel<String>();
        String path= fileService.upLoadMakeDirImage(request,response,file);
        model.setCode(100);
        model.setMsg("上传单张图片成功");
        model.setData(path);
        return model;
    }

    //多文件上传
    @RequestMapping("uploadFiles")
    private BaseResModel<List<String>> upLoadFiles(HttpServletRequest request, HttpServletResponse response, @RequestParam("files") MultipartFile[] files) {
        BaseResModel<List<String>> model = new BaseResModel<List<String>>();
        List<String> pathList= fileService.upLoadMakeDirImages(request,response,files);
        model.setCode(100);
        model.setMsg("上传多张图片成功");
        model.setData(pathList);
        return model;
    }

}
