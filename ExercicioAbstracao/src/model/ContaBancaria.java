package model;

public abstract class ContaBancaria {

	private String numero;
	private Double saldo;

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean transferir(Double valor, ContaBancaria contaBancaria) {
		if (sacar(valor)) {
			contaBancaria.depositar(valor);
			return true;
		}
		return false;
	}

	public abstract Boolean sacar(Double valor);
	public abstract void depositar(Double valor);
}