package com.sofrecom.authentifmou3ina.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import com.sofrecom.authentifmou3ina.services.Imou3inaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;





@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Mou3inaRestController {
	@Autowired
	Imou3inaService mou3inaService;
	@Autowired
	Mou3inaRepository mou3inaRepository;
	public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";

	@RequestMapping(value = "/Mou3inas", method = RequestMethod.GET)
	public ResponseEntity<Object> findMou3iness() {
		return (ResponseEntity<Object>) mou3inaService.findAll();
	}


	@GetMapping(value = "/Mou3ina/{id}")
	public Mou3inaEntity findOneMou3inaById(@PathVariable Long id) {
		
		return	 mou3inaService.findMou3ina(id);
	
		
		 
	}		
	@GetMapping(value = "/Mou3inaa/{id}")
	public Mou3inaEntity findOneMou3ina(@PathVariable Long id) {
		
		return	 mou3inaService.findMou3inaa(id);
	
		
		 
	}	
	@GetMapping(value = "/Mou3ina/Search/firstName")
	public Mou3inaEntity findMou3inanByfirstName(@PathVariable String e) {
		return mou3inaService.findByfirstName(e);
	}
	
	
	
	
	
	@PostMapping(value = "/Mou3ina/newMou3ina")
	public Mou3inaEntity addMou3ina(@RequestBody Mou3inaEntity m) {
		return mou3inaService.addMou3ina(m);
		
	}
	
	@PutMapping(value = "/Mou3inas/Mou3ina/{id}")
	public Mou3inaEntity updateMou3ina(@PathVariable Long id, @RequestBody Mou3inaEntity p) {
		p.setId(id);
		return mou3inaService.updateMou3ina(p);
	}

	@DeleteMapping(value = "/deleteMou3inas/{id}")
	public void deleteMou3ina(@PathVariable Long id) {
		mou3inaService.deleteMou3ina(id);
	}
	
}