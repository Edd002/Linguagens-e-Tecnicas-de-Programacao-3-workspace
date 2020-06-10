package model;

public abstract class Noticia {

	public Noticia() {
	}

	private int id;
	private String imagem;
	private String descricao;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public abstract String buscarNoticia() throws InterruptedException;

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", imagem=" + imagem + ", descricao=" + descricao + "]";
	}
}