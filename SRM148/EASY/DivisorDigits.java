// SRM148 EASY
public class DivisorDigits {
   public int howMany(int number) {
       String numString = String.valueOf(number);
       char[] nums = numString.toCharArray();

       int count=0;
       for(int p : nums) {
           if((p-'0') == 0)
               continue;
           if(number%(p-'0') == 0)
               count++;
       }
       return count;

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			DivisorDigitsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DivisorDigitsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class DivisorDigitsHarness {
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
			int number                = 12345;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}
		case 1: {
			int number                = 661232;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}
		case 2: {
			int number                = 52527;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}
		case 3: {
			int number                = 730000000;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}

		// custom cases

/*      case 4: {
			int number                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}*/
/*      case 5: {
			int number                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}*/
/*      case 6: {
			int number                = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisorDigits().howMany(number));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
