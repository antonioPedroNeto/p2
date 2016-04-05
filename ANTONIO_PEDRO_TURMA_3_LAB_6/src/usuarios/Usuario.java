package usuarios;


import java.util.HashSet;

import exception.DadoInvalidoException;
import exception.NumeroInvalidoException;
import exception.StringInvalidaException;
import exception.UtilException;
import jogos.Jogo;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public abstract class Usuario {

	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double dinheiro;
	private int x2p;
	private final int DINHEIRO_MINIMO = 0;
	
	public Usuario(String nome, String login) throws StringInvalidaException{
		UtilException.verificaNome(nome);
		UtilException.verificaLogin(login);
		this.nome = nome;
		this.login = login;
		jogosComprados = new HashSet<Jogo>();
		this.dinheiro = 0;
		this.x2p = 0;
	}//fecha construtor

	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws StringInvalidaException {
		UtilException.verificaNome(nome);
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) throws StringInvalidaException{
		UtilException.verificaLogin(login);
		this.login = login;
	}

	public HashSet<Jogo> getJogosComprados() {
		return this.jogosComprados;
	}
	/**
	 * Metodo que adiciona jogo no array de jogos comprados
	 * @param jogo - objeto jogo
	 * @return retorna true para adicionado ou false para nao adicionado
	 */
	public boolean adicionaJogo(Jogo jogo) throws DadoInvalidoException{
		UtilException.verificaObjetoNull(jogo);
		return this.jogosComprados.add(jogo);
	}

	public double getDinheiro() {
		return this.dinheiro;
	}

	public void setDinheiro(double dinheiro) throws NumeroInvalidoException{
		UtilException.verificaDinheiro(dinheiro);
		this.dinheiro = dinheiro;
	}
	
	public int getX2p(){
		return this.x2p;
	}
	
	public void setX2p(int x2p) throws NumeroInvalidoException{
		UtilException.verificaX2P(x2p);
		this.x2p = x2p;
	}
	
	
	
	/**
	 * Metodo que realiza uma jogada para o usuario 
	 * @param nomeDoJogo - nome do jogo
	 * @param score - pontuacao do jogo
	 * @param zerou - se zerou o jogo
	 * @return - true para adicionado
	 * @throws Exception
	 */
	public boolean recompensar(String nomeDoJogo, int score, boolean zerou) throws DadoInvalidoException {
		Jogo jogoAtual = contemJogo(nomeDoJogo);
		int x2p = jogoAtual.registraJogada(score, zerou);
		
		
		
		setX2p(getX2p() + x2p);
		return true;
	}//fecha registraJogada
	
	/**
	 * Metodo que adiciona dinheiro a conta do usuario
	 * @param dinheiro - dinheiro que o usuario quer adicionar
	 * @return - true para adicionado
	 * @throws Exception - lanca exception caso o dinheiro seja menor que 0
	 */
	public boolean adicionaDinheiro(double dinheiro) throws NumeroInvalidoException {
		
		UtilException.verificaDinheiro(dinheiro);
		
		double dinheiroAtual = this.getDinheiro() + dinheiro;
		
		this.setDinheiro(dinheiroAtual);
		
		return true;
	}//fecha adicionaDinheiro
	
	/**
	 * Metodo que comprar jogos
	 * @param nome - Nome do jogo a comprar
	 * @return - true para jogo comprado ou false para jogo nao comprado
	 * @throws Exception - pode lancar exception caso jogo nao exista
	 */
	public abstract boolean compraJogos(Jogo jogo) throws DadoInvalidoException;
	
	/**
	 * Metodo que busca no arrayList de jogos por um jogo especifico
	 * @param nome - nome do jogo
	 * @return - retorna um jogo caso encontrado
	 * @throws Exception - lanca exception caso nao encontre o jogo
	 */
	public Jogo contemJogo(String nome) throws DadoInvalidoException {

		for(Jogo jogo : jogosComprados){
			if(jogo.getNome().equals(nome)){
				return jogo;
			}//fecha if
		}//fecha for

		throw new DadoInvalidoException("O jogo nao existe nas minhas compras");
	}//fecha contemJogo	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
	public double getPrecoTotal(){
		double precoTotal = 0;
		for(Jogo jogo : jogosComprados){
			
			precoTotal += jogo.getPreco();
			
		}//fecha for
		
		return precoTotal;
	}//fecha getPrecoTotal
	
}//fecha class