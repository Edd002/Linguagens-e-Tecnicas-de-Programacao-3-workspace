package view;

import controller.Operacao;
import model.Pessoa;
import utilitarios.Console;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		char opcao = ' ';

		Console.printPrompt("CADASTRO DE PESSOAS");
		opcao = Console.readLine("Informe:\n1 para Cliente\n2 para Empregado\n3 para Gerente\n4 para Vendedor\n").charAt(0);

		switch (opcao) {
			case '1':
				pessoa = Operacao.inserirCliente();
				break;
			case '2':
				pessoa = Operacao.inserirEmpregado();
				break;
			case '3':
				pessoa = Operacao.inserirGerente();
				break;
			case '4':
				pessoa = Operacao.inserirVendedor();
				break;
			default:
				Console.printPrompt("Opção inválida.");
				break;
		}

		Operacao.visualizarPessoa(pessoa);

		Console.printPrompt("\n\nFIM DO PROGRAMA.");
	}
}