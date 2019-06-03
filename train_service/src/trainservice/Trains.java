package trainservice;

import java.util.ArrayList;
import java.util.List;

public class Trains {
	private static ArrayList<Train> trains = new ArrayList<>();
	static {
		trains.add(new Train(1, "Mount Lavinia/Kankesanthurai", "AC Intercity", "4021", "4:11", "24:12", 1000));
		trains.add(new Train(2, "Colombo/Kandy", "Night Mail", "1009", "4:11", "24:12", 2000));
		trains.add(new Train(3, "Colombo/Batticaloa", "Udaya Devi", "6011", "4:11", "24:12", 2500));
		trains.add(new Train(4, "Colombo/Batticaloa", "Night mail Express", "6079", "4:11", "24:12", 1500));
		trains.add(new Train(5, "Colombo/Badulla", "Udarata Manike", "3011", "4:11", "24:12", 1000));
		trains.add(new Train(6, "Colombo/Badulla", "Night mail Express", "5021", "4:11", "24:12", 3500));
		trains.add(new Train(7, "Colombo/Kandy", "AC Intercity", "4009", "4:11", "24:12", 1500));
	}
	public static List<Train> getTrains() {
		return trains;
	}
	public static void addTrain(Train train) {
		trains.add(train);
	}
	public static boolean removeTrain(int id) {
		for(Train train : trains) {
			  if ( train.getId() == id) {
				   trains.remove(train);
				   return true;
			  }
		  }
		return false;
	}
	public static Train getTrain(int id) {
		for(Train train : trains) {
			  if ( train.getId() == id) {
				   return train;
			  }
		  }
		return null;
	}
}
