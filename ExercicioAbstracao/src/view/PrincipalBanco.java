package view;

import model.Banco;
import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Imprimivel;
import utilitarios.Console;

public class PrincipalBanco {

	public static void main(String[] args) {
		menu();
		Console.printPrompt("\n\nFim do programa.");
	}

	private static void menu() {
		Integer opcao = 0;

		do {
			opcao = Console.readInt("\nInforme:\n1 para criar conta\n2 para selecionar conta\n3 para remover conta\n4 para gerar relatório\n5 para voltar ao menu anterior\n");

			switch (opcao) {
			case 1:
				Console.printPrompt("\n--- MENU DE CRIAÇÃO DE CONTA SELECIONADO ---\n");
				menuInformarConta();
				break;
			case 2:
				Console.printPrompt("\n--- MENU DE SELEÇÃO DE CONTA SELECIONADO ---\n");
				menuSelecionarConta();
				Console.printPrompt("\n--- CONTA SELECIONADA ---\n");
				break;
			case 3:
				Console.printPrompt("\n--- MENU DE REMOÇÃO DE CONTA SELECIONADO ---\n");
				excluirConta();
				Console.printPrompt("\n--- CONTA REMOVIDA ---\n");
				break;
			case 4:
				Console.printPrompt("\n--- MENU DE GERAÇÃO DE RELATÓRIO SELECIONADO ---\n");
				Console.printPrompt((new Banco()).mostrarDados());
				Console.printPrompt("\n--- RELATÓRIO GERADO ---\n");
				break;
			case 5:
				Console.printPrompt("\n--- SAIR ---\n");
				break;
			default:
				Console.printPrompt("\nOpção Informada inválida.\n");
				break;
			}

			if (opcao == 5)
				break;
		} while (true);
	}

	private static void menuInformarConta() {
		Integer opcao = 0;

		do {
			opcao = Console.readInt("\nInforme:\n1 para criar conta poupança\n2 para criar conta corrente\n3 para voltar ao menu anterior\n");

			switch (opcao) {
			case 1:
				Console.printPrompt("\n--- MENU DE CRIAÇÃO DE CONTA POUPANÇA SELECIONADO ---\n");
				informarConta(new ContaPoupanca());
				Console.printPrompt("\n--- CONTA POUPANÇA INSERIDA ---\n");
				break;
			case 2:
				Console.printPrompt("\n--- CRIAÇÃO DE CONTA CORRENTE SELECIONADO ---\n");
				informarConta(new ContaCorrente());
				Console.printPrompt("\n--- CONTA CORRENTE INSERIDA ---\n");
				break;
			case 3:
				Console.printPrompt("\n--- VOLTAR AO MENU ANTERIOR SELECIONADO ---\n");
				break;
			default:
				Console.printPrompt("\nOpção Informada inválida.\n");
				break;
			}

			if (opcao == 3)
				break;
		} while (true);
	}

	private static void menuSelecionarConta() {
		Integer opcao = 0;
		ContaBancaria contaBancaria = selecionarConta();

		do {
			opcao = Console.readInt("\nInforme:\n1 para depositar um valor\n2 para sacar um valor\n3 para transferir um valor\n4 para gerar relatório\n5 para voltar ao menu anterior\n");

			switch (opcao) {
			case 1:
				Console.printPrompt("\n--- MENU DE DEPÓSITO SELECIONADO ---\n");
				contaBancaria.depositar(Console.readDouble("\nInforme o valor para depositar: \n"));
				Console.printPrompt("\n--- DEPÓSITO EFETUADO ---\n");
				break;
			case 2:
				Console.printPrompt("\n--- MENU DE SAQUE SELECIONADO ---\n");
				contaBancaria.sacar(Console.readDouble("\nInforme o valor para sacar: \n"));
				Console.printPrompt("\n--- SAQUE EFETUADO ---\n");
				break;
			case 3:
				Console.printPrompt("\n--- MENU DE TRANSFERÊNCIA SELECIONADO ---\n");
				if (contaBancaria.transferir(Console.readDouble("\nInforme o valor para tranferir: \n"), selecionarConta()))
					Console.printPrompt("\n--- TRANSFERÊCIA EFETUADA ---\n");
				else
					Console.printPrompt("\n--- TRANSFERÊCIA NÃO EFETUADA: ERRO AO SACAR ---\n");
				break;
			case 4:
				Console.printPrompt("\n--- MENU DE RELATÓRIO SELECIONADO ---\n");
				System.out.println(((Imprimivel) contaBancaria).mostrarDados());
				Console.printPrompt("\n--- RELATÓRIO EXIBIDO ---\n");
				break;
			case 5:
				Console.printPrompt("\n--- VOLTAR AO MENU ANTERIOR SELECIONADO ---\n");
				break;
			default:
				Console.printPrompt("\nOpção Informada inválida.\n");
				break;
			}

			if (opcao == 5)
				break;
		} while (true);
	}

