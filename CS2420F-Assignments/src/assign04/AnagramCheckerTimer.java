
	package assign04;


	import java.nio.charset.Charset;
	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.Random;

	import assign02.Library;
	import assign02.LibraryBook;
	import assign03.IntegerComparator;

	public class AnagramCheckerTimer {
	    private static Random rand;
	    public static void main(String[] args)
	    {
	        rand = new Random();
	        rand.setSeed(System.currentTimeMillis());
	        IntegerComparator cmp = new IntegerComparator();
	        
	        
	        // Do 10000 lookups and use the average running time.
	        int timesToLoop = 1000;
	        
//	        // For each problem size n . . .
	        for (int n = 1000; n <= 20000; n += 1000) {
	            
	            // Generate a new "random" library of size n.
	            String[] randArrColl = new String[n];
	            //randArrColl.addAll(generateLibrary(n));
	            for(int i = 0; i < n; i ++)
	            {
	                byte[] array = new byte[7]; // length is bounded by 7
	                new Random().nextBytes(array);
	                String generatedString = new String(array, Charset.forName("UTF-8"));
	                randArrColl[i] = generatedString;
	            }
	            
	            long startTime, midpointTime, stopTime;
	            
	            // First, spin computing stuff until one second has gone by.
	            // This allows this thread to stabilize.
	            startTime = System.nanoTime();
	            while (System.nanoTime() - startTime < 1000000000) { 
	                // empty block
	                }
	            
	            // Now, run the test.
	            startTime = System.nanoTime();
	            
	            for (int i = 0; i < timesToLoop; i++) {
	                AnagramChecker.getLargestAnagramGroup(randArrColl);
	            }
	            
	            midpointTime = System.nanoTime();
	            
	            // Run a loop to capture the cost of running the "timesToLoop" loop and
	            // generating a random ISBN.
	            
	            for (int i = 0; i < timesToLoop; i++) {    
	            }
	            stopTime = System.nanoTime();
	            
	            // Compute the time, subtract the cost of running the loop
	            // from the cost of running the loop and doing the lookups.
	            // Average it over the number of runs.
	            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	                    / (double) timesToLoop;
	            System.out.println(n + "\t" + averageTime);}
	    }
	    public static Integer randomInt()
	    {
	        return rand.nextInt();
	    }

	}
