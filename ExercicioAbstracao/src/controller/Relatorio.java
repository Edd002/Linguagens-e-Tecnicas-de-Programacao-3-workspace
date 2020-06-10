package controller;

import model.Imprimivel;

public class Relatorio {

	public String gerarRelatorio(Imprimivel imprimivel) {
		return imprimivel.mostrarDados();
	}
}