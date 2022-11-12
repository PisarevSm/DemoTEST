package com.example.demobullsht.demobullsht.booking.controller;

import com.example.demobullsht.demobullsht.booking.annatation.TestAnnotation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class CustomController {
    @GetMapping()
    public ResponseEntity<String> sayHelloTest(){
        throw new TestAnnotation("Test govna");
    }
}
