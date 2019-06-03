package nicservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trainservice.Train;
import trainservice.Trains;

@Path("/niccards")
public class NICService {
	List<NIC> nicCards;

	public NICService() {
		nicCards = NICCards.getNICCards();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NIC> getNICCards() {
		return nicCards;
	}

	@Path("{nic}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public NIC getNIC(@PathParam("nic") String nic) {
		for (NIC b : nicCards) {
			if (b.getNIC().equals(nic))
				return b;
		}
		throw new NotFoundException();
	}
}
