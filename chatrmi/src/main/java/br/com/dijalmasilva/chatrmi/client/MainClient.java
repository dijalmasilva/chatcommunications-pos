package br.com.dijalmasilva.chatrmi.client;

import br.com.dijalmasilva.chatrmi.interfaces.ChatInterface;
import br.com.dijalmasilva.chatrmi.server.Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 21/06/17.
 */
public class MainClient {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite seu nome: ");
            String name = s.nextLine().trim();
            ChatInterface client = new Chat(name);

            ChatInterface server = (ChatInterface) Naming.lookup("rmi://localhost/server");
            String msg = "" + client.getName() + " foi conectado!";
            server.send(msg);
            System.out.println("Chat Remoto está pronto: ");
            server.setClient(client);

            while (true) {
                msg = s.nextLine().trim();
                msg = "[" + client.getName() + "] " + msg;
                server.send(msg);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
