import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Search_Window extends JFrame
{
     HashMap<String,Student> my_map;
    ArrayList <Student> my_array;
     private JLabel headerLabel;
    JTextArea my_text_box;
    private JPanel controlPanel;
    private JPanel button_Panel;
    private JTextField program_name;    
    private JTextField program_year;    
    private JTextField last_name;
	public Search_Window(ArrayList <Student> my_array, HashMap<String,Student> my_map)
    {
      super();
      this.my_array = my_array;
      this.my_map = my_map;
      make_my_gui();
      make_grid_layout();
    }	

    private void make_my_gui()
    {
    	setTitle("Search a student");                                        //Setting the title for JFrame window
        setSize(500,500);                                              //Setting the size of JFrame Window
        setLayout(new GridLayout(4, 1));                               //Creating a gridlayout ot add functionality to JFRAME in top down order by having 5 rows and  1 column
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                //Applying default close operation for the JFrame

        headerLabel = new JLabel("", JLabel.CENTER);

        my_text_box = new JTextArea(5,30);                             //Creating a JText area to print the results of buying 
        JScrollPane scrolledText = new JScrollPane(my_text_box);       //Enabling scrollbars on the the text box created above
        scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); //Adding a horizontal scroll bar
        scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        controlPanel = new JPanel();                                   //Creating a new panel to add the control panel at the top of the frame
        controlPanel.setLayout(new FlowLayout());

        button_Panel = new JPanel();                                   //Creating a new panel to add the control panel at the top of the frame
        button_Panel.setLayout(new FlowLayout());

        add(headerLabel);
        add(button_Panel);
        add(scrolledText);
        add(controlPanel);
    }

    private void make_grid_layout()
    {
    	headerLabel.setText("Printing student information"); 

    	JPanel panel = new JPanel();                 //Creating a new panel to add the header label for all textfields
        panel.setBackground(Color.darkGray);         //Setting the background colour and size of panel created above
        panel.setSize(500, 500);

        JPanel newpanel = new JPanel();                 //Creating a new panel to add the header label for all textfields
        newpanel.setBackground(Color.darkGray);         //Setting the background colour and size of panel created above
        newpanel.setSize(500, 500);

        GridLayout button_layout = new GridLayout(8,1);
        GridLayout infolayout = new GridLayout(3,1);

        JButton student = new JButton("Add Student to Portfolio");
        MyListener s = new MyListener();
        student.addActionListener(s);
   
        JButton grad_stud = new JButton("Make new Graduate Student");
        MygradListener n = new MygradListener();
        grad_stud.addActionListener(n);

        JButton print_stud = new JButton("print stud info");
        MyprintListener z = new MyprintListener();
        print_stud.addActionListener(z);

        JButton print_avg = new JButton("Print average of class");
        MyavgListener a = new MyavgListener();
        print_avg.addActionListener(a);

        JButton read_input = new JButton("Please read input from file");
        MyreadinputListener b = new MyreadinputListener();
        read_input.addActionListener(b);

        JButton print_output = new JButton("Print output to a file");
        MyprintoutputListener c = new MyprintoutputListener();
        print_output.addActionListener(c);

        JButton search = new JButton("Search using Hashmap");
        MysearchListener d = new MysearchListener();
        search.addActionListener(d);

        JButton end_program = new JButton("End the program");
        MyendprogramListener f = new MyendprogramListener();
        end_program.addActionListener(f);

        program_name = new JTextField("Enter name of program");
        program_year = new JTextField("Enter program year here");
        last_name = new JTextField("Enter last name here");

        newpanel.setLayout(infolayout);
        newpanel.add(program_name);
        newpanel.add(program_year);
        newpanel.add(last_name);

        panel.setLayout(button_layout); 
        panel.add(search);
        panel.add(student);
        panel.add(grad_stud);
        panel.add(print_stud);
        panel.add(read_input);
        panel.add(print_output);
        panel.add(print_avg);
        panel.add(end_program);

        controlPanel.add(panel);
        button_Panel.add(newpanel);
    }

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
          String name = program_name.getText();
          String year = program_year.getText();
          String last = last_name.getText();
          boolean error_exist = false;
          if(name.isEmpty())
          {
          	my_text_box.setText("Name should be provided for search funcion");
          	error_exist = true;
          }
          if(year.isEmpty())
          {
          	my_text_box.setText("Year should be provided for search function");
          	error_exist = true;
          }
          if(last.isEmpty())
          {
          	my_text_box.setText("Last name should be provided for search function");
          	error_exist = true;
          }
          if(error_exist == false)
          {
          	    String my_key = (name.toLowerCase())+(year.toLowerCase())+(last.toLowerCase());
          	    if(my_map.containsKey(my_key))
          	    {
                     String student_info = my_map.get(my_key).toString();
                     my_text_box.setText(student_info);
          	    }
          	    else
          	    {
          	    	my_text_box.setText("The student does not exist in the list");
          	    }
          }
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

}