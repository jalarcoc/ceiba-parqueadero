package dominio.excepcion;

public class ParqueoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ParqueoException(String message){
		super(message);
	}

}
