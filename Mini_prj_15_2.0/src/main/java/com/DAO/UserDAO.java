/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.User;

/**
 *
 * @author ADMIN
 */
public interface UserDAO {
    public boolean userRegister(User us);
    public User login(String email,String password);
}
