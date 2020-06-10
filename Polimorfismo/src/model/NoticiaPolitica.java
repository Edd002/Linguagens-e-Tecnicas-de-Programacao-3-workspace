package model;

public class NoticiaPolitica extends Noticia {

	public NoticiaPolitica() {
	}

	private String esferaPolitica;

	public String getEsferaPolitica() {
		return esferaPolitica;
	}
	public void setEsferaPolitica(String esferaPolitica) {
		this.esferaPolitica = esferaPolitica;
	}

	@Override
	public String buscarNoticia() throws InterruptedException {
		Thread.sleep(2000);
		return "Buscando not�cia sobre pol�tica...";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNoticiaPolitica [esferaPolitica=" + esferaPolitica + "]";
	}
}