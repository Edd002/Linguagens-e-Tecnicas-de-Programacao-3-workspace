package controller;

public class BizException extends Exception {
	private static final long serialVersionUID = 1L;

	public BizException(String mensagem) {
		super(mensagem);
	}
}