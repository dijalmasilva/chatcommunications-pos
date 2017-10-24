package br.com.dijalmasilva.chatrmi.server;

import br.com.dijalmasilva.chatrmi.interfaces.ChatInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 21/06/17.
 */
public class MainServer {

    public static void main(String[] args) {

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite seu nome: ");
            String name = s.nextLine().trim();

            Chat server = new Chat(name);

            Naming.rebind("rmi://localhost/server", server);

            System.out.println("Chat Remote está pronto:");

            while (true) {
                String msg = s.nextLine().trim();
                if (server.getClient() != null) {
                    ChatInterface client = server.getClient();
                    msg = "[" + server.getName() + "] " + msg;
                    client.send(msg);
                }
            }
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
