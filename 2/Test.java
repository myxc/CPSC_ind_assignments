public class Test 
{
	public int a = 1;
	public int b = 1234;
		public String c = "Nig Nog";
	public String returString()
	{
		
		String d = c + a + b;
		return d;
	}

	public static void main(String[] args)
	{
		Test aObject = new Test();
		System.out.print(aObject.returString().type());
	}
}
