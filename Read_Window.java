import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Read_Window extends JFrame
{
	HashMap<String,Student> my_map;
    ArrayList <Student> my_array;
    private JLabel headerLabel;
    JTextArea my_text_box;
    private JPanel controlPanel;
    private JPanel inputPanel;
    private JTextField file_input;
	public Read_Window(ArrayList <Student> my_array, HashMap<String,Student> my_map)
    {
      super();
      this.my_array = my_array;
      this.my_map = my_map;
      make_my_gui();
      make_grid_layout();
    }

     private void make_my_gui()
    {
    	setTitle("Take input from file");                                        //Setting the title for JFrame window
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
    	headerLabel.setText("Enter the name of the file is the space below"); 

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

        file_input = new JTextField("Enter file name here",30);

        newpanel.setLayout(infolayout);
        newpanel.add(file_input);

        panel.setLayout(button_layout); 
        panel.add(read_input);
        panel.add(search);
        panel.add(student);
        panel.add(grad_stud);
        panel.add(print_stud);
        panel.add(print_output);
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
          String file_name = file_input.getText();
          if(file_name.isEmpty())
          {
          	my_text_box.setText("Please enter a name of a file");
          }
          else
          {
          	   int line_number = 0;
          	   try
          	   {
                    File my_file = new File(file_name);
                    Scanner scan_file = new Scanner(my_file);
                    while(scan_file.hasNextLine())
                    {
                    	line_number++;
                    	String line = scan_file.nextLine();
                    	String words[] = line.split("[ ]+");
                    	if(words.length == 3)
                    	{
                    		String my_key_string = words[0] + words[1] + words[2];
                            String my_key = my_key_string.toLowerCase();
                            if(my_map.containsKey(my_key))
                            {
                                my_text_box.setText("Student information on line " + line_number + "was already on list");
                            }
                            else
                            {
                                int studentcount = my_array.size();
                                my_array.add(studentcount,new Student());
         	                    my_array.get(studentcount).set_program_name(words[0]);
         	                    my_array.get(studentcount).set_year(words[1]);
                                my_array.get(studentcount).set_lastName(words[2]);
                                my_map.put(my_key,my_array.get(studentcount));
                            }
                    	}
                    	else if(words.length == 4)
                    	{
                    		String my_key_string = words[0] + words[1] + words[3];
                               String my_key = my_key_string.toLowerCase();
                               if(my_map.containsKey(my_key))
                               {
                                   my_text_box.setText("Student information on line " + line_number + "was already on list");
                               }
                               else
                               {
                                   double localavg;
                                   localavg = Double.parseDouble(words[2]);
                                   if(localavg <0 || localavg >100)
                                   {
                                        my_text_box.setText("Average cannot be negative or greater than 100");
                                   }
                                   else
                                   {
                                        int studentcount = my_array.size();
                                        my_array.add(studentcount,new Student());
                                        my_array.get(studentcount).set_program_name(words[0]);
                                        my_array.get(studentcount).set_year(words[1]);
                                        my_array.get(studentcount).set_avg(localavg);
                                        my_array.get(studentcount).set_lastName(words[3]);
                                        my_map.put(my_key,my_array.get(studentcount));
                                   }
                               }
                    	}
                    	else if(words.length == 6)
                    	{
                    		String my_key_string = words[0]+words[1]+words[5];
                               String my_key = my_key_string.toLowerCase();
                               if(my_map.containsKey(my_key))
                               {
                                   my_text_box.setText("Student information on line " + line_number + "was already on list");
                               }
                               else
                               {
                                   double localavg = Double.parseDouble(words[2]);
                                   if(localavg <0 || localavg >100)
                                   {
                                        my_text_box.setText("Average cannot be negative or greater than 100");
                                   }
                                   else
                                   {
                                        int check = Integer.parseInt(words[4]);
                                        boolean phd_check = (check == 1);
                                        boolean masters_check = (check == 0);
                                        int studentcount = my_array.size();
                                        my_array.add(studentcount,new Student());
                                        my_array.get(studentcount).set_program_name(words[0]);
                                        my_array.get(studentcount).set_year(words[1]);
                                        my_array.get(studentcount).set_avg(localavg);
                                        my_array.get(studentcount).set_supervisor(words[3]);
                                        my_array.get(studentcount).set_isPhd(phd_check);
                                        my_array.get(studentcount).set_isMasters(masters_check);
                                        my_array.get(studentcount).set_lastName(words[5]);
                                        my_map.put(my_key,my_array.get(studentcount));
                                   }
                               }
                    	}
                    	else if(words.length ==7)
                    	{
                    		String my_key_string = words[0]+words[1]+words[6];
                               String my_key = my_key_string.toLowerCase();
                               if(my_map.containsKey(my_key))
                               {
                                   my_text_box.setText("Student information on line " + line_number + "was already on list");
                               }
                               else
                               { 
                                   double localavg;
                                   localavg = Double.parseDouble(words[2]);
                                   if(localavg <0 || localavg >100)
                                   {
                                        my_text_box.setText("Average cannot be negative or greater than 100");
                                   }
                                   else
                                   {
                                        int check = Integer.parseInt(words[4]);
                                        boolean phd_check = (check == 1);
                                        boolean masters_check = (check == 0);
                                        int studentcount = my_array.size();
                                        my_array.add(studentcount,new Student());
                                        my_array.get(studentcount).set_program_name(words[0]);
                                        my_array.get(studentcount).set_year(words[1]);
                                        my_array.get(studentcount).set_avg(localavg);
                                        my_array.get(studentcount).set_supervisor(words[3]);
                                        my_array.get(studentcount).set_isPhd(phd_check);
                                        my_array.get(studentcount).set_undergraduate_school(words[5]);
                                        my_array.get(studentcount).set_isMasters(masters_check);
                                        my_array.get(studentcount).set_lastName(words[6]);
                                        my_map.put(my_key,my_array.get(studentcount));
                                   }
                               }
                    	}
                    	else
                    	{ 
                             my_text_box.setText("Student information on line " + line_number + "was incorrect");
                    	}
                    }
          	   }
          	   catch(Exception ece)
          	   {
          	   	    my_text_box.setText("Could not open the file");
          	   }
          }
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
}