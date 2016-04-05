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
public class Veterano extends Usuario{
	
	private final double VETERANO_DESCONTO = 0.80;
	private final int VETERANO_BONUS = 15;
	
	public Veterano(String nome, String login) throws StringInvalidaException {
		super(nome, login);
		// TODO Auto-generated constructor stub
	}//fecha construtor

	
	@Override
	public boolean compraJogos(Jogo jogo) throws DadoInvalidoException {
		
		UtilException.verificaObjetoNull(jogo);
		
		if(this.getDinheiro() > jogo.getPreco()*VETERANO_DESCONTO){
			double dinheiroAtual = this.getDinheiro() - jogo.getPreco()*VETERANO_DESCONTO;//20% de desconto
			this.setDinheiro(dinheiroAtual);//retira o dinheiro gastado no jogo
			
			this.getJogosComprados().add(jogo);//adiciona a lista de comprados o jogo comprado
			
			int x2pAtual = this.getX2p();//pega a x2p atual
			this.setX2p(x2pAtual + (int)jogo.getPreco()*VETERANO_BONUS);//adiciona x2p para o usuario
			
			return true;
		}//fecha if
		
		return false;
		
	}//fecha compraJogos
	
	public String toString(){
		
		String mensagem = "Jogador Veterado"+this.getLogin()+"\n";
		
		mensagem += this.getNome() + " - "+this.getX2p()+" x2p\n";
		
		for(Jogo jogo : this.getJogosComprados()){
			mensagem += jogo;
		}//fecha for
		
		mensagem += "Total de preço dos jogos: R$ "+this.getPrecoTotal()+"\n";
		
		return mensagem;
	}//fecha toString
	
}//fecha class