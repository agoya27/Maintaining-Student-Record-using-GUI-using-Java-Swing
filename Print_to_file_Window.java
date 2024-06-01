import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Print_to_file_Window extends JFrame
{
	HashMap<String,Student> my_map;
    ArrayList <Student> my_array;
     private JLabel headerLabel;
    JTextArea my_text_box;
    private JPanel controlPanel;
     private JPanel inputPanel;
     private JTextField file_output;
	public Print_to_file_Window(ArrayList <Student> my_array, HashMap<String,Student> my_map)
    {
      super();
      this.my_array = my_array;
      this.my_map = my_map;
      make_my_gui();
      make_grid_layout();
    }

     private void make_my_gui()
    {
    	setTitle("Print information to student");                                        //Setting the title for JFrame window
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

        inputPanel = new JPanel();                                   //Creating a new panel to add the control panel at the top of the frame
       inputPanel.setLayout(new FlowLayout());

        add(headerLabel);
        add(inputPanel);
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
        GridLayout infolayout = new GridLayout(1,1);

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

        file_output = new JTextField("Enter file name here",30);

        newpanel.setLayout(infolayout);
        newpanel.add(file_output);

        panel.setLayout(button_layout); 
        panel.add(print_output);
        panel.add(search);
        panel.add(student);
        panel.add(grad_stud);
        panel.add(print_stud);
        panel.add(read_input);
        panel.add(print_avg);
        panel.add(end_program);

        controlPanel.add(panel);
       inputPanel.add(newpanel);
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
          String file_name = file_output.getText();
          if(file_name.isEmpty())
          {
          	my_text_box.setText("Please enter the name of the file");
          }
          else
          {
          	   try
          	   {
                    PrintWriter write_to_file = new PrintWriter(file_name, "UTF-8");
                    for(int i=0; i<my_array.size();i++)
                    {
                    	if(my_array.get(i).get_isPhd())
         	              {
                               if(my_array.get(i).get_undergraduate_school() == null)
                               {
                                    String name_of_program = my_array.get(i).get_program_name();
                                    String year = my_array.get(i).get_year();
                                    double avg = my_array.get(i).get_avg();
                                    String average = String.valueOf(avg);
                                    String supervisor = my_array.get(i).get_supervisor();
                                    String last_name = my_array.get(i).get_lastName();
                                    write_to_file.println(name_of_program +" "+year+" "+average+" "+supervisor+" 1 "+last_name);
                               }
                               else
                               {
                                    String name_of_program = my_array.get(i).get_program_name();
                                    String year = my_array.get(i).get_year();
                                    double avg = my_array.get(i).get_avg();
                                    String average = String.valueOf(avg);
                                    String supervisor = my_array.get(i).get_supervisor();
                                    String last_name = my_array.get(i).get_lastName();
                                    String school_name = my_array.get(i).get_undergraduate_school();
                                    write_to_file.println(name_of_program +" "+year+" "+average+" "+supervisor+" 1 "+school_name+" "+last_name);
                               }
         	              }
         	            else if(my_array.get(i).get_isMasters())
         	            {
                               if(my_array.get(i).get_undergraduate_school() == null)
                               {
                                    String name_of_program = my_array.get(i).get_program_name();
                                    String year = my_array.get(i).get_year();
                                    double avg = my_array.get(i).get_avg();
                                    String average = String.valueOf(avg);
                                    String supervisor = my_array.get(i).get_supervisor();
                                    String last_name = my_array.get(i).get_lastName();
                                    write_to_file.println(name_of_program +" "+year+" "+average+" "+supervisor+" 0 "+last_name);
                               }
                               else
                               {
                                    String name_of_program = my_array.get(i).get_program_name();
                                    String year = my_array.get(i).get_year();
                                    double avg = my_array.get(i).get_avg();
                                    String average = String.valueOf(avg);
                                    String supervisor = my_array.get(i).get_supervisor();
                                    String last_name = my_array.get(i).get_lastName();
                                    String school_name = my_array.get(i).get_undergraduate_school();
                                    write_to_file.println(name_of_program +" "+year+" "+average+" "+supervisor+" 0 "+school_name+" "+last_name);
                               }
                          }
                          else
                          {
                          	    String name_of_program = my_array.get(i).get_program_name();
                                String year = my_array.get(i).get_year();
                                double avg = my_array.get(i).get_avg();
                                String average = String.valueOf(avg);
                                String last_name = my_array.get(i).get_lastName();
                                write_to_file.println(name_of_program+" "+year+" "+average+" "+last_name);
                          }
                    }
                    write_to_file.close();
          	   }
          	   catch(Exception ece)
          	   {
          	   	    my_text_box.setText("Could not write into the file");
          	   }
          }
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
}