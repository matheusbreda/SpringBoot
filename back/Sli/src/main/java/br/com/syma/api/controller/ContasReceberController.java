package br.com.syma.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.responses.Response;
import br.com.syma.api.model.ContasReceber;
import br.com.syma.api.service.impl.ContasReceberServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/receber")
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class ContasReceberController {
	
	@Autowired
	private ContasReceberServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<ContasReceber>> salvar(@Valid @RequestBody ContasReceber contasReceber, BindingResult result) {		
		return service.salvar(contasReceber, result);
	}
	
	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<ContasReceber>> inserirListar(@Valid @RequestBody ContasReceber[] listaContasReceber, BindingResult result) {		
		return service.salvarLista(listaContasReceber, result);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<ContasReceber>> alterar(@Valid @RequestBody ContasReceber contasReceber, BindingResult result) {		
		return service.salvar(contasReceber, result);
	}
	
	@GetMapping
	public List<ContasReceber> Listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<ContasReceber>> getById(@PathVariable Integer id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<ContasReceber>> deleteById(@PathVariable Integer id) {
		return service.deleteById(id);
	}
	
}
