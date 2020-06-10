package controller;

import java.io.File;
import java.util.ArrayList;

import model.Pet;
import utilitarios.LtpLib;

@SuppressWarnings("unchecked")
public class Negocio {

	public static ArrayList<Pet> arrayListPets = new ArrayList<>();

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param Pet pet
	 * @throws Exception exception
	 * @return void
	 * 
	 * Este m�todo valida cadastra um pet.
	 */
	public static void cadastrarPet(Pet pet) throws Exception {
		if (new File("Pets.obj").exists())
			arrayListPets = LtpLib.lerArquivoObjetosArray("Pets.obj");

		arrayListPets.add(pet);
		LtpLib.gravarArquivoObjetosArray("Pets.obj", arrayListPets);
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param Integer codigo
	 * @throws Exception exception
	 * @return Pet pet
	 * 
	 * Este m�todo consulta um pet por c�digo.
	 */
	public static Pet consultarPet(Integer codigo) throws Exception {
		if (new File("Pets.obj").exists()) {
			arrayListPets = LtpLib.lerArquivoObjetosArray("Pets.obj");
			for (Pet petArquivo : arrayListPets) {
				if (petArquivo.getCodigo().equals(codigo))
					return petArquivo;
			}
		} else {
			throw new Exception("\nN�o h� nenhum cadastro ainda.\n");
		}
		throw new Exception("\nErro ao consultar pet.\n");
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param Integer codigo, Pet pet
	 * @throws Exception exception
	 * @return void
	 * 
	 * Este m�todo edita um pet buscando em arquivo o pet com o c�digo informado e substituindo pelo objeto pet tamb�m informado.
	 */
	public static void editarPet(Integer codigo, Pet pet) throws Exception {
		if (new File("Pets.obj").exists()) {
			arrayListPets = LtpLib.lerArquivoObjetosArray("Pets.obj");
			int contPosicao = 0;
			for (Pet petArquivo : arrayListPets) {
				if (petArquivo.getCodigo().equals(codigo)) {
					arrayListPets.set(contPosicao, pet);
					break;
				}
				contPosicao++;
			}
			LtpLib.gravarArquivoObjetosArray("Pets.obj", arrayListPets);
		} else {
			throw new Exception("\nN�o h� nenhum cadastro ainda.\n");
		}
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param Integer codigo
	 * @throws Exception exception
	 * @return void
	 * 
	 * Este m�todo deleta o pet que possui o c�digo informado.
	 */
	public static void deletarPet(Integer codigo) throws Exception {
		if (new File("Pets.obj").exists()) {
			arrayListPets = LtpLib.lerArquivoObjetosArray("Pets.obj");
			int contPosicao = 0;
			for (Pet petArquivo : arrayListPets) {
				if (petArquivo.getCodigo().equals(codigo)) {
					arrayListPets.remove(contPosicao);
					break;
				}
				contPosicao++;
			}
			LtpLib.gravarArquivoObjetosArray("Pets.obj", arrayListPets);
		} else {
			throw new Exception("\nN�o h� nenhum cadastro ainda.\n");
		}
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param void
	 * @throws Exception exception
	 * @return ArrayList<Pet> arrayListPets
	 * 
	 * Este m�todo lista todos os pets.
	 */
	public static ArrayList<Pet> listarPets() throws Exception {
		if (new File("Pets.obj").exists()) {
			arrayListPets = LtpLib.lerArquivoObjetosArray("Pets.obj");
			return arrayListPets;
		} else {
			throw new Exception("\nN�o h� nenhum cadastro ainda.\n");
		}
	}
}