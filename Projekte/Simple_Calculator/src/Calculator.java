import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) throws Exception
	{
		while (true)
		{
			try
			{
				printGreeting();
				
				int first_number = requestInteger();
				int second_number = requestInteger();
				String operation = requestOperation();
				
				float result = performOperation(first_number, second_number, operation);
				System.out.println("Ergebnis: " + Float.toString(result));
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void printGreeting()
	{
		String greeting = "------- SimpleCalculator -------";
		System.out.println(greeting);
	}
	
	public static int requestInteger()
	{
		Scanner sc = new Scanner(System.in);
	    System.out.print("Gib eine Zahl ein: ");
	    String value = sc.next();
	    int number =  Integer.parseInt(value);
	    return number;
	}
	
	public static String requestOperation()
	{
		Scanner sc = new Scanner(System.in);
	    System.out.print("Wähle eine Operation (+,-,*,/): ");
	    String value = sc.next();
	    return value;
	}
	
	public static float performOperation(int first, int second, String operation) throws Exception
	{
		float result = 0;
		switch(operation)
		{
			case "-":
				result = subtract(first, second);
				break;
			case "+":
				result = add(first, second);
				break;
			case "*":
				result = multiply(first, second);
				break;
			case "/":
				result = multiply(first, second);
				break;
			default:
				throw new OperationUnknownException(">> Error: Operation unbekannt!");
		}
		return result;
	}
	
	public static float multiply(int first, int second)
	{
		return first * second;
	}
	
	public static float add(int first, int second)
	{
		return first + second;
	}
	
	public static float subtract(int first, int second)
	{
		return first - second;
	}
	
	public static int divide(int first, int second) throws CalculationException
	{
		if (second == 0)
			throw new CalculationException(">> Error: teilen durch 0!");
		else
			return first % second;
	}
	
}
