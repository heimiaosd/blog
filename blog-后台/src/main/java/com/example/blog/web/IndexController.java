package com.example.blog.web;

import com.example.blog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
   /* @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id, @PathVariable String name){
        *//*String blog = "";
        if(blog=="")
            throw new NotFoundException();*//*
        System.out.println("id"+id+"name"+name);
        System.out.println("-----------index----------");
        return "index"; }*/

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
