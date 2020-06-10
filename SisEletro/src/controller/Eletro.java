package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Eletronico;
import utilitarios.LtpLib;

@SuppressWarnings("unchecked")
public class Eletro {

	public static ArrayList<Eletronico> arrayListEletronicos = new ArrayList<Eletronico>();

	public static void cadastrarEletronico(Eletronico eletronico) throws Exception {
		if (new File("Eletronico.obj").exists())
			arrayListEletronicos = LtpLib.lerArquivoObjetosArray("Eletronico.obj");

		arrayListEletronicos.add(eletronico);
		LtpLib.gravarArquivoObjetosArray("Eletronico.obj", arrayListEletronicos);
	}

	public static Eletronico consultarEletronico(String modelo) throws Exception {
		if (new File("Eletronico.obj").exists()) {
			arrayListEletronicos = LtpLib.lerArquivoObjetosArray("Eletronico.obj");
			for (Eletronico eletronicoArquivo : arrayListEletronicos) {
				if (eletronicoArquivo.getModelo().equals(modelo))
					return eletronicoArquivo;
			}
		} else {
			throw new Exception("\nNão há nenhum cadastro ainda.\n");
		}
		throw new Exception("\nErro ao consultar eletrônico.\n");
	}

	public static void editarEletronico(String idEletronico) throws Exception {
		if (new File("Eletronico.obj").exists()) {
			arrayListEletronicos = LtpLib.lerArquivoObjetosArray("Eletronico.obj");
			int contPosicao = 0;
			for (Eletronico eletronicoArquivo : arrayListEletronicos) {
				if (eletronicoArquivo.getIdEletronico().equals(idEletronico)) {
					arrayListEletronicos.set(contPosicao, eletronicoArquivo);
					break;
				}
				contPosicao++;
			}
			LtpLib.gravarArquivoObjetosArray("Eletronico.obj", arrayListEletronicos);
		} else {
			throw new Exception("\nNão há nenhum cadastro ainda.\n");
		}
	}

	public static void deletarEletronico(String modelo) {
	}

	public static void listarEletronico() {
	}

	public static void gerarRanking() throws Exception {
		Collections.sort(arrayListEletronicos, Comparator.comparing(Eletronico::getValor));
	}
}
