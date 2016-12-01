import java.net.*;
import java.io.*;
import java.util.*;

class ServerClass
{
    public static void main(String args[])
    {
        try
        {
            //we need to make 2 sockets for accepting 2 connections.

            ServerSocket serverSoc1 = new ServerSocket(1337);
            Socket server1=serverSoc1.accept();

            ServerSocket serverSoc2 = new ServerSocket(1338);
            Socket server2=serverSoc2.accept();
            
            //first of all you need to be able to accept connections.
            OutputStream out1=server1.getOutputStream();
            DataOutputStream dataOut1=new DataOutputStream(out1);

            InputStream in1=server1.getInputStream();
            DataInputStream dataIn1=new DataInputStream(in1);

            OutputStream out2=server2.getOutputStream();
            DataOutputStream dataOut2=new DataOutputStream(out2);

            InputStream in2=server2.getInputStream();
            DataInputStream dataIn2=new DataInputStream(in2);

            String a;

            while(true)
            {
                //assuming that client1 has sent the data first 
                a=dataIn1.readUTF();
                System.out.println("Message from client 1:"+ a +"\n relaying to client2...");
                dataOut2.writeUTF(a);

                a=dataIn2.readUTF();
                System.out.println("Message from client 2:"+ a +"\n relaying to client1...");
                dataOut1.writeUTF(a);
            }



        }
        catch(UnknownHostException e)
        {
            System.out.println("host not found");
        }
        catch(IOException e)
        {
            System.out.println("IOException detected");
        }
    }
}