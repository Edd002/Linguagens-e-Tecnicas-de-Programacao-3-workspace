package view;

import model.Noticia;
import model.NoticiaPolitica;
import model.NoticiaSaude;

public class MainThread {

	public static void main(String[] args) {
		NoticiaPolitica noticiaPolitica = new NoticiaPolitica();
		noticiaPolitica.setId((int) Math.random());
		noticiaPolitica.setImagem("Imagem notícia política 1");
		noticiaPolitica.setDescricao("Descrição notícia política 1");
		noticiaPolitica.setEsferaPolitica("Esfera política notícia política 1");
		verNoticia(noticiaPolitica);

		System.out.println();

		NoticiaSaude noticiaSaude = new NoticiaSaude();
		noticiaSaude.setId((int) Math.random());
		noticiaSaude.setImagem("Imagem notícia saúde 1");
		noticiaSaude.setDescricao("Descrição notícia saúde 1");
		noticiaSaude.setSetorSaude("Setor saúde notícia saúde 1");
		verNoticia(noticiaSaude);
	}

	// Polimorfismo: classe mais abstrata (Noticia) se comportando como uma classe mais concreta (NoticiaPolitica ou NoticiaSaude) de acordo com qual delas é passada por parâmetro
	public static void verNoticia(Noticia noticia) {
		try {
			System.out.println(noticia.buscarNoticia());
			System.out.println(noticia.toString());
		} catch (InterruptedException interruptedException) {
			System.out.println("Erro ao buscar notícia: \n" + interruptedException.getMessage());
		}
	}
}