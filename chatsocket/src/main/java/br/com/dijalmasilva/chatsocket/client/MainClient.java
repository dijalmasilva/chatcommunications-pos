package br.com.dijalmasilva.chatsocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 22/06/17.
 */
public class MainClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 9091);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Dijalma Silva".getBytes());
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            inputStream.read(b);
            inputStream.close();
            outputStream.close();
            System.out.println("Mensagem do server: " + new String(b).trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
