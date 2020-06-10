package model;

import java.util.Date;

/**
 * @author Eduardo
 * 
 * Classe de modelagem de dados.
 */
public class Gerente extends Funcionario {
	private static final long serialVersionUID = 1L;
	private int numFuncGerenciados;
	private String senha;
	private double salario;
	private double acerto;
	private boolean ativo;

	public Gerente() {
	}

	public Gerente(String nome, String cpf, String telefone, String endereco, Date dataNascimento, Date dataEntrada, Date dataSaida, int numFuncGerenciados, String senha, double salario, double acerto, boolean ativo) {
		super(nome, cpf, telefone, endereco, dataNascimento, dataEntrada, dataSaida);
		this.numFuncGerenciados = numFuncGerenciados;
		this.senha = senha;
		this.salario = salario;
		this.acerto = acerto;
		this.ativo = ativo;
	}

	public int getNumFuncGerenciados() {
		return numFuncGerenciados;
	}
	public void setNumFuncGerenciados(int numFuncGerenciados) {
		this.numFuncGerenciados = numFuncGerenciados;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getAcerto() {
		return acerto;
	}
	public void setAcerto(double acerto) {
		this.acerto = acerto;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Gerente [numFuncGerenciados=" + numFuncGerenciados + ", senha=" + senha + ", salario=" + salario
				+ ", acerto=" + acerto + ", ativo=" + ativo + ", nome=" + nome + ", cpf=" + cpf + ", telefone="
				+ telefone + ", endereco=" + endereco + ", dataNascimento=" + dataNascimento + ", dataEntrada="
				+ dataEntrada + ", dataSaida=" + dataSaida + "]";
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param void
	 * 
	 * Método para demitir funcionário.
	 */
	@Override
	public void demitirFuncionario() {
		super.setDataSaida(new Date());
		setAtivo(false);
		setAcerto(getSalario() + (40 * getSalario()) / 100);
		System.out.println("Gerente demitido.");
	}

	/**
	 * @author Eduardo
	 * @return double
	 * @param void
	 * 
	 * Método para calcular bonificação.
	 */
	@Override
	public double calcularBonificacao() {
		System.out.println("Calculando bonificação do Gerente...");
		return getSalario() * 2.4;
	}
}