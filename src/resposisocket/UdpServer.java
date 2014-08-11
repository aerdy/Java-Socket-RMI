/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resposisocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author aerdy
 */
public class UdpServer {
    public byte [] getTime(){
        Date d = new Date();
        return d.toString().getBytes();
    }
    
    public void go () throws IOException{
        DatagramSocket datagramSocket;
        DatagramPacket inDataPacket;
        DatagramPacket outDataPacket;
        InetAddress clientAddress;
        int clientPort;
        byte[] msg = new byte[10];
        byte [] time;
        
        datagramSocket = new DatagramSocket(8000);
        System.out.println("UDP server active on port 8000");
        while(true){
            inDataPacket = new DatagramPacket(msg,msg.length);
            datagramSocket.receive(inDataPacket);
            
            clientAddress = inDataPacket.getAddress();
            clientPort = inDataPacket.getPort();
            
            time = getTime();
            outDataPacket = new DatagramPacket(time,time.length,clientAddress,clientPort);
            datagramSocket.send(outDataPacket);
            datagramSocket.close();
        }
        
    }
    public void go2 () throws IOException{
        DatagramSocket datagramSocket;
        DatagramPacket inDataPacket;
        DatagramPacket outDataPacket;
        InetAddress clientAddress;
        int clientPort;
        byte[] msg = new byte[10];
        byte [] time;
        
        datagramSocket = new DatagramSocket(1024);
        System.out.println("UDP server active on port 1024");
        while(true){
            inDataPacket = new DatagramPacket(msg,msg.length);
            datagramSocket.receive(inDataPacket);
            
            clientAddress = inDataPacket.getAddress();
            clientPort = inDataPacket.getPort();
            
            time = getTime();
            outDataPacket = new DatagramPacket(time,time.length,clientAddress,clientPort);
            datagramSocket.send(outDataPacket);
            datagramSocket.close();
        }
        
    }
    
    public static void main(String[] args) {
        UdpServer udpSever = new UdpServer();
        UdpClient client = new UdpClient();
        try {
            udpSever.go();
            client.go2();
          
        } catch (Exception e) {
            System.out.println("IOException occured with socket");
            System.out.println(e);
            System.exit(1);
        }
    }
}
