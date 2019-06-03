package nicservice;

import java.util.ArrayList;
import java.util.List;


public class NICCards {

	private static ArrayList<NIC> nicCards = new ArrayList<>();
	static {
		nicCards.add(new NIC(1, "971222222V", true));
		nicCards.add(new NIC(2, "866652121V", true));
		nicCards.add(new NIC(3, "121212123V", false));
		nicCards.add(new NIC(4, "787232131V", true));
		nicCards.add(new NIC(5, "984324344V", false));
		nicCards.add(new NIC(6, "837233123V", true));
		nicCards.add(new NIC(7, "232323223V", true));
	}
	public static List<NIC> getNICCards() {
		return nicCards;
	}
	public static void addNIC(NIC nic) {
		nicCards.add(nic);
	}
	public static boolean removeTrain(int id) {
		for(NIC nic : nicCards) {
			  if ( nic.getId() == id) {
				  nicCards.remove(nic);
				   return true;
			  }
		  }
		return false;
	}
}
