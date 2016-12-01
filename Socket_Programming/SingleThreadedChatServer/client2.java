import java.io.*;
import java.util.*;
import java.net.*;

class client2Class
{
    public static void main(String args[])
    {
        try
        {
            Socket clientSoc=new Socket("localhost",1338);
            OutputStream out=clientSoc.getOutputStream();
            DataOutputStream dataOut=new DataOutputStream(out);
            InputStream in=clientSoc.getInputStream();
            DataInputStream dataIn=new DataInputStream(in);
            String a;
            Scanner sc=new Scanner(System.in);
            while(true)
            {
                a=dataIn.readUTF();
                System.out.println("Message from server: "+a);
                System.out.println("Enter a message to send:");
                a=sc.nextLine();
                dataOut.writeUTF(a);
                
            }

        }
        catch(UnknownHostException e)
        {
            System.out.println("unknown host found");

        }
        catch(IOException e)
        {
            System.out.println("IOException occured: "+e.getMessage());
        }
        
    }
}