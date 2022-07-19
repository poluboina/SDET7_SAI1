package parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class para extends para_Annotations{
@Parameters("username")
	@Test
	public void para1(String Username)
	{
		System.out.println(Username);
	}

}



