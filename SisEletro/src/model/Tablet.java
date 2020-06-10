package model;

import java.util.Date;

//Alt + Shift + S para getters e settes e toString()
public class Tablet extends Eletronico {

	private static final long serialVersionUID = 1L;

	public Tablet() {
	}

	private String idTablet;
	private int tamanhoTela;
	private String modeloTablet;
	private boolean tabletUsado;
	private boolean produtoApple;
	private boolean tabletVendido;

	public String getIdTablet() {
		return idTablet;
	}
	public void setIdTablet(String idTablet) {
		this.idTablet = idTablet;
	}
	public int getTamanhoTela() {
		return tamanhoTela;
	}
	public void setTamanhoTela(int tamanhoTela) {
		this.tamanhoTela = tamanhoTela;
	}
	public String getModeloTablet() {
		return modeloTablet;
	}
	public void setModeloTablet(String modeloTablet) {
		this.modeloTablet = modeloTablet;
	}
	public boolean isTabletUsado() {
		return tabletUsado;
	}
	public void setTabletUsado(boolean tabletUsado) {
		this.tabletUsado = tabletUsado;
	}
	public boolean isProdutoApple() {
		return produtoApple;
	}
	public void setProdutoApple(boolean produtoApple) {
		this.produtoApple = produtoApple;
	}
	public boolean isTabletVendido() {
		return tabletVendido;
	}
	public void setTabletVendido(boolean tabletVendido) {
		this.tabletVendido = tabletVendido;
	}

	@Override
	public void informarVenda() {
		super .setDataVenda(new Date());
		setTabletVendido( true );
		System. out .println( "Tablet vendido." );
	}

	@Override
	public String toString() {
		return super.toString() + "\nTablet [idTablet=" + idTablet + ", tamanhoTela=" + tamanhoTela + ", modeloTablet=" + modeloTablet
				+ ", tabletUsado=" + tabletUsado + ", produtoApple=" + produtoApple + ", tabletVendido=" + tabletVendido
				+ "]";
	}
}