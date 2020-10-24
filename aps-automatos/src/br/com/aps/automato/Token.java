package br.com.aps.automato;

/**
 * Classe responsável pela declaração dos atributos que representa os tokens.
 */
public abstract class Token {

	/**
	 * Inicia por uma letra minúscula, seguido por uma quantidade qualquer de letras
	 * minúsculas, dígitos ou underline.
	 */
	public static final String IDENTIFICADOR = "[a-z] ( [a-z] | [0-9] | [_])*";

	/**
	 * É representado pelo caractere “=”
	 */
	public static final char OP_ATRIB = '=';

	/**
	 * Inicia por um dígito, seguido por uma quantidade qualquer de dígitos, podendo
	 * ter opcionalmente a parte fracionária. Caso ele tenha a parte fracionária,
	 * ele recebe o caractere “.” , seguido de uma sequência de um ou mais dígitos.
	 */
	public static final String NUMERO = "( [0-9]([0-9])* ) | ( [0-9]([0-9])*‘.’ [0-9]([0-9])* )";

	/**
	 * É representado pelo caractere ‘;’.
	 */
	public static final char PV = ';';

}
