package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Eduardo
 * 
 * Classe de modelagem de dados.
 */
public abstract class Funcionario implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String endereco;
	protected Date dataNascimento;
	protected Date dataEntrada;
	protected Date dataSaida;

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, String telefone, String endereco, Date dataNascimento, Date dataEntrada, Date dataSaida) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public abstract void demitirFuncionario();

	public abstract double calcularBonificacao();
}