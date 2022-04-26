package cat.dbuenov.app.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String id) {
		super("No he encontrado el usuario con la id: "+id);
	}
}
