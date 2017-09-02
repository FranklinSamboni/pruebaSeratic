/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testSeratic.models.repository;

import com.example.testSeratic.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author FRANK
 */
public interface UserRepository extends CrudRepository<Usuario, Integer> {
    
    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    public Usuario findByUserName(@Param("usuario") String usuario);
    
}
