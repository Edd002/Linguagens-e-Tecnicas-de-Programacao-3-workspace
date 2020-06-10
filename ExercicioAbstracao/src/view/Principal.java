package view;

import controller.Relatorio;
import model.ContaCorrente;
import model.ContaPoupanca;
import utilitarios.Console;

public class Principal {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		Relatorio relatorio = new Relatorio();

		contaCorrente.setNumero("000000000");
		contaCorrente.setSaldo(1000.00);
		contaCorrente.setTaxaDeOperacao(5.00);

		contaPoupanca.setNumero("111111111");
		contaPoupanca.setSaldo(1000.00);
		contaPoupanca.setLimite(100.00);

		Console.printPrompt("Saque em conta corrente: " + contaCorrente.sacar(95.00));
		Console.printPrompt("\nSaque em conta poupança: " + contaPoupanca.sacar(199.00));
		Console.printPrompt("\n" + relatorio.gerarRelatorio(contaCorrente));
		Console.printPrompt("\n" + relatorio.gerarRelatorio(contaPoupanca));

		contaCorrente.transferir(100.00, contaPoupanca);
		Console.printPrompt("\n" + relatorio.gerarRelatorio(contaCorrente));
		Console.printPrompt("\n" + relatorio.gerarRelatorio(contaPoupanca));
	}
}