package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Cliente;
import model.Empregado;
import model.Gerente;
import model.Pessoa;
import model.Vendedor;
import utilitarios.Console;
import utilitarios.LtpLib;

public class Operacao {

	private static ArrayList<Pessoa> arrayListPessoa = new ArrayList<>(); 

	public static Pessoa inserirCliente() {
		Cliente cliente = new Cliente();

		Console.printPrompt("\nENTRADA");
		cliente.setNome(Console.readLine("Nome: "));
		cliente.setIdade(Console.readInt("Idade: "));
		cliente.setSexo(Console.readLine("Sexo: "));
		cliente.setValorDivida(Console.readDouble("Valor da d�vida: "));
		cliente.setAnoNascim(GregorianCalendar.getInstance().get(Calendar.YEAR) - cliente.getIdade());

		cadastrarPessoa(cliente);

		return cliente;
	}

	public static Pessoa inserirEmpregado() {
		Empregado empregado = new Empregado();

		Console.printPrompt("\nENTRADA");
		empregado.setNome(Console.readLine("Nome: "));
		empregado.setIdade(Console.readInt("Idade: "));
		empregado.setSexo(Console.readLine("Sexo: "));
		empregado.setSalario(Console.readDouble("Valor da d�vida: "));
		empregado.setMatricula("Matr�cula: ");

		cadastrarPessoa(empregado);

		return empregado;
	}

	public static Pessoa inserirGerente() {
		Gerente gerente = new Gerente();

		Console.printPrompt("\nENTRADA");
		gerente.setNome(Console.readLine("Nome: "));
		gerente.setIdade(Console.readInt("Idade: "));
		gerente.setSexo(Console.readLine("Sexo: "));
		gerente.setSalario(Console.readDouble("Sal�rio: "));
		gerente.setMatricula(Console.readLine("Matr�cula: "));
		gerente.setNomeGerencia(Console.readLine("Nome da ger�ncia: "));

		cadastrarPessoa(gerente);

		return gerente;
	}

	public static Pessoa inserirVendedor() {
		Vendedor vendedor = new Vendedor();

		Console.printPrompt("\nENTRADA");
		vendedor.setNome(Console.readLine("Nome: "));
		vendedor.setIdade(Console.readInt("Idade: "));
		vendedor.setSexo(Console.readLine("Sexo: "));
		vendedor.setSalario(Console.readDouble("Sal�rio: "));
		vendedor.setMatricula(Console.readLine("Matr�cula: "));
		vendedor.setValorVendas(Console.readDouble("Valor das vendas: "));
		vendedor.setQntVendas(Console.readInt("Quantidade das vendas: "));

		cadastrarPessoa(vendedor);

		return vendedor;
	}

	// Projeto "Tabela de Pre�os de Produtos"
	private static void cadastrarPessoa(Pessoa pessoa) {
		arrayListPessoa.add(pessoa);
		try {
			LtpLib.gravarArquivoObjetosArray("Pessoas.obj", arrayListPessoa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static void visualizarPessoa(Pessoa pessoa) {
		Console.printPrompt("\nSA�DA");
		Console.printPrompt(pessoa.toString());
	}
}