package br.com.aps.automato;

import java.util.Scanner;

public class Execucao {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ValidadorImpl validador = ValidadorImpl.getInstance();
		validador.getRegra();
		System.out.println("Informe um automato para a valida��o: ");
		validador.validaAutomato(scanner.next());
		scanner.close();
	}
}
