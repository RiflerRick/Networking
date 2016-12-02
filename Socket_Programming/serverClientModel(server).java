import java.io.*;
import java.net.*;

class serverClass 
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket server=new ServerSocket(1337);
            Socket serverSoc=server.accept();
            OutputStream out=serverSoc.getOutputStream();
            DataOutputStream dataOut=new DataOutputStream(out);
            InputStream in=serverSoc.getInputStream();
            DataInputStream dataIn=new DataInputStream(in);
            //Scanner sc=new Scanner(System.in);
            String a;
            while(true)
            {
                a=dataIn.readUTF();
                if (a.equals("end")==true)
                {
                    break;
                }
                dataOut.writeUTF("ping");

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