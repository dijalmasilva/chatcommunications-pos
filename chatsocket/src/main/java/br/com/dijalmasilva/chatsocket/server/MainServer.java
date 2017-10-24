package br.com.dijalmasilva.chatsocket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 22/06/17.
 */
public class MainServer {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9091);

            while(true) {
                Socket client = server.accept();
                InputStream inputStream = client.getInputStream();
                byte[] b = new byte[1024];
                inputStream.read(b);
                String received = new String(b).trim();
                System.out.println("Mensagem recebida: " + received);
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(("HelloWorld " + received).getBytes());
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
