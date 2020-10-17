package br.com.tst.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.VeiculoService;
import br.com.tst.service.dto.VeiculoDTO;

@RestController
@RequestMapping("/rest/veiculo")
public class VeiculoRestController {

    @Autowired 
    private VeiculoService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<Veiculo> list = service.findAll();
		List<VeiculoDTO> listDto = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody Veiculo veiculo) {
    	service.calculaRisco(veiculo);
    	veiculo = service.save(veiculo);
        return veiculo;
    }
    
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody VeiculoDTO objDto, @PathVariable Long id){
		Veiculo obj = service.fromVeiculoDTO(objDto);
		obj.setId(id);
		obj = service.calculaRisco(obj);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
