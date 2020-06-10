package view;

import model.Noticia;
import model.NoticiaPolitica;
import model.NoticiaSaude;

public class MainThread {

	public static void main(String[] args) {
		NoticiaPolitica noticiaPolitica = new NoticiaPolitica();
		noticiaPolitica.setId((int) Math.random());
		noticiaPolitica.setImagem("Imagem not�cia pol�tica 1");
		noticiaPolitica.setDescricao("Descri��o not�cia pol�tica 1");
		noticiaPolitica.setEsferaPolitica("Esfera pol�tica not�cia pol�tica 1");
		verNoticia(noticiaPolitica);

		System.out.println();

		NoticiaSaude noticiaSaude = new NoticiaSaude();
		noticiaSaude.setId((int) Math.random());
		noticiaSaude.setImagem("Imagem not�cia sa�de 1");
		noticiaSaude.setDescricao("Descri��o not�cia sa�de 1");
		noticiaSaude.setSetorSaude("Setor sa�de not�cia sa�de 1");
		verNoticia(noticiaSaude);
	}

	// Polimorfismo: classe mais abstrata (Noticia) se comportando como uma classe mais concreta (NoticiaPolitica ou NoticiaSaude) de acordo com qual delas � passada por par�metro
	public static void verNoticia(Noticia noticia) {
		try {
			System.out.println(noticia.buscarNoticia());
			System.out.println(noticia.toString());
		} catch (InterruptedException interruptedException) {
			System.out.println("Erro ao buscar not�cia: \n" + interruptedException.getMessage());
		}
	}
}