package model;

@SuppressWarnings("serial")
public class Vendedor extends Empregado {
	private double valorVendas;
	private int qntVendas;

	public double getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}

	public int getQntVendas() {
		return qntVendas;
	}

	public void setQntVendas(int qntVendas) {
		this.qntVendas = qntVendas;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nSalário: " + salario + "\nValor das Vendas: " + valorVendas + "\nQuantidade de Vendas: " + qntVendas;
	}
}