package emailservice;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import trainservice.Train;
import trainservice.Trains;

@Path("/sendmail")
public class EmailService {
	public EmailService() {
	}
	
	@Path("/{emailAddress}/{id}/{total}/{ticketCount}")
	@GET
	public boolean sendMail(@PathParam("emailAddress") String emailAddress, @PathParam("id") int id, @PathParam("total") String total, @PathParam("ticketCount") String ticketCount) {
		Train train = Trains.getTrain(id);
		Email email = new Email();
		if(email.sendMail(emailAddress, ticketCount, train.getTrain(), train.getTrainName(), total))
			return true;
		else
		throw new NotFoundException();
	}
}
