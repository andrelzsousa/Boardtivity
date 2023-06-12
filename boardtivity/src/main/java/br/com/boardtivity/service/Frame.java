package br.com.boardtivity.service;

import br.com.boardtivity.data.StrateegiaData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Frame {
	private static int numeroInstancias = 0;
	
    public static int gerarFrame(String tituloFrame, Post envio, String arquivo, int posicao){
    	numeroInstancias++;
        //Post envio = new Post(token, idBoard);
       
        try {
        	List<StrateegiaData> listaDeComentarios = StrateegiaData.loadDataFromFile("C:\\Users\\andre\\Desktop\\"+ arquivo +"");

        	
        	int i = 0;
            int j = 0;
            int k = 0;
            int posY = posicao;
            int posX = 0;
            int posYFrame = 0;
            int posXFrame = 0;
            
            if(numeroInstancias == 1) {
            	posYFrame = 0 ;
                posXFrame = 0;
            }
            
            
            int largura = 300;
            int altura = 200;
            
            String cor;
           
            	
            String questao = listaDeComentarios.get(0).getQuestao();
            envio.gerarStickerNote(questao, "red", "-255", Integer.toString(posicao));
            
         
            int maior = listaDeComentarios.get(0).getRepostas().size();
            
            while(j < listaDeComentarios.size()) {
            	
            	if(questao != listaDeComentarios.get(j).getQuestao()) {
            		posX = posX + 255;
            		largura = largura + 255;
            		envio.gerarStickerNote(listaDeComentarios.get(j).getQuestao(), "red", Integer.toString(posX), Integer.toString(posicao));
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
                
                posY = posicao;
                j++;
                i = 0;
            }
            
            altura = altura + ((maior + 1) * 255);
            
            if(numeroInstancias == 1) {
            	posXFrame = (largura - 500 - 300)/2;
                posYFrame = (altura - 255 - 200)/2;
            }
            else {
            	posXFrame = (largura - 500 - 300)/2;
            	posYFrame = posicao + 250;
            }
            System.out.println(numeroInstancias);
            
            String retorno = envio.gerarBackground(tituloFrame, Integer.toString(posXFrame), Integer.toString(posYFrame), Integer.toString(altura), Integer.toString(largura));
            System.out.println(retorno);
            return altura;
            
        } catch (IOException e) {
        	e.printStackTrace();
        	return 0;
        }
        

        
    }
}
