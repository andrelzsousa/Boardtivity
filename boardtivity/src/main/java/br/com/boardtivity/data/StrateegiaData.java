package br.com.boardtivity.data;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StrateegiaData {
	private String questao;
    private String comentario;
    private List<String> repostas;

    

    public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<String> getRepostas() {
		return repostas;
	}

	public void setRepostas(List<String> repostas) {
		this.repostas = repostas;
	}

	public StrateegiaData(String questao, String comentario, List<String> repostas) {
        super();
        this.questao = questao;
        this.comentario = comentario;
        this.repostas = repostas;
    }
	
	public StrateegiaData() {
        super();
    }

	public static List<StrateegiaData> loadDataFromFile(String filename) throws IOException {
	    List<StrateegiaData> dataList = new ArrayList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));
	    String line;
	    String questao = null;
	    String comentario = null;
	    List<String> respostas = new ArrayList<>();

	    while ((line = reader.readLine()) != null) {
	        if (line.startsWith("Questão")) {
	            if (questao != null && comentario != null) {
	                dataList.add(new StrateegiaData(questao, comentario, new ArrayList<>(respostas)));
	                respostas.clear();
	            }
	            questao = reader.readLine();
	            comentario = null; // reset comment for new question
	        } else if (line.startsWith("Comentário:")) {
	            if (comentario != null) {
	                dataList.add(new StrateegiaData(questao, comentario, new ArrayList<>(respostas)));
	                respostas.clear();
	            }
	            comentario = reader.readLine();
	        } else if (line.startsWith("Respostas:")) {
	            while ((line = reader.readLine()) != null && !line.startsWith("Comentário:") && !line.startsWith("Questão") && !line.isEmpty()) {
	                respostas.add(line.trim());
	            }
	        }
	    }
	    if (questao != null && comentario != null) {
	        dataList.add(new StrateegiaData(questao, comentario, new ArrayList<>(respostas)));
	    }

	    reader.close();
	    return dataList;
	}

    @Override
    public String toString() {
        return "Questão: " + questao + ", Comentário: " + comentario + ", Respostas: " + repostas;
    }

    public static void main(String[] args) {
        try {
            List<StrateegiaData> dataList = loadDataFromFile("C:\\Users\\andre\\Desktop\\data.txt");
            for (StrateegiaData data : dataList) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}