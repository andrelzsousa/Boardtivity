package br.com.boardtivity.service;

import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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

public class Get {
	public static void main(String[] args) {
		String url = "https://api.miro.com/v2/boards/uXjVOzzQtpM%3D/items";
		String authorization = "Bearer eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_oWiVydDnZGOvhnkvcfbZKMIrLjc";
		
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			//Definindo Token e URL do pedido
			HttpGet request = new HttpGet(url);
			request.setHeader("accept", "application/json");
			request.setHeader("authorization", authorization);
			
			//Fazendo requisição para API do Miro
			CloseableHttpResponse response = client.execute(request);
			String json = EntityUtils.toString(response.getEntity());
			//System.out.println(json);
			
			//Tratando os dados recebidos do JSON
			Gson gson = new Gson();
			Response responseObject = gson.fromJson(json, Response.class);
			
			//Acessando os campos no objeto Response
			System.out.println(responseObject.getSize());
			System.out.println(responseObject.getTotal());
			System.out.println(responseObject.getCursor());

			//Acessando lista de "Item" no objeto Response
			List<Item> items = responseObject.getData();
			for (Item item : items) {
				System.out.println(item.getId());
				System.out.println(item.getType());

				//Acessando objeto "data" dentro de cada Item
				Data data = item.getData();
				System.out.println("Content" + data.getContent());
				System.out.println(data.getShape());

				//Acessando objeto "style" dentro de cada Item
				Style style = item.getStyle();
				System.out.println(style.getFillColor());
				System.out.println(style.getTextAlign());
				System.out.println(style.getTextAlignVertical());

				//Acessando objeto "createdBy" dentro de cada Item
				CreatedBy createdBy = item.getCreatedBy();
				System.out.println(createdBy.getId());
				System.out.println(createdBy.getType());

				//Acessando objeto "modifiedBy" dentro de cada Item
				ModifiedBy modifiedBy = item.getModifiedBy();
				System.out.println(modifiedBy.getId());
				System.out.println(modifiedBy.getType());
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

 

