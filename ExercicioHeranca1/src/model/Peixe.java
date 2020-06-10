package model;

public class Peixe extends Animal {
	private String tipoHabitat;

	public String getTipoHabitat() {
		return tipoHabitat;
	}

	public void setTipoHabitat(String tipoHabitat) {
		this.tipoHabitat = tipoHabitat;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nPeso: " + peso +"\nHabitat: " + tipoHabitat + "\n";
	}
}