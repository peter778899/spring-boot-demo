package com.tx.stu.interfaces2;

import com.tx.stu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper2 {
    @Select("SELECT * FROM USER WHERE username = #{name}")
    User findByName(@Param("name") String name);
}
