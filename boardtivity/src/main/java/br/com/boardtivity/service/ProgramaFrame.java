package br.com.boardtivity.service;

public class ProgramaFrame {
	public static void main(String[] args){
		String token = "eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_w1aZ2dYTiSbbY4bT0h4sI5BIM0U";
        String idBoard = "uXjVOzzQtpM=";

        Post envio = Post.getInstance(token, idBoard);
		
        int posicao = Frame.gerarFrame("Fale sobre você", envio, "data.txt", 0);
        int posicao2 = Frame.gerarFrame("Ambientes", envio, "data2.txt", posicao + 300);
        int posicao3 = Frame.gerarFrame("Perguntas aleatórias", envio, "data3.txt", posicao2 + 300);
	}
}




