package model;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {

	private Double limite;

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	@Override
	public Boolean sacar(Double valor) {
		if (valor <= (getSaldo() + limite)) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}

	@Override
	public void depositar(Double valor) {
		setSaldo(getSaldo() + valor);
	}

	@Override
	public String mostrarDados() {
		return "\n--- CONTA POUPANÇA ---\nNúmero da conta: " + getNumero() + "\nSaldo da conta: " + getSaldo() + "\nLimite da conta: " + getLimite();
	}
}