package br.com.dijalmasilva.chatrmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 21/06/17.
 */
public interface ChatInterface extends Remote{

    String getName() throws RemoteException;
    void send(String msg) throws RemoteException;
    void setClient(ChatInterface c) throws RemoteException;
    ChatInterface getClient() throws RemoteException;
}
