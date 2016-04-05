package usuarios;

import exception.DadoInvalidoException;
import exception.StringInvalidaException;
import exception.UtilException;
import jogos.Jogo;
import jogos.Luta;
import jogos.Plataforma;
import jogos.Rpg;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public class Noob extends Usuario{
	
	private final double NOOB_DESCONTO = 0.90;
	private final int NOOB_BONUS = 10;
	
	public Noob(String nome, String login) throws StringInvalidaException {
		super(nome, login);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean compraJogos(Jogo jogo) throws DadoInvalidoException {
		
		UtilException.verificaObjetoNull(jogo);
		
		
		if(this.getDinheiro() >= jogo.getPreco()*NOOB_DESCONTO){
			double dinheiroAtual = this.getDinheiro() - jogo.getPreco()*NOOB_DESCONTO;//10% de desconto
			this.setDinheiro(dinheiroAtual);
			
			this.adicionaJogo(jogo);
			
			int x2pAtual = this.getX2p();
			this.setX2p(x2pAtual+(int)jogo.getPreco()*NOOB_BONUS);//X2P DA COMPRA
			
			return true;
		}//fecha if
		
		return false;
		
	}//fecha compraJogos
	
	public String toString(){
		
		String mensagem = "Jogador Noob: "+this.getLogin()+"\n";
		
		mensagem += this.getNome() + " - "+this.getX2p()+" x2p\n";
		
		for(Jogo jogo : this.getJogosComprados()){
			mensagem += jogo;
		}//fecha for
			
			mensagem += "Total de preço dos jogos: R$ "+this.getPrecoTotal()+"\n";
		
		return mensagem;
	}//fecha toString
	
	
	


}//fecha class