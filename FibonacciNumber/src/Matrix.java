import java.math.BigInteger;


public class Matrix {
	
	public BigInteger[][] arr;	
	public BigInteger module;
	
	public int n;
	public int m;
	
	
	public Matrix(){
		
	}
	
	public Matrix(int n, int m, BigInteger module){
		arr = new BigInteger[n][m];
		this.n = n;
		this.m = m;
		this.module = module;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				if (i != j){
					arr[i][j] = BigInteger.ZERO;
				} else {
					arr[i][i] = BigInteger.ONE;
				}
		}
	}
	
	public Matrix(Matrix source){
		this.n = source.n;
		this.m = source.m;
		this.arr = source.arr;
		this.module = source.module;
	}
	
	public Matrix multiply(Matrix obj){
		Matrix res = new Matrix(n, obj.m, module);
		for(int i = 0; i < res.n; i++)
			for(int j = 0; j < res.m; j++){
				res.arr[i][j] = BigInteger.ZERO;
				for(int k = 0; k < m; k++){
					BigInteger buffer = arr[i][k].multiply(obj.arr[k][j]);
					BigInteger buffer1 = buffer.add(res.arr[i][j]);
					buffer1.mod(module);
					res.arr[i][j] = res.arr[i][j].add(arr[i][k].multiply(obj.arr[k][j])).mod(module);
				}
			}
		return res;
	}
	
	public Matrix pow(BigInteger p){
		Matrix mul = new Matrix(this);
		Matrix res = new Matrix(this.n, this.m, module);
		while(p.compareTo(BigInteger.ZERO) != 0){
			if (p.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0){
				res = res.multiply(mul);
			}
			mul = mul.multiply(mul);
			p = p.shiftRight(1);
		}
		return res;
	}
}
