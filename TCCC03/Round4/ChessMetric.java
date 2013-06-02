import java.util.*;

public class ChessMetric {
    public long howMany(int size, int[] start, int[] end, int numMoves) {

        // All move = KING + NIGHT move.
        int[] mv_x = {-1, -1, 0, 1, 1, 1, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2};
        int[] mv_y = {0, 1, 1, 1, 0, -1, -1, -1, 1, 2, 2, 1, -1, -2, -2, -1};

        long[][][] ways = new long[size][size][numMoves+1];
        for(int i=0; i<size; i++) 
            for(int j=0; j<size; j++) 
                for(int k=0; k<numMoves; k++)
                    ways[i][j][k] = -1;

        ways[start[0]][start[1]][0] = 0;

        for(int i=0; i<numMoves; i++) {
            for(int x=0; x<size; x++) {
                for(int y=0; y<size; y++) {
                    if(ways[x][y][i] == -1)
                        continue;
                    for(int j=0; j<mv_x.length; j++) {
                        int dx = mv_x[j];
                        int dy = mv_y[j];
                        if(x + dx < 0 || x + dx >= size ||
                            y + dy < 0 || y + dy >= size)
                            continue;
                        ways[x+dx][y+dy][i+1] += ways[x][y][i] + 1;
                    }
                }
            }
        }

        return ways[end[0]][end[1]][numMoves];
    }


    // BEGIN CUT HERE
    public static void main(String[] args) {
        if (args.length == 0) {
            ChessMetricHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                ChessMetricHarness.run_test(Integer.valueOf(args[i]));
        }
    }
    // END CUT HERE
}

// BEGIN CUT HERE
class ChessMetricHarness {
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

    static boolean compareOutput(long expected, long result) { return expected == result; }
    static String formatResult(long res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, long expected, long received) { 
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
                        int size                  = 3;
                        int[] start               = {0,0};
                        int[] end                 = {1,0};
                        int numMoves              = 1;
                        long expected__           = 1;

                        return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
            }
            case 1: {
                        int size                  = 3;
                        int[] start               = {0,0};
                        int[] end                 = {1,2};
                        int numMoves              = 1;
                        long expected__           = 1;

                        return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
            }
            case 2: {
                        int size                  = 3;
                        int[] start               = {0,0};
                        int[] end                 = {2,2};
                        int numMoves              = 1;
                        long expected__           = 0;

                        return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
            }
            case 3: {
                        int size                  = 3;
                        int[] start               = {0,0};
                        int[] end                 = {0,0};
                        int numMoves              = 2;
                        long expected__           = 5;

                        return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
            }
            case 4: {
                        int size                  = 100;
                        int[] start               = {0,0};
                        int[] end                 = {0,99};
                        int numMoves              = 50;
                        long expected__           = 243097320072600L;

                        return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
            }

            // custom cases

            /*      case 5: {
                    int size                  = ;
                    int[] start               = ;
                    int[] end                 = ;
                    int numMoves              = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
                    }*/
            /*      case 6: {
                    int size                  = ;
                    int[] start               = ;
                    int[] end                 = ;
                    int numMoves              = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
                    }*/
            /*      case 7: {
                    int size                  = ;
                    int[] start               = ;
                    int[] end                 = ;
                    int numMoves              = ;
                    long expected__           = ;

                    return verifyCase(casenum__, expected__, new ChessMetric().howMany(size, start, end, numMoves));
                    }*/
            default:
                    return -1;
        }
    }
}

// END CUT HERE
