import java.util.*;

public class Student{
	String program_name;
    String year;
    double student_avg = 0.0;
    String supervisor;
    String undergraduate_school;
    boolean isPhd = (1 == 2);
    boolean isMasters = (1 ==2);
    String lastName;

    public boolean get_isMasters()
	{
		return isMasters;
	}

	public void set_isMasters(boolean local_isMasters)
	{
		isMasters = local_isMasters;
	}
    
    public String get_lastName()
	{
		return lastName;
	}

	public void set_lastName(String local_last_name)
	{
		lastName = local_last_name;
	}

    public String get_supervisor()
	{
		return supervisor;
	}

	public void set_supervisor(String name)
	{
		supervisor = name;
	}

	public String get_undergraduate_school()
	{
		return undergraduate_school;
	}

	public void set_undergraduate_school(String name)
	{
		undergraduate_school = name;
	}

	public boolean get_isPhd()
	{
		return isPhd;
	}

	public void set_isPhd(boolean local_isPhd)
	{
		isPhd = local_isPhd;
	}

    public String get_program_name()
	{
		return program_name;
	}

	public void set_program_name(String name)
	{
		program_name = name;
	}

	public void set_year(String localyear)
	{
        year = localyear;
	}
	
	public String get_year()
	{
		return year;
	}
	
	public double get_avg()
	{
		return student_avg;
	}

	public void set_avg(double avg)
	{
		student_avg = avg;
	}

    public String toString(){

    	if(isPhd)
    	{
    	    if(undergraduate_school == null)
    	    {
    	        String message;
                String avg = String.valueOf(student_avg);
                message = "\n\nProgram: " + program_name +"\nYear: "+year+"\nAvg Grade: "+avg+"\nSupervisor: "+supervisor+"\nisPhd = true\nDid not mention the undergraduate school\nLast name: "+lastName;
    	        return message;
    	    }
    	    else
    	    {
    	    	String message;
                String avg = String.valueOf(student_avg);
                message = "\n\nProgram: " + program_name +"\nYear: "+year+"\nAvg Grade: "+avg+"\nSupervisor: "+supervisor+"\nisPhd = true\nundergraduate school: "+undergraduate_school +"\nlastName: "+lastName;
    	        return message;
    	    }
    	}
    	else if(isMasters)
    	{
    		if(undergraduate_school == null)
    		{
    			String message;
                String avg = String.valueOf(student_avg);
                message = "\n\nProgram: " + program_name +"\nYear: "+year+"\nAvg Grade: "+avg+"\nSupervisor: "+supervisor+"\nisMasters = true\nDid not mention the undergraduate school\nLast name: "+lastName;
                return message;
    		}
    		else
    		{
    			String message;
                String avg = String.valueOf(student_avg);
                message = "\n\nProgram: " + program_name +"\nYear: "+year+"\nAvg Grade: "+avg+"\nSupervisor: "+supervisor+"\nisMasters = true\nundergraduate school: "+undergraduate_school +"\nlastName: "+lastName;
                return message;
    		}
    	}

    	else
    	{
    		String message;
            String avg = String.valueOf(student_avg);
            message = "\n\nProgram: "+program_name+"\nYear: "+year+"\nAvg Grade: "+avg+"\nLast name: "+lastName;
    	    return message;
    	}

    }

    public Student(){

    }

    public Student(String name){
            program_name = name;
    }

    public Student(String name, String year){
            program_name = name;
            this.year = year;
    }

    public Student(String name, String year, double avg) throws Exception{
        if(avg >= 0 && avg <= 100 )
        {
        	program_name = name;
            this.year = year;
            student_avg = avg;
        }
        else
        {
        	throw new Exception("Average cannot be negative or more that 100");
        }
    }
    public Student(String name, String year, double avg, String supervisor) throws Exception{
        if(avg >= 0 && avg <= 100 )
        {
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
        }
        else
        {
        	throw new Exception("Average cannot be negative or more that 100");
        }
    }
    public Student(String name, String year, double avg, String supervisor,int check) throws Exception{
        if(avg < 0 || avg > 100)
        {
        	throw new Exception("Average cannot be negative or greater than 100");
        }
        if(check == 0)
        {
        	isMasters = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
        }
        else if(check == 1)
        {
        	isPhd = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
        }
        else
        {
        	throw new Exception("Error: vairable is Phd can either be 0 or 1");
        }
    }
    public Student(String name, String year, double avg, String supervisor,int check,String school_name) throws Exception{
        if(avg < 0 || avg > 100)
        {
        	throw new Exception("Average cannot be negative or greater than 100");
        }
        if(check == 0)
        {
        	isMasters = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
            undergraduate_school = school_name;
        }
        else if(check == 1)
        {
        	isPhd = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
            undergraduate_school = school_name;
        }
        else
        {
        	throw new Exception("Error: vairable is Phd can either be 0 or 1");
        }
    }
    public Student(String name, String year, double avg, String supervisor,int check,String school_name,String lastName) throws Exception{
        if(avg < 0 || avg > 100)
        {
        	throw new Exception("Average cannot be negative or greater than 100");
        }
        if(check == 0)
        {
        	isMasters = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
            undergraduate_school = school_name;
            this.lastName = lastName;
        }
        else if(check == 1)
        {
        	isPhd = (1==1);
        	program_name = name;
            this.year = year;
            student_avg = avg;
            this.supervisor = supervisor;
            undergraduate_school = school_name;
            this.lastName = lastName;
        }
        else
        {
        	throw new Exception("Error: vairable is Phd can either be 0 or 1");
        }
    }

}