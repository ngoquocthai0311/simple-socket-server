package test;

import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        
        
        
        pr.println("hello from client");
        
        pr.flush();
	}

}
