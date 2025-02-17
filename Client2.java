import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse du serveur
        int port = 1234; // Même port que le serveur

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur. Tapez vos messages ('fin' pour quitter) :");

            String message;
            while (true) {
                // Lire l'entrée utilisateur
                System.out.print("> ");
                message = scanner.nextLine();

                // Envoyer le message au serveur
                out.println(message);

                // Vérifier si le message est "fin" pour arrêter la boucle et fermer proprement
                if (message.equalsIgnoreCase("fin")) {
                    System.out.println("Déconnexion demandée.");
                    break;
                }

                // Lire la réponse du serveur
                String response = in.readLine();
                System.out.println("Réponse du serveur : " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
