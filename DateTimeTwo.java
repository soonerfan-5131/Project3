import java.util.Calendar;
import java.util.Locale;

public class DateTimeTwo extends MesoDateTimeTwoAbstract{

	public void daysOfCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 10);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.YEAR, 2019);
		String tenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		
		cal.set(Calendar.DAY_OF_MONTH, 18);
		String eighteenthDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		System.out.println("The tenth day of this month is " + tenthDay.toUpperCase() +
				" and eighteenth is " + eighteenthDay.toUpperCase());
	}
	public void daysOfAnyMonth(int month, int year) {
		
	}
	
	public void compareYear() {
		
	}
	public void dateHashMap() {
		
	}
	public void dateHashMapSorted() {
		
	}
}
