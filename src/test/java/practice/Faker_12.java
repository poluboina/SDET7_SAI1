package practice;

import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class Faker_12 {
	

	public static void main(String[] args) {
		Faker faker=new Faker();
		Random random=new Random();
		int i = random.nextInt(23);
		
		 String orgname = faker.name().firstName();
		 System.out.println(i+""+orgname);
				
		
	}

}
