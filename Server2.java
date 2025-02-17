import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String[] args) {
        int port = 1234; // Port d'écoute

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur en attente de connexion sur le port " + port);

            // Attente de connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté : " + clientSocket.getInetAddress());

            // Flux d'entrée et de sortie
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            // Lire les messages du client en boucle
            while ((message = in.readLine()) != null) {
                System.out.println("Message reçu du client : " + message);

                // Vérifier si le message est "fin" pour arrêter
                if (message.equalsIgnoreCase("fin")) {
                    System.out.println("Le client a demandé la fermeture de la connexion.");
                    break;
                }

                // Répondre au client
                out.println("Message bien reçu : " + message);
            }

            // Fermer la connexion proprement
            System.out.println("Fermeture de la connexion avec le client.");
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
