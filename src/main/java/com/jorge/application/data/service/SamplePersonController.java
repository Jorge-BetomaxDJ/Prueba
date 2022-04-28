package com.jorge.application.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.application.data.entity.Usuario;

@RestController
@RequestMapping(path = "/usuario")
public class SamplePersonController {
	
	@Autowired
	private SamplePersonService samplaPersonService;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> crear(@RequestBody Usuario usuario){
		
		samplaPersonService.update(usuario);
		
		return ResponseEntity.status(HttpStatus.OK).body(true);
		
	}
	
	@RequestMapping(value = "/obtener", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> obtener(){
	
		
		return ResponseEntity.status(HttpStatus.OK).body(samplaPersonService.getRepository().findAll());
		
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> editar(@RequestBody Usuario usuario){
		
		samplaPersonService.update(usuario);
		
		return ResponseEntity.status(HttpStatus.OK).body(true);
		
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> eliminar(@RequestBody Usuario usuario){
		
		samplaPersonService.delete(usuario.getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(true);
		
	}

}
