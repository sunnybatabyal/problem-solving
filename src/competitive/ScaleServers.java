/**
 * 
 */
package competitive;

import java.util.Arrays;

/**
 * You’re investigating what happened when one of your computer systems recently
 * broke down. So far you’ve concluded that the system was overloaded; it looks
 * like it couldn’t handle the hailstorm of incoming requests. Since the
 * incident, you have had ample opportunity to add more servers to your system,
 * which would make it capable of handling more concurrent requests. However,
 * you’ve simply been too lazy to do it—until now. Indeed, you shall add all the
 * necessary servers very soon! To predict future requests to your system,
 * you’ve reached out to the customers of your service, asking them for details
 * on how they will use it in the near future. The response has been pretty
 * impressive; your customers have sent you a list of the exact timestamp of
 * every request they will ever make! You have produced a list of all the n
 * upcoming requests specified in milliseconds. Whenever a request comes in, it
 * will immediately be sent to one of your servers.
 * 
 * A request will take exactly 1000 milliseconds to process, and it must be
 * processed right away. Each server can work on at most k requests
 * simultaneously. Given this limitation, can you calculate the minimum number
 * of servers needed to prevent another system breakdown?
 * 
 * 
 * Input
 * 
 * The first line contains two integers 1 ≤ n ≤ 100 000 and 1 ≤ k ≤ 100 000, the
 * number of upcoming requests and the maximum number of requests per second
 * that each server can handle.
 * 
 * Then follow n lines with one integer 0 ≤ ti ≤ 100 000 each, specifying that
 * the ith request will happen ti milliseconds from the exact moment you
 * notified your customers. The timestamps are sorted in chronological order. It
 * is possible that several requests come in at the same time.
 * 
 * 
 * Output Output a single integer on a single line: the minimum number of
 * servers required to process all the incoming requests, without another system
 * breakdown.
 * 
 * 
 * Input 1 2 1 0 1000
 * 
 * Output 1 1
 * 
 * 
 * Input 2 3 2 1000 1010 1999
 * 
 * Output 2 2
 * 
 * 
 * Input 3 4 2 1804 1906 2160 2274
 * 
 * Output 3 2
 * 
 * @author sunnyb
 *
 */
public class ScaleServers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 1804, 1906, 2160, 2274 };
		int k = 2;

		Arrays.sort(arr);

		int maxEndTime = arr[0] + 1000;
		int count = 0, maxCount = 0;

		for (int i : arr) {

			if (i < maxEndTime) {
				count++;
			} else {
				maxEndTime = i + 1000;
				count = 0;
			}

			if (count > maxCount) {
				maxCount = count;
			}
		}

		System.out.println((maxCount + (k - 1)) / k);
	}

}
