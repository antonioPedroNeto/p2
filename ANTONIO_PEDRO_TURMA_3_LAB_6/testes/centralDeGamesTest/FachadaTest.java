package centralDeGamesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import centralDeGames.LojaController;
import exception.DadoInvalidoException;
import jogos.Jogo;
import jogos.Rpg;
import usuarios.Noob;
import usuarios.Usuario;

public class FachadaTest {
	
	@Test
	public void testFachada() {
		try{
		LojaController lojaDaEsquina = new LojaController();
		
		Usuario ramela = new Noob("Ramela", "Ramelinha");
		Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
		
		assertEquals(true, lojaDaEsquina.adicionaUsuarios(ramela));
		assertEquals(true, lojaDaEsquina.adicionaUsuarios(rasAlGhul));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testAdicionaDinheiro() {
		
		try {
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("Ramelinha", 1));
			
			assertEquals(1, ramela.getDinheiro(), 0.00);
			
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("rasAlGhul", 1000));

			assertEquals(1000, rasAlGhul.getDinheiro(), 0.00);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAdicionaUsuarios() {
		
		try{
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			assertEquals(0, lojaDaEsquina.contemUsuario("Ramelinha"));

			assertEquals(-1, lojaDaEsquina.contemUsuario("R"));

			assertEquals(1, lojaDaEsquina.contemUsuario("rasAlGhul"));	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testVendeJogos() {
		try {
			
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			Jogo rag = new Rpg("ragnarok", 1000);
			assertEquals(false, lojaDaEsquina.vendeJogos("Ramelinha", "ragnarok"));
			
			ramela.adicionaDinheiro(2000);
			
			lojaDaEsquina.adicionaJogoLoja(rag);
			
			assertEquals(true, lojaDaEsquina.vendeJogos("Ramelinha", "ragnarok"));
			
			assertEquals(true, lojaDaEsquina.vendeJogos("Ramelinha", "ragnarok"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//fecha trycatch
	
	}

	@Test
	public void testContemUsuario() {

	}

	@Test
	public void testUpgrade() {		
		try {
			
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			
			Jogo rag = new Rpg("ragnarok", 1000);
			Jogo dota = new Rpg("Dota", 1000);
			Jogo lol = new Rpg("lol", 1000);
			//Jogo no = new Rpg("nao", 1000);

			
			ramela.adicionaJogo(rag);
			ramela.adicionaJogo(dota);
			ramela.adicionaJogo(lol);

			
			ramela.setX2p(2300);
			ramela.adicionaDinheiro(1000);
			assertEquals(rag, ramela.contemJogo("ragnarok"));
			assertEquals(dota, ramela.contemJogo("Dota"));
			assertEquals(lol, ramela.contemJogo("lol"));
			assertEquals(1000, ramela.getDinheiro(), 0.00);
			assertEquals(2300, ramela.getX2p());
			assertEquals("Noob", ramela.getClass().getSimpleName());
			
			assertEquals(true, lojaDaEsquina.upgrade("Ramelinha"));
			
			ArrayList<Usuario> meusUsuarios = lojaDaEsquina.getUsuarios();
			
			assertEquals("Ramela", meusUsuarios.get(1).getNome());
			assertEquals("Veterano", meusUsuarios.get(1).getClass().getSimpleName());
			assertEquals(1000, meusUsuarios.get(1).getDinheiro(), 0.00);
			assertEquals(2300, meusUsuarios.get(1).getX2p());
			assertEquals("Ramelinha", meusUsuarios.get(1).getLogin());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testMostraUsuarios(){		
		try {
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			
			Jogo rag = new Rpg("ragnarok", 200);
			Jogo dota = new Rpg("Dota", 1000);
			Jogo lol = new Rpg("lol", 1000);
			//Jogo no = new Rpg("nao", 1000);

			assertEquals(true, lojaDaEsquina.adicionaJogoLoja(rag));
			assertEquals(true, lojaDaEsquina.adicionaJogoLoja(lol));
			assertEquals(true, lojaDaEsquina.adicionaJogoLoja(dota));
			assertEquals(false, lojaDaEsquina.adicionaJogoLoja(rag));
			
			
			assertEquals(0, lojaDaEsquina.contemJogoEmLoja("ragnarok"));
			
			
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("Ramelinha", 1900));
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("rasAlGhul", 1900));

			
			assertEquals(true, lojaDaEsquina.vendeJogos("Ramelinha", "ragnarok"));
			assertEquals(true, lojaDaEsquina.vendeJogos("rasAlGhul", "Dota"));
			
			assertEquals(true, lojaDaEsquina.vendeJogos("Ramelinha", "Dota"));

			ArrayList<Usuario> meusUsuarios = lojaDaEsquina.getUsuarios();
			
			assertEquals(true, meusUsuarios.get(0).registraJogada("ragnarok", 100, false));
			
			assertEquals(true, meusUsuarios.get(0).registraJogada("Dota", 1000, true));
			
			assertEquals(true, lojaDaEsquina.vendeJogos("rasAlGhul", "ragnarok"));
			
			assertEquals(true, meusUsuarios.get(1).registraJogada("ragnarok", 1000, true));
			
			//System.out.println(lojaDaEsquina.listaUsuarios());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testVendeJogosParametros(){
		try{
			LojaController lojaDaEsquina = new LojaController();
			
			Usuario ramela = new Noob("Ramela", "Ramelinha");
			Usuario rasAlGhul = new Noob("rasAlGhul", "rasAlGhul");
			
			lojaDaEsquina.adicionaUsuarios(ramela);
			lojaDaEsquina.adicionaUsuarios(rasAlGhul);
			
			rasAlGhul.setX2p(3000);
			
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("Ramelinha", 2000));
			assertEquals(true, lojaDaEsquina.adicionaDinheiro("rasAlGhul", 3000));
			
			assertEquals(true, lojaDaEsquina.vendeJogos("Ramelinha", "ragnarok", 400, "Rpg"));
			assertEquals(true, lojaDaEsquina.vendeJogos("rasAlGhul", "ragnarok", 400, "Rpg"));
			
			ramela.registraJogada("ragnarok", 10, false);

			rasAlGhul.registraJogada("ragnarok", 1000, true);
			
			lojaDaEsquina.upgrade("rasAlGhul");
			
			System.out.println(lojaDaEsquina.listaUsuarios());
		}catch(DadoInvalidoException e){
			e.printStackTrace();
		}
	}

}
