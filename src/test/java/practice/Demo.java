package practice;

public class Demo {

	public static void main(String[] args) {

		String str = "?1,48,324";
		String newstr=str.replaceAll("[^a-zA-Z0-9]","");

		System.out.println(newstr);
		System.out.println("hiiii..args.");

		//		String str2=newstr.replaceAll(",", "");
		//		System.out.println(str2);
		//
		//		String arr[]=str2.split("?");
		//		
		//		System.out.println(arr[0]+"  "+arr[1]);

	}
}
