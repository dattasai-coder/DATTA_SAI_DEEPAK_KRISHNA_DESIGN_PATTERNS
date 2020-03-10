package designpatterns;
import java.io.IOException;  
import java.util.Scanner;  
interface Prototype {  
	public Prototype getClone();      
}

class StudentRecord implements Prototype{  	      
	private int id;  
	private String name;
	private int sclass;  
	private double salary;  
	private String address;  
	public StudentRecord(){  
		System.out.println("Student Records");  
	}
	
	public  StudentRecord(int id, String name, int sclass, String address) {  
		this();  
		this.id = id;  
		this.name = name;  
		this.sclass = sclass;  
		this.address = address;
	}
			      
	public void showRecord(){  		          
		System.out.println(id+"\t"+name+"\t"+sclass+"\t"+salary+"\t"+address);  
	}
			  
	public Prototype getClone() {  
		return new StudentRecord(id,name,sclass,address);  
	}
}

class PrototypePattern {  
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {  
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student ID number: ");  
	    int StudentNumber=sc.nextInt();
	    System.out.println();
	    System.out.print("Enter Student Name: ");   
	    String StudentName=sc.next(); 
	    System.out.println();  
	    System.out.print("Enter Student Class: ");  
	    int StudentClass=sc.nextInt();  
	    System.out.println();
	    System.out.print("Enter Student Address: ");  
	    String StudentAddress=sc.next();  
	    System.out.println();  
	    StudentRecord s1=new StudentRecord(StudentNumber,StudentName,StudentClass,StudentAddress);  
	    s1.showRecord(); 
	    System.out.println(); 
	    StudentRecord s2=(StudentRecord) s1.getClone();  
	    s2.showRecord();  
	}     
}