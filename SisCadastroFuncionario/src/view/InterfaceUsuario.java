package view;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.BizException;
import controller.RH;
import model.Funcionario;
import model.Gerente;
import model.Vendedor;
import util.Console;
import util.LtpLib;

/**
 * @author Eduardo
 * 
 * Classe de interface com usuário.
 */
@SuppressWarnings("unchecked")
public class InterfaceUsuario {

	private static RH rh = new RH();

	public static void main(String[] args) {
		lerArquivo();
		menu();
		gravarArquivo();

		System.out.println("\n\nFim do programa.");
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de exibição de menu.
	 */
	private static void menu() {
		boolean continuar = true;
		char opcaoFuncionario = '\0';
		char opcao = '\0';

		do {
			opcao = Console.readLine("\nINFORME\n"
					+ "1- Cadastrar funcionário\n"
					+ "2- Consultar funcionário\n"
					+ "3- Editar funcionário\n"
					+ "4- Deletar funcionário\n"
					+ "5- Listar todos os funcionários\n"
					+ "6- Demitir funcionário\n"
					+ "7- Calcular bonificação\n"
					+ "8- Gerar relatório gerencial\n"
					+ "0- Sair").charAt(0);

			switch (opcao) {
			case '1':
				opcaoFuncionario = Console.readLine("Informe A para GERENTE ou qualquer entrada VENDEDOR: \n").charAt(0);
				cadastrarFuncionario(opcaoFuncionario);
				Console.printPrompt("CADASTRO REALIZADO COM SUCESSO");
				break;
			case '2':
				consultarFuncionario();
				break;
			case '3':
				editarFuncionario();
				Console.printPrompt("EDIÇÃO REALIZADA COM SUCESSO");
				break;
			case '4':
				deletarFuncionario();
				Console.printPrompt("EXCLUSÇÃO REALIZADA COM SUCESSO");
				break;
			case '5':
				listarFuncionario();
				break;
			case '6':
				demitirFuncionario();
				Console.printPrompt("DEMISSÃO REALIZADA COM SUCESSO");
				break;
			case '7':
				calcularBonificacao();
				Console.printPrompt("BONIFICAÇÃO CALCULADA.");
				break;
			case '8':
				gerarRelatorio();
				break;
			case '0':
				continuar = false;
				break;
			default:
				Console.printPrompt("Opção inválida.");
				break;
			}
		} while (continuar);
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de cadastro de funcionário.
	 */
	private static void cadastrarFuncionario(char opcaoFuncionario) {
		try {
			if (opcaoFuncionario == 'A') {
				Gerente gerente = new Gerente("Nome1", "CPF1", "Telefone1", "Endereco1", new Date(), new Date(), null, 0, "Senha1", 0.0, 0.0, true);
				rh.cadastrarFuncionario(gerente);
			} else {
				Vendedor vendedor = new Vendedor("Nome1", "CPF1", "Telefone1", "Endereco1", new Date(), new Date(), null, "Departamento1", 0.0, 0.0, 0.0, true);
				rh.cadastrarFuncionario(vendedor);
			}
			gravarArquivo();
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de consulta de funcionário.
	 */
	private static void consultarFuncionario() {
		try {
			String cpf = Console.readLine("Informe o CPF para consultar: \n");
			Funcionario funcionario = rh.consultarFuncionario(cpf);
			Console.printPrompt(funcionario.toString());
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de edição de funcionário.
	 */
	private static void editarFuncionario() {
		try {
			String cpf = Console.readLine("Informe o CPF para editar: \n");
			Funcionario funcionario = rh.consultarFuncionario(cpf);
			rh.deletarFuncionario(cpf);

			if (funcionario instanceof Gerente)
				cadastrarFuncionario('A');
			else if (funcionario instanceof Vendedor)
				cadastrarFuncionario('B');
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de exclusão de funcionário.
	 */
	private static void deletarFuncionario() {
		try {
			String cpf = Console.readLine("Informe o CPF para deletar: \n");
			rh.deletarFuncionario(cpf);
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de listagem de funcionários.
	 */
	private static void listarFuncionario() {
		try {
			for (Funcionario funcionario : rh.getArrayListFuncionario())
				Console.printPrompt(funcionario.toString() + "\n");
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de demissão de funcionário.
	 */
	private static void demitirFuncionario() {
		try {
			String cpf = Console.readLine("Informe o CPF do funcionário que será demitido: \n");
			Funcionario funcionario = rh.consultarFuncionario(cpf);
			funcionario.demitirFuncionario();
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de bonificação de funcionário.
	 */
	private static void calcularBonificacao() {
		try {
			String cpf = Console.readLine("Informe o CPF do funcionário que será demitido: \n");
			Funcionario funcionario = rh.consultarFuncionario(cpf);
			Console.printPrompt(funcionario.calcularBonificacao() + "");
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método de geração de relatório de funcionários.
	 */
	private static void gerarRelatorio() {
		try {
			Date dataInicio = (new SimpleDateFormat("dd/MM/yyy")).parse(Console.readLine("Informe uma data início (dd/MM/yyyy): "));
			Date dataFim = (new SimpleDateFormat("dd/MM/yyy")).parse(Console.readLine("Informe uma data fim (dd/MM/yyyy): "));

			for (Funcionario funcionario : rh.getArrayListFuncionario()) {
				if (funcionario.getDataEntrada().after(dataInicio) && funcionario.getDataEntrada().before(dataFim))
					Console.printPrompt(funcionario.toString() + "\n");
			}
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método para ler o arquivo.
	 */
	private static void lerArquivo() {
		try {
			if (new File("funcionarios.obj").exists()) {
				rh.setArrayListFuncionario(LtpLib.lerArquivoObjetosArray("funcionarios.obj"));
			}
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método para gravar o arquivo.
	 */
	private static void gravarArquivo() {
		try {
			LtpLib.gravarArquivoObjetosArray("funcionarios.obj", rh.getArrayListFuncionario());
		} catch (BizException bizException) {
			System.out.println(bizException.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}