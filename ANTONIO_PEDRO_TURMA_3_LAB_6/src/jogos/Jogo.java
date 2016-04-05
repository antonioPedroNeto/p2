package jogos;

import java.util.HashSet;

import centralDeGames.Jogabilidade;
import exception.DadoInvalidoException;
import exception.NumeroInvalidoException;
import exception.StringInvalidaException;
import exception.UtilException;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public abstract class Jogo {
	
	private String nome;
	private double preco;
	private int quantidadeJogada;
	private int pontuacao; //Maior Score
	private int zeradas;
	private HashSet<Jogabilidade> jogabilidade;
	
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException{
		UtilException.verificaNome(nome);
		UtilException.verificaPreco(preco);
		this.nome = nome;
		this.preco = preco;
		this.quantidadeJogada = 0;
		this.pontuacao = 0;
		this.zeradas = 0;
		this.jogabilidade = jogabilidade;
	}//fecha construtor
	

	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome) throws StringInvalidaException{
		UtilException.verificaNome(nome);
		this.nome = nome;
	}
	
	
	public double getPreco(){
		return this.preco;
	}
	public void setPreco(double preco) throws NumeroInvalidoException{
		UtilException.verificaPreco(preco);
		this.preco = preco;
	}
	
	
	public int getQuantidadeJogada(){
		return this.quantidadeJogada;
	}
	public void setQuantidadeJogada(int quantidadeJogada) throws NumeroInvalidoException{
		UtilException.verificaQuantidadeJogada(quantidadeJogada);
		this.quantidadeJogada = quantidadeJogada;
	}
	
	
	public int getPontuacao() {
		return this.pontuacao;
	}
	public void setPontuacao(int pontuacao) throws NumeroInvalidoException{
		UtilException.verificaPontuacaoMaxima(pontuacao);
		this.pontuacao = pontuacao;
	}

	
	public int getZeradas() {
		return this.zeradas;
	}
	public void setZeradas(int zeradas) {
		this.zeradas = zeradas;
	}

	/**
	 * Metodo que registra a pontuacao do usuario
	 * @param pontuacao - pontuacao feita pelo usuario
	 * @param zerado - se o usuario zerou true se nao false
	 * @return - retorna um int referente a pontuacao
	 * @exception - Pode lancar uma exception caso a pontuacao seja menor que 0
	 */
	public int registraJogada(int pontuacao, boolean zerado)  throws DadoInvalidoException{
		
		UtilException.verificaPontuacaoMinima(pontuacao);
		
		this.setQuantidadeJogada(this.getQuantidadeJogada() + 1);
		
		if(pontuacao > this.getPontuacao()){
			this.setPontuacao(pontuacao);
		}//Fecha if
		
		if(zerado){
			this.setZeradas(this.getZeradas() + 1);
		}//fecha if
		
		return 0;
		
	}//fecha registraJogada

	
	/**
	 * Metodo que adiciona uma jogabilidade ao jogo
	 * @param j
	 * @return
	 * @throws Exception
	 */
	public boolean adicionaJogabilidade(Jogabilidade j) throws Exception{
		
		if(j == null){
			throw new Exception("Jogabilidade nao pode ser vazia");
		}//fecha if
		
		return jogabilidade.add(j);

	}//fecha adicionaJogabilidade
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}