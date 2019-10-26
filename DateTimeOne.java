import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime a;
	SimpleDateFormat s;
	private int currentSeconds;
	private HashMap<String, LocalDateTime> myHash;
	public DateTimeOne() {
		a = LocalDateTime.now();
		myHash = new HashMap<String,LocalDateTime>();
	}
   public int getValueOfSecond() {
	   currentSeconds = a.getSecond();
	   return currentSeconds;
   }
   public void sleepForFiveSec() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  }
   public void dateTimeNow() {
	   System.out.println("Current Date/Time: " + a.parse(a.toString()));
   }
   public void dateTimeOfOtherCity() {
		
   }
   public void dateTimeDifferentZone() {
		
   }
   public void timeZoneHashMap() {
		
   }
}