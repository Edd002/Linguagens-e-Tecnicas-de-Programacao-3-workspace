package view;

import java.util.Date;
import java.util.Scanner;

import controller.Eletro;
import model.Eletronico;
import model.Smartphone;

public class InterfaceUsuario {

	public static void main(String[] args) {
		// Instânciar uma classe (alocar memória)
		Smartphone smartphone = new Smartphone();
		smartphone.setIdEletronico("EL-001");
		smartphone.setMarca("Marca1");
		smartphone.setModelo("Modelo1");
		smartphone.setAno(2000);
		smartphone.setValor(100.00);
		smartphone.setDataCompra(new Date());
		smartphone.setDataVenda(new Date());
		smartphone.setIdSmartphone("SP-001");
		smartphone.setSO("SO1");
		smartphone.setAnosDeUso("5");
		smartphone.setBomEstado(true);
		smartphone.setTelaQuebrada(false);
		smartphone.setSmartphoneVendido(false);

		Smartphone smartphone2 = new Smartphone();
		smartphone2.setIdEletronico("EL-002");
		smartphone2.setMarca("Marca2");
		smartphone2.setModelo("Modelo2");
		smartphone2.setAno(2000);
		smartphone2.setValor(100.00);
		smartphone2.setDataCompra(new Date());
		smartphone2.setDataVenda(new Date());
		smartphone2.setIdSmartphone("SP-002");
		smartphone2.setSO("SO2");
		smartphone2.setAnosDeUso("10");
		smartphone2.setBomEstado(true);
		smartphone2.setTelaQuebrada(false);
		smartphone2.setSmartphoneVendido(false);

		Eletro.arrayListEletronicos.add(smartphone);
		Eletro.arrayListEletronicos.add(smartphone2);

		for (Eletronico eletronico : Eletro.arrayListEletronicos)
			System.out.println(eletronico.toString() + "\n");
	}

	@SuppressWarnings({ "resource", "unused" })
	private static void menu() {
		Scanner scanner = new Scanner(System.in);

		// Fazer validação com tratamento de exceção para cada atributo de eletrônico
		Smartphone smartphone = new Smartphone();
		int anoSmartPhone; 
		do {
			try {
				System.out.println("Informe o ano do smartphone: ");
				anoSmartPhone = scanner.nextInt();

				break;
			} catch (Exception e) {
				System.out.println("Erro. Informe um número inteiro.");
			}
			
			scanner.nextLine();
		} while (true);
		smartphone.setAno(anoSmartPhone);


		System.out.println("1- Cadastrar eletro");
		System.out.println("2- Consultar eletro");
		System.out.println("3- Cadastrar eletro");
		System.out.println("4- Cadastrar eletro");
		System.out.println("5- Cadastrar eletro");
		System.out.println("6- Cadastrar eletro");
		System.out.println("7- Cadastrar eletro");
	}
}