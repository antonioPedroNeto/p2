package usuariosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.NumeroInvalidoException;
import exception.StringInvalidaException;
import jogos.Jogo;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;

public class NoobTest {

	@Test
	public void testAdicionaDinheiro() {		
		try {
			Usuario nb = new Noob("Alfredo", "Ras Al Ghul");
			assertEquals(0, nb.getDinheiro(), 0.00);
			assertEquals(true, nb.adicionaDinheiro(1000));
			
			assertEquals(1000, nb.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			nb.adicionaJogo(jogo1);
			
			assertEquals(jogo1, nb.contemJogo("ragnarok"));
			
			assertEquals(false, nb.compraJogos(jogo1));
			
			assertEquals(true, nb.adicionaDinheiro(1000));
			
			assertEquals(true, nb.compraJogos(jogo1));
			
			assertEquals(200, nb.getDinheiro(), 0.00);
			
			Usuario noobMaster = new Noob("Larissa", "Taina Menina da Selva");
			
			assertEquals(0, noobMaster.getDinheiro(), 0.00);
			
			assertEquals(true, noobMaster.adicionaDinheiro(3000));
			
			assertEquals(200, nb.getDinheiro(), 0.00);
			
			assertEquals(3000, noobMaster.getDinheiro(), 0.00);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch
	
	}

	@Test
	public void testCompraJogos() {
		try {
			Usuario nb = new Noob("Pedro", "Ras Al Ghul");
			assertEquals(0, nb.getDinheiro(), 0.00);
			nb.adicionaDinheiro(1000);
			
			assertEquals(1000, nb.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			nb.adicionaJogo(jogo1);
			
			assertEquals(jogo1, nb.contemJogo("ragnarok"));
			
			assertEquals(false, nb.compraJogos(jogo1));
			
			assertEquals(true, nb.adicionaDinheiro(1000));
			
			assertEquals(true, nb.compraJogos(jogo1));//noob comprando o jogo ja com o desconto
			
			assertEquals(200, nb.getDinheiro(), 0.00);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch			
	}

	@Test
	public void testContemJogo() {
		try {
			Usuario nb = new Noob("Pedro", "Ras Al Ghul");
			assertEquals(0, nb.getDinheiro(), 0.00);
			assertEquals(true, nb.adicionaDinheiro(1000));
			
			assertEquals(1000, nb.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			nb.adicionaJogo(jogo1);
			
			assertEquals(jogo1, nb.contemJogo("ragnarok"));		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch	
	}
	@Test
	public void testX2p(){
		try {
			Usuario nb = new Noob("Pedro", "Ras Al Ghul");
			assertEquals(0, nb.getDinheiro(), 0.00);
			assertEquals(true, nb.adicionaDinheiro(3000));
			
			assertEquals(3000, nb.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 75);
			
			nb.adicionaJogo(jogo1);
			
			assertEquals(jogo1, nb.contemJogo("ragnarok"));		
			
			assertEquals(true, nb.compraJogos(jogo1));
			
			assertEquals(750, nb.getX2p(), 0.00);
			
			assertEquals(true, nb.compraJogos(jogo1));
			
			assertEquals(1500, nb.getX2p(), 0.00);
			
			assertEquals(true, nb.registraJogada("ragnarok", 1000, true));
			
			
			assertEquals(1510, nb.getX2p(), 0.00);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch	
	}
	
	@Test
	public void testToString(){
		try{
			
		
		Usuario user1 = new Noob("Antonio Pedro","Antonio3Pedro");
		
		
		Jogo novo = new Rpg("ragnarok", 100);
		Jogo novo2 = new Rpg("WoE", 25);
		
		
		user1.adicionaJogo(novo);
		user1.adicionaJogo(novo2);
		
		//System.out.println(user1);

		//System.out.println(novo.getClass().getSimpleName());//USAR ISSO<<<<<<<<<<<<<
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}//fecha toString
	
	@Test
	public void testAdicionaDinheiroNegativo(){
		try {
			Usuario pedro = new Noob("pedro", "Pedro.123");
			
			pedro.adicionaDinheiro(-100);
			
		} catch (StringInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (NumeroInvalidoException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCriaUsuarioSemLogin(){
	
		try{
			Noob nb = new Noob("pedro", "");
			
		}catch(StringInvalidaException e){
			System.out.println(e.getMessage());
		}//fecha try-Catch
	}
}
