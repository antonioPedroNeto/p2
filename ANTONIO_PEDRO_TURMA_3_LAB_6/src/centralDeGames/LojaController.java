package centralDeGames;


import java.util.ArrayList;
import java.util.HashSet;

import exception.DadoInvalidoException;
import exception.NumeroInvalidoException;
import exception.StringInvalidaException;
import exception.UtilException;
import factories.FactoryDeJogos;
import factories.FactoryDeUsuarios;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public class LojaController {

	private ArrayList<Usuario> usuarios;
	private FactoryDeUsuarios usuarioFactory;
	private FactoryDeJogos jogosFactory;
	
	public LojaController(){
		usuarios = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	
	/**
	 * Metodo que adiciona dinheiro na conta de um usuario
	 * @param loginUsuario - login do usuario
	 * @param dinheiro - quantidade de dinheiro para adicionar
	 * @return - retorna um boolean true para dinheiro adicionado com sucesso e false para nao adicionado
	 * @throws Exception - pode lan�ar uma exeception caso o usuario nao esteja na lista de usuarios
	 */
	public boolean adicionaDinheiro(String loginUsuario, double dinheiro) {
		int indice = contemUsuario(loginUsuario);
		if(indice == -1){
			return false;
		}//fecha if
		
		Usuario usuarioAtual = usuarios.get(indice);
		 
		try {
			usuarioAtual.adicionaDinheiro(dinheiro);
		} catch (NumeroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		return true;
		
	}//fecha adicionaDinheiro
	
	
	/**
	 * Metodo que adiciona um usuario na lista de usuarios
	 * @param nome - nome do usuario
	 * @param login - login do usuario
	 * @param tipo - tipo do usuario
	 * @return - retorna um boolean true para adicionado com sucesso ou false para nao adicionado
	 * @throws StringInvalidaException 
	 */
	public boolean adicionaUsuarios(String nome, String login, String tipo) throws StringInvalidaException{
		
		Usuario usuario = criaUsuarios(nome, login, tipo);
		
		if(contemUsuario(usuario.getLogin()) != -1){
			return false;
		}//fecha if
		
		usuarios.add(usuario);
		return true;
		
	}//fecha adicionaUsuarios
	/**
	 * Metodo que vende jogos para os usuarios
	 * @param loginUsuario - login do usuario
	 * @param nomeJogo - nome do jogo
	 * @param precoJogo - preco do jogo
	 * @param tipoJogo - tipo do jogo
	 * @return - retorna um boolean true para adicionado ou false para nao adicionado
	 * @throws DadoInvalidoException - pode lancar uma exception caso um dado seja invalido
	 */
	public boolean vendeJogos(String loginUsuario, String nomeJogo, double precoJogo, String tipoJogo, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		
		int indice = contemUsuario(loginUsuario);
		if(indice == -1){
			return false;
		}//fecha if
		
		usuarios.get(indice).adicionaJogo(criaJogo(nomeJogo, precoJogo, tipoJogo, estilo));
		
		return true;
	}//fecha vendeJogos
	
	
	/**
	 * Metodo que busca por um usuario na lista de usuarios
	 * @param loginUsuario - login do usuario
	 * @return - retorna o indice respectivo do usuario ou -1 para nao achou o usuario
	 */
	public int contemUsuario(String loginUsuario){
		
		for(int i = 0; i < usuarios.size(); i++){
			
			if(usuarios.get(i).getLogin().equals(loginUsuario)){
				return i;
			}//fecha if
			
		}//fecha for
		
		return -1;		
	}//fecha pesquisaUsuario

	/**
	 * Metodo que realiza um upgrade em um determinado usuario
	 * @param login - login do usuario
	 * @return retora true para sucesso no upgrade ou false para falha no upgrade
	 * @throws Exception - pode lancar uma exception caso o usuario nao tenha x2p suficiente ou na seja veterano
	 */
	public boolean upgrade (String login){
		
		int indice = contemUsuario(login);// verificacao se o usuario existe
		
		if(indice == -1){
			return false;
		}//fecha if

		Usuario usuarioUp = usuarios.get(indice); // a referencia usuarioUp aponta para um objeto usuario
		try{
			
			if(usuarioUp instanceof Veterano){
				throw new Exception("O usuario ja e um veterano");
			}//fecha if
		
			if(usuarioUp instanceof Noob){
				usuarioUp = this.upgradeNoob(usuarioUp);
				UtilException.verificaObjetoNull(usuarioUp);
			}//fecha if
			
		}catch(DadoInvalidoException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}//fecha catch
		
		usuarios.remove(indice);//remove o usuario antigo da lista
		
		usuarios.add(usuarioUp);//adiciona o usuario novo na lista
		
		return true;
	}//fecha upgrade
	
	/**
	 * Meotodo que realiza o upgrade de noob
	 * @param usuarioUp
	 * @return
	 * @throws Exception
	 */
	private Usuario upgradeNoob(Usuario usuarioUp) {
		try{	
			if(usuarioUp.getX2p() > 1000){
				Usuario usuarioUpgrade = new Veterano(usuarioUp.getNome(), usuarioUp.getLogin()); //cria um novo usuario do tipo veterano
				
				usuarioUpgrade.setDinheiro(usuarioUp.getDinheiro());//adiciona o dinheiro antigo no novo usuario
				usuarioUpgrade.setX2p(usuarioUp.getX2p()); //adiciona a x2p antiga no novo usuario
		
				//adicionando os jogos
				
				HashSet<Jogo> meusJogos = usuarioUp.getJogosComprados();//pega todos os jogos do usuario antigo
				
				for(Jogo jogo : meusJogos){
					usuarioUpgrade.adicionaJogo(jogo); //adiciona cada jogo no novo usuario
				}//fecha for
				
				return usuarioUpgrade;
			}//fecha if
			

			throw new NumeroInvalidoException("Nao possui pontos suficientes");
		}catch(DadoInvalidoException e){
			System.out.println(e.getMessage());
			return null;
		}//fecha catch
	}//fecha upgradeNoob
	
	
	/**
	 * Metodo que mostra na tela as informacoes dos usuarios existentes na Fachada.
	 */
	public String listaUsuarios(){
		String mensagem = "=== Central P2CG ===\n";
		
		for(int i = 0; i < usuarios.size(); i++){
			
			mensagem += usuarios.get(i)+"\n";
			
			
		}//fecha for
		
		mensagem +="----------------------------";
		
		return mensagem;
		
	}//fecha listaUsuarios
	/**
	 * Metodo que retorna um usuario criado pela fabrica de usuarios(FactoryDeUsuarios)
	 * @param nome - nome do usuario
	 * @param login - login do usuario
	 * @param tipo - tipo do usuario
	 * @return retorna uma referencia Usuario do usuario criado
	 * @throws StringInvalidaException - pode lancar uma exception caso alguma das strings passadas seja invalida
	 */
	public Usuario criaUsuarios(String nome, String login, String tipo) throws StringInvalidaException{
		
		return usuarioFactory.criaUsuario(nome, login, tipo);
		
	}//fecha criaUsuarios
	
	/**
	 * Metodo que retorna um jogo criado pela fabrica de jogos(FactoryDeJogos)
	 * @param nome - nome do jogo
	 * @param preco - preco do jogo
	 * @param tipo - tipo do jogo
	 * @param estilo - estilo do jogo
	 * @return - retorna uma referencia Jogo de um jogo do tipo especificado
	 * @throws DadoInvalidoException - pode lanca uma exception caso um dado seja invalido
	 */
	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		
		return jogosFactory.criaJogo(nome, preco, tipo, estilo);
				
	}//fecha criaJogo
	
}//fecha class
