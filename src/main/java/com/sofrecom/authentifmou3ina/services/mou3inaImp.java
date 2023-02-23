package com.sofrecom.authentifmou3ina.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;






@Service
public class mou3inaImp  implements Imou3inaService{
	@Autowired
	Mou3inaRepository mou3inaRepository ;
	public static final String DIRECTORY =  "C://Users/a.mosbah/Downloads/operation-admin-fe-master/operation-admin-fe-master/src/assets/img";
	@Override
	public Mou3inaEntity addMou3ina(Mou3inaEntity m) {
		return  mou3inaRepository.save(m);
	}

	@Override
	public void deleteMou3ina(Long id) {
		if(mou3inaRepository.findById(id).isPresent())
			mou3inaRepository.deleteById(id);
		
	}

	@Override
	public Mou3inaEntity updateMou3ina(Mou3inaEntity m) {
		return mou3inaRepository.saveAndFlush(m);
	}

	@Override
	public Mou3inaEntity findMou3ina(Long id) {
		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
		Path path = Paths.get(mouina.getPhoto());
		Path path2 = Paths.get(mouina.getName());
		try {
			byte[] data = Files.readAllBytes(path);
		
			mouina.setImage(data);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			byte[] data2 = Files.readAllBytes(path2);
			
			mouina.setCopie(data2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mouina;
		 
	}

	@Override
	public Mou3inaEntity findByfirstName(String firstName) {
		return mou3inaRepository.findByFirstName(firstName);
	}

	@Override
	public Mou3inaEntity findByTypeService(String serviceType) {
		return mou3inaRepository.findByServiceType(serviceType);
	}

	@Override
	public ResponseEntity<Object> findAll() {
		  List<Mou3inaEntity> dbMou3inas = mou3inaRepository.findAll();
	        if (dbMou3inas.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	      
	        return new ResponseEntity<>(dbMou3inas, HttpStatus.OK);
	    }

	@Override
	public Mou3inaEntity findMou3inaa(Long id) {
		Mou3inaEntity mouina=(Mou3inaEntity) mou3inaRepository.findById(id).get();
		return mouina;
	}
	}
	




	

	


	
	


