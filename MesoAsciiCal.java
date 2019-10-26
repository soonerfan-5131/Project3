public class MesoAsciiCal extends MesoAsciiAbstract 
{
	
	MesoStation station;
	
	public MesoAsciiCal(MesoStation mesoStation) {
		station = mesoStation;
	}
   public int calAverage() {
	   int[] cal = new int[2];
	   cal[0] = ((int)Math.ceil((station.getStID().charAt(0) + 
			  station.getStID().charAt(1) +
			  station.getStID().charAt(2) +
			  station.getStID().charAt(3)) / 4.0));
	   cal[1] = ((station.getStID().charAt(0) + 
				  station.getStID().charAt(1) +
				  station.getStID().charAt(2) +
				  station.getStID().charAt(3)) / 4);
	   double value = ((station.getStID().charAt(0) + 
				  station.getStID().charAt(1) +
				  station.getStID().charAt(2) +
				  station.getStID().charAt(3)) / 4.0) % 1.0;
	   if(value >= 0.25) {
		   return cal[0];
	   }
	   else {
		   return cal[1];
	   }
   }
}