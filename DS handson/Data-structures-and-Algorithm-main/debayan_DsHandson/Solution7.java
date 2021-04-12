package debayan_DsHandson;

import java.io.*;
import java.math.*;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class Solution7 {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) throws ParseException {

		DateFormat df = new SimpleDateFormat("hh:mm:ssa");
		DateFormat out = new SimpleDateFormat("HH:mm:ss");
		Date date = df.parse(s);
		String result = out.format(date);
		return result;

	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\MY\\OneDrive\\Desktop\\Chat.txt"));

		String s = scan.nextLine();

		String result = timeConversion(s);

		bw.write(result);
		bw.newLine();

		bw.close();
	}
}
