package model;

import java.util.ArrayList;

public class Banco implements Imprimivel {

	public static ArrayList<ContaBancaria> arrayListContasBancarias = new ArrayList<>();

	public static void inserirConta(ContaBancaria contaBancaria) {
		arrayListContasBancarias.add(contaBancaria);
	}

	public static void removerConta(ContaBancaria contaBancaria) {
		arrayListContasBancarias.remove(contaBancaria);
	}

	public static ContaBancaria procurarConta(String numeroConta) {
		for (ContaBancaria contaBancaria : arrayListContasBancarias) {
			if(contaBancaria.getNumero().equals(numeroConta))
				return contaBancaria;
		}
		return null;
	}

	@Override
	public String mostrarDados() {
		String dadosBancarios = "";
		for (ContaBancaria contaBancaria : arrayListContasBancarias) {
			dadosBancarios += ((Imprimivel) contaBancaria).mostrarDados();
		}
		return dadosBancarios;
	}
}