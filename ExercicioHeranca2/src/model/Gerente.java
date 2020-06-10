package model;

@SuppressWarnings("serial")
public class Gerente extends Empregado {
	private String nomeGerencia;

	public String getNomeGerencia() {
		return nomeGerencia;
	}

	public void setNomeGerencia(String nomeGerencia) {
		this.nomeGerencia = nomeGerencia;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade + "\nMatr�cula: " + matricula + "\nNome da Ger�ncia: " + nomeGerencia + "\nValor INSS: " + valorInss();
	}
}