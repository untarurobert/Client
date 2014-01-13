package client;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.text.StyledDocument;

public class ReadThread extends Thread {

    DataInputStream dis;
    DataOutputStream dos;
    String rtname;
    String lastUser;
    Client tata;

    StyledDocument usersListDoc;
    StyledDocument receivedDoc;
    StyledDocument messageDoc;

    public String getMyName() {
        return rtname;
    }

    ReadThread(Client t, String newName, DataInputStream in, DataOutputStream out, StyledDocument users, StyledDocument received, StyledDocument message) throws IOException {
        dis = in;
        dos = out;
        rtname = newName;
        lastUser = "-1";
        tata = t;

        usersListDoc = users;
        receivedDoc = received;
        messageDoc = message;

        start();
    }

    @Override
    public void run() {

        while (true) {
            boolean hasMessage = true;
            String newMessage = null;

            try {
                Scanner sc = new Scanner(System.in);
                newMessage = dis.readUTF();
                
                if (newMessage.equals("LIST")) {
                    int n = dis.readInt();
                    usersListDoc.remove(0, usersListDoc.getLength());
                    usersListDoc.insertString(usersListDoc.getLength(), "There are " + n + " users connected:\n", null);
                    for (int i = 1; i <= n; i++) {
                        usersListDoc.insertString(usersListDoc.getLength(), dis.readUTF().concat("\n"), null);
                    }
                } else if (newMessage.equals("MSG")) {
                    String messageFrom = dis.readUTF();

                    if (!(lastUser.equals(messageFrom))) {
                        receivedDoc.insertString(receivedDoc.getLength(), "Message from user: " + messageFrom + "\n", null);
                        lastUser = messageFrom;
                    }
                    receivedDoc.insertString(receivedDoc.getLength(), "        " + dis.readUTF() + "\n", null);
                } else if (newMessage.equals("BCAST")) {
                    receivedDoc.insertString(receivedDoc.getLength(), "Broadcast from user " + dis.readUTF() + ":\n", null);
                    receivedDoc.insertString(receivedDoc.getLength(), "        " + dis.readUTF() + "\n", null);
                } else if (newMessage.equals("QUIT")) {
                    break;
                } else if (newMessage.equals("NICK")) {
                    String input = dis.readUTF();
                    if (!input.equals("-1")) {
                        rtname = input;
                    }
                } else if (newMessage.equals("QUIT2")) {
                    tata.closeClient();
                    break;
                }

            } catch (Exception e) {
            }

        }
    }
}
