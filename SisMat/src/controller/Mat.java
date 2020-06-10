package controller;

import java.io.File;
import java.util.ArrayList;

import model.Aluno;
import model.Curso;
import model.Matricula;
import utilitarios.LtpLib;

@SuppressWarnings("unchecked")
public class Mat {

	private static ArrayList<Aluno> arrayListAlunos = new ArrayList<>();
	//private static ArrayList<Curso> arrayListCursos = new ArrayList<>();
	//private static ArrayList<Matricula> arrayListMatriculas = new ArrayList<>();

	/**
	 * JAVADOC
	 * @author author@email.com
	 * @param Aluno aluno
	 * @throws Exception exception
	 * @return Pet pet
	 * 
	 * Este método cadastrar um aluno.
	 */
	public static void cadastrarAluno(Aluno aluno) throws Exception {
		if (new File("Alunos.obj").exists())
			arrayListAlunos = LtpLib.lerArquivoObjetosArray("Alunos.obj");

		arrayListAlunos.add(aluno);
		LtpLib.gravarArquivoObjetosArray("Alunos.obj", arrayListAlunos);
	}

	/**
	 * JAVADOC
	 * @author author@email.com
	 * @param Aluno aluno
	 * @throws Exception exception
	 * @return Pet pet
	 * 
	 * Este método consulta de aluno pelo seu cpf.
	 */
	public static Aluno consultarAluno(String cpf) throws Exception {
		if (new File("Alunos.obj").exists()) {
			arrayListAlunos = LtpLib.lerArquivoObjetosArray("Alunos.obj");
			for (Aluno alunoArquivo : arrayListAlunos) {
				if (alunoArquivo.getCpf().equals(cpf))
					return alunoArquivo;
			}
		} else {
			throw new Exception("\nNão há nenhum cadastro ainda.\n");
		}
		throw new Exception("\nErro ao consultar pet.\n");
	}

	public static void cadastrarCurso(Curso curso) throws Exception {
	}

	public static Curso consultarCurso(String nomeCurso) throws Exception {
		return null;
	}

	public static void matricularAluno(Matricula matricula) throws Exception {
	}

	public static void desmatricularAluno(Matricula matricula) throws Exception {
	}

	public static Matricula consultarMatricula(int codigoMatricula) throws Exception {
		return null;
	}
}