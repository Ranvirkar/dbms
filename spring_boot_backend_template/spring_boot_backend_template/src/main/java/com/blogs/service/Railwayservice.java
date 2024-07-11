package com.blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.Entity.Railway;
import com.blogs.repository.Railwayrepository;
@Service
public class Railwayservice implements Irailwayservice {
@Autowired
private Railwayrepository repo;
	@Override
	public List<Railway> getAll() {
		return repo.findAll();
	}

//	@Override
//	public Railway delete(Long id) {
//		Optional<Railway> optional=repo.findById(id);
//		return optional.orElseThrow();
//	
//	}
	@Override
	public Railway delete(Long id) {
	    Optional<Railway> railway = repo.findById(id);
	    if (railway.isPresent()) {
	        repo.deleteById(id);
	        return railway.get();
	    } else {
	        // Handle the case where the railway entry doesn't exist
	        // You can throw an exception or return null, depending on your requirements
	        throw new RuntimeException("Railway entry not found with id: " + id);
	    }
	}


	@Override
	public Railway update(Railway railway) {
		return repo.save(railway);
		
	}

	@Override
	public Railway getbyid(Long id) {
		    Optional<Railway> railway=repo.findById(id);
		return railway.orElseThrow();
	}

	@Override
	public String insert(Railway railway) {
		repo.save(railway);
		return "data inserted";
	}

}
