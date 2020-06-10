package view;

import controller.Caixa;

public class Principal {

	public static void main(String[] args) {
		Caixa c1 = new Caixa();
		System.out.println("Valume da caixa 1 = " + c1.volume());

		Caixa c2 = new Caixa(10, 5, 3);
		System.out.println("Volume da caixa 2 = " + c2.volume());

		c2.setComp(2);

		c2.setLarg(c2.getLarg() - 3);

		System.out.println("Novo volume da caixa 2 = " + c2.volume());
	}
}