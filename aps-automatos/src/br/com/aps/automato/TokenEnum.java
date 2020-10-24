package br.com.aps.automato;

public enum TokenEnum {

	VALIDACAO1(0), VALIDACAO2(1), VALIDACAO3(2);

	private int tipo;

	TokenEnum(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return this.tipo;
	}

}
