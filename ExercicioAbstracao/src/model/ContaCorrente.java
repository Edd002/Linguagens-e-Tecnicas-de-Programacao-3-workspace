package model;

public class ContaCorrente extends ContaBancaria implements Imprimivel {

	private Double taxaDeOperacao;

	public Double getTaxaDeOperacao() {
		return taxaDeOperacao;
	}

	public void setTaxaDeOperacao(Double taxaDeOperacao) {
		this.taxaDeOperacao = taxaDeOperacao;
	}

	@Override
	public Boolean sacar(Double valor) {
		if (valor <= (getSaldo() - taxaDeOperacao)) {
			setSaldo(getSaldo() - valor - taxaDeOperacao);
			return true;
		}
		return false;	
	}

	@Override
	public void depositar(Double valor) {
		setSaldo(getSaldo() + valor - taxaDeOperacao);
	}

	@Override
	public String mostrarDados() {
		return "\n--- CONTA CORRENTE ---\nNúmero da conta: " + getNumero() + "\nSaldo da conta: " + getSaldo() + "\nTaxa de operação da conta: " + getTaxaDeOperacao();
	}
}