package com.springboot;

import com.springboot.entity.UserDo;
import com.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDo userDo = new UserDo();
        userDo.setUsername(UUID.randomUUID().toString());
        userDo.setPassword("niubi");
        userDo.setCreateTime(new Date());
        userMapper.insert(userDo);
    }

    @Test
    public void testUpdateById() {
        UserDo userDo = new UserDo();
        userDo.setId(1);
        userDo.setPassword("niubi666");
        userMapper.updateById(userDo);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(5);
    }

    @Test
    public void testSelectById() {

        System.out.println(userMapper.selectById(1));
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("penguin");
    }

    @Test
    public void testSelectByIds() {
        List<UserDo> users = userMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
    }
}
