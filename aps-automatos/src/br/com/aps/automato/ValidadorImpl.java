package br.com.aps.automato;

public class ValidadorImpl implements Validador {

	private static final ValidadorImpl INSTANCE = new ValidadorImpl();

	public static ValidadorImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public void validaAutomato(String automato) {
		if (validaIdentificador(getStringTrim(automato, TokenEnum.VALIDACAO1))) {
			if (validaOpAtrib(getStringTrim(automato, TokenEnum.VALIDACAO2))) {
				if (validaNumero(getStringTrim(automato, TokenEnum.VALIDACAO3))
						|| validaIdentificador(getStringTrim(automato, TokenEnum.VALIDACAO1))) {
					if (validaPV(automato)) {
						System.out.println("O automato " + automato + " � v�lido!");
					} else {
						printErro("Regra 4");
					}
				} else {
					printErro("Regra 3");
				}
			} else {
				printErro("Regra 2");
			}
		} else {
			printErro("Regra 1");
		}
	}

	@Override
	public void getRegra() {
		System.out.println("Aten��o para a entrada de um automato v�lido: \n\n"
				+ "identificador op_atrib (identificador | numero) pv\n\n" + "Sendo que:\n"
				+ "- identificador: inicia por uma letra min�scula, seguido por uma quantidade qualquer de\n"
				+ "letras min�sculas, d�gitos ou underline.\n" + "- op_atrib: � representado pelo caractere �=�\n"
				+ "- numero: inicia por um d�gito, seguido por uma quantidade qualquer de d�gitos, podendo\n"
				+ "ter opcionalmente a parte fracion�ria. Caso ele tenha a parte fracion�ria, ele recebe o\n"
				+ "caractere �.� , seguido de uma sequ�ncia de um ou mais d�gitos.\n"
				+ "- pv: � representado pelo caractere �;�.");
	}

	@Override
	public void printErro(String regra) {
		System.out.println("O automato informado n�o � v�lido, pois infringiu a " + regra + ".\n\n"
				+ "Por favor, verifique as regras e tente novamente! ");
	}

	private boolean validaIdentificador(String automato) {
		boolean identificador = Character.isLowerCase(automato.charAt(0)) && Character.isAlphabetic(automato.charAt(0));
		if (identificador) {
			char[] array = automato.substring(1).toCharArray();
			for (int i = 0; i < array.length; i++) {
				if (!Character.isDigit(array[i]) || !Character.isAlphabetic((array[i])) || array[i] == '_')
					return false;
			}
		}
		return identificador;
	}

	private boolean validaOpAtrib(String automato) {
		return automato.equals(String.valueOf(Token.OP_ATRIB));
	}

	private boolean validaNumero(String automato) {
		char[] array = automato.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (!Character.isDigit(array[i]))
				return false;
		}
		return true;
	}

	private boolean validaPV(String automato) {
		return automato.endsWith(String.valueOf(Token.PV));
	}

	private String getStringTrim(String automato, TokenEnum tipoToken) {
		char[] array = automato.toCharArray();
		int inicio = 0, fim = 0;
		for (int i = 0; i < array.length; i++) {
			switch (tipoToken) {
			case VALIDACAO1:
				if (array[i] == Token.OP_ATRIB) {
					inicio = i - 1;
					fim = i + 1;
				}
				break;
			case VALIDACAO2:
				if (array[i] == Token.OP_ATRIB) {
					inicio = i - 1;
					fim = array.length - 1;
				}
				break;
			default:
				if (array[i] == Token.OP_ATRIB) {
					inicio = i;
					fim = array.length - 1;
				}
				break;
			}
		}
		automato = automato.substring(inicio, fim);
		return automato;
	}
}
