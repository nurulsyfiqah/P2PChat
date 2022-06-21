package javaapplication48;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import peer2peerchat.LoginPage;

public class Peer2PeerChat {

    public static void main(String[] args) throws FileNotFoundException {
        
        //create portList.txt if the file not existed
        String portFile = "portList.txt";
        File tmpDir = new File(portFile);
        boolean exists = tmpDir.exists();
        
        if(!exists) {
            FileOutputStream fos = new FileOutputStream(portFile);
            try{
            fos.close();
            }
            catch(IOException e){}
        }
        
        //open first frame
        LoginPage frame = new LoginPage();
        frame.setVisible(true); 
        
        
    }
    
}
