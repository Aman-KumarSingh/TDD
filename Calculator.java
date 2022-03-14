import java.util.*;
import java.lang.*;
class UserDefinedException extends Exception  
{  
    public UserDefinedException(String str)  
    {  
        super(str);  
    }  
}  
class Calculator{
	public static int extractNumber(final String str) {                
		int []arr=new int[str.length()];
		if(str == null || str.isEmpty()) return 0;
		int j=0;
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		for(int x=0;x<str.length();x++){
			try{
				if(str.charAt(x)=='-' && x!=str.length()-1)
					if(Character.isDigit(str.charAt(x+1))){
						 throw new UserDefinedException("Negatives not allowed");  
					}
			}catch(UserDefinedException e){
				System.out.println(e.toString());
				return 0;
			}
			if(Character.isDigit(str.charAt(x))){
				sb.append(str.charAt(x));
				found = true;
			} else if(found){
				arr[j]=Integer.parseInt(sb.toString());
				j++;
				sb.delete(0, sb.length());
				found=false;
			}
		}
		if(found){
			arr[j]=Integer.parseInt(sb.toString());
			j++;
			sb.delete(0, sb.length());
			found=false;
        }
		int sum=0;
		for(int k=0;k<=j;k++){
			sum+=arr[k];
		}
		return sum;
	}
	
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.print(extractNumber(str));
	}
}