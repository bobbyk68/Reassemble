package reassemble.fragment.submission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReassembleTest {
	
	public static void main(String[] args) throws IOException {
		String resourcesFolder = "src/test/resources/" ;
		String file = resourcesFolder + args[0];
		List<String> entries = null;
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			 entries = in.lines().collect(Collectors.toList());
			 System.out.println(entries.size() );
		}
		
		assert(entries.size() > 2);
		
	}
	
	@BeforeClass
	public void setUp() {
		
	}
	
	@Test
	public void testLinesAreGreaterThan2Characters() {
		
	}
	
	class YourClass {
		public int reassemble(String is) {
			return 1;
			
		}
	}

}
