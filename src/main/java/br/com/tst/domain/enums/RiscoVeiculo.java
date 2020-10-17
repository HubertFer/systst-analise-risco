package br.com.tst.domain.enums;

public enum RiscoVeiculo {

	RISCOBAIXO(1, "Risco Baixo"),
	RISCOMEDIO(2, "Risco Médio"),
	RISCOALTO(3, "Risco Alto");
	
	private int cod;
	private String descricao;
	
	private RiscoVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static RiscoVeiculo toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (RiscoVeiculo x : RiscoVeiculo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
