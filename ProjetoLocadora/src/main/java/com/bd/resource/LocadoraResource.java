package com.bd.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bd.model.Modelo;
import com.bd.repository.LocadoraRepository;

//Get --> pegar
//Put --> alterar
//Delet --> apagar
//Post --> inserir


@RestController
@RequestMapping("/locadora")

public class LocadoraResource {
	
	@Autowired
	private LocadoraRepository locadorasRepository;
	@GetMapping
	public List<Modelo> list(){
		return locadorasRepository.findAll();
	}


	@GetMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT) --->  isso serve para não aparecer nenhuma resposta
	public Optional<Modelo> findById(@PathVariable Long id){
		return locadorasRepository.findById(id);
	}

	@PostMapping 
	public ResponseEntity<Modelo> create(@RequestBody Modelo modelo, HttpServletResponse response){
		
		Modelo save = locadorasRepository.save(modelo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(uri).body(save);
	}
	
//===== Deletando algum componente do banco
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		locadorasRepository.deleteById(id);
	}

	@PutMapping("/{id}") 
	public ResponseEntity<Modelo> update(@PathVariable Long id, @RequestBody Modelo locadoras){
		
		Optional<Modelo> locadorasBanco = locadorasRepository.findById(id);
		
		BeanUtils.copyProperties(locadoras, locadorasBanco.get(), "id");
		
		locadorasRepository.save(locadorasBanco.get());
				
		return ResponseEntity.ok(locadoras);
	}
}

























