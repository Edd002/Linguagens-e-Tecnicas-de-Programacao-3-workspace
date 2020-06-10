package view;

import java.util.ArrayList;

import controller.Negocio;
import model.Pet;
import utilitarios.Console;
import utilitarios.LtpLib;

public class Interface {

	public static void main(String[] args) {
		menu();
		Console.printPrompt("\n\nFim do programa.");
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param void
	 * @throws void
	 * @return void
	 * 
	 * Este método exibe o menu para o usuário.
	 */
	private static void menu() {
		String opcao = null;

		do {
			opcao = Console.readLine("\nInforme: \n" + "1- Cadastrar pet\n" + "2- Consultar pet\n" + "3- Editar pet\n"
					+ "4- Deletar pet\n" + "5- Listar todos os pets" + "\n0- Sair\n");

			if (opcao.length() != 1) {
				Console.printPrompt("\nA opção deve conter apenas um dígito.\n");
				continue;
			}

			if (opcao.charAt(0) < 48 || opcao.charAt(0) > 53) {
				Console.printPrompt("\nA opção deve conter apenas um dígito de 0 a 5.\n");
				continue;
			}

			if (opcao.equals("0"))
				break;

			switch (opcao) {
			case "1":
				try {
					Pet pet;
					do {
						pet = informarPet();
						if (pet != null) {
							Negocio.cadastrarPet(pet);
							break;
						}
					} while (true);
					Console.printPrompt("\nPET CADASTRADO.\n");
				} catch (Exception exception) {
					Console.printPrompt("\n" + exception.getMessage());
				}
				break;
			case "2":
				try {
					Integer codigo;
					do {
						codigo = receberCodigo("consultar");
						if (codigo != -1) {
							Pet pet = Negocio.consultarPet(codigo);
							Console.printPrompt("\n Código: " + pet.getCodigo() + "\n");
							Console.printPrompt("Nome: " + pet.getNome() + "\n");
							Console.printPrompt("CPF do Dono: " + pet.getCpfDono() + "\n");
							Console.printPrompt("Telefone do Dono: " + pet.getTelDono() + "\n");
							break;
						} else { 
							Console.printPrompt("\nErro ao informar o código para consulta.\n");
						}
					} while (true);
				} catch (Exception exception) {
					Console.printPrompt("\n" + exception);
				}
				break;
			case "3":
				try {
					Integer codigo;
					do {
						codigo = receberCodigo("editar");
						if (codigo != -1) {
							Pet pet;
							do {
								pet = informarPet();
								if (pet != null) {
									Negocio.editarPet(codigo, pet);
									break;
								}
							} while (true);
							break;
						} else { 
							Console.printPrompt("\nErro ao informar o código para edição.\n");
						}
					} while (true);
					Console.printPrompt("\nPET EDITADO.\n");
				} catch (Exception exception) {
					Console.printPrompt("\n" + exception);
				}
				break;
			case "4":
				try {
					Integer codigo;
					do {
						codigo = receberCodigo("deletar");
						if (codigo != -1) {
							Negocio.deletarPet(codigo);
							break;
						} else { 
							Console.printPrompt("\nErro ao informar o código para exclusão.\n");
						}
					} while (true);
					Console.printPrompt("\nPET DELETADO.\n");
				} catch (Exception exception) {
					Console.printPrompt("\n" + exception);
				}
				break;
			case "5":
				try {
					ArrayList<Pet> arrayListPets = Negocio.listarPets();

					Console.printPrompt("\nEXIBIR TODOS OS PETS");
					for (Pet pet : arrayListPets) {
						Console.printPrompt("\n");
						Console.printPrompt("\nCodigo: " + pet.getCodigo());
						Console.printPrompt("\nNome: " + pet.getNome());
						Console.printPrompt("\nCPF do dono: " + pet.getCpfDono());
						Console.printPrompt("\nTelefone do dono: " + pet.getTelDono() + "\n");
					}
				} catch (Exception exception) {
					Console.printPrompt("\n" + exception);
				}
				break;
			case "0":
				break;
			default:
				continue;
			}
		} while (true);
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param void
	 * @throws void
	 * @return Pet pet
	 * 
	 * Este método valida um cadastro de pet.
	 */
	private static Pet informarPet() {
		try {
			Pet pet = new Pet();

			pet.setCodigo(Console.readInt("\nInforme o código do pet: \n"));
			if (pet.getCodigo() <= 0) {
				Console.printPrompt("\nO código informado deve ser positivo.\n");
				return null;
			}

			pet.setNome(Console.readLine("\nInforme o nome do pet: \n"));
			
			pet.setCpfDono(Console.readLine("\nInforme o CPF do dono: \n"));
			if (LtpLib.validarCPF(pet.getCpfDono()) == false) {
				Console.printPrompt("\nO CPF informado não é válido.\n");
				return null;
			}

			pet.setTelDono(Console.readLine("\nInforme o telefone do dono: \n"));

			return pet;
		} catch (Exception exception) {
			Console.printPrompt("\nErro ao cadastrar pet.\n");
			return null;
		}
	}

	/**
	 * JAVADOC
	 * @author eduardo@email.com
	 * @param String operacao
	 * @throws void
	 * @return Integer codigo
	 * 
	 * Este método valida o código de pet (inteiro, positivo e se está cadastrado) recebendo como parâmetro a operação (editar, deletar ou consultar).
	 */
	private static Integer receberCodigo(String operacao) {
		try {
			Integer codigo = 0;
			codigo = Console.readInt("\nInforme o código do pet para " + operacao + ": ");

			if (codigo <= 0) {
				Console.printPrompt("\nO código deve ser positivo e não nulo.\n");
				receberCodigo(operacao);
			} else {
				if (operacao.equals("editar") || operacao.equals("deletar")) {
					try {
						if ((Negocio.consultarPet(codigo) instanceof Pet) == true)
							return codigo;
					} catch (Exception exception) {
						Console.printPrompt("\nO código informado não está cadastrado.\n");
						receberCodigo(operacao);
					}
				}
				return codigo;
			}
		} catch (Exception exception) {
			return -1;
		}
		return -1;
	}
}
