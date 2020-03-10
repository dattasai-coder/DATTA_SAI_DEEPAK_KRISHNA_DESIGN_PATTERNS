package designpatterns;
import java.io.BufferedReader;
import java.io.InputStreamReader;

interface Strategy {  
        public int shift(int a, int b);  
}
class LeftShift implements Strategy{  
	public int shift(int a, int b) {  
        return a<<b;  
    }  
}
class RightShift implements Strategy{  
	public int shift(int a, int b) {  
        return a>>b;  
    }
}

class Context {
    private Strategy strategy;  
    public Context(Strategy strategy){  
       this.strategy = strategy;  
    }  
    public int executeStrategy(int num1, int num2){
       return strategy.shift(num1, num2);  
    }
}
public class StrategyPattern {
    public static void main(String[] args) throws Exception {  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        System.out.print("Enter value to be shifted: ");  
        int value1=Integer.parseInt(br.readLine());  
        System.out.print("Enter Shifting value: ");  
        int value2=Integer.parseInt(br.readLine());  
        Context context = new Context(new RightShift());          
        System.out.println("After Right Shift  = " + context.executeStrategy(value1, value2));  
        context = new Context(new LeftShift());       
        System.out.println("After Left Shift  = " + context.executeStrategy(value1, value2));  
     }  

}
