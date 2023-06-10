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
    public static void main(String[] args) {
        String url = "https://api.miro.com/v2/boards/uXjVOzzQtpM%3D/sticky_notes";
        String authorization = "Bearer eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_5gcEyoUNaNurlc4pFADytS2wc0I";
        
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            
            //Definindo Token, URL do pedido e corpo da solicitação
            HttpPost request = new HttpPost(url);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.setHeader("Authorization", authorization);
            String jsonInputString = "{\"data\":{\"shape\":\"square\",\"content\":\"careca\"},\"position\":{\"origin\":\"center\",\"x\":0,\"y\":30}}";
            request.setEntity(new StringEntity(jsonInputString));
            
            //Fazendo requisição para API do Miro
            CloseableHttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            System.out.println(json);
            
            //Tratando os dados recebidos do JSON
            //Gson gson = new Gson();
            //Response responseObject = gson.fromJson(json, Response.class);
            
            //Aqui você pode continuar a processar a resposta conforme necessário...

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}