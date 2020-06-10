package model;

import java.util.Date;

//Alt + Shift + S para getters e settes e toString()
public class Smartphone extends Eletronico {

	private static final long serialVersionUID = 1L;

	public Smartphone() {
	}

	private String idSmartphone;
	private String SO;
	private String anosDeUso;
	private boolean bomEstado;
	boolean telaQuebrada;
	boolean smartphoneVendido;

	public String getIdSmartphone() {
		return idSmartphone;
	}
	public void setIdSmartphone(String idSmartphone) {
		this.idSmartphone = idSmartphone;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public String getAnosDeUso() {
		return anosDeUso;
	}
	public void setAnosDeUso(String anosDeUso) {
		this.anosDeUso = anosDeUso;
	}
	public boolean isBomEstado() {
		return bomEstado;
	}
	public void setBomEstado(boolean bomEstado) {
		this.bomEstado = bomEstado;
	}
	public boolean isTelaQuebrada() {
		return telaQuebrada;
	}
	public void setTelaQuebrada(boolean telaQuebrada) {
		this.telaQuebrada = telaQuebrada;
	}
	public boolean isSmartphoneVendido() {
		return smartphoneVendido;
	}
	public void setSmartphoneVendido(boolean smartphoneVendido) {
		this.smartphoneVendido = smartphoneVendido;
	}

	@Override
	public void informarVenda() {
		super .setDataVenda( new Date());
		setSmartphoneVendido( true );
		System. out .println( "Smartphone vendido." );
	}

	@Override
	public String toString() {
		return super.toString() + "\nSmartphone [idSmartphone=" + idSmartphone + ", SO=" + SO + ", anosDeUso=" + anosDeUso + ", bomEstado="
				+ bomEstado + ", telaQuebrada=" + telaQuebrada + ", smartphoneVendido=" + smartphoneVendido + "]";
	}
}