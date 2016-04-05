package usuariosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import jogos.Jogo;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;
import usuarios.Veterano;

public class VeteranoTest {


	@Test
	public void testAdicionaDinheiro() {		
		try {
			Usuario vt = new Veterano("Alfredo", "Ras Al Ghul");
			assertEquals(0, vt.getDinheiro(), 0.00);
			assertEquals(true, vt.adicionaDinheiro(1000));
			
			assertEquals(1000, vt.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			vt.adicionaJogo(jogo1);
			
			assertEquals(jogo1, vt.contemJogo("ragnarok"));
			
			assertEquals(false, vt.compraJogos(jogo1));
			
			assertEquals(true, vt.adicionaDinheiro(1000));
			
			assertEquals(true, vt.compraJogos(jogo1));
			
			assertEquals(400, vt.getDinheiro(), 0.00);
			
			Usuario veteranoMaster = new Veterano("Larissa", "Taina Menina da Selva");
			
			assertEquals(0, veteranoMaster.getDinheiro(), 0.00);
			
			assertEquals(true, veteranoMaster.adicionaDinheiro(3000));
			
			assertEquals(400, vt.getDinheiro(), 0.00);
			
			assertEquals(3000, veteranoMaster.getDinheiro(), 0.00);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch
	
	}

	@Test
	public void testCompraJogos() {
		try {
			Usuario vt = new Veterano("Pedro", "Ras Al Ghul");
			assertEquals(0, vt.getDinheiro(), 0.00);
			vt.adicionaDinheiro(1000);
			
			assertEquals(1000, vt.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			vt.adicionaJogo(jogo1);
			
			assertEquals(jogo1, vt.contemJogo("ragnarok"));
			
			assertEquals(false, vt.compraJogos(jogo1));
			
			assertEquals(true, vt.adicionaDinheiro(1000));
			
			assertEquals(true, vt.compraJogos(jogo1));//noob comprando o jogo ja com o desconto
			
			assertEquals(400, vt.getDinheiro(), 0.00);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch			
	}

	@Test
	public void testContemJogo() {
		try {
			Usuario vt = new Veterano("Pedro", "Ras Al Ghul");
			assertEquals(0, vt.getDinheiro(), 0.00);
			assertEquals(true, vt.adicionaDinheiro(1000));
			
			assertEquals(1000, vt.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 2000);
			
			vt.adicionaJogo(jogo1);
			
			assertEquals(jogo1, vt.contemJogo("ragnarok"));		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch	
	}
	@Test
	public void testX2p(){
		try {
			Usuario vt = new Veterano("Pedro", "Ras Al Ghul");
			assertEquals(0, vt.getDinheiro(), 0.00);
			assertEquals(true, vt.adicionaDinheiro(3000));
			
			assertEquals(3000, vt.getDinheiro(), 0.00);
			
			Jogo jogo1 = new Rpg("ragnarok", 75);
			
			vt.adicionaJogo(jogo1);
			
			assertEquals(jogo1, vt.contemJogo("ragnarok"));		
			
			assertEquals(true, vt.compraJogos(jogo1));
			
			assertEquals(1125, vt.getX2p(), 0.00);
			
			assertEquals(true, vt.compraJogos(jogo1));
			
			assertEquals(2250, vt.getX2p(), 0.00);
			
			assertEquals(true, vt.registraJogada("ragnarok", 1000, true));
			
			
			assertEquals(2260, vt.getX2p(), 0.00);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha catch	
	}
	
	@Test
	public void testToString(){
		
		try{
			Usuario user1 = new Veterano("Antonio Pedro","Antonio3Pedro");
			
			
			Jogo novo = new Rpg("ragnarok", 100);
			Jogo novo2 = new Rpg("WoE", 25);
			
			
			user1.adicionaJogo(novo);
			user1.adicionaJogo(novo2);
			
			System.out.println(user1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//fecha toString
	
}
