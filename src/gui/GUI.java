package gui;

import java.net.*;
import java.io.*;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Student;

public class GUI extends Frame{
	
	private TextField tfNameInput;
	private TextField tfIdInput;
	private TextField tfYearInput;
	private TextField tfGenderInput;
	private Button submit;
	private Button clear;
	private static Socket socket;
	
	public GUI() { 
		addWindowListener(new WindowAdapter(){  
	          public void windowClosing(WindowEvent e) {  
	              dispose();  
	          }  
	      });  
	   
		setLayout(new GridLayout(5, 2, 3, 3));
		
		add(new Label("Name"));
		tfNameInput = new TextField();
		add(tfNameInput);
		
		add(new Label("ID"));
		tfIdInput = new TextField();
		add(tfIdInput);
		
		add(new Label("Year"));
		tfYearInput = new TextField();
		add(tfYearInput);
		
		add(new Label("Gender"));
		tfGenderInput = new TextField();
		add(tfGenderInput);
		
		submit = new Button("Submit");
		clear = new Button("Clear");
		add(submit);
		add(clear);
		
		// add event handler 
		submit.addActionListener(new SubmitButtonListener());
		
		setTitle("simple socket server");
		setSize(500,200);
		setVisible(true);
	}
	
	static void setUpConnectionToServer() throws IOException{
		socket = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("hello from client");
        pr.flush();
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			setUpConnectionToServer();
			new GUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	private class SubmitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){			
			Student student = new Student(
					tfNameInput.getText(),
					tfIdInput.getText(),
					tfYearInput.getText(),
					tfGenderInput.getText());
			
			// pass object to server
			OutputStream outputStream;
			try {
				outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(student);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

}
