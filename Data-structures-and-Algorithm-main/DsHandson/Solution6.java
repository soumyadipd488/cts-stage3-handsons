package debayan_DsHandson;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution6 {

	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		long max = 0, min = 0;
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			max += arr[i];
		}
		for (int i = 0; i < arr.length - 1; i++) {
			min += arr[i];
		}
		System.out.println(min + " " + max);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);
		scanner.close();
	}
}
