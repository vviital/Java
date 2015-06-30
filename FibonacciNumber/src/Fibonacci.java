import java.math.BigInteger;

public class Fibonacci {
	public static BigInteger Calculate(BigInteger n, BigInteger module){
		Matrix A = new Matrix(2, 2, module);
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				if (i != 0 || j != 0)
					A.arr[i][j] = BigInteger.ONE;
				else
					A.arr[i][j] = BigInteger.ZERO;
		Matrix X = new Matrix(2, 1, module);
		X.arr[0][0] = BigInteger.ZERO;
		X.arr[1][0] = BigInteger.ONE;
		return A.pow(n).multiply(X).arr[0][0];
	}
}