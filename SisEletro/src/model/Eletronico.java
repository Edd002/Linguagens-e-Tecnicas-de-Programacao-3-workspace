package model;

import java.io.Serializable;
import java.util.Date;

// Alt + Shift + S para getters e settes e toString()
public abstract class Eletronico implements Serializable {

	private static final long serialVersionUID = 1L;

	public Eletronico() {
	}

	private String idEletronico;
	private String marca;
	private String modelo;
	private int ano;
	private double valor;
	private Date dataCompra;
	private Date dataVenda;

	public String getIdEletronico() {
		return idEletronico;
	}
	public void setIdEletronico(String idEletronico) {
		this.idEletronico = idEletronico;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public abstract void informarVenda();

	@Override
	public String toString() {
		return "Eletronico [idEletronico=" + idEletronico + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano
				+ ", valor=" + valor + ", dataCompra=" + dataCompra + ", dataVenda=" + dataVenda + "]";
	}
}
