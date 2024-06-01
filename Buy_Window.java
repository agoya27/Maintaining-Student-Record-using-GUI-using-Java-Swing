import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Buy_Window extends JFrame{

	private JLabel headerLabel;
  private JPanel controlPanel;
  private JTextField program_name;
  String my_program_name;
  private JTextField program_year;
  String my_program_year;
  private JTextField stud_avg;
  String student_avg;
  double my_student_avg = 0;
  double my_stud_avg = 0;
  private JTextField last_name;
  String my_last_name;
  int studentcount = 0;
  HashMap<String,Student> my_map;
  ArrayList <Student> my_array;
	public Buy_Window(ArrayList <Student> my_array, HashMap<String,Student> my_map)
	{
      super();
      this.my_array = my_array;
      this.my_map = my_map;
      make_my_gui();
      make_grid_layout();
	}
    
    private void make_my_gui()
    {
    	  setTitle("Entering new student information");
        setSize(600, 600);
        setLayout(new GridLayout(10, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton student = new JButton("Add Student to Portfolio");
        MyListener s = new MyListener();
        student.addActionListener(s);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton grad_stud = new JButton("Make new Graduate Student");
        MygradListener n = new MygradListener();
        grad_stud.addActionListener(n);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton print_stud = new JButton("print stud info");
        MyprintListener z = new MyprintListener();
        print_stud.addActionListener(z);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton print_avg = new JButton("Print average of class");
        MyavgListener a = new MyavgListener();
        print_avg.addActionListener(a);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton read_input = new JButton("Please read input from file");
        MyreadinputListener b = new MyreadinputListener();
        read_input.addActionListener(b);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton print_output = new JButton("Print output to a file");
        MyprintoutputListener c = new MyprintoutputListener();
        print_output.addActionListener(c);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton search = new JButton("Search using Hashmap");
        MysearchListener d = new MysearchListener();
        search.addActionListener(d);

        headerLabel = new JLabel("", JLabel.CENTER);
        JButton end_program = new JButton("End the program");
        MyendprogramListener f = new MyendprogramListener();
        end_program.addActionListener(f);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout()); 
        // Flowlayout simply lays out components in a single row

        add(headerLabel);
        add(controlPanel);
        add(student);
        add(grad_stud);
        add(print_stud);
        add(print_avg);
        add(read_input);
        add(print_output);
        add(search);
        add(end_program);
    }

    private void make_grid_layout()
    {
    	headerLabel.setText("Please fill the information below and press Add student");

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(500, 500);

        //Creating the layout where the buttons are to be placed
        GridLayout layout = new GridLayout(2,2);
        program_name = new JTextField("Enter Program name here",30);
        program_year = new JTextField("Enter Program year here",30);
        stud_avg = new JTextField("Enter Student avg here");
        last_name = new JTextField("Enter Last name here");
        panel.setLayout(layout);
        panel.add(last_name);
        panel.add(stud_avg);
        panel.add(program_year);
        panel.add(program_name);
        controlPanel.add(panel);
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

    private class MyListener implements ActionListener 
    {
      public void actionPerformed(ActionEvent e) 
      {
          my_program_name = program_name.getText();
          int prog_year = 0;
          my_last_name = last_name.getText();
          my_program_year = program_year.getText();
          student_avg = stud_avg.getText();
          boolean error_exist = false;

          if(my_program_name.isEmpty())
          {
              error_exist = true;
              headerLabel.setText("Invalid program name");    
          }
          if(my_last_name.isEmpty())
          {
            error_exist = true;
            headerLabel.setText("Invalid last name");
          }
          if(my_program_year.isEmpty())
          {
            error_exist = true;
            headerLabel.setText("Invalid Program year");
          }
          else
          {
            try
            {
               prog_year = Integer.parseInt(my_program_year);
               if(prog_year < 0)
               {
                error_exist = true;
                headerLabel.setText("Invalid program_year");
               }
            }
            catch(Exception ece)
            {
              error_exist = true;
              headerLabel.setText("Invalid program year");
            }
          }
          if(student_avg.isEmpty() == false)
          {
          	try
          	{
          		my_stud_avg = Double.parseDouble(student_avg);
          		if(my_stud_avg >= 0 && my_stud_avg <= 100)
          		{
          			my_student_avg = my_stud_avg;
          		}
          		else
          		{
          			headerLabel.setText("You did not enter valid student average");
                error_exist = true;
          		}
          	}
          	catch(Exception error)
          	{
          		headerLabel.setText("You did not enter valid student avg");
              error_exist = true;
          	}

          }
          if(error_exist == false)
          {
              String my_key = (my_program_name+my_program_year+my_last_name).toLowerCase();
              if(my_map.containsKey(my_key))
              {
                headerLabel.setText("Student information already in list, cannot be added again");
              }
              else
              {
                 if(student_avg.isEmpty())
                 {
                     int my_position = my_array.size();
                     my_array.add(new Student());
                     my_array.get(my_position).set_program_name(my_program_name);
                     my_array.get(my_position).set_year(my_program_year);
                     my_array.get(my_position).set_lastName(my_last_name);
                     my_map.put(my_key,my_array.get(my_position));
                     headerLabel.setText("Student added to list");
                 }
                 else
                 {
                      int my_position = my_array.size();
                      my_array.add(new Student());
                      my_array.get(my_position).set_program_name(my_program_name);
                      my_array.get(my_position).set_year(my_program_year);
                      my_array.get(my_position).set_lastName(my_last_name);
                      my_array.get(my_position).set_avg(my_stud_avg);
                      my_map.put(my_key,my_array.get(my_position));
                      headerLabel.setText("Student added to list");
                 }
              }
          }
      }
   }
}