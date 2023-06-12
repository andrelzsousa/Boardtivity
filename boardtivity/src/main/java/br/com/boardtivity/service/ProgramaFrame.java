package br.com.boardtivity.service;

public class ProgramaFrame {
	public static void main(String[] args){
		String token = "eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_JiBFHqHds3jax-Rgh0AuQRpc41I";
        String idBoard = "uXjVOzzQtpM=";

        Post envio = Post.getInstance(token, idBoard);
		
        int posicao = Frame.gerarFrame("Fale sobre você", envio, "data.txt", 0);
        int posicao2 = Frame.gerarFrame("Ambientes", envio, "data2.txt", posicao + 250);
		
        //int posicao3 = Frame.gerarFrame("Perguntas aleatórias", envio, "data3.txt", (posicao2*2) + (250*2));
	}
}
