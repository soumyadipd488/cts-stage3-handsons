package debayan_DsHandson;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'rotateLeft' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER d 2. INTEGER_ARRAY arr
	 */

	public static List<Integer> rotateLeft(int d, List<Integer> arr) {
		// Write your code here
		int head = -99;
		for (int i = 0; d >= 0; i++) {
			head = arr.get(i);
			if (i == arr.size() - 1) {
				i = -1;
			}
			d--;
		}
		// get elements from head to the end of the original array
		List<Integer> sub = arr.subList(arr.lastIndexOf(head), arr.size());

		// get elements from begginning to head
		List<Integer> remainder = arr.subList(0, arr.lastIndexOf(head));

		// concat them
		List<Integer> newl = new ArrayList<Integer>(sub);
		newl.addAll(remainder);

		return newl;
	}

}

public class Solution3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int d = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> result = Result.rotateLeft(d, arr);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
