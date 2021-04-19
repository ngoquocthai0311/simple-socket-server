package gui;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

// An AWT program inherits from the top-level container java.awt.Frame
public class AWTCounter extends Frame {
   private Label lblCount;    // Declare a Label component
   private TextField tfCount; // Declare a TextField component
   private Button btnCount;   // Declare a Button component
   private int count = 0;     // Counter's value

   public AWTCounter () {
      setLayout(new FlowLayout());
      addWindowListener(new WindowAdapter(){  
          public void windowClosing(WindowEvent e) {  
              dispose();  
          }  
      });  

      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component

      tfCount = new TextField(count + "", 10); // construct the TextField component with initial text
      tfCount.setEditable(false);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component

      btnCount = new Button("Count");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component

      BtnCountListener listener = new BtnCountListener();
      btnCount.addActionListener(listener);

      setTitle("AWT Counter");  // "super" Frame sets its title
      setSize(300, 100);        // "super" Frame sets its initial window size

     
      setVisible(true);         // "super" Frame shows
     
   }

   // The entry main() method
   public static void main(String[] args) {
      AWTCounter app = new AWTCounter();
   }

   // Define an inner class to handle the "Count" button-click
   private class BtnCountListener implements ActionListener {
      // ActionEvent handler - Called back upon button-click.
      public void actionPerformed(ActionEvent evt) {
         ++count; // Increase the counter value
         // Display the counter value on the TextField tfCount
         tfCount.setText(count + ""); // Convert int to String
      }
   }
}