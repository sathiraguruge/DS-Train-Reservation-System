package dialogservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sampathservice.CreditCard;

@Path("/dialogezcash")
public class DialogService {
	List<Phone> dialogPhones;

	public DialogService() {
		dialogPhones = DialogPhones.getPhones();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Phone> getPhones() {
		return dialogPhones;
	}

	@Path("{mobileNo}/{pin}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Phone getMobille(@PathParam("mobileNo") String mobileNo, @PathParam("pin") int pin) {
		for (Phone b : dialogPhones) {
			if (b.getMobileNo().equals(mobileNo) && b.getPin() == pin)
				return b;
		}
		throw new NotFoundException();
	}

	@Path("/updateMobileAmount/{mobileNo}/{amount}/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Phone updateAmount(@PathParam("mobileNo") String mobileNo, @PathParam("amount") double amount) {
		for (Phone b : dialogPhones) {
			if (b.getMobileNo().equals(mobileNo)) {
				b.setBalance(b.getBalance() - amount);
				return b;
			}
		}
		throw new NotFoundException();
	}
}
