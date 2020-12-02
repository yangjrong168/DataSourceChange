package com.example.DataSourceChange.dao;

import com.example.DataSourceChange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
