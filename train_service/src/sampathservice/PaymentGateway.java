package sampathservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cards")
public class PaymentGateway {
	List<CreditCard> cards;

	public PaymentGateway() {
		cards = CreditCards.getCards();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CreditCard> getCards() {
		return cards;
	}

	@Path("/verifyCard/{cardNo}/{cvcNo}/{holderName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard getCard(@PathParam("cardNo") String cardNo, @PathParam("cvcNo") String cvcNo,
			@PathParam("holderName") String holderName) {
		for (CreditCard b : cards) {
			if (b.getCreditCardNo().equals(cardNo) && b.getCvcNo().equals(cvcNo)
					&& b.getCardHolder().equals(holderName))
				return b;
		}
		throw new NotFoundException();
	}

	@Path("/updateAmount/{cardNo}/{amount}/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard updateAmount(@PathParam("cardNo") String cardNo, @PathParam("amount") double amount) {
		for (CreditCard b : cards) {
			if (b.getCreditCardNo().equals(cardNo)) {
				b.setCurrentAmount(b.getCurrentAmount() + amount);
				return b;
			}
		}
		throw new NotFoundException();
	}
}
