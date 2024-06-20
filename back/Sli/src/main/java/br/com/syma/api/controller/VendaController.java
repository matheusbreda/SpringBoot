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
import br.com.syma.api.model.Venda;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.impl.VendaServiceImpl;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class VendaController {
	
	@Autowired
	private VendaServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Venda>> salvar(@Valid @RequestBody Venda venda, BindingResult result ){		    
		return service.salvar(venda, result);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Venda>> alterar(@Valid @RequestBody Venda venda, BindingResult result ){		    
		return service.salvar(venda, result);		
	}
	
	@GetMapping
	public List<Venda> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Venda>> getById(@PathVariable String id){
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code  = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<Venda>> deleteById(@PathVariable String id){
		return service.deleteById(id);
	}


}

