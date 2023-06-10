package br.com.boardtivity.service;

public class ProgramaPost {

	public static void main(String[] args) {
		
		String token = "eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_6Rxtv64yZ_muLaZ7iBM19OybODg";
		String idBoard = "uXjVOzzQtpM=";
		
		Post envio = new Post(token, idBoard);
		
		//String retorno = envio.gerarPontoConvergencia("Careca", "green", "0", "30");
		
		int i = 0;
		int posY = 0;
		String cor;
		
		while(i < 3) {
			if(i == 1) {
				cor = "red";
			}
			else if (i == 2) {
				cor = "blue";
			}
			else{
				cor = "green";
			}
			
			
			envio.gerarPontoConvergencia("Careca" + i, cor, "0", Integer.toString(posY));
			posY = posY + 255;
			i++;
		}
		
		
		//envio.gerarPontoConvergencia("Careca", "green", "0", "0");
		//envio.gerarPontoConvergencia("Careca1", "red", "0", "225");
		//envio.gerarPontoConvergencia("Careca2", "blue", "0", "450");
		//System.out.println(retorno);
		
	}

}
