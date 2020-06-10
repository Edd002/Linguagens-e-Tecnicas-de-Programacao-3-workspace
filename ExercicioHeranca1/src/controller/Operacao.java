package controller;

import model.Animal;
import model.Cachorro;
import model.Peixe;
import utilitarios.Console;

public class Operacao {

	public static Animal inserirCachorro() {
		Cachorro cachorro = new Cachorro();

		Console.printPrompt("\nENTRADA");
		cachorro.setNome(Console.readLine("Nome: "));
		cachorro.setPeso(Console.readDouble("Peso: "));
		cachorro.setRaca(Console.readLine("Raça: "));

		return cachorro;
	}

	public static Animal inserirPeixe() {
		Peixe peixe = new Peixe();

		Console.printPrompt("\nENTRADA");
		peixe.setNome(Console.readLine("Nome: "));
		peixe.setPeso(Console.readDouble("Peso: "));
		peixe.setTipoHabitat(Console.readLine("Habitat: "));

		return peixe;
	}

	public static void visualizarAnimal(Animal animal) {
		Console.printPrompt("\nSAÍDA");
		Console.printPrompt(animal.toString());
	}
}