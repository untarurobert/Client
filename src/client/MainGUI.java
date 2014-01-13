package client;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class MainGUI extends javax.swing.JFrame {

    public void setConnected(boolean b) {
        isConnected = b;
        if (b){
            connectionPane.setText("    ONLINE");
        } else {
            connectionPane.setText("    OFFLINE");
        }
    }

    public MainGUI() {
        initComponents();
        setResizable(false);
        setConnected(false);
        usersListUpdated = false;

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                if (isConnected) {
                    t.quit();
                    System.exit(0);
                } else {
                    System.exit(0);
                }
            }
        }
        );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receivedPane = new javax.swing.JTextPane();
        msg = new javax.swing.JButton();
        bcast = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageToSendPane = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        usersListPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changeNick = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        nicknameChangePane = new javax.swing.JEditorPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        portArea = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        ipArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        userToSendToPane = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        connectionPane = new javax.swing.JTextArea();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receivedPane.setPreferredSize(new java.awt.Dimension(480, 172));
        jScrollPane1.setViewportView(receivedPane);
        receivedDoc = receivedPane.getStyledDocument();

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 450, 172));

        msg.setText("Message");
        msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msgMouseClicked(evt);
            }
        });
        msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgActionPerformed(evt);
            }
        });
        getContentPane().add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 190, -1));

        bcast.setText("Broadcast");
        bcast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bcastMouseClicked(evt);
            }
        });
        bcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcastActionPerformed(evt);
            }
        });
        getContentPane().add(bcast, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 190, -1));

        messageToSendPane.setPreferredSize(new java.awt.Dimension(303, 87));
        jScrollPane3.setViewportView(messageToSendPane);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 240, 100));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel1.setText("Send to:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 74, -1));

        jScrollPane5.setHorizontalScrollBar(null);
        jScrollPane5.setInheritsPopupMenu(true);

        usersListPane.setMaximumSize(new java.awt.Dimension(124, 60));
        usersListPane.setMinimumSize(new java.awt.Dimension(124, 60));
        jScrollPane5.setViewportView(usersListPane);
        usersListDoc = usersListPane.getStyledDocument();

        try{
            usersListDoc.insertString(usersListDoc.getLength(), "Online users list not yet updated! Press Update!", null);
        } catch (BadLocationException ble) {

        }

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 300));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel2.setText("Messages:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel3.setText("Online users:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        changeNick.setText("Change Nick");
        changeNick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeNickMouseClicked(evt);
            }
        });
        changeNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNickActionPerformed(evt);
            }
        });
        getContentPane().add(changeNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 11, -1, -1));

        update.setFont(new java.awt.Font("Ubuntu", 0, 8)); // NOI18N
        update.setText("Update");
        update.setMargin(new java.awt.Insets(2, 2, 2, 2));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 19, 60, 20));

        jScrollPane2.setViewportView(nicknameChangePane);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jLabel4.setText("New message:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 90, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Connection");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        portArea.setColumns(5);
        portArea.setRows(1);
        jScrollPane6.setViewportView(portArea);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 80, -1));

        ipArea.setColumns(20);
        ipArea.setRows(1);
        jScrollPane7.setViewportView(ipArea);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jLabel7.setText("IP:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));
        jLabel7.getAccessibleContext().setAccessibleDescription("");

        jLabel8.setText("PORT:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        connectButton.setText("CONNECT");
        connectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectButtonMouseClicked(evt);
            }
        });
        getContentPane().add(connectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        disconnectButton.setText("DISCONNECT");
        disconnectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disconnectButtonMouseClicked(evt);
            }
        });
        getContentPane().add(disconnectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        userToSendToPane.setColumns(5);
        jScrollPane8.setViewportView(userToSendToPane);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 190, -1));

        connectionPane.setBackground(new java.awt.Color(240, 240, 240));
        connectionPane.setColumns(1);
        connectionPane.setRows(1);
        connectionPane.setBorder(null);
        connectionPane.setCaretColor(new java.awt.Color(240, 240, 240));
        connectionPane.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        jScrollPane4.setViewportView(connectionPane);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        if (isConnected) {
            if (t != null) {
                t.list();
            }
        } else {
            try {
                receivedDoc.insertString(receivedDoc.getLength(), "You are not connected to a server!\n", null);
            } catch (BadLocationException ble) {
            }
        }
    }//GEN-LAST:event_updateMouseClicked

    private void changeNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeNickActionPerformed

    private void changeNickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeNickMouseClicked
        if (isConnected) {
            String newNick = nicknameChangePane.getText();
            if (newNick.indexOf(" ") != -1) {
                newNick = newNick.substring(0, newNick.indexOf(" "));
            }
            t.nick(newNick);
        } else {
            try {
                receivedDoc.insertString(receivedDoc.getLength(), "You are not connected to a server!\n", null);
            } catch (BadLocationException ble) {
            }
        }
        nicknameChangePane.setText("");
    }//GEN-LAST:event_changeNickMouseClicked

    private void bcastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcastMouseClicked
        if (isConnected) {
            t.bcast(messageToSendPane.getText());
            messageToSendPane.setText("");
        } else {
            try {
                receivedDoc.insertString(receivedDoc.getLength(), "You are not connected to a server!\n", null);
            } catch (BadLocationException ble) {
            }
        }
        messageToSendPane.setText("");
    }//GEN-LAST:event_bcastMouseClicked

    private void bcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcastActionPerformed

    private void msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msgMouseClicked
        if (isConnected) {
            t.message(userToSendToPane.getText(), messageToSendPane.getText());

        } else {
            try {
                receivedDoc.insertString(receivedDoc.getLength(), "You are not connected to a server!\n", null);
            } catch (BadLocationException ble) {
            }
        }
        messageToSendPane.setText("");
    }//GEN-LAST:event_msgMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void connectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectButtonMouseClicked
        String ip = ipArea.getText();
        String p = portArea.getText();
        int port = Integer.parseInt(p);

        if (!isConnected) {
            t = new Client(this, ip, port, usersListDoc, receivedDoc, messageDoc);

            t.start();
            receivedPane.setText("");
            //isConnected = true;
        }
    }//GEN-LAST:event_connectButtonMouseClicked

    private void disconnectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnectButtonMouseClicked
        try {
            if (isConnected) {
                receivedDoc.insertString(receivedDoc.getLength(), "You have disconnected from the server!\n", null);
                Thread.sleep(1000);
                t.quit();
                setConnected(false);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_disconnectButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);

            }
        });
    }

    Client t;
    boolean isConnected;

    boolean usersListUpdated;
    StyledDocument usersListDoc;
    StyledDocument receivedDoc;
    StyledDocument messageDoc;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcast;
    private javax.swing.JButton changeNick;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextArea connectionPane;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextArea ipArea;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JEditorPane messageToSendPane;
    private javax.swing.JButton msg;
    private javax.swing.JEditorPane nicknameChangePane;
    private javax.swing.JTextArea portArea;
    private javax.swing.JTextPane receivedPane;
    private javax.swing.JButton update;
    private javax.swing.JTextArea userToSendToPane;
    private javax.swing.JTextPane usersListPane;
    // End of variables declaration//GEN-END:variables
}
