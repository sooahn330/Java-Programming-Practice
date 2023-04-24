import java.util.Scanner;

class OutOfRangeException extends Exception {
    public OutOfRangeException() {
        super("OutOfRangeException");
    }
}

class AddZeroException extends Exception {
    public AddZeroException() {
    	super("AddZeroException");
    }
}

class SubtractZeroException extends Exception {
   
	public SubtractZeroException() {
    	super("SubtractZeroException");
    }
}

public class SimCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        calculator(input);
    }

    public static void calculator(String input) {
        try {
        	//System.out.println(input);
        	String[] ex = null;
            if (input.contains("-")) {
                ex = input.split("-");
            }
            else if (input.contains("+")) {
            	ex = input.split("\\+");
            }
            int a = Integer.parseInt(ex[0]);
            int b = Integer.parseInt(ex[1]);
           
            String operator = input.contains("-") ? "-" : "+";
            
            if (a == 0 || b == 0) {
                if (operator.equals("+")) {
                    throw new AddZeroException();
                } else {
                    throw new SubtractZeroException();
                }
            }
            if(a < 0 || a> 1000 || b < 0 || b> 1000)
            	throw new OutOfRangeException();
            int result = 0;
           // System.out.println(operator);
            if(operator.equals("+")) {
            	result = a + b;
            }
            else  {
            	result = a - b;
            }
     
            
            if (result < 0 || result > 1000) {
                throw new OutOfRangeException();
            }
            
            System.out.println(result);
        } catch (AddZeroException e) {
            System.out.println(e.getMessage());
        }catch (SubtractZeroException e) {
            System.out.println(e.getMessage());
        }
        catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
