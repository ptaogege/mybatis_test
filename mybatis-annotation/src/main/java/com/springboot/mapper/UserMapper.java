package com.springboot.mapper;

import com.springboot.entity.UserDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper {

    @Insert("INSERT INTO users(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(UserDo user);

    @Update(value = {
            "<script>",
            "UPDATE users",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "</script>"
    })
    int updateById(UserDo user);

    @Insert("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM users WHERE id = #{id}")
    UserDo selectById(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM users WHERE username = #{username}")
    UserDo selectByUsername(@Param("username") String username);

    @Select(value = {
            "<script>",
            "SELECT username, password, create_time FROM users",
            "WHERE id IN",
            "<foreach item='id' collection='ids' separator=',' open='(' close=')' index=''>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<UserDo> selectByIds(@Param("ids") Collection<Integer> ids);
}
