package centralDeGames;

import java.util.HashSet;

import exception.DadoInvalidoException;
import exception.NumeroInvalidoException;
import exception.StringInvalidaException;
import exception.UtilException;
import jogos.Jogo;
import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;

public class LojaFacade {
	private LojaController loja;
	
	/**
	 * Metodo que adiciona dinheiro na conta de um usuario
	 * @param loginUsuario - login do usuario
	 * @param dinheiro - quantidade de dinheiro para adicionar
	 * @return - retorna um boolean true para dinheiro adicionado com sucesso e false para nao adicionado
	 * @throws Exception - pode lan�ar uma exeception caso o usuario nao esteja na lista de usuarios
	 */
	public boolean adicionaDinheiro(String loginUsuario, double dinheiro) {

		return loja.adicionaDinheiro(loginUsuario, dinheiro);
		
	}//fecha adicionaDinheiro
	
	public boolean adicionaUsuarios(String nome, String login, String tipo) throws StringInvalidaException{
		
		return loja.adicionaUsuarios(nome, login, tipo);
		
	}//fecha adicionaUsuarios
	
	
	public boolean vendeJogos(String loginUsuario, String nomeJogo, double precoJogo, String tipoJogo, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		
		return loja.vendeJogos(loginUsuario, nomeJogo, precoJogo, tipoJogo, estilo);
		
	}//fecha vendeJogos
	
	public int contemUsuario(String loginUsuario){
		
		return loja.contemUsuario(loginUsuario);
		
	}//fecha pesquisaUsuario

	public boolean upgrade (String login){
		
		return loja.upgrade(login);
		
	}//fecha upgrade
	
	
	public String listaUsuarios(){
		
		return loja.listaUsuarios();
		
	}//fecha listaUsuarios

	public Usuario criaUsuarios(String nome, String login, String tipo) throws StringInvalidaException{
		
		return loja.criaUsuarios(nome, login, tipo);
		
	}//fecha criaUsuarios
	

	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		
		return loja.criaJogo(nome, preco, tipo, estilo);
		
	}//fecha criaJogo
}
