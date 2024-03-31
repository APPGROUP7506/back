package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @date 2021/5/21 9:26
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into t_user(id,username,password) values(?,?,?)";
        return this.jdbcTemplate.update(
                sql,
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from t_user where id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "update t_user set password = ? where id = ?";
        return this.jdbcTemplate.update(
                sql,
                user.getPassword(),
                user.getId()
        );
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from t_user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        }, id);
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return this.jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }, username,password);
    }
}

