package factories;

import exception.StringInvalidaException;
import usuarios.Noob;
import usuarios.Usuario;

public class FactoryDeUsuarios {
	
	
	public Usuario criaUsuario(String nome, String login, String tipo) throws StringInvalidaException{
		
		return new Noob(nome, login);
		
	}//fecha criaUsuario

}//fecha class
