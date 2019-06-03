function getTotal() {
	var price = document.getElementById("ticketPrice").value;
	var tickets = document.getElementById("ticketCount").value;
	var trainID = document.getElementById("trainbookingID").value;
	var total = price * tickets;
	document.getElementById("total").value = total;
	localStorage.setItem("totalAmount", total);
	localStorage.setItem("ticketCount", tickets);
	localStorage.setItem("trainbookingID", trainID);
}

function redirectPayment() {
	var paymentMethod = document.getElementById("payment").value;
	if (!paymentMethod.localeCompare("CC")) {
		window.location.href = "creditCardPayment.html";
	} else if (!paymentMethod.localeCompare("Mobile")) {
		window.location.href = "mobilePayment.html";
	}
}