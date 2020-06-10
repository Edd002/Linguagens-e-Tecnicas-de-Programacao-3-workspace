package view;

import controller.Operacao;
import model.Animal;
import utilitarios.Console;

public class Principal {

	public static void main(String[] args) {
		Animal animal = new Animal();
		char opcao = ' ';

		opcao = Console.readLine("Informe 1 para inserir cachorro ou 2 para inserir peixe: ").charAt(0);
	
		if (opcao == '1')
			animal = Operacao.inserirCachorro();
		else
			animal = Operacao.inserirPeixe();

		Operacao.visualizarAnimal(animal);
	}
}