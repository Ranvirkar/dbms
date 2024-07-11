package com.blogs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blogs.Entity.Railway;

public interface Irailwayservice {

	public List<Railway> getAll();
	public Railway delete(Long id);
	public Railway update(Railway railway);
	public Railway getbyid(Long id);
	public String insert(Railway railway);
	
	
}
