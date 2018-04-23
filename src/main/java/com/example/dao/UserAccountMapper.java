package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.UserAccountModel;

@Mapper
public interface UserAccountMapper {
	
	@Select("select * from ruang where username = #{username} and password = #{password}")
    UserAccountModel selectUserAccount (@Param("username") String username, @Param("password") String password);

}
