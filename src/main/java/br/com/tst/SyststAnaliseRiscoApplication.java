package br.com.tst;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRep;
import br.com.tst.service.VeiculoService;

@SpringBootApplication
public class SyststAnaliseRiscoApplication implements CommandLineRunner{

	@Autowired
	private VeiculoRep repository;
	
	@Autowired
	private VeiculoService service;
	
    public static void main(String[] args) {
        SpringApplication.run(SyststAnaliseRiscoApplication.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception {
		
		Veiculo v1 = new Veiculo(null, "FIAT", "UNO", 2000, (float) 8000.00, null);
		Veiculo v2 = new Veiculo(null, "PEUGEOT", "307", 2010, (float) 8000.00, null);
		Veiculo v3 = new Veiculo(null, "FORD", "FUSION", 2015, (float) 8000.00, null);
		Veiculo v4 = new Veiculo(null, "VW", "NEW BEATTLE", 2019, (float) 8000.00, null);
		
		service.calculaRisco(v1);
		service.calculaRisco(v2);
		service.calculaRisco(v3);
		service.calculaRisco(v4);
		
		repository.saveAll(Arrays.asList(v1, v2, v3, v4));
	}
}
