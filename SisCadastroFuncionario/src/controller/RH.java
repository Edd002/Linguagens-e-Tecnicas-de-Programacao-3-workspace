package controller;

import java.util.ArrayList;

import model.Funcionario;

/**
 * @author Eduardo
 * 
 * Classe de controle de regras de neg�cio.
 */
public class RH {
	private ArrayList<Funcionario> arrayListFuncionario = new ArrayList<>();

	public ArrayList<Funcionario> getArrayListFuncionario() throws BizException {
		return arrayListFuncionario;
	}

	public void setArrayListFuncionario(ArrayList<Funcionario> arrayListFuncionario) throws BizException {
		this.arrayListFuncionario = arrayListFuncionario;
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param Funcionario funcionario
	 * @throws BizException
	 * 
	 * M�todo de cadastro de funcion�rio.
	 */
	public void cadastrarFuncionario(Funcionario funcionario) throws BizException {
		boolean adicionar = arrayListFuncionario.add(funcionario);
		if (!adicionar)
			throw new BizException("Erro ao cadastrar funcion�rio.");
	}

	/**
	 * @author Eduardo
	 * @return Funcionario
	 * @param String cpf
	 * @throws BizException
	 * 
	 * M�todo de cadastro de funcion�rio.
	 */
	public Funcionario consultarFuncionario(String cpf) throws BizException {
		for (Funcionario funcionario : arrayListFuncionario) {
			if (funcionario.getCpf().equals(cpf))
				return funcionario;
		}
		throw new BizException("Funcion�rio n�o encontrado.");
	}

	/**
	 * @author Eduardo
	 * @return void
	 * @param String cpf
	 * @throws BizException
	 * 
	 * M�todo de deletar de funcion�rio.
	 */
	public void deletarFuncionario(String cpf) throws BizException {
		Funcionario funcionario = consultarFuncionario(cpf);
		boolean deletar = arrayListFuncionario.remove(funcionario);
		if (!deletar)
			throw new BizException("Erro ao deletar funcion�rio.");
	}
}