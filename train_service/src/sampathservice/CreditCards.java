package sampathservice;

import java.util.ArrayList;
import java.util.List;

public class CreditCards {
	private static ArrayList<CreditCard> cards = new ArrayList<>();
	static {
		cards.add(new CreditCard("4024007155211112", "123", "YaraLuna", 5000, 0, "22/08"));
		cards.add(new CreditCard("4929570311913059", "423", "Ace Morin", 85000, 1000, "23/09"));
		cards.add(new CreditCard("4024007195367999", "543", "Darlene Timms", 57000, 1000, "23/09"));
		cards.add(new CreditCard("4916107452462243", "323", "Amiya Romero", 56000, 1000, "23/09"));
		cards.add(new CreditCard("4916286362099228", "873", "Daryl Mccullough", 55000, 1000, "23/09"));
		cards.add(new CreditCard("5153705312725508", "433", "Lilia Mcfarland", 2000, 1000, "23/09"));
		cards.add(new CreditCard("5578824892969357", "443", "Cruz Weaver", 23000, 1000, "23/09"));
	}

	public static List<CreditCard> getCards() {
		return cards;
	}

	public static void addTrain(CreditCard creditCard) {
		cards.add(creditCard);
	}

	public static boolean removeTrain(String cardNumber) {
		for (CreditCard creditCard : cards) {
			if (creditCard.getCreditCardNo().equals(cardNumber)) {
				cards.remove(creditCard);
				return true;
			}
		}
		return false;
	}
}
