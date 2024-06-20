package br.com.syma.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.model.TabelaPreco;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.impl.TabelaPrecoServiceImpl;


@RestController
@RequestMapping("/api/tabela-preco")
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class TabelaPrecoController {
	
	@Autowired
	private TabelaPrecoServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<TabelaPreco>> inserir(@Valid @RequestBody TabelaPreco tabelaPreco, BindingResult result ){		    
		return service.salvar(tabelaPreco, result);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<TabelaPreco>> alterar(@Valid @RequestBody TabelaPreco tabelaPreco, BindingResult result ){		    
		return service.salvar(tabelaPreco, result);		
	}
	
	@GetMapping
	public List<TabelaPreco> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<TabelaPreco>> getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code  = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<TabelaPreco>> deleteById(@PathVariable Integer id){
		return service.deleteById(id);
	}


}
