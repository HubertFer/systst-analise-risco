package br.com.tst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.domain.enums.RiscoVeiculo;
import br.com.tst.repository.VeiculoRep;
import br.com.tst.repository.VeiculoRepository;
import br.com.tst.service.dto.VeiculoDTO;

@Service
@Validated
public class VeiculoService {

    @Autowired 
    private VeiculoRepository repository;
    
    @Autowired
    private VeiculoRep repo;

    public List<Veiculo> findAll() {
        return (List<Veiculo>) repo.findAll();
    }

    public Veiculo save(Veiculo veiculo) {
    	
        return repo.save(veiculo);
    }
    
    public Veiculo calculaRisco(Veiculo veiculo) {
    	if(veiculo.getAno() < 2010) {
    		veiculo.setRisco(RiscoVeiculo.RISCOALTO);
    	}
    	
    	switch (veiculo.getAno()) {
		case 2010: veiculo.setRisco(RiscoVeiculo.RISCOMEDIO);break;
		case 2011: veiculo.setRisco(RiscoVeiculo.RISCOMEDIO);break;
		case 2012: veiculo.setRisco(RiscoVeiculo.RISCOMEDIO);break;
		case 2013: veiculo.setRisco(RiscoVeiculo.RISCOMEDIO);break;
		case 2014: veiculo.setRisco(RiscoVeiculo.RISCOMEDIO);break;
		case 2015: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		case 2016: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		case 2017: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		case 2018: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		case 2019: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		case 2020: veiculo.setRisco(RiscoVeiculo.RISCOBAIXO);break;
		}
    	
    	return veiculo;
    }
    
	public Veiculo find(Long id) {
		
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Veiculo update(Veiculo obj) {
		Veiculo newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Long id){
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Veiculo newObj, Veiculo obj) {
		newObj.setAno(obj.getAno());
		newObj.setMarca(obj.getMarca());
		newObj.setModelo(obj.getModelo());
		newObj.setValor(obj.getValor());
	}
	
	public Veiculo fromVeiculoDTO (VeiculoDTO objDto) {
		return new Veiculo(objDto.getId(), objDto.getMarca(), objDto.getModelo(), objDto.getAno(), 
				objDto.getValor(), objDto.getRiscoVeiculo());
	}

}
