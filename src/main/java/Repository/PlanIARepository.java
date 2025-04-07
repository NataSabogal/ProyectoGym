/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanIARepository {

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent";
    private static final String API_KEY = Dotenv.load().get("API_KEY");
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String obtenerPlanRecomendado(String prompt) throws IOException, InterruptedException {
        Gson gson = new Gson();

        // Crear el contenido de la solicitud
        JsonObject requestBody = new JsonObject();
        JsonObject content = new JsonObject();
        JsonObject part = new JsonObject();

        part.addProperty("text", prompt);
        content.add("parts", gson.toJsonTree(new JsonObject[]{part}));
        requestBody.add("contents", gson.toJsonTree(new JsonObject[]{content}));

        // Enviar la solicitud a la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("x-goog-api-key", API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObj = new JSONObject(response.body());

        // Extraer la respuesta de la IA
        return jsonObj.getJSONArray("candidates")
                .getJSONObject(0)
                .getJSONObject("content")
                .getJSONArray("parts")
                .getJSONObject(0)
                .getString("text");
    }

}
