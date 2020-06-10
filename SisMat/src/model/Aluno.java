package model;

import java.io.Serializable;
import java.util.Date;

public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	public Aluno() {
	}

	private int codigoAluno;
	private String nomeAluno;
	private String cpf;
	private String telefone;
	private Date dataEntrada;

	public int getCodigoAluno() {
		return codigoAluno;
	}
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
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
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	@Override
	public String toString() {
		return "Aluno [codigoAluno=" + codigoAluno + ", nomeAluno=" + nomeAluno + ", cpf=" + cpf + ", telefone="
				+ telefone + ", dataEntrada=" + dataEntrada + "]";
	}
}