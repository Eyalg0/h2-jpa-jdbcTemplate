package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDAO implements IUserDAO {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public User getById(User user) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
		return jdbcTemplate.queryForObject(GET_BY_ID, namedParameters, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(rs.getString("name"), rs.getString("email"));
				user.setId(rs.getInt("id"));
				return user;
			}
		});
	}
	
}
