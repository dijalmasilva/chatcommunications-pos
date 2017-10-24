package br.com.dijalmasilva.chatrmi.server;

import br.com.dijalmasilva.chatrmi.interfaces.ChatInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 21/06/17.
 */
public class Chat extends UnicastRemoteObject implements ChatInterface{

    private String name;
    private ChatInterface client;

    public Chat(String name) throws RemoteException {
        this.name = name;
        this.client = null;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    public void send(String msg) throws RemoteException {
        System.out.println();
    }

    public void setClient(ChatInterface c) throws RemoteException {

    }

    public ChatInterface getClient() throws RemoteException {
        return null;
    }
}
