import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MesoEquivalent {
	
	private String stationID;
	private HashMap<String, Integer> map;
	public MesoEquivalent(String stID) {
		stationID = stID;
		map = new HashMap<String, Integer>();
	}
	public HashMap<String, Integer> calAsciiEqual() throws IOException{
		BufferedReader read = new BufferedReader(new FileReader("Mesonet.txt"));
		String line = read.readLine();
		for(int i = 0; i < 3; i++) {
			line = read.readLine();
		}
		MesoAsciiCal compareTo = new MesoAsciiCal(new MesoStation(stationID));
		while(line != null) {
			String stID = line.trim().substring(0,4);
			MesoAsciiCal compareFor = new MesoAsciiCal(new MesoStation(stationID));
			if(compareTo.calAverage() == compareFor.calAverage()) {
				map.put(stID, compareFor.calAverage());
			}
			line = read.readLine();
		}
		read.close();
		return map;
	}
}
