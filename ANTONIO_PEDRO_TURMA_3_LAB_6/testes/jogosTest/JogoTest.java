package jogosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import jogos.Jogo;
import jogos.Luta;
import jogos.Rpg;

public class JogoTest {

	@Test
	public void testRegistraJogada() {
		try{
			Jogo jogo1 = new Rpg("Ragnarok", 100);

			assertEquals(10, jogo1.registraJogada(100, true));
			
			assertEquals(100, jogo1.getPontuacao());
			
			
			assertEquals(10, jogo1.registraJogada(10, false));
			
			assertEquals(100, jogo1.getPontuacao());
			
			assertEquals(10, jogo1.registraJogada(101, true));

			assertEquals(101, jogo1.getPontuacao());
			
			assertEquals(2, jogo1.getZeradas());
			
			assertEquals(3, jogo1.getQuantidadeJogada());
		
			Jogo jogo2 = new Rpg("Cs1.6", 200);
			
			assertEquals(10, jogo2.registraJogada(1, true));
	
			assertEquals(10, jogo2.registraJogada(100, false));
			
			assertEquals(100, jogo2.getPontuacao());
			
			assertEquals(2, jogo2.getQuantidadeJogada());
			
			Jogo luta1 = new Luta("Street Figth", 300);
			
			luta1.registraJogada(200, true);
			
			assertEquals(200, luta1.getPontuacao());
			
			assertEquals(1, luta1.getZeradas());
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}