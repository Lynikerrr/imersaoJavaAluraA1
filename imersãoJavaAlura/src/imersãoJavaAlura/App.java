package imersãoJavaAlura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {

		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		var body = response.body();

		var parser = new JsonParser();
		List<Map<String, String>> ListaDeFilmes = parser.parse(body);

		for (Map<String, String> filme : ListaDeFilmes) {
			System.out.println("\uD83C\uDfAc \u001b[1mTitulo:\u001b[m " + filme.get("title")+ "\n");
			System.out.println("\u001b[34m" + filme.get("image") + "\u001b[m" + "\n");

			System.out.println("\u001b[1mNota:\u001b[m " + filme.get("imDbRating")+ "\n");
			double classificacao = Double.parseDouble(filme.get("imDbRating"));
			

			int estrelas = (int) classificacao;
	        for (int x = 1; x <= estrelas; x++) {
	                System.out.print("\u2B50");
	        }
	        System.out.println("\n");

		}
	}
}
