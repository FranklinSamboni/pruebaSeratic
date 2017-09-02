/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testSeratic;

import com.example.testSeratic.models.repository.UserRepository;
import com.example.testSeratic.models.Response;
import com.example.testSeratic.models.Usuario;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author FRANK
 */
@Controller    
@RequestMapping(path="/testSeratic") 
public class UserController {
    
    @Autowired 
    private UserRepository userRepository;
    
    @PostMapping(path="/registerNewUser") 
    public ResponseEntity addNewUser (@RequestBody String strJson) {
        
        JSONObject jObject = new JSONObject(strJson);
        
        Usuario current = userRepository.findByUserName(jObject.getString("usuario"));
        Response response = new Response();
        if(current != null){
            
            response.setMessage("El usuario ya existe");
            response.setStatus(-1);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        
        Usuario user = new Usuario();
        user.setNombre(jObject.getString("nombre"));
        user.setApellido(jObject.getString("apellido"));
        user.setUsuario(jObject.getString("usuario"));
        user.setClave(jObject.getString("clave"));
        user.setTelefono(jObject.getString("telefono"));
        user.setHabilitado(true);
        
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
        String date = formatter.format(currentDate);

        user.setFechaRegistro(date);
        Usuario newUser = userRepository.save(user);
        response.setMessage("Se haguardado correctamente");
        response.setStatus(1);
        response.setObject(newUser);
        
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @PostMapping(path="/validateLogin") // Map ONLY GET Requests
    public ResponseEntity validateLogin (@RequestBody String strJson) {

        JSONObject jObject = new JSONObject(strJson);
        
        Usuario user = userRepository.findByUserName(jObject.getString("usuario"));
        Response response = new Response();
        if(user != null){
            
                if( user.getClave().equals(jObject.getString("clave"))){
                    user.setHabilitado(true);
                    userRepository.save(user);
                    response.setObject(user);
                    response.setMessage("La información es correcta");
                    response.setStatus(1);
                }else{
                    response.setMessage("La información proporcionada es incorrecta");
                    response.setStatus(-1);
                }
        }else{
            response.setMessage("Usuario no registrado");
            response.setStatus(-1);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    
}
