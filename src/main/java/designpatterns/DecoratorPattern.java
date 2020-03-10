package designpatterns;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Sport {  
    public String game();  
    public double perHour();  
}
class IndoorGames implements Sport{  
    public String game(){  
         return "Carroms";
    }
        public double perHour(){  
        return 1000.0;
    }
}

abstract class MySport implements Sport{  
    private Sport newSport;  
    public MySport(Sport newSport)  {  
        this.newSport=newSport;  
    }   
    public String game(){  
        return newSport.game();   
    }  
    public double perHour(){  
        return newSport.perHour();  
    }  
}

class OutdoorGames extends MySport{    
    public OutdoorGames(Sport newSport) {  
        super(newSport);  
    }  
	public String game() {
		return super.game() +" With Cricket  ";
	}
	public double perHour() {
		return super.perHour()+150.0;
	}  
}

public class DecoratorPattern {
    private static int  choice;  
	public static void main(String args[]) throws NumberFormatException, IOException{
	       do{        
	           System.out.println("Sports");  
	           System.out.println("1. Indoor Games");  
	           System.out.println("2. Outdoor Games");  
	           System.out.println("3. Exit");  
	           System.out.print("Enter your choice: ");  
	           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
	           choice=Integer.parseInt(br.readLine());  
	           switch (choice) {  
	           		case 1:{   
	                 IndoorGames indoor=new IndoorGames();  
	                 		System.out.println(indoor.game());  
	                 		System.out.println(indoor.perHour());  
	               }  
	               break;  
			                 
	           		case 2:{  
	           		  OutdoorGames f1=new OutdoorGames((Sport) new IndoorGames());  
	           		  		System.out.println(f1.game());  
			                System.out.println(f1.perHour());  
			       }  
	           	   break;    
	           		default:{    
	           		  System.out.println("Other than these no Games available");  
			       }         
	           		return;  
			  }	             
               System.out.println("---------------------------------------------------------");  
	           
	   }while(choice!=3);  

}
}
