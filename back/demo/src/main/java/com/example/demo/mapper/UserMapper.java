package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    /**增**/

    int insert(User user);
    /**删**/
    //int deleteById(Integer id);
    /**改**/
    //int update(User user);
    /**查**/
    //User getById(Integer id);
    /**登录**/
    Integer login(User user);

}
