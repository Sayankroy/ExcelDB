package com.example.demo.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@Autowired
	PersonService pServ;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("/register")
	public String registerForm()
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String excel(HttpServletRequest request)
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phno"));
		
		Person person = new Person(id,name,phone);
		
		try {
			pServ.addPerson(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
	@GetMapping("/download")
    public ResponseEntity<FileSystemResource> download() {
        try {
            File file = pServ.getExcel();
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=persons.xlsx")
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
