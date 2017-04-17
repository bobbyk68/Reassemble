package reassemble.fragment.submission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.Test;

import junit.framework.Assert;

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
	
	
	@Test
	public void testLine1() {
		String testLine = "O draconia;conian devil! Oh la;h lame sa;saint!";
		String mergedLine = new DeFragment().reassemble(testLine);
		Assert.assertEquals("O draconian devil! Oh lame saint!", mergedLine);
		
	}
	
	class DeFragment {
		
		
		
		public String reassemble(String line) {
			//break line into elements
			List<String> entries = getFragments(line);
			String mergedLine = mergeFragments(entries);
			return mergedLine;
		}
		
		private String mergeFragments(List<String> fragments){
			String merged = "";
			for ( int index = 0;  index < fragments.size() ; index++){
				String candidate = fragments.get(index);
				int candidateIndex = index+1;
				int maxOverLap = 0;
				while ( candidateIndex < fragments.size()){
					int overLap = overLapCount(candidate, fragments.get(candidateIndex));
					if ( overLap > maxOverLap ){
						//our new overlap
						maxOverLap = overLap;
						merged = merge(candidate, fragments.get(candidateIndex));
					}
					candidateIndex++;
				}
				
				
			}
			return merged;
			
		}
		
		private int overLapCount(String first, String second){
			return 1;
		}
		
		private String merge(String first, String second){
			return "";
		}
		
		private List<String> getFragments(String line){
			StringTokenizer st = new StringTokenizer(line, ";");
			List<String> fragments = new ArrayList<>();
			while (st.hasMoreTokens()) {
				fragments.add( st.nextToken() );
			}
			return fragments;
		}
	}

}
