package model;

public class Cachorro extends Animal {
	private String raca;

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nPeso: " + peso + "\nRa�a: " + raca + "\n";
	}
}