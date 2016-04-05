package factories;

import java.util.HashSet;

import centralDeGames.Jogabilidade;
import exception.DadoInvalidoException;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;

public class FactoryDeJogos {

	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		if(tipo.equals("Rpg")){
			return criaJogoRPG(nome, preco, estilo);
		}else if(tipo.equals("Luta")){
			return criaJogoLuta(nome, preco, estilo);
		}else{
			return criaJogoPlataforma(nome, preco, estilo);
		}//fecha else
	}//fecha criaJogo
	
	/**
	 * Metodo que cria um objeto RPG
	 * @param nome - nome do jogo
	 * @param preco - preco do jogo
	 * @param estilo - estilo do jogo
	 * @return - retorna uma referencia Jogo que aponta para um objeto RPG
	 * @throws DadoInvalidoException - pode lancar uma exception caso um dado seja unvalido
	 */
	public Jogo criaJogoRPG(String nome, double preco, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		return new Rpg(nome, preco, estilo);
	}//fecha criaJogoRPG
	
	/**
	 * Metodo que cria um objeto Luta
	 * @param nome - nome do jogo
	 * @param preco - preco do jogo
	 * @param estilo - estilo do jogo
	 * @return - retorna uma referencia Jogo que aponta para um objeto Luta
	 * @throws DadoInvalidoException - pode lancar uma exception caso um dado seja unvalido
	 */
	public Jogo criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		return new Luta(nome, preco, estilo);
	}//fecha criaJogoLuta
	
	/**
	 * Metodo que cria um objeto Plataforma
	 * @param nome - nome do jogo
	 * @param preco - preco do jogo
	 * @param estilo - estilo do jogo
	 * @return - retorna uma referencia Jogo que aponta para um objeto Plataforma
	 * @throws DadoInvalidoException - pode lancar uma exception caso um dado seja unvalido
	 */
	public Jogo criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> estilo) throws DadoInvalidoException{
		return new Plataforma(nome, preco, estilo);
	}//fecha criaJogoPlataforma
	
}//fecha class
