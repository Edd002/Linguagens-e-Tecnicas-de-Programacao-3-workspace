package model;

public class NoticiaSaude extends Noticia {

	public NoticiaSaude() {
	}

	private String setorSaude;

	public String getSetorSaude() {
		return setorSaude;
	}
	public void setSetorSaude(String setorSaude) {
		this.setorSaude = setorSaude;
	}

	@Override
	public String buscarNoticia() throws InterruptedException {
		Thread.sleep(2000);
		return "Buscando notícia sobre saúde...";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNoticiaSaude [setorSaude=" + setorSaude + "]";
	}	
}