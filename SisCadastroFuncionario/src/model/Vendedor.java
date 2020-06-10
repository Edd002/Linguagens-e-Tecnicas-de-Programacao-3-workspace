package model;

import java.util.Date;

/**
 * @author Eduardo
 * 
 * Classe de modelagem de dados.
 */
public class Vendedor extends Funcionario {
	private static final long serialVersionUID = 1L;
	private String departamento;
	private double metaVenda;
	private double salario;
	private double acerto;
	private boolean ativo;

	public Vendedor() {
	}

	public Vendedor(String nome, String cpf, String telefone, String endereco, Date dataNascimento, Date dataEntrada, Date dataSaida, String departamento, double metaVenda, double salario, double acerto, boolean ativo) {
		super(nome, cpf, telefone, endereco, dataNascimento, dataEntrada, dataSaida);
		this.departamento = departamento;
		this.metaVenda = metaVenda;
		this.salario = salario;
		this.acerto = acerto;
		this.ativo = ativo;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getMetaVenda() {
		return metaVenda;
	}
	public void setMetaVenda(double metaVenda) {
		this.metaVenda = metaVenda;
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
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Vendedor [departamento=" + departamento + ", metaVenda=" + metaVenda + ", salario=" + salario
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
		setAcerto(getSalario() + (30 * getSalario()) / 100);
		System.out.println("Vendedor demitido.");
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
		System.out.println("Calculando bonificação do vendedor...");
		return getSalario() * 1.2;
	}
}