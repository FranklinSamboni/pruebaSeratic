/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testSeratic;

import com.example.testSeratic.models.Response;
import com.example.testSeratic.models.repository.EventoRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path="/eventos") 
public class EventoController {
    
    @Autowired 
    private EventoRepository eventoRepository;
    
    @GetMapping(path="/getAllEvents") // Map ONLY GET Requests
    public @ResponseBody ResponseEntity getAllEvents () {
    
        Response response = new Response();
        
        response.setMessage("Lista con todos los eventos");
        response.setStatus(1);
        response.setObject(eventoRepository.findAll());
        
        
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
}
