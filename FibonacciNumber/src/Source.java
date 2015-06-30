import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


public class Source {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		BigInteger n = scanner.nextBigInteger();
		BigInteger module = scanner.nextBigInteger();
		writer.println(Fibonacci.Calculate(n, module));
		writer.close();
	}

}
