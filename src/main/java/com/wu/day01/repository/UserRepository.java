package com.wu.day01.repository;

import com.wu.day01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User,Integer> {




}
