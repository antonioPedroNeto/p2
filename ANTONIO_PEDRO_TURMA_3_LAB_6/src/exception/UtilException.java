package exception;
/* Matricula: 115111271 
 * Nome Completo: Antonio Pedro de Abreu Neto
 * LAB 06
 * Turma 03
 * */
public class UtilException {

	
	public static void verificaObjetoNull(Object objeto) throws DadoInvalidoException{
		if(objeto == null){
			throw new DadoInvalidoException("O objeto passado nao pode ser");
		}
	}
	
	public static void verificaNome(String nome) throws StringInvalidaException {

		if(nome == null | nome.trim().isEmpty()){
			throw new StringInvalidaException("Nome informado nao pode ser vazio");
		}//fecha if
		
	}//fecha verificaNome
	
	public static void verificaLogin(String login)throws StringInvalidaException{
		
		if(login == null | login.trim().isEmpty()){
			throw new StringInvalidaException("Login informado nao pode ser vazio");
		}//fecha if
		
	}//fecha verificaLogin
	
	
	
	public static void verificaPreco(double preco) throws NumeroInvalidoException{
		
		if(preco < 0){
			throw new NumeroInvalidoException("O preco nao pode ser negativo");	
		}//fecha if
		
	}//fecha verificaPreco
	
	
	public static void verificaPontuacaoMinima(int pontuacao) throws NumeroInvalidoException {
		
		if(pontuacao < 0){
			throw new NumeroInvalidoException("A pontuacao nao pode ser negativa");			
		}//fecha if
		
	}//fecha verificaPontuacao
	
	public static void verificaPontuacaoMaxima(int pontuacao) throws NumeroInvalidoException {
		
		if(pontuacao > 100000){
			throw new NumeroInvalidoException("A pontuacao nao pode passar a pontuacao maxima de 100000");			
		}//fecha if
		
	}//fecha verificaPontuacao
	
	
	public static void verificaQuantidadeJogada(int quantidade) throws NumeroInvalidoException{
		
		if(quantidade < 0){
			throw new NumeroInvalidoException("A quantidade de vezes que um jogo é jogado nao pode ser negativo");	
		}//fecha if
		
	}//fecha verificaPreco
		
	public static void verificaDinheiro(double dinheiro) throws NumeroInvalidoException{
		
		if(dinheiro < 0){
			throw new NumeroInvalidoException("A quantidade de dinheiro nao pode ser menor que zero");
		}//fecha if
		
	}//fecha verificaDinheiro
	
	public static void verificaX2P(int x2p) throws NumeroInvalidoException{
		
		if(x2p < 0){
			throw new NumeroInvalidoException("O valor de x2p nao pode ser negativo");	
		}//fecha if
		
	}//fecha verificaX2P
	
	
}//fecha class
