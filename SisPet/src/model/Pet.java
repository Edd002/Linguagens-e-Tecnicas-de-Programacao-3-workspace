package model;

import java.io.Serializable;

public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nome;
	private String cpfDono;
	private String telDono;

	public Pet() {
	}

	public Pet(Integer codigo, String nome, String cpfDono, String telDono) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpfDono = cpfDono;
		this.telDono = telDono;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}

	public String getTelDono() {
		return telDono;
	}

	public void setTelDono(String telDono) {
		this.telDono = telDono;
	}

	@Override
	public String toString() {
		return "Pet [codigo=" + codigo + ", nome=" + nome + ", cpfDono=" + cpfDono + ", telDono=" + telDono + "]";
	}
}