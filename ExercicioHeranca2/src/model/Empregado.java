package model;

@SuppressWarnings("serial")
public class Empregado extends Pessoa {
	protected double salario;
	protected String matricula;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	protected double valorInss() {
		return salario * 0.11;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo + "\nSalário: " + salario + "\nMatrícula: " + matricula;
	}
}