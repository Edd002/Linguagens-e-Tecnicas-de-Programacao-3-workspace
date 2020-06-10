package model;

import java.io.Serializable;

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Curso() {
	}

	private int codigoCurso;
	private String nomeCurso;
	private double valorCurso;
	private int duracaoCurso;
	private int notaMec;

	public int getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public double getValorCurso() {
		return valorCurso;
	}
	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}
	public int getDuracaoCurso() {
		return duracaoCurso;
	}
	public void setDuracaoCurso(int duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}
	public int getNotaMec() {
		return notaMec;
	}
	public void setNotaMec(int notaMec) {
		this.notaMec = notaMec;
	}

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", nomeCurso=" + nomeCurso + ", valorCurso=" + valorCurso
				+ ", duracaoCurso=" + duracaoCurso + ", notaMec=" + notaMec + "]";
	}
}