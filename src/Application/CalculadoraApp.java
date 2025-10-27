package Application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraApp {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		char continuar;

		do {

			try {

				double numero_1;
				String operacao;
				double numero_2;

				System.out.println("\t=== Calculadora ===");
				System.out.print("\nNúmero 1: ");
				numero_1 = sc.nextDouble();
				System.out.print("Digite a operação [+, -, *, /, ^, √]: ");
				operacao = sc.next();
				
				if (!operacao.equals("√")) {// se a minha operação for diferente de √, ou seja, qualquer sinal diferente de √ vai passar
					System.out.print("Número 2: ");
					numero_2 = sc.nextDouble();
				} else {
					numero_2 = 0.0;
				}

				System.out.println("\nResultado " + String.format("%.2f", escolhaCaso(operacao, numero_1, numero_2)));

			} catch (InputMismatchException e) {// pode dar um error de entrada com o dado errado
				System.err.println("\nErro: Colocar somente valores numerais.");
				sc.nextLine();
			}

			continuar = desejaNovaOperacao(sc);
			System.out.println();

		} while (Character.toLowerCase(continuar) != 'n');

		System.out.println("\nFim do programa!");

		sc.close();

	}

	public static char desejaNovaOperacao(Scanner sc) {

		System.out.print("\nDeseja realizar uma nova operação? [s/n] ");
		char desejo = sc.next().charAt(0);
		return desejo;
	}

	public static double escolhaCaso(String operacao, double numero_1, double numero_2) {

		double soma = 0.0;

		switch (operacao) {// escolha/caso
		case "+":
			// adição
			soma = numero_1 + numero_2;
			break;
		case "-":
			// subtração
			soma = numero_1 - numero_2;
			break;
		case "*":
			// multiplicação
			soma = numero_1 * numero_2;
			break;
		case "/":
			// divisao
			if (numero_2 == 0) {
				System.out.println("Error: Impossível realizar uma divisão por zero");
			} else {
				soma = numero_1 / numero_2;
			}
			break;
		case "^":
			if (numero_2 == 0) {
				soma = 1;
				System.out.println("Todo número elevado a zero será igual a 1.");
			} else {
				soma = Math.pow(numero_1, numero_2);
			}
			break;
		case "√":
			soma = Math.sqrt(numero_1);
			break;
		default:
			System.out.println("Operação inválida");
		}

		return soma;

	}

}
