package br.com.engenhariadesoftware;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;

class JogoDaVelhaTest {

	JogoDaVelha jogo = new JogoDaVelha();


	@Before
	public void setUp() {
		jogo.jogar();	
	
	}

	 
	@Test
	public void testValidarJogada() {
		Assert.assertTrue(jogo.validarJogada(1, 1));
	}

	@Test
	public void testValidarJogadaPorLinhaNegativa() {
		Assert.assertTrue(jogo.validarJogada(-1, 1));
	}

	@Test
	public void testValidarJogadaPorColunaNegativa() {
		Assert.assertTrue(jogo.validarJogada(1, -1));
	}

	@Test
	public void testValidarJogadaPorLinhaGrande() {
		Assert.assertTrue(jogo.validarJogada(5, 2));
	}

	@Test
	public void testValidarJogadaPorColunaGrande() {
		Assert.assertTrue(jogo.validarJogada(2, 5));
	}

	@Test
	public void testValidarJogadaPorEspaco() {
		jogo.marcarNoTabuleiro(1, 1);
		Assert.assertTrue(jogo.validarJogada(1, 1));
	}

	@Test
	public void testMarcarNoTabuleiro() {
		assertEquals(1, jogo.jogador);

		jogo.marcarNoTabuleiro(1, 1);
		assertEquals(2, jogo.jogador);
	}

	@Test
	public void testCenarios() {
		jogo.gerarMatriz();
		Assert.assertNotNull(jogo);
	}
	
	@Test
	public void testIniciarJogadas() {
		jogo.iniciarJogadas();
		String entrada = "1 2";
		jogo.jogada(entrada);
		Assert.assertTrue(entrada,true);
	}

	@Test
	public void testGanhouNasLinhas1() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][0] = jogada;
		matriz[0][1] = jogada;
		matriz[0][2] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasLinhas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasLinhas2() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[1][0] = jogada;
		matriz[1][1] = jogada;
		matriz[1][2] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasLinhas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasLinhas3() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[2][0] = jogada;
		matriz[2][1] = jogada;
		matriz[2][2] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasLinhas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasColunas1() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][0] = jogada;
		matriz[1][0] = jogada;
		matriz[2][0] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasColunas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasColunas2() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][1] = jogada;
		matriz[1][1] = jogada;
		matriz[2][1] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasColunas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasColunas3() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][2] = jogada;
		matriz[1][2] = jogada;
		matriz[2][2] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasColunas(matriz, jogada, ganhou), true);
	}

	@Test
	public void testGanhouNasDiagonais() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][0] = jogada;
		matriz[1][1] = jogada;
		matriz[2][2] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasDiagonais(matriz, jogada, ganhou), true);
	}
	
	@Test
	public void testGanhouNasDiagonais2() {
		String[][] matriz = new String[3][3];
		String jogada = "X";
		matriz[0][2] = jogada;
		matriz[1][1] = jogada;
		matriz[2][0] = jogada;
		boolean ganhou = true;
		Assert.assertEquals(jogo.ganhouNasDiagonais(matriz, jogada, ganhou), true);
	}

	@Test
	public void testEmpate() {
		String[][] matriz = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			matriz[i][j] = " ";
			}
		}
		Assert.assertEquals(jogo.empate(matriz), true);
	}
	


}
