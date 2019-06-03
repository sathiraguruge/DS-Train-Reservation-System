package trainservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/trains")
public class TrainService {
	List<Train> trains;

	public TrainService() {
		trains = Trains.getTrains();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Train> getBooks() {
		return trains;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Train getBook(@PathParam("id") int id) {
		for (Train b : trains) {
			if (b.getId() == id)
				return b;
		}
		throw new NotFoundException();
	}
}
