import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DateTimeTwo{
	
	private HashMap<LocalDate, Integer> hash;

	public DateTimeTwo() throws IOException {
		readFile();
	}
	public void daysOfCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 10);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.YEAR, 2019);
		String tenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		
		cal.set(Calendar.DAY_OF_MONTH, 18);
		String eighteenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		System.out.println("The tenth day of this month is " + tenthDay.toUpperCase() +
				" and eighteenth is " + eighteenthDay.toUpperCase());
	}
	public void daysOfAnyMonth(int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 15);
		String fifteenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		fifteenthDay = fifteenthDay.toUpperCase();
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		String lastDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		lastDay = lastDay.toUpperCase();
		System.out.println("For the year (" + year + ") and month (" + month + "), the fifteenth day is " + fifteenthDay + " and the last day is "
				+ lastDay);
	}
	
	public void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
		String line = br.readLine();
		Integer i = 1;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		hash = new HashMap<LocalDate, Integer>();
		while(line != null) {
			line = br.readLine();
			hash.put(LocalDate.parse(line, format), i);
			i++;
			line = br.readLine();
		}
	}
	
	public void compareYear() throws IOException {
		LocalDate localDate = LocalDate.now();
		for(Entry<LocalDate, Integer> entry : hash.entrySet()) {
			LocalDate myDate = entry.getKey();
			Period myPeriod = Period.between(myDate, localDate);
			int yearDifference = myPeriod.getYears();
			int monthDifference = myPeriod.getMonths();
			int dayDifference = myPeriod.getDays();
			int myDateYear = myDate.getYear();
			if(myDate.isLeapYear() == true) {
				System.out.println(myDate.getYear() + " is a leap year, and Difference: " + yearDifference + " years, " + monthDifference + 
						" months, " + dayDifference + " days.");
			}
			else {
				System.out.println(myDate.getYear() + " is not a leap year, and Difference: " + yearDifference + " years, " + monthDifference + 
						" months, " + dayDifference + " days.");
			}
		}
	}
	public void dateHashMap() {
		for(Entry<LocalDate, Integer> entry: hash.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	public void dateHashMapSorted() {
		Map<LocalDate, Integer> sorted = new TreeMap<>(hash);
		
		for(Entry<LocalDate, Integer> entry: sorted.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
