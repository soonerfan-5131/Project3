import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	ZoneId CST;
	ZoneId BST;
	ZoneId GMT;
	LocalDateTime a;
	private int currentSeconds;
	private HashMap<String, LocalDateTime> myHash;
	
	public DateTimeOne() {
		a = LocalDateTime.now();
		myHash = new HashMap<String,LocalDateTime>();
	}
   public int getValueOfSecond() {
	   currentSeconds = a.getSecond();
	   System.out.println("The value of Second now: " + currentSeconds);
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
	   DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	   String text = a.format(format);//DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(a);  could also be an option
	   //LocalDateTime parsedDateTime = LocalDateTime.parse(text, format);
	   System.out.println("Current Date/Time: " + text);
   }
   public void dateTimeOfOtherCity() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("kk:mm");
		String text = a.format(format);
		LocalDateTime b = a.plusHours(5);
		String text2 = b.format(format);
		LocalDateTime c = b.plusHours(6);
		String text3 = c.format(format);
		CST = ZoneId.of("America/Chicago");
		LocalDateTime d = LocalDateTime.now(CST);
		String text4 = d.format(format);
		//Set<String> text4 = zoneID.getAvailableZoneIds();
		System.out.println("Time on Server: " + text + "\nGMT: " + text2 + "\nBST (90E): " + text3 + "\nCST (90W): " + text4);
   }
   public void dateTimeDifferentZone() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm");
		LocalDateTime b = a.plusHours(5);
		String text = b.format(format);
		LocalDateTime c = b.plusHours(6);
		String text2 = c.format(format);
		CST = ZoneId.of("America/Chicago");
		LocalDateTime d = LocalDateTime.now(CST);
		String text3 = d.format(format);
		System.out.println("GMT: " + text + "\nBST: " + text2 + "\nCST: " + text3);
		myHash.put("GMT", b);
		myHash.put("BST", c);
		myHash.put("CST", d);
		//System.out.println(myHash);
   }
   public void timeZoneHashMap() {
	   LocalDateTime ZST = LocalDateTime.of(2018, 11, 05, 19, 59);
	   myHash.put("ZST", ZST);
	   LocalDateTime AST = LocalDateTime.of(2020, 10, 01, 19, 59);
	   myHash.put("AST", AST);
	   TreeMap<String, LocalDateTime> sorted = new TreeMap<>();
	   sorted.putAll(myHash);
	   //DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern)
	   System.out.println("Print Style 1: ");
	   for(Map.Entry<String, LocalDateTime> entry: sorted.entrySet()) {
		   System.out.println(entry.getKey() + " " + entry.getValue());
	   }
	   HashMap<LocalDateTime, String> temp = new HashMap<>();
	   temp.put(myHash.get("AST"), "AST");
	   temp.put(myHash.get("GMT"), "GMT");
	   temp.put(myHash.get("BST"), "BST");
	   temp.put(myHash.get("CST"), "CST");
	   temp.put(myHash.get("ZST"), "ZST");
	   System.out.println("Print Style 3: ");
	   for(Map.Entry<LocalDateTime, String> entry: temp.entrySet()) {
		   System.out.println(entry.getKey());
	   }
	   LocalDateTime[] localDate = new LocalDateTime[5];
	   localDate[0] = myHash.get("AST");
	   localDate[1] = myHash.get("CST");
	   localDate[2] = myHash.get("BST");
	   localDate[3] = myHash.get("GMT");
	   localDate[4] = myHash.get("ZST");
	   System.out.println("Print Style 5: Final Sorted Array:");
	   for(int i = 0; i < localDate.length; i++) {
		   System.out.println(localDate[i]);
	   }
	   
	   //System.out.println(myHash);
   }
}