import java.io.*;
import java.util.*;
import java.net.*;

class clientClass
{
    public static void main(String args[])
    {
        try
        {
            Socket clientSoc=new Socket("localhost",1337);
            OutputStream out=clientSoc.getOutputStream();
            DataOutputStream dataOut=new DataOutputStream(out);
            InputStream in=clientSoc.getInputStream();
            DataInputStream dataIn=new DataInputStream(in);
            Scanner sc=new Scanner(System.in);
            String a;
            while(true)
            {
                System.out.println("Enter a message to send to the server");
                a=sc.nextLine();
                dataOut.writeUTF(a);
                System.out.println("server message:"+dataIn.readUTF());
            }
        }
        catch(UnknownHostException e)
        {
            System.out.println("error: unknown host");
        }
        catch(IOException e)
        {
            System.out.println("IOError");
        }

    }
}