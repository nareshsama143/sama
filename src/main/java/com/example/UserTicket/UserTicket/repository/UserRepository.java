package com.example.UserTicket.UserTicket.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserTicket.UserTicket.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

}