	private static void informarConta(ContaBancaria contaBancaria) {
		do {
			try {
				contaBancaria.setNumero(Console.readLine("\nInforme o número da conta: \n"));
				if (Integer.parseInt(contaBancaria.getNumero()) <= 0) {
					Console.printPrompt("\nInforme apenas números positivos para este campo.\n");
					continue;
				}

				break;
			} catch (Exception exception) {
				Console.printPrompt("\nInforme apenas números inteiros para este campo.\n");
			}
		} while (true);

		do {
			try {
				contaBancaria.setSaldo(Console.readDouble("\nInforme o saldo da conta: \n"));
				if (contaBancaria.getSaldo() < 0) {
					Console.printPrompt("\nInforme apenas números positivos ou nulo para este campo.\n");
					continue;
				}

				break;
			} catch (Exception exception) {
				Console.printPrompt("\nInforme apenas números para este campo.\n");
			}
		} while (true);

		if (contaBancaria instanceof ContaPoupanca) {
			do {
				try {
					((ContaPoupanca) contaBancaria).setLimite(Console.readDouble("\nInforme o limite da conta: \n"));
					if (((ContaPoupanca) contaBancaria).getLimite() < 0) {
						Console.printPrompt("\nInforme apenas números positivos ou nulo para este campo.\n");
						continue;
					}

					break;
				} catch (Exception exception) {
					Console.printPrompt("\nInforme apenas números para este campo.\n");
				}
			} while (true);
		} else if (contaBancaria instanceof ContaCorrente) {
			do {
				try {
					((ContaCorrente) contaBancaria).setTaxaDeOperacao(Console.readDouble("\nInforme a taxa de operação da conta: \n"));
					if (((ContaCorrente) contaBancaria).getTaxaDeOperacao() < 0) {
						Console.printPrompt("\nInforme apenas números positivos ou nulo para este campo.\n");
						continue;
					}

					break;
				} catch (Exception exception) {
					Console.printPrompt("\nInforme apenas números para este campo.\n");
				}
			} while (true);
		}

		Banco.inserirConta(contaBancaria);
	}

	private static ContaBancaria selecionarConta() {
		Integer numeroConta = 0;

		do {
			try {
				numeroConta = Integer.parseInt(Console.readLine("\nInforme o número da conta: \n"));
				if (numeroConta <= 0) {
					Console.printPrompt("\nInforme apenas números positivos para este campo.\n");
					continue;
				}

				ContaBancaria contaBancaria = Banco.procurarConta(numeroConta.toString());
				if (contaBancaria == null) {
					Console.printPrompt("\nNúmero da conta não encontrado.\n");
					continue;
				}

				return contaBancaria;
			} catch (Exception exception) {
				Console.printPrompt("\nInforme apenas números inteiros para este campo.\n");
			}
		} while (true);
	}

	private static void excluirConta() {
		Integer numeroConta = 0;

		do {
			try {
				numeroConta = Integer.parseInt(Console.readLine("\nInforme o número da conta: \n"));
				if (numeroConta <= 0) {
					Console.printPrompt("\nInforme apenas números positivos para este campo.\n");
					continue;
				}

				ContaBancaria contaBancaria = Banco.procurarConta(numeroConta.toString());
				if (contaBancaria == null) {
					Console.printPrompt("\nNúmero da conta não encontrado.\n");
					continue;
				}

				Banco.removerConta(contaBancaria);
				break;
			} catch (Exception exception) {
				Console.printPrompt("\nInforme apenas números inteiros para este campo.\n");
			}
		} while (true);
	}
}