/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package peer2peerchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author user
 */
public class ChattingPage extends javax.swing.JFrame {

        
private String peerPortNumber;
private String username;
private String portnumber;
private String message; 
private Socket socket;
private String myUser;
private Server server;


static boolean pass = false;
static boolean startFlag = false;
static boolean connectFlag = false;
static boolean sendMsgFlag = false; 

    
    /**
     * Creates new form ChattingPage
     */
    public ChattingPage() {
        initComponents();
    }
    
    public ChattingPage(String username, String portnumber) {
        this.username = username;
        this.portnumber = portnumber;     
        initComponents();
        welcomeText.setText("Hi, " + username + " (PN: " + portnumber + ") " );
        
        try {
            //put users into portList.txt
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("portList.txt", true)));
            printWriter.println(username +" (" + portnumber + ") ");
            printWriter.close();
            //connect users into servers
            server = new Server(username, portnumber); 
            server.start();
        } 
        catch(Exception e) {} 
        
        //to iterate through all online users in txt file
         myUser = username +" (" + portnumber + ") ";
         onlineUser();
    }
    
        public void onlineUser(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("portList.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.equals(myUser))
                    onlineUsersTextArea.append(line +"\n");
            }
            br.close();
        } catch (IOException e){}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        messageTextField = new javax.swing.JTextField();
        sendMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        exitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        peerTextField = new javax.swing.JTextField();
        submitPeerButton = new javax.swing.JButton();
        welcomeText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        onlineUsersTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        messageTextField.setBackground(new java.awt.Color(255, 255, 255));

        sendMessageButton.setBackground(new java.awt.Color(255, 102, 102));
        sendMessageButton.setText("Send");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        chatTextArea.setBackground(new java.awt.Color(255, 255, 255));
        chatTextArea.setColumns(20);
        chatTextArea.setForeground(new java.awt.Color(0, 0, 0));
        chatTextArea.setRows(5);
        chatTextArea.setCaretColor(new java.awt.Color(51, 51, 51));
        chatTextArea.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(chatTextArea);

        exitButton.setBackground(new java.awt.Color(204, 0, 51));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(sendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendMessageButton))
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Input peer port number");

        peerTextField.setBackground(new java.awt.Color(255, 255, 255));

        submitPeerButton.setBackground(new java.awt.Color(255, 102, 102));
        submitPeerButton.setText("Submit");
        submitPeerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPeerButtonActionPerformed(evt);
            }
        });

        welcomeText.setForeground(new java.awt.Color(51, 51, 51));

        onlineUsersTextArea.setBackground(new java.awt.Color(255, 255, 255));
        onlineUsersTextArea.setColumns(20);
        onlineUsersTextArea.setRows(5);
        jScrollPane2.setViewportView(onlineUsersTextArea);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Online Peers");

        refreshButton.setBackground(new java.awt.Color(153, 153, 153));
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(submitPeerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(welcomeText))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(peerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(refreshButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeText)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitPeerButton)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        StringWriter stringWriter = new StringWriter();
        message = messageTextField.getText();
        Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
                                                   .add("username", username)
                                                   .add("message", message)
                                                   .build());
        chatTextArea.append("Me: " + message + "\n");
        server.sendMessage(stringWriter.toString());
        messageTextField.setText("");
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
//remove disconnected users from online users list
        try{
            File inputFile = new File("portList.txt"); 
            String temp = "tempFile.txt";
            File tempFile = new File(temp); 

            //create temp txt files
            FileOutputStream fos = new FileOutputStream(temp);

                try{
                fos.close();}
                catch(IOException e){}

            BufferedReader read = new BufferedReader(new FileReader(inputFile));
            BufferedWriter wri = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = myUser;
            String currentLine;

            while ((currentLine = read.readLine()) != null) {
                if (currentLine.equals(lineToRemove)) 
                    continue;
                wri.write(currentLine + System.getProperty("line.separator"));

            }
            wri.close();
            read.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        }
        catch(IOException ex){}
 
        //send disconnected message
        message = "";
        StringWriter stringWriter = new StringWriter();
        Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
                                                                       .add("username", username)
                                                                       .add("message", message)
                                                                       .build());
       server.sendMessage(stringWriter.toString());
       //exit system
       System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void submitPeerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPeerButtonActionPerformed
        peerPortNumber = peerTextField.getText();
        try{
            addPeers(username, server);
        }
        catch(Exception e) { 
            if (peerPortNumber != null) 
                System.out.println("No port numbers");
        }
        peerTextField.setText("");
    }//GEN-LAST:event_submitPeerButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        onlineUsersTextArea.setText("");
        onlineUser();
    }//GEN-LAST:event_refreshButtonActionPerformed

    public static void main(String args[]) {
        ChattingPage jfr = new ChattingPage();
        jfr.mainNonStatic();
    }
    
    /**
     * @param args the command line arguments
     */
    public void mainNonStatic(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChattingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChattingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChattingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChattingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChattingPage().setVisible(true);
            }
        });
        
        try {
            
            //chatting loop  
            boolean flag = true;
            while(flag) {  
                if (connectFlag && startFlag ) {
                    if (sendMsgFlag) {
                        String message = messageTextField.getText();
                        BufferedReader bufferedReader = new BufferedReader(new StringReader(message));
                        StringWriter stringWriter = new StringWriter();
                        Json.createWriter(stringWriter).writeObject(Json.createObjectBuilder()
                                                                                       .add("username", username)
                                                                                       .add("message", message)
                                                                                       .build());
                        server.sendMessage(stringWriter.toString());
                         
                    }
                }

            } 
        } catch(Exception e) {}            
    }
    
     //add peers
    public void addPeers(String username, Server server) throws Exception {
            try {
                socket = new Socket("localhost", Integer.valueOf(peerPortNumber));
                Peer peer = new Peer(socket);
                peer.start();
                communicate(username, server);
            } catch(Exception e) { 
                if (socket != null) socket.close(); 
                else{ 
                    System.out.println("invalid input. skipping to next step.");
                    chatTextArea.append("\nInvalid input\n");
                }
            }
    }

    public void communicate(String username, Server server) {
    try {
            System.out.println("You can start chatting now! ??? ");
            chatTextArea.append("\nYou can start chatting now! ??? \n");
    }
    catch (Exception e) { e.printStackTrace();}
    }


    //ServerThread class
    public class ServerThread extends Thread {
    private Server server;
    private Socket socket;
    private PrintWriter printWriter; 

    public ServerThread(Socket socket, Server server) {
            this.server = server;
            this.socket = socket;
    }

    public void run() {
            try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.printWriter = new PrintWriter(socket.getOutputStream(), true);
                    while(true) {
                        server.sendMessage( bufferedReader.readLine());
                    }
            } catch (Exception e) { server.getServerThreads().remove(this); }
    }
    public PrintWriter getPrintWriter() { return printWriter; }
    }
    
    //Peer class
    public class Peer extends Thread {
    private BufferedReader bufferedReader;
    
    public Peer(Socket socket) throws IOException {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
    }
    public void run() {
            boolean flag = true;
            while (flag) {
                    try {
                        JsonObject jsonObject = Json.createReader(bufferedReader).readObject();
                        //for disconnected users
                        if(jsonObject.getString("message").equals("")){
                            message = jsonObject.getString("username")+ " is disconnected!\n";
                            chatTextArea.append(message);   
                            onlineUsersTextArea.setText("");
                            onlineUser();
                        }
                        //for normal messages
                        else if (jsonObject.containsKey("username")) {
                            System.out.println("["+jsonObject.getString("username")+"]: "+jsonObject.getString("message"));
                            message = "["+jsonObject.getString("username")+"]: "+jsonObject.getString("message")+"\n";
                            chatTextArea.append(message);
                        }
                    } catch(Exception e) { 
                            flag = false;
                            interrupt();
                    }
            }
    }
    }

    //Server class
    public class Server extends Thread {
    private ServerSocket serverSocket;
    private Set<ServerThread> serverThreads = new HashSet<ServerThread>(); 
    private String username;
    private String portNumb;

    public Server(String username, String portNumb) throws IOException {
        this.username = username;    
        this.portNumb = portNumb;
        serverSocket = new ServerSocket(Integer.valueOf(portNumb));
    }
    @Override
    public void run() {
            try {
                while (true) {
                        ServerThread serverThread = new ServerThread(serverSocket.accept(), this);
                        serverThreads.add(serverThread);
                        serverThread.start();
                }
            } 
            catch (Exception e) { e.printStackTrace(); }
    }
    void sendMessage(String message) {
            try { 
                serverThreads.forEach(t-> t.getPrintWriter().println(message));
            } catch(Exception e) { e.printStackTrace(); }
    }
    public Set<ServerThread> getServerThreads() { 
        return serverThreads; }

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JTextArea onlineUsersTextArea;
    private javax.swing.JTextField peerTextField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JButton submitPeerButton;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
