package br.com.boardtivity.service;

import br.com.boardtivity.data.StrateegiaData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProgramaPost {

    public static void main(String[] args) throws InterruptedException {
        String token = "eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_dqbgV9DmYc_iVwqR-1q_gl6daIo";
        String idBoard = "uXjVOzzQtpM=";

        Post envio = new Post(token, idBoard);
        
        //pergunta
//        envio.gerarStickerNote("Pergunta", "red", "-255", "0");
//
//        List<String> listaDeA = Arrays.asList("repostas 1", "repostas 2", "resposta 3");
//        StrateegiaData a = new StrateegiaData("a", "COMENTARIO", listaDeA);
//
//        List<String> listaDeB = Arrays.asList("repostas w", "repostas x", "resposta y", "resposta z");
//        StrateegiaData b = new StrateegiaData("a", "COMENTARIO", listaDeB);
        
        
        
        
        
        try {
        	List<StrateegiaData> listaDeComentarios = StrateegiaData.loadDataFromFile("C:\\Users\\andre\\Desktop\\data.txt");

        	
        	int i = 0;
            int j = 0;
            int k = 0;
            int posY = 0;
            int posX = 0;
            int posYFrame = 0;
            int posXFrame = 0;
            
            int largura = 300;
            int altura = 200;
            
            String cor;
           
            	
            String questao = listaDeComentarios.get(0).getQuestao();
            envio.gerarStickerNote(questao, "red", "-255", "0");
            
         
            int maior = listaDeComentarios.get(0).getRepostas().size();
            
            while(j < listaDeComentarios.size()) {
            	
            	if(questao != listaDeComentarios.get(j).getQuestao()) {
            		posX = posX + 255;
            		largura = largura + 255;
            		envio.gerarStickerNote(listaDeComentarios.get(j).getQuestao(), "red", Integer.toString(posX), "0");
            		questao = listaDeComentarios.get(j).getQuestao();
            		posX = posX + 255;
            		largura = largura + 255;
            	}
                
            	
                while(i < listaDeComentarios.get(j).getRepostas().size() + 1) {
                	         	
                	if(listaDeComentarios.get(j).getRepostas().size() > maior) {
                		maior = listaDeComentarios.get(j).getRepostas().size();
                	}
                	
                    String conteudo;
                    if(i == 0) {
                        cor = "blue";
                        conteudo = listaDeComentarios.get(j).getComentario();
                    }
                    else{
                        cor = "green";
                        conteudo = listaDeComentarios.get(j).getRepostas().get(i - 1);
                    }

                    envio.gerarStickerNote(conteudo, cor, Integer.toString(posX), Integer.toString(posY));
                    
                    posY = posY + 255;
                    
                    
                    
                    i++;
                }
                posX = posX + 255;
                largura = largura + 255;
                
                posY = 0;
                j++;
                i = 0;
            }
            
            altura = altura + ((maior + 1) * 255);
            
            posXFrame = (largura - 500 - 300)/2;
            posYFrame = (altura - 255 - 200)/2;
            envio.gerarFrame("Fale sobre você", Integer.toString(posXFrame), Integer.toString(posYFrame), Integer.toString(altura), Integer.toString(largura));

            
        } catch (IOException e) {
        	e.printStackTrace();
        }
        

        
    }
}
