package com.example.demo.controller;

import com.example.demo.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    static User user;
    static List<User> users; //模拟数据库查询
    static {
        user = new User();
        users = new ArrayList<>();
        user.setUserId("10");
        user.setUserName("张三");
        user.setUserAddress("湖北省武汉市");
        User user1 = new User();
        user1.setUserId("22");
        user1.setUserName("李四");
        user1.setUserAddress("广东省深圳市");
        users.add(user);
        users.add(user1);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @GetMapping("/{id}")
    public @ResponseBody
    User getUserById(@PathVariable(value = "id") Integer id) {
        return user;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/list")
    public @ResponseBody
    List<User> getUserList() {
        return users;
    }

    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    public @ResponseBody
    Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public @ResponseBody
    Map<String, Object> deleteUser(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }

    @ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"), @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")})
    @PutMapping("/{id}")
    public @ResponseBody
    Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }


}
