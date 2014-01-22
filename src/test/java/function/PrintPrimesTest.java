package function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hongseongmin
 * Date: 2014. 1. 22.
 * Time: 오후 6:00
 * To change this template use File | Settings | File Templates.
 */
public class PrintPrimesTest {
	private PrintStream out;

	@Before
	public void setUp() throws FileNotFoundException {
		out = System.out;
		System.setOut(new PrintStream(new FileOutputStream("lead")));
	}

	@After
	public void tearDown() {
		System.setOut(out);
		new File("lead").delete();
	}


	@Test
	public void makeSureMatchesGold() throws IOException {
		new PrintPrimes().main(new String[0]);
		BufferedReader lead = new BufferedReader(new FileReader("lead"));
		BufferedReader gold = new BufferedReader(new FileReader("src/test/java/function/gold"));
		String line;
		while ((line = gold.readLine()) != null)
			assertEquals(line, lead.readLine());
		assertEquals(null, lead.readLine());
	}
}
