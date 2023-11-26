package com.mustafa.advancejava.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Create Read Update Delete
    public int createUser(String name, String surname, Integer age) {
        String sql = "INSERT INTO users (name, surname, age) VALUES (?, ?, ?)";

        if (name != null && surname != null && age != null) {
            return jdbcTemplate.update(sql, name, surname, age);
        } else {
            return 0;
        }
    }

    public List<Map<String, Object>> readUsers() {
        String sql = "SELECT * FROM users";

        List<Map<String, Object>> listUsers = new ArrayList<>();

        listUsers = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Map<String, Object> user = new HashMap<>();

            user.put("id", rs.getInt("id"));
            user.put("name", rs.getString("name"));
            user.put("surname", rs.getString("surname"));
            user.put("age", rs.getInt("age"));

            return user;
        });

        return listUsers;
    }

    public Map<String, Object> readUserById(Integer id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Map<String, Object> user = new HashMap<>();

            user.put("id", rs.getInt("id"));
            user.put("name", rs.getString("name"));
            user.put("surname", rs.getString("surname"));
            user.put("age", rs.getInt("age"));
            return user;
        }, id).get(0);
    }

    public int updateUserById(Integer id, String name, String surname, Integer age) {
        StringJoiner joinerUpColumn = new StringJoiner(", ");
        List<Object> listArgs = new ArrayList<>();

        if (name != null) {
            joinerUpColumn.add("name = ?");
            listArgs.add(name);
        }

        if (surname != null) {
            joinerUpColumn.add("surname = ?");
            listArgs.add(surname);
        }

        if (age != null) {
            joinerUpColumn.add("age = ?");
            listArgs.add(age);
        }

        if (joinerUpColumn.length() > 0) {
            String sql = "UPDATE users SET " + joinerUpColumn.toString() + " WHERE id = ?";
            listArgs.add(id);

            return jdbcTemplate.update(sql, listArgs.toArray());
        } else {
            return 0;
        }
    }

    public int deleteUserById(Integer id) {
        String sql = "DELETE FROM users WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}
