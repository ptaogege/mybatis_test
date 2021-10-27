package com.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.entity.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserDo> {

    default UserDo selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<UserDo>().eq("username", username));
    }

    List<UserDo> selectByIds(@Param("ids") Collection<Integer> ids);

    default IPage<UserDo> selectPageByCreateTime(IPage<UserDo> page, @Param("createTime") Date createTime) {
        return selectPage(page, new QueryWrapper<UserDo>().gt("create_time", createTime));
    }

}
