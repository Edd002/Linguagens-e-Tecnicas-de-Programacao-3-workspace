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
 * Classe de interface com usu�rio.
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
	 * M�todo de exibi��o de menu.
	 */
	private static void menu() {
		boolean continuar = true;
		char opcaoFuncionario = '\0';
		char opcao = '\0';

		do {
			opcao = Console.readLine("\nINFORME\n"
					+ "1- Cadastrar funcion�rio\n"
					+ "2- Consultar funcion�rio\n"
					+ "3- Editar funcion�rio\n"
					+ "4- Deletar funcion�rio\n"
					+ "5- Listar todos os funcion�rios\n"
					+ "6- Demitir funcion�rio\n"
					+ "7- Calcular bonifica��o\n"
					+ "8- Gerar relat�rio gerencial\n"
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
				Console.printPrompt("EDI��O REALIZADA COM SUCESSO");
				break;
			case '4':
				deletarFuncionario();
				Console.printPrompt("EXCLUS��O REALIZADA COM SUCESSO");
				break;
			case '5':
				listarFuncionario();
				break;
			case '6':
				demitirFuncionario();
				Console.printPrompt("DEMISS�O REALIZADA COM SUCESSO");
				break;
			case '7':
				calcularBonificacao();
				Console.printPrompt("BONIFICA��O CALCULADA.");
				break;
			case '8':
				gerarRelatorio();
				break;
			case '0':
				continuar = false;
				break;
			default:
				Console.printPrompt("Op��o inv�lida.");
				break;
			}
		} while (continuar);
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * M�todo de cadastro de funcion�rio.
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
	 * M�todo de consulta de funcion�rio.
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
	 * M�todo de edi��o de funcion�rio.
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
	 * M�todo de exclus�o de funcion�rio.
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
	 * M�todo de listagem de funcion�rios.
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
	 * M�todo de demiss�o de funcion�rio.
	 */
	private static void demitirFuncionario() {
		try {
			String cpf = Console.readLine("Informe o CPF do funcion�rio que ser� demitido: \n");
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
	 * M�todo de bonifica��o de funcion�rio.
	 */
	private static void calcularBonificacao() {
		try {
			String cpf = Console.readLine("Informe o CPF do funcion�rio que ser� demitido: \n");
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
	 * M�todo de gera��o de relat�rio de funcion�rios.
	 */
	private static void gerarRelatorio() {
		try {
			Date dataInicio = (new SimpleDateFormat("dd/MM/yyy")).parse(Console.readLine("Informe uma data in�cio (dd/MM/yyyy): "));
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
	 * M�todo para ler o arquivo.
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
	 * M�todo para gravar o arquivo.
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