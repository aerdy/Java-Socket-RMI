/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resposisocket;

import java.io.*;
import java.net.*;
/**
 *
 * @author aerdy
 */
public class UdpClient {
    public void go() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket;
		
		DatagramPacket outDataPacket;
		
		DatagramPacket inDataPacket;
		
		InetAddress serverAddress;
		
		byte[] msg = new byte[100];
		
		String receivedMsg;
		
		datagramSocket= new DatagramSocket();
		
		serverAddress = InetAddress.getLocalHost();
		
		outDataPacket = new DatagramPacket(msg, 1, serverAddress, 8000);
		
		datagramSocket.send(outDataPacket);
		
		inDataPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.receive(inDataPacket);
		
		receivedMsg = new String(inDataPacket.getData(), 0, inDataPacket.getLength());
		System.out.println(receivedMsg);
		datagramSocket.close();
		}
    public void go2() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket;
		
		DatagramPacket outDataPacket;
		
		DatagramPacket inDataPacket;
		
		InetAddress serverAddress;
		
		byte[] msg = new byte[100];
		
		String receivedMsg;
		
		datagramSocket= new DatagramSocket();
		
		serverAddress = InetAddress.getLocalHost();
		
		outDataPacket = new DatagramPacket(msg, 1, serverAddress, 1024);
		
		datagramSocket.send(outDataPacket);
		
		inDataPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.receive(inDataPacket);
		
		receivedMsg = new String(inDataPacket.getData(), 0, inDataPacket.getLength());
		System.out.println(receivedMsg);
		datagramSocket.close();
		}
		
		public static void main(String[]args) {
		
			UdpClient udpClient = new UdpClient();
			UdpServer server = new UdpServer();
                        
                        
			try
			{
                		udpClient.go();
                                server.go2();
				}
				catch(Exception e) {
				
				System.out.println("Exception occured with socket.");
				System.out.println(e);
				System.exit(1);
				}
				}
}
