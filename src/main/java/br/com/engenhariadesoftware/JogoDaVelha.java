package br.com.engenhariadesoftware;

import java.util.Scanner;

public class JogoDaVelha {

	String[][] matriz = new String[3][3];
	String tabuleiro;
	Integer jogador = 1;
	
	
	public void gerarMatriz() {

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				matriz[linha][coluna] = " ";
			}
		}
	}

	public void mostrarTabuleiro() {

		tabuleiro = "    1   2   3";
		tabuleiro += "\n---------------\n";
		for (int linha = 0; linha < 3; linha++) {
			tabuleiro += (linha + 1) + " | ";
			for (int coluna = 0; coluna < 3; coluna++) {
				tabuleiro += matriz[linha][coluna] + " | ";
			}
			tabuleiro += "\n---------------\n";
		}

		System.out.println(tabuleiro);

	}

	public void jogar() {

		gerarMatriz();

		mostrarTabuleiro();

		iniciarJogadas();

		resultado();

	}

	public void iniciarJogadas() {
		
		Scanner scanner = new Scanner(System.in);

		while (!(empate(matriz) || ganhador(matriz, "X") || ganhador(matriz, "O"))) {
			System.out.println("Jogador " + jogador + " digite a posição (linha e coluna): ");
			String entrada = scanner.nextLine();			
			jogada(entrada);
		}
		resultado();
		scanner.close();
	}

	public void jogada(String entrada) {
		
		
		String[] split = entrada.split(" ");

		Integer linha = Integer.valueOf(split[0]);
		Integer coluna = Integer.valueOf(split[1]);
		
		if (validarJogada(linha, coluna) == true) {
			marcarNoTabuleiro(linha, coluna);
		}else {
			System.out.println("jogada inválida!");
		}
		
		
	}


	public boolean validarJogada(Integer linha, Integer coluna) {

		Integer i = linha - 1;
		Integer j = coluna - 1;

		if (i < 3 && i >= 0 && j < 3 && j >= 0 && matriz[i][j].equals(" ")) {
			return true;
		} 
		return false;
		

	}

	public void marcarNoTabuleiro(Integer linha, Integer coluna) {

		
		if (jogador == 1) {
			matriz[linha - 1][coluna - 1] = "X";
			jogador = 2;
		} else {
			matriz[linha - 1][coluna - 1] = "O";
			jogador = 1;
		}
		mostrarTabuleiro();
	}

	public void resultado() {

		// Verifica o resultado final
		if (ganhador(matriz, "X")) {
			System.out.println("O jogador 1 ganhou!");
		} else if (ganhador(matriz, "O")) {
			System.out.println("O jogador 2 ganhou!");
		} else if (empate(matriz)) {
			System.out.println("O jogo terminou empatado!");
		}
	}

	// verifica se ganhou
	public boolean ganhador(String matriz[][], String jogada) {
		boolean ganhou = false;

		if (ganhouNasLinhas(matriz, jogada, ganhou) == true) {
			System.out.println("ganhou nas linhas");

		}
		if (ganhouNasColunas(matriz, jogada, ganhou) == true) {
			System.out.println("ganhou nas colunas");

		}
		if (ganhouNasDiagonais(matriz, jogada, ganhou) == true) {
			System.out.println("ganhou nas diagonais");
		}

		return ganhou;
	}

	public boolean ganhouNasLinhas(String matriz[][], String jogada, boolean ganhou) {

		for (int i = 0; i < 3; i++) {
			int count = 0;
			for (int j = 0; j < 3; j++) {
				if (matriz[i][j] == jogada) {
					count++;
				}
			}
			if (count == 3) {
				ganhou = true;
			}
		}
		return ganhou;

	}

	public boolean ganhouNasColunas(String matriz[][], String jogada, boolean ganhou) {

		for (int j = 0; j < 3; j++) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (matriz[i][j] == jogada) {
					count++;
				}
			}
			if (count == 3) {
				ganhou = true;
			}
		}
		return ganhou;
	}

	public boolean ganhouNasDiagonais(String matriz[][], String jogada, boolean ganhou) {
		if (matriz[0][0] == jogada && matriz[1][1] == jogada && matriz[2][2] == jogada) {
			ganhou = true;
		} else if (matriz[0][2] == jogada && matriz[1][1] == jogada && matriz[2][0] == jogada) {
			ganhou = true;
		}
		return ganhou;
	}

	public boolean empate(String matriz[][]) {
		boolean empate = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matriz[i][j] == " ") {
					empate = true;
				}
			}
		}
		return !empate;
	}

}
