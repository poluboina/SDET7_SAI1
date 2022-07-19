package parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class para1 extends para_Annotations {
	@Parameters("password")
	@Test
	public void para2(String Password)
	{
		System.out.println(Password);
	}

}
