package br.com.tst.service.dto;

import br.com.tst.domain.Veiculo;
import br.com.tst.domain.enums.RiscoVeiculo;
import lombok.Data;

@Data
public class VeiculoDTO {

    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private Float valor;
    private RiscoVeiculo riscoVeiculo;
    
    public VeiculoDTO() {
    }
    
	public VeiculoDTO(Veiculo obj) {
		id = obj.getId();
		marca = obj.getMarca();
		modelo = obj.getModelo();
		ano = obj.getAno();
		valor = obj.getValor();
		riscoVeiculo = obj.getRisco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public RiscoVeiculo getRiscoVeiculo() {
		return riscoVeiculo;
	}

	public void setRiscoVeiculo(RiscoVeiculo riscoVeiculo) {
		this.riscoVeiculo = riscoVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoDTO other = (VeiculoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VeiculoDTO [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valor=" + valor
				+ "]";
	}
    
}
