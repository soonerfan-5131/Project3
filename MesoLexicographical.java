import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	private HashMap<String, Integer> hashMap;
	public MesoLexicographical(HashMap<String, Integer> hash) {
		for(String key: sortedMap(hash).keySet()) {
			System.out.println(key);
		}
	}
	@Override
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
		Map<String, Integer> sorted = new TreeMap<>(unsorted);
		return sorted;
	}
}