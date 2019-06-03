function sendEmail() {
	jQuery.ajax({
		url : "http://localhost:8080/train_service/rest/email/sendmail/"
			+ $("#emailAddress").val() + "/" + $("#trainbookingID").val() + "/" + $("#total").val() + "/" + $("#ticketCount").val(),
		type : "GET",
		contentType : "application/json",
		dataType : 'json',
		success : function(data, textStatus, errorThrown) {
			alert("Email Sent");
			window.location.href = "index.html";
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Sorry ! Email Sending Failed");
		},
		timeout : 12000,
	});
};