function getTrain() {
	jQuery
			.ajax({
//				url : "http://localhost:8080/train_service/rest/trains/"
//						+ $("#trainID :selected").val(),	
				url : "http://localhost:8280/train/queryTrain/"
					+ $("#trainID :selected").val(),
				type : "GET",
				contentType : "application/json",
				dataType : 'json',
				success : function(data, textStatus, errorThrown) {
					$("#trainbookingID").val(data.id);
					$("#train").text(data.train);
					$("#trainName").text(data.trainName);
					$("#trainNumber").text(data.trainNo);
					$("#Arrival").text(data.arrival);
					$("#Departure").text(data.departure);
					$("#ticketPrice").val(data.price);

				},
				error : function(jqXHR, textStatus, errorThrown) {
//					$("#train").text("Sorry! Train not found!");
					$("#train").text(data);
					alert(data);
					$("#trainName").text("");
					$("#trainNumber").text("");
					$("#Arrival").text("");
					$("#Departure").text("");
					$("#TicketPrice").text("");
				},
				timeout : 12000,
			});
};
