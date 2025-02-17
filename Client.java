import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse du serveur
        int port = 1234; // Même port que le serveur

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connecté au serveur");

            // Flux d'entrée et de sortie
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer un message au serveur
            String message = "Bonjour, serveur !";
            out.println(message);
            System.out.println("Message envoyé au serveur : " + message);

            // Lire la réponse du serveur
            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
