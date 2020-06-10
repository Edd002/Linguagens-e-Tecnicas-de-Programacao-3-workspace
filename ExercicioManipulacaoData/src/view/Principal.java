package view;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Principal {

	private static Scanner scanner;

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		String opcao = null;

		do {
			scanner = new Scanner(System.in);
			System.out.println("TRATAMENTO DE DATAS\n");
			System.out.println("1 - Validar data do usuário");
			System.out.println("2 - Calcular diferença entre datas");
			System.out.println("3 - Calcular diferença entre datas em horas");
			System.out.println("4 - Ajustar fim de semana");
			System.out.println("5 - Calcular data");
			System.out.println("6 - Informar dia da semana");
			System.out.println("7 - Informar quantidade de dias do mês");
			System.out.println("8 - Exibir calendário completo do mês");
			System.out.println("9 - Verificar se o ano é bissexto");
			System.out.println("10 - Informar primeiro dia útil do mês");
			System.out.println("0 - Sair da aplicação");
			opcao = scanner.nextLine();

			switch (opcao) {
			case "1":
				validarData();
				break;
			case "2":
				calcularDiferencaDatas();
				break;
			case "3":
				calcularDiferencaDatasHora();
				break;
			case "4":
				ajustarFimDeSemana();
				break;
			case "5":
				calcularData();
				break;
			case "6":
				informarDiaSemana();
				break;
			case "7":
				informarQuantidadeDiasMes();
				break;
			case "8":
				exibirCalendarioMes();
				break;
			case "9":
				verificarBissexto();
				break;
			case "10":
				informarPrimeiroDiaUtilMes();
				break;
			case "0":
				break;
			default:
				System.out.println("Entrada inválida.\n");
				break;
			}
		} while (!opcao.equals("0"));

		System.out.println("\n\nFim do programa.");
	}

	// Exercício 1
	private static void validarData() {
		scanner = new Scanner(System.in);
		String stringDate = null;

		System.out.println("Informe a data (dd/MM/yyyy): ");
		stringDate = scanner.nextLine();

		try {
			(new SimpleDateFormat("dd/MM/yyyy")).parse(stringDate);
			System.out.println("Formato correto.");
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		System.out.println("\n");
	}

	// Exercício 2
	private static void calcularDiferencaDatas() {
		scanner = new Scanner(System.in);
		String stringDate1 = null;
		String stringDate2 = null;
		Date date1 = new Date();
		Date date2 = new Date();
		long diferencaDias = 0;
	    long diferencaMeses = 0;
	    long diferencaAnos = 0;

		do {
			System.out.println("Informe a primeira data (dd/MM/yyyy): ");
			stringDate1 = scanner.nextLine();

			System.out.println("Informe a segunda data (dd/MM/yyyy): ");
			stringDate2 = scanner.nextLine();

			try {
				date1 = (new SimpleDateFormat("dd/MM/yyyy")).parse(stringDate1);
				date2 = (new SimpleDateFormat("dd/MM/yyyy")).parse(stringDate2);
				System.out.println("Formato correto.");
			} catch (Exception exception) {
				System.out.println("Formato incorreto.");
			}

		    diferencaDias = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
		    diferencaMeses = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) / 30;
		    diferencaAnos = ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) / 30) / 12;

			if (diferencaDias < 0) {
				System.out.println("A primeira não pode ser maior que a segunda.\n");
			} else {
				System.out.println("DIFERENÇA ENTRE AS DATAS");
				System.out.println("Total em dias dias: " + diferencaDias);
				System.out.println("Total em meses: " + diferencaMeses);
				System.out.println("Total em anos: " + diferencaAnos);
			}
		} while (diferencaDias < 0);

		System.out.println("\n");
	}

	// Exercício 3
	private static void calcularDiferencaDatasHora() {
		scanner = new Scanner(System.in);
		String stringDate1 = null;
		String stringDate2 = null;
		Date date1 = new Date();
		Date date2 = new Date();
		long dateDiference = 0;
		long seconds = 0;
		long minutes = 0; 
		long hours = 0;

		/*
	    long diferencaSegundos = 0;
	    long diferencaMinutos = 0;
	    long diferencaHoras = 0;
	    */
		/*
		diferencaSegundos = (date2.getTime() - date1.getTime()) / (1000);
	    diferencaMinutos = (date2.getTime() - date1.getTime()) / (1000 * 60);
	    diferencaHoras = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60);
	    */

		System.out.println("Informe a data e a hora (dd/MM/yyyy HH:mm:ss): ");
		stringDate1 = scanner.nextLine();

		System.out.println("Informe a segunda data e a horas (dd/MM/yyyy HH:mm:ss): ");
		stringDate2 = scanner.nextLine();

		try {
			date1 = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(stringDate1);
			date2 = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(stringDate2);
			System.out.println("Formato correto.");
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		dateDiference =  date2.getTime() - date1.getTime();
		seconds = TimeUnit.MILLISECONDS.toSeconds(dateDiference);
		minutes = TimeUnit.MILLISECONDS.toMinutes(dateDiference);

		hours = minutes / 60;
		minutes = (minutes % 60);
		seconds = (seconds % 60);

		System.out.println("A diferença em horas entre as duas datas é de " + hours + " horas.");
		System.out.println("A diferença em minutos entre as duas datas é de " + minutes + " minutos.");
		System.out.println("A diferença em segundos entre as duas datas é de " + seconds + " segundos.");

		System.out.println("\n");
	}

	// Exercício 4
	private static void ajustarFimDeSemana() {
		scanner = new Scanner(System.in);
		String stringDate = null;
		String newStringDate = null;
		String diaSemanaPagamento = null;
		String diaSemanaAjustadoPagamento = null;
		SimpleDateFormat simpleDateFormat = null;
		Calendar calendar = null;

		System.out.println("Informe a data de pagamento do boleto (dd/MM/yyyy): ");
		stringDate = scanner.nextLine();

		try {
			simpleDateFormat = (new SimpleDateFormat("dd/MM/yyyy"));
			diaSemanaPagamento = (new SimpleDateFormat("EEEE")).format(simpleDateFormat.parse(stringDate));
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		if (diaSemanaPagamento.equals("Sábado") || diaSemanaPagamento.equals("Domingo")) {
			try {
				calendar = Calendar.getInstance();
				calendar.setTime(simpleDateFormat.parse(stringDate));
				calendar.add(Calendar.DATE, 2);
				newStringDate = simpleDateFormat.format(calendar.getTime());
				diaSemanaAjustadoPagamento = "Segunda-feira";
			} catch (Exception exception) {
				System.out.println("Erro ao converter.");
			}
		} else {
			diaSemanaAjustadoPagamento = diaSemanaPagamento;
		}

		System.out.println("Data de pagamento: " + stringDate + " " + diaSemanaPagamento);
		System.out.println("Data ajustada: " + newStringDate + " " + diaSemanaAjustadoPagamento);

		System.out.println("\n");
	}

	// Exercício 5
	private static void calcularData() {
		scanner = new Scanner(System.in);
		String stringDate = null;
		String newStringDate = null;
		SimpleDateFormat simpleDateFormat = null;
		Calendar calendar = null;
		int quantidadeDias = 0;

		System.out.println("Informe a data (dd/MM/yyyy): ");
		stringDate = scanner.nextLine();

		System.out.println("Informe a quantidade em dias: ");
		quantidadeDias = scanner.nextInt();

		try {
			simpleDateFormat = (new SimpleDateFormat("dd/MM/yyyy"));
			calendar = Calendar.getInstance();
			calendar.setTime(simpleDateFormat.parse(stringDate));
			calendar.add(Calendar.DATE, quantidadeDias);
			newStringDate = simpleDateFormat.format(calendar.getTime());
		} catch (Exception exception) {
			System.out.println("Erro ao converter.");
		}

		System.out.println("Data antiga: " + stringDate);
		System.out.println("Data nova: " + newStringDate);

		System.out.println("\n");
	}

	// Exercício 6
	private static void informarDiaSemana() {
		scanner = new Scanner(System.in);
		String stringDate = null;
		String diaSemana = null;

		System.out.println("Informe a data (dd/MM/yyyy): ");
		stringDate = scanner.nextLine();

		try {
			diaSemana = (new SimpleDateFormat("EEEE")).format((new SimpleDateFormat("dd/MM/yyyy").parse(stringDate)));
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		System.out.println("Data: " + stringDate);
		System.out.println("Data ajustada: " + diaSemana);

		System.out.println("\n");
	}

	// Exercício 7
	private static void informarQuantidadeDiasMes() {
		scanner = new Scanner(System.in);
		String stringMes = null;
		String stringMesNumerico = null;
		boolean validador = true;
		Calendar calendar = null;

		do {
			System.out.println("Informe o mês: ");
			stringMes = scanner.nextLine();

			validador = true;
			switch (stringMes.toUpperCase()) {
				case "JANEIRO":
					stringMesNumerico = "01";
					break;
				case "FEVEREIRO":
					stringMesNumerico = "02";
					break;
				case "MARÇO":
					stringMesNumerico = "03";
					break;
				case "ABRIL":
					stringMesNumerico = "04";
					break;
				case "MAIO":
					stringMesNumerico = "05";
					break;
				case "JUNHO":
					stringMesNumerico = "06";
					break;
				case "JULHO":
					stringMesNumerico = "07";
					break;
				case "AGOSTO":
					stringMesNumerico = "08";
					break;
				case "SETEMBRO":
					stringMesNumerico = "09";
					break;
				case "OUTUBRO":
					stringMesNumerico = "10";
					break;
				case "NOVEMBRO":
					stringMesNumerico = "11";
					break;
				case "DEZEMBRO":
					stringMesNumerico = "12";
					break;
				default:
					System.out.println("Mês inválido.\n");
					validador = false;
					break;
			}
		} while (!validador);

		try {
			calendar = Calendar.getInstance();
			calendar.setTime((new SimpleDateFormat("dd/MM/yyyy").parse("01/" + stringMesNumerico + "/2000")));
			System.out.println(calendar.getActualMaximum(Calendar.DATE));
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		System.out.println("\n");
	}

	// Exercício 8
	private static void exibirCalendarioMes() {
		scanner = new Scanner(System.in);
		String stringMes = null;
		String stringMesNumerico = null;
		String stringData = null;
		String diaSemana = null;
		boolean validador = true;
		int dia = 0;
		int maxDias = 0;
		int anoAtual = 0;
		Calendar calendar = null;

		do {
			System.out.println("Informe o mês: ");
			stringMes = scanner.nextLine();

			validador = true;
			switch (stringMes.toUpperCase()) {
				case "JANEIRO":
					stringMesNumerico = "01";
					break;
				case "FEVEREIRO":
					stringMesNumerico = "02";
					break;
				case "MARÇO":
					stringMesNumerico = "03";
					break;
				case "ABRIL":
					stringMesNumerico = "04";
					break;
				case "MAIO":
					stringMesNumerico = "05";
					break;
				case "JUNHO":
					stringMesNumerico = "06";
					break;
				case "JULHO":
					stringMesNumerico = "07";
					break;
				case "AGOSTO":
					stringMesNumerico = "08";
					break;
				case "SETEMBRO":
					stringMesNumerico = "09";
					break;
				case "OUTUBRO":
					stringMesNumerico = "10";
					break;
				case "NOVEMBRO":
					stringMesNumerico = "11";
					break;
				case "DEZEMBRO":
					stringMesNumerico = "12";
					break;
				default:
					System.out.println("Mês inválido.\n");
					validador = false;
					break;
			}
		} while (!validador);

		try {
			calendar = Calendar.getInstance();
			calendar.setTime((new SimpleDateFormat("dd/MM/yyyy").parse("01/" + stringMesNumerico + "/2000")));
			maxDias = calendar.getActualMaximum(Calendar.DATE);
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		try {
			anoAtual = Year.now().getValue();
			for (dia = 1; dia <= maxDias; dia++) {
				stringData = dia + "/" + stringMesNumerico + "/" + anoAtual;
				diaSemana = (new SimpleDateFormat("EEEE")).format((new SimpleDateFormat("dd/MM/yyyy").parse(stringData)));
				System.out.println(stringData + " - " + diaSemana);
			}
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		System.out.println("\n");
	}

	// Exercício 9
	private static void verificarBissexto() {
		scanner = new Scanner(System.in);
		int ano = 0;

		System.out.println("Informe o ano (número inteiro): ");
		ano = scanner.nextInt();

		boolean calculo = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
		if (calculo) {
			System.out.println("O ano " + ano + " é bissexto.");
		} else {
			System.out.println("O ano não " + ano + " é bissexto.");
		}

		System.out.println("\n");
	}

	// Exercício 10
	private static void informarPrimeiroDiaUtilMes() {
		scanner = new Scanner(System.in);
		String stringMes = null;
		String stringMesNumerico = null;
		String stringData = null;
		String diaSemana = null;
		boolean validador = true;

		do {
			System.out.println("Informe o mês: ");
			stringMes = scanner.nextLine();

			validador = true;
			switch (stringMes.toUpperCase()) {
				case "JANEIRO":
					stringMesNumerico = "01";
					break;
				case "FEVEREIRO":
					stringMesNumerico = "02";
					break;
				case "MARÇO":
					stringMesNumerico = "03";
					break;
				case "ABRIL":
					stringMesNumerico = "04";
					break;
				case "MAIO":
					stringMesNumerico = "05";
					break;
				case "JUNHO":
					stringMesNumerico = "06";
					break;
				case "JULHO":
					stringMesNumerico = "07";
					break;
				case "AGOSTO":
					stringMesNumerico = "08";
					break;
				case "SETEMBRO":
					stringMesNumerico = "09";
					break;
				case "OUTUBRO":
					stringMesNumerico = "10";
					break;
				case "NOVEMBRO":
					stringMesNumerico = "11";
					break;
				case "DEZEMBRO":
					stringMesNumerico = "12";
					break;
				default:
					System.out.println("Mês inválido.\n");
					validador = false;
					break;
			}
		} while (!validador);

		try {
			stringData = "01/" + stringMesNumerico + "/" + Year.now().getValue();
			diaSemana = (new SimpleDateFormat("EEEE")).format((new SimpleDateFormat("dd/MM/yyyy").parse(stringData)));

			if (diaSemana.equals("Sábado")) {
				stringData = "03/" + stringMesNumerico + "/" + Year.now().getValue();
				diaSemana = "Segunda-feira";
			}

			if (diaSemana.equals("Domingo")) {
				stringData = "02/" + stringMesNumerico + "/" + Year.now().getValue();
				diaSemana = "Segunda-feira";
			}
		} catch (Exception exception) {
			System.out.println("Formato incorreto.");
		}

		System.out.println(stringData + " - " + diaSemana);

		System.out.println("\n");
	}
}