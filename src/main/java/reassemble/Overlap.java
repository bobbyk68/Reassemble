package reassemble;

public class Overlap {

	  static int calculateOverlap(final String s1, final String s2) {
	        final int s1len = s1.length();
	        final int s2len = s2.length();
	        final int maxlen = Integer.min(s1len, s2len);

	        // from the longest overlap to the shortest possible.
	        for (int len = maxlen; len > 0; len--) {
	            // sliding window into s1 from 0
	            for (int toffset = 0; toffset + len <= s1len; toffset++) {
	                // sliding window into s2 from 0
	                for (int ooffset = 0; ooffset + len <= s2len; ooffset++) {
	                    //System.out.println("Comparing s1.regionMatches(" + toffset + ", s2, " + ooffset + ", " + len + ")");
	                    if (s1.regionMatches(toffset, s2, ooffset, len)) {
	                        return len;
	                    }
	                }
	            }
	        }

	        // no overlap found.
	        return 0;
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        String s1 = "ABCD";
	        String s2 = "DBCA";
	        //System.out.println("Maximum overlap is: " + calculateOverlap(s1, s2));
	        String f1 = "ABCDEF";
	        String f2 = "XCDEZ";
	        System.out.println("Maximum overlap is: " + calculateOverlap(f1, f2));
	    }
	}
