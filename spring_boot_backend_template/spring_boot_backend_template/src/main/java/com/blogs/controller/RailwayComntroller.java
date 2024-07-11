package com.blogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.Entity.Railway;
import com.blogs.service.Irailwayservice;
@RestController
public class RailwayComntroller {
   @Autowired
   private Irailwayservice service;
	@GetMapping("/home")
	public String home() {
		return "this is the home";
	}
	@GetMapping("/railway")
	public ResponseEntity<List<Railway>> getall(){
		
		List<Railway> list= service.getAll();
		if(list!=null) {
			
			return new ResponseEntity<List<Railway>>(list,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<List<Railway>>(list,HttpStatus.NO_CONTENT);
		}
	}
	@PutMapping("/railway")
	public Railway update(@RequestBody Railway railway) {
		return service.update(railway);
	}
	@DeleteMapping("/railway/{id}")
	public Railway delete(@PathVariable Long id) {
		 return service.delete(id);
	}
	@GetMapping("/railway/{id}")
	public ResponseEntity<Railway> getbyid(@PathVariable Long id){
		
		Railway railway = service.getbyid(id);
		if(railway!=null) {
			
			return new ResponseEntity<Railway>(railway,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Railway>(railway,HttpStatus.NO_CONTENT);
		}
	}
//	@PostMapping("/railway")
//   public String insert(Railway railway) {
//		return service.insert(railway);
//	}
	
	
	 @PostMapping("/railway")
	    public ResponseEntity<String> insert(@Valid @RequestBody Railway railway) {
	        String result = service.insert(railway);
	        if (result != null) {
	            return new ResponseEntity<>(result, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>("Failed to create the railway entry.", HttpStatus.BAD_REQUEST);
	        }
	    }
	
}
