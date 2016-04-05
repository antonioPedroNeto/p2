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
public class Plataforma extends Jogo{

	private final int BONUS_PLATAFORMA = 20;
	
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws DadoInvalidoException {
		super(nome, preco, jogabilidade);
		// TODO Auto-generated constructor stub
	}//fecha construtor

	@Override
	public int registraJogada(int pontuacao, boolean zerado) throws DadoInvalidoException {
		
		UtilException.verificaPontuacaoMinima(pontuacao);
		
		int x2p = super.registraJogada(pontuacao, zerado);
		
		if(zerado){
			x2p += BONUS_PLATAFORMA; 
		}//fecha if
		
		return x2p;
		
	}//fecha registraJogada
	

	public String toString(){
		
		String mensagem = "+ ";
		
		mensagem += this.getNome() +" - Plataforma:\n";
		mensagem += "==> Jogou "+this.getQuantidadeJogada()+" vez(es)\n";
		mensagem += "==> Zerou "+this.getZeradas()+" vez(es)\n";
		mensagem += "==> Maior score: "+this.getPontuacao()+"\n\n";
		
		return mensagem;
		
	}//fecha toString
	
}//fecha class
	

	
