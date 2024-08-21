package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Auther;
import com.example.demo.service.AutherService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/auther")
public class AutherController {
    
    @Autowired
    private AutherService autherService;

    @GetMapping
    public ResponseEntity<List<Auther>> getAllAuthers() {
        List<Auther> autherList = autherService.getAuthersList();
        return ResponseEntity.status(200).body(autherList);
    }
    
    @PostMapping
    public ResponseEntity<String> createAuther(@RequestBody Auther auther) {
        if (auther.getName() == null || auther.getName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid author name");
        }

        autherService.createAuther(auther);
        return ResponseEntity.status(201).body("Author created successfully");
    }

    @GetMapping("/auther/{autherId}")
    public ResponseEntity<Auther>getAutherById(@PathVariable Long autherId) {
        Auther auther = autherService.getAutherById(autherId);
        
        if (auther == null) {
            return ResponseEntity.status(404).body(null);
        }  else {
            return ResponseEntity.status(200).body(auther);
        }
            
        }

        @PutMapping("/auther/{autherid}")
        public ResponseEntity<Auther>updateAuther(@PathVariable Long autherid, @RequestBody Auther auther) {
            Auther updateAuther = autherService.updateAuther(autherid, auther);

            if (updateAuther == null) {
                return ResponseEntity.status(404).body(null);
            } else {
                return ResponseEntity.status(200).body(updateAuther);
            }
           
        }

        @DeleteMapping("auther/{autherId}")
        public void deleteAuther(@PathVariable Long autherId) {
            autherService.deleteAuther(autherId);
        }


    }
    


