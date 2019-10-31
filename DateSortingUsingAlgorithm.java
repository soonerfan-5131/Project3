import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DateSortingUsingAlgorithm {
	private HashMap<LocalDate, Integer> HASH;
	
	public DateSortingUsingAlgorithm() throws IOException {
		readFile();
	}

	public void readFile() throws IOException{
		HASH = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-dd");
		String data = br.readLine();
		Integer i = 1;
		while(data != null) {
			data = data.replaceAll("\\s", "");
			LocalDate date = LocalDate.parse(data, format);
			HASH.put(date, i);
			i++;
			data = br.readLine();
		}
		br.close();
	}
	public void dateHashMapSortedDescending() throws IOException{
		Map<LocalDate, Integer> sorted = new TreeMap<>(HASH);
		Map<LocalDate, Integer> descending = new TreeMap<>(Collections.reverseOrder());
		descending.putAll(sorted);
		for(LocalDate key: descending.keySet()) {
			System.out.println(key);
		}
	}

	public void dateHashMapSorted() throws IOException{
		Map<LocalDate, Integer> sorted = new TreeMap<>(HASH);
		for(LocalDate key: sorted.keySet()) {
			System.out.println(key);
		}
	}

}
