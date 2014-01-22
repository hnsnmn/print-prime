package function;

import java.io.BufferedReader;
import java.io.FileReader;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hongseongmin
 * Date: 2014. 1. 22.
 * Time: 오후 6:00
 * To change this template use File | Settings | File Templates.
 */
public class FileContentComparator {
	public void compare() {
		try {
			BufferedReader lead = new BufferedReader(new FileReader("lead"));
			BufferedReader gold = new BufferedReader(new FileReader("src/test/java/function/gold"));
			String line;

			while ((line = gold.readLine()) != null)
				assertEquals(line, lead.readLine());
			assertEquals(null, lead.readLine());
		} catch (Exception e) {
			e.printStackTrace();	// To change body of catch statement use File | Settings | File Templates
		}
	}

}
