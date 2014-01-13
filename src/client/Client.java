package client;

import java.net.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

class Client extends Thread {

    boolean run;
    boolean isConnected;
    DataOutputStream dos;
    DataInputStream dis;
    String name;

    String ip;
    int port;
    MainGUI tata;
    ReadThread rt;

    StyledDocument usersListDoc;
    StyledDocument receivedDoc;
    StyledDocument messageDoc;

    public Client(MainGUI dad, String i, int p, StyledDocument users, StyledDocument received, StyledDocument message) {
        usersListDoc = users;
        receivedDoc = received;
        messageDoc = message;

        isConnected = false;

        ip = i;
        port = p;
        tata = dad;
    }

    public void closeClient() throws InterruptedException {
        try {
            receivedDoc.insertString(receivedDoc.getLength(), "Connection closed by server! Plase try again later!", null);
        } catch (BadLocationException ble) {
            System.out.println("Nu pot scrie closeClinet()");
        }
        run = false;
        tata.setConnected(false);
    }

    public void list() {
        try {
            dos.writeUTF("LIST");
        } catch (IOException ioe) {
            System.out.println("Nu am putut scrie LIST!");
        }
    }

    public void quit() {
        try {
            dos.writeUTF("QUIT");
        } catch (IOException ioe) {
            System.out.println("Nu am putut face quit()");
        }
    }

    public void nick(String newNick) {
        try {
            dos.writeUTF("NICK");
            dos.writeUTF(newNick);
            Thread.sleep(500);
        } catch (IOException ioe) {
            System.out.println("Nu am putut scrie NICK!");
        } catch (InterruptedException ie) {

        }

        try {
            if (newNick.equals(rt.getMyName())) {
                name = newNick;
                receivedDoc.insertString(receivedDoc.getLength(), "Nickname changed to: " + name + "\n", null);
            } else {
                receivedDoc.insertString(receivedDoc.getLength(), "Nickname is not available! \n", null);

            }
        } catch (BadLocationException ble) {
            System.out.println("Nu am putut scrie nick()");
        }
    }

    public void bcast(String message) {
        try {
            dos.writeUTF("BCAST");
            dos.writeUTF(message);
            receivedDoc.insertString(receivedDoc.getLength(), "Broadcast: " + message + "\n", null);
        } catch (IOException ioe) {
            System.out.println("Nu am putut scrie BCAST!");
        } catch (BadLocationException ble) {
            System.out.println("Nu am putut scrie bcast()");
        }
    }

    public void message(String sendTo, String message) {
        try {
            dos.writeUTF("MSG");
            dos.writeUTF(sendTo);
            dos.writeUTF(message);
            receivedDoc.insertString(receivedDoc.getLength(), "MESSAGE sent! \n", null);
        } catch (IOException ioe) {
            System.out.println("Nu am putut scrie MSG!");
        } catch (BadLocationException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        try {
            //Scanner sc = new Scanner(System.in);

            run = true;
            Socket cs = new Socket(ip, port);
            dis = new DataInputStream(cs.getInputStream());
            dos = new DataOutputStream(cs.getOutputStream());
            tata.setConnected(true);
            isConnected = true;

            Random randomGenerator = new Random();
            Integer nr = randomGenerator.nextInt(5000);
            name = nr.toString();
            dos.writeUTF(name);

            while (true) {
                String mesaj = dis.readUTF();
                if (mesaj.equals("TAKEN")) {
                    nr = randomGenerator.nextInt(5000);
                    String numeNou = nr.toString();
                    name = numeNou;
                    dos.writeUTF(numeNou);
                } else {
                    try {
                        receivedDoc.insertString(receivedDoc.getLength(), "Hello, " + name + "!", null);
                        receivedDoc.insertString(receivedDoc.getLength(), " You can change your nickname using the button above!\n", null);
                    } catch (BadLocationException ble) {
                        System.out.println("Nu am putut scrie salut-ul!");
                    }
                    break;
                }
            }

            rt = new ReadThread(this, name, dis, dos, usersListDoc, receivedDoc, messageDoc);

            while (run == true) {
                /*String newInput = null;

                 if (run == false) {
                 break;
                 } else {

                 newInput = sc.next();
                 if (newInput.equals(Actiuni.LIST.getMessage())) {
                 dos.writeUTF(newInput);
                 } else if (newInput.equals(Actiuni.QUIT.getMessage())) {
                 dos.writeUTF(newInput);
                 System.out.println("La revedere, " + name + "!");
                 break;
                 } else if (newInput.equals(Actiuni.NICK.getMessage())) {
                 dos.writeUTF(newInput);
                 String newNick = sc.next();
                 dos.writeUTF(newNick);
                 Thread.sleep(500);
                 if (newNick.equals(rt.getMyName())) {
                 name = newNick;
                 System.out.println("De acum ai nickname-ul " + name + "!");
                 } else {
                 System.out.println("Acest nickname apartine deja altcuiva!");
                 }
                 } else if (newInput.equals(Actiuni.MSG.getMessage())) {
                 dos.writeUTF(newInput);
                 String toSend = sc.next();
                 dos.writeUTF(toSend);

                 String message = sc.nextLine();
                 dos.writeUTF(message);
                 } else if (newInput.equals(Actiuni.BCAST.getMessage())) {
                 dos.writeUTF(newInput);
                 String toSend = sc.nextLine();
                 dos.writeUTF(toSend);
                 } else {
                 System.out.println("Comanda invalida!");
                 }
                 }*/
            }
        } catch (IOException ioe) {
            System.out.println("Nu m-am putut conecta!");
            tata.setConnected(false);
            isConnected = false;
        }// catch (InterruptedException ie) {
        //}
    }
}
