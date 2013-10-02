public class FirstTest{

	public static void main(String args[]){
		System.out.println("Hey..Congratulations you have successfully completed your first build task.");
		int result=0;
		for (int i=0;i<args.length;i++){
			result += Integer.parseInt(args[i]);
		}

	    System.out.println(result);
	}
}