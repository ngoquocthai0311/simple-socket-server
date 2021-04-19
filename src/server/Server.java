package server;

import java.net.*;

import model.Database;
import model.Student;

import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(4999);
        Socket socket = ss.accept();

        System.out.println("client connected");

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client: " + str);
        
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
			Student student = (Student) objectInputStream.readObject();
//			Database db = new Database();
//			int code = db.insertStudent(student);
//			if (code == 0) {
//				System.out.println("can not insert the student's info");
//			}
			System.out.println("Inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
