import java.util.Scanner;

public class FloatingPointDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		double inputDouble;
		float inputFloat;
		String binary32, binary64;
		int pick;
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.println("Select either 1 for float to binary(32-bit) or 2 for double to binary (64-bit) \n" 
				+ "or 3 for binary (32-bit) to float or 4 for binary (64-bit) to double : ");
		
		pick = keyboard.nextInt();
		
		if (pick == 1)
		{
			System.out.println("Enter a single precision floating point number: ");
			inputFloat = keyboard.nextFloat();
			
			System.out.println("The binary for this number is " + String.format("%32s", decimalTo32Binary(inputFloat)).replace(' ', '0'));
		}
		
		if (pick == 2)
		{
			System.out.println("Enter a double precision floating point number: ");
			inputDouble = keyboard.nextDouble();
			
			System.out.println("The binary for this number is " + String.format("%64s", decimalTo64Binary(inputDouble)).replace(' ', '0'));
		}
		
		if (pick == 3)
		{
			System.out.println("Enter a 32-bit binary string: ");
			binary32 = keyboard.next();
			
			System.out.println("The binary for this number is " + binary32ToDecimal(binary32));
		}
		
		if (pick == 4)
		{
			System.out.println("Enter a 64-bit binary string: ");
			binary64 = keyboard.next();
			
			
			
			System.out.println("The binary for this number is " + binary64ToDecimal(binary64));
			
			
		}
		
	}
	
	public static String decimalTo64Binary(double dec)
	{
		return Long.toBinaryString(Double.doubleToLongBits(dec));
	}
	
	public static double binary64ToDecimal(String binary64)
	{
		char first = binary64.charAt(0);
		if (first == '1')
		{
			String swap = binary64.replaceFirst("1", "0");
			double plus = Double.longBitsToDouble(Long.parseLong(swap, 2));
			
			return plus * -1;
		}
		
		else
			return Double.longBitsToDouble(Long.parseLong(binary64, 2));
	}
	
	/**
	 * Method to swap dec decimal to binary32 string 
	 * @param dec
	 * @return
	 */
	public static String decimalTo32Binary(float dec)
	{
		return Integer.toBinaryString(Float.floatToIntBits(dec));
	} 
	
	/**
	 * Method to swap binary32 string to dec decimal 
	 * @param dec
	 * @return
	 */
	public static float binary32ToDecimal(String binary32)
	{
		//changes first character in string to "0" if it is "1"
		char first = binary32.charAt(0);
		if (first == '1')
		{
			String swap = binary32.replaceFirst("1", "0");
			float plus = Float.intBitsToFloat(Integer.parseInt(swap, 2));
			//makes it negative 
			return plus * -1;
		}
		else
			return Float.intBitsToFloat(Integer.parseInt(binary32, 2));
	}

}
