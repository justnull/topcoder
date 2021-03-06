import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class NextOrPrev {
    public boolean check(char a, char b,  char c,  char d) {
           if (c > a && b > d)
           {
               return false;
           }
           if (a > c && d > b)
           {
               return false;
           }
           return true;
       }
    public int getMinimum(int nextCost, int prevCost, String start, String goal) {

       char[] S = start.toCharArray();
       char[] G = goal.toCharArray();

       int nnum = 0;
       int pnum = 0;
       int total = 0;
       int len = S.length;

       for (int i=0; i<len; i++) {
           for (int j=i+1;j<len;j++) {
               if (!check(S[i], G[i], S[j], G[j]))
                   return -1;
           }
       }


       int tmp = 0;
       for(int i=0;i<S.length;i++){
           tmp = (int)S[i] - (int)G[i];
           if(tmp < 0)
               nnum += abs(tmp);
           else
               pnum += abs(tmp);
       }

       total = nnum*nextCost + pnum*prevCost;
       return total;


   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			NextOrPrevHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NextOrPrevHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class NextOrPrevHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, int expected, int received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int nextCost              = 5;
			int prevCost              = 8;
			String start              = "ae";
			String goal               = "bc";
			int expected__            = 21;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 1: {
			int nextCost              = 5;
			int prevCost              = 8;
			String start              = "ae";
			String goal               = "cb";
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 2: {
			int nextCost              = 1;
			int prevCost              = 1;
			String start              = "srm";
			String goal               = "srm";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 3: {
			int nextCost              = 10;
			int prevCost              = 1;
			String start              = "acb";
			String goal               = "bdc";
			int expected__            = 30;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 4: {
			int nextCost              = 10;
			int prevCost              = 1;
			String start              = "zyxw";
			String goal               = "vuts";
			int expected__            = 16;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 5: {
			int nextCost              = 563;
			int prevCost              = 440;
			String start              = "ptrbgcnlaizo";
			String goal               = "rtscedkiahul";
			int expected__            = 10295;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}
		case 6: {
			int nextCost              = 126;
			int prevCost              = 311;
			String start              = "yovlkwpjgsna";
			String goal               = "zpwnkytjisob";
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}

		// custom cases

/*      case 7: {
			int nextCost              = ;
			int prevCost              = ;
			String start              = ;
			String goal               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}*/
/*      case 8: {
			int nextCost              = ;
			int prevCost              = ;
			String start              = ;
			String goal               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}*/
/*      case 9: {
			int nextCost              = ;
			int prevCost              = ;
			String start              = ;
			String goal               = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NextOrPrev().getMinimum(nextCost, prevCost, start, goal));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
