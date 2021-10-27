package com.springboot;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.entity.UserDo;
import com.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDo userDo = new UserDo();
        userDo.setUsername("penguin123");
        userDo.setPassword(UUID.randomUUID().toString());
        userDo.setCreateTime(new Date());
        userDo.setDeleted(0);
        userMapper.insert(userDo);
    }

    @Test
    public void testUpdateById() {
        UserDo userDo = new UserDo();
        userDo.setId(7);
        userDo.setUsername("penguin666");
        userMapper.updateById(userDo);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(5);
    }

    @Test
    public void testSelectById() {

        System.out.println(userMapper.selectById(7).getUsername());
    }

    @Test
    public void testSelectByUsername() {
        System.out.println(userMapper.selectByUsername("penguin123").getUsername());
    }

    @Test
    public void testSelectByIds() {
        List<UserDo> users = userMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
    }

    @Test
    public void testSelectPageByCreateTime() {
        IPage<UserDo> page = new Page<>(1, 10);
        Date createTime = new Date(2020 - 1990, Calendar.MAY, 1);
        page = userMapper.selectPageByCreateTime(page, createTime);
        System.out.println("users：" + page.getRecords().size());
    }
}
