package br.com.aps.automato;

/**
 * Classe respons�vel pela declara��o dos atributos que representa os tokens.
 */
public abstract class Token {

	/**
	 * Inicia por uma letra min�scula, seguido por uma quantidade qualquer de letras
	 * min�sculas, d�gitos ou underline.
	 */
	public static final String IDENTIFICADOR = "[a-z] ( [a-z] | [0-9] | [_])*";

	/**
	 * � representado pelo caractere �=�
	 */
	public static final char OP_ATRIB = '=';

	/**
	 * Inicia por um d�gito, seguido por uma quantidade qualquer de d�gitos, podendo
	 * ter opcionalmente a parte fracion�ria. Caso ele tenha a parte fracion�ria,
	 * ele recebe o caractere �.� , seguido de uma sequ�ncia de um ou mais d�gitos.
	 */
	public static final String NUMERO = "( [0-9]([0-9])* ) | ( [0-9]([0-9])*�.� [0-9]([0-9])* )";

	/**
	 * � representado pelo caractere �;�.
	 */
	public static final char PV = ';';

}
