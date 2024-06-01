import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class My_Main extends JFrame{

   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JTextArea theText;
   private static My_Main mymain;
   ArrayList <Student> my_array = new ArrayList<Student>();
   HashMap<String,Student> my_map = new HashMap<String,Student>();
   int studentcount = 0;

   private class MyprintListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Print_Window open_printing_window = new Print_Window(my_array,my_map);
          open_printing_window.setVisible(true);
      }
   }

    private class MyavgListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Avg_Window open_avg_window = new Avg_Window(my_array,my_map);
          open_avg_window.setVisible(true);
      }
   }
    private class MygradListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          New_Grad_Stud open_grad_window = new New_Grad_Stud(my_array,my_map);
          open_grad_window.setVisible(true);
      }
   }

   private class MyreadinputListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Read_Window open_read_window = new Read_Window(my_array,my_map);
          open_read_window.setVisible(true);
      }
   }

   private class MyprintoutputListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Print_to_file_Window open_print_window = new Print_to_file_Window(my_array,my_map);
          open_print_window.setVisible(true);
      }
   }

   private class MysearchListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Search_Window open_search_window = new Search_Window(my_array,my_map);
          open_search_window.setVisible(true);
      }
   }

   private class MyendprogramListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }

    private class MyListener implements ActionListener {
      public void actionPerformed(ActionEvent e) 
      {
          dispose();
          Buy_Window open_buy_window = new Buy_Window(my_array,my_map);  
          open_buy_window.setVisible(true); 
     }
  }

   public My_Main() {
      super();
      prepareGUI();
      showBorderLayout();
   }

   private void prepareGUI() {
      setTitle("My Student Portfolio");
      setSize(600, 600);
      setLayout(new GridLayout(4, 1));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("The status Label", JLabel.CENTER);
      statusLabel.setSize(350, 100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout()); 

      theText = new JTextArea("Enter text here",5,20);
      // Flowlayout simply lays out components in a single row

      add(headerLabel);
      add(controlPanel);
      add(theText);
      add(statusLabel);
   }

   private void showBorderLayout() {
      headerLabel.setText("Welcome to the Student Portfolio, Please choose one of options given below");

      JPanel panel = new JPanel();
      panel.setBackground(Color.darkGray);
      panel.setSize(500, 500);

      //Creating the layout where the buttons are to be placed
      GridLayout layout = new GridLayout(4,2);
      
      JButton student = new JButton("Enter information for new Student");
      MyListener s = new MyListener();
      student.addActionListener(s);

      JButton grad_student = new JButton("Enter information for new Graduate student");
      MygradListener n = new MygradListener();
      grad_student.addActionListener(n);

      JButton print_stud_info = new JButton("Print Information of all the Students in Portfolio");
      MyprintListener m = new MyprintListener();
      print_stud_info.addActionListener(m);

      JButton print_stud_avg = new JButton("Print average of all the Students in Portfolio");
      MyavgListener l = new MyavgListener();
      print_stud_avg.addActionListener(l);

      JButton read_input_file = new JButton("Read input from a file");
      MyreadinputListener k = new MyreadinputListener();
      read_input_file.addActionListener(k);

      JButton print_output_file = new JButton("Print Information to a file");
      MyprintoutputListener o = new MyprintoutputListener();
      print_output_file.addActionListener(o);

      JButton lookup_via_hashmap = new JButton("Lookup via a HashMap Key");
      MysearchListener y= new MysearchListener();
      lookup_via_hashmap.addActionListener(y);

      JButton end_my_program = new JButton("End th Program");
      MyendprogramListener z = new MyendprogramListener();
      end_my_program.addActionListener(z);

      panel.setLayout(layout);
      panel.add(student);
      panel.add(grad_student);
      panel.add(print_stud_info);
      panel.add(print_stud_avg);
      panel.add(read_input_file);
      panel.add(print_output_file);
      panel.add(lookup_via_hashmap);
      panel.add(end_my_program);


      controlPanel.add(panel);
   }

   public static void main(String[] args) {
      mymain = new My_Main();
      mymain.setVisible(true);
   }
}

