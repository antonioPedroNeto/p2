package jogos;


import java.util.HashSet;

import centralDeGames.Jogabilidade;
import exception.DadoInvalidoException;
import exception.UtilException;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public class Luta extends Jogo{

	//private final int PONTUACAO_MINIMA = 0;
	//private final int PONTUACAO_MAXIMA = 100000;
	
	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException{
		super(nome, preco, jogabilidade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registraJogada(int pontuacao, boolean zerado) throws DadoInvalidoException {		

		int x2p = 0;
		
		UtilException.verificaPontuacaoMinima(pontuacao);
		
		UtilException.verificaPontuacaoMaxima(pontuacao);
		
		if(pontuacao > super.getPontuacao()){
			x2p += pontuacao / 1000;
		}//fecha if
		
		x2p += super.registraJogada(pontuacao, zerado);

		return x2p;
		
	}//fecha registra
	
	public String toString(){
		
		String mensagem = "+ ";
		
		mensagem += this.getNome() +" - Luta:\n";
		mensagem += "==> Jogou "+this.getQuantidadeJogada()+" vez(es)\n";
		mensagem += "==> Zerou "+this.getZeradas()+" vez(es)\n";
		mensagem += "==> Maior score: "+this.getPontuacao()+"\n\n";
		
		return mensagem;
		
	}//fecha toString

}//fecha class
