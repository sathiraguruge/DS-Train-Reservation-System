package dialogservice;

import java.util.ArrayList;
import java.util.List;

public class DialogPhones {
	private static ArrayList<Phone> phoneNumbers = new ArrayList<>();
	static {
		phoneNumbers.add(new Phone("0770786542", "Tom", 5000, 1234));
		phoneNumbers.add(new Phone("0770721542", "Jerry", 51000, 1111));
		phoneNumbers.add(new Phone("0770123542", "Alan", 61000, 6543));
		phoneNumbers.add(new Phone("0770745542", "David", 9000, 6523));
		phoneNumbers.add(new Phone("0770786542", "Marie", 1000, 9876));
		phoneNumbers.add(new Phone("0770124542", "Daniel", 100, 1123));
		phoneNumbers.add(new Phone("0770098542", "Nicolson", 500, 8876));
	}

	public static List<Phone> getPhones() {
		return phoneNumbers;
	}

	public static void addPhone(Phone phone) {
		phoneNumbers.add(phone);
	}

	public static boolean removeMobile(String mobileNo) {
		for (Phone phone : phoneNumbers) {
			if (phone.getMobileNo().equals(mobileNo)) {
				phoneNumbers.remove(phone);
				return true;
			}
		}
		return false;
	}
}
