/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resposisocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author aerdy
 */
public class ConnServer {
    public String ip = "127.0.0.1";
	public int port = 123;
	public ConnServer() {
    }
    public void startServer() {
        try{
           ServerSocket ss = new ServerSocket(51234);
            while (true) {
              try {
		Socket socket = ss.accept();
                System.out.println("Got a connection");
                ServerChild child = new ServerChild(socket);
                child.start();
              } catch (Exception ex) {
               	   System.out.println("client disconnected");
                }
            }
         } catch (Exception ex){
            ex.printStackTrace();
           }
     }
    
    class ServerChild extends Thread{
        Socket soc;
        ServerChild (Socket p_soc){
            soc = p_soc;
        }
        public void run(){
            try{
                DataInputStream dis = new DataInputStream(soc.getInputStream());
                while (true) {
                    String text = dis.readUTF();
                    System.out.println("Received from :/" + text);
                }
             } catch (Exception ex){
                 System.out.println("Connection closed");
               }
        }
    }
    
    // client
    
        public void startClient() {
        try {
            Socket socket = new Socket(ip,port); 
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            for (int i = 0; i < 20; i++){
                dos.writeUTF("This is client? count:" +i);
                Thread.sleep(1000);
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String [] args) {
        new ConnServer().startServer();
        new ConnServer().startClient();
    }
}
