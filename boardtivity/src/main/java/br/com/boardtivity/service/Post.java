package br.com.boardtivity.service;

import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

import br.com.boardtivity.models.CreatedBy;
import br.com.boardtivity.models.Data;
import br.com.boardtivity.models.Item;
import br.com.boardtivity.models.ModifiedBy;
import br.com.boardtivity.models.Response;
import br.com.boardtivity.models.Style;

public class Post {
    private String token;
    private String idBoard;

    private static Post instance;

    private Post(String token, String idBoard) {
        this.token = token;
        this.idBoard = idBoard;
    }

    public static Post getInstance(String token, String idBoard) {
        if (instance == null) {
            instance = new Post(token, idBoard);
        }
        return instance;
    }

    public String gerarStickerNote(String conteudo, String cor, String posX, String posY) {
        String url = "https://api.miro.com/v2/boards/" + idBoard + "/sticky_notes";
        String authorization = "Bearer " + token;

        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();

            // Definindo Token, URL do pedido e corpo da solicitação
            HttpPost request = new HttpPost(url);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.setHeader("Authorization", authorization);
            String jsonInputString = "{\"data\":{\"shape\":\"square\",\"content\":\"" + conteudo + "\"},"
                    + "\"style\":{\"fillColor\":\"" + cor + "\"},\"position\":{\"origin\":\"center\",\"x\":" + posX
                    + ",\"y\":" + posY + "}}";
            request.setEntity(new StringEntity(jsonInputString, "UTF-8"));

            // Fazendo requisição para API do Miro
            CloseableHttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            return json;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String gerarBackground(String titulo, String posX, String posY, String altura, String largura) {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();

            String url = "https://api.miro.com/v2/boards/" + idBoard + "/frames";
            String authorization = "Bearer " + token;

            // Definindo Token, URL do pedido e corpo da solicitação
            HttpPost request = new HttpPost(url);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.setHeader("Authorization", authorization);
            String jsonInputString = "{\"data\":{\"format\":\"custom\",\"title\":\"" + titulo
                    + "\",\"type\":\"freeform\",\"showContent\":true},\"style\":{\"fillColor\":\"#E4C891\"},\"position\":{\"origin\":\"center\",\"x\":"
                    + posX + ",\"y\":" + posY + "},\"geometry\":{\"height\":" + altura + ",\"width\":" + largura + "}}";
            request.setEntity(new StringEntity(jsonInputString, "UTF-8"));

            // Fazendo requisição para API do Miro
            CloseableHttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            return json;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
