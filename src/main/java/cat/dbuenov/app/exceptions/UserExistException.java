package cat.dbuenov.app.exceptions;

public class UserExistException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserExistException(String name) {
		super("El usuario"+name+" ya existe");
	}
}
