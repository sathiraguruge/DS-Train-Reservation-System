function payCreditCard() {
	jQuery
			.ajax({
//				url : "http://localhost:8080/train_service/rest/paymentgateway/cards/verifyCard/"
//						+ $("#cardNo").val()
//						+ "/"
//						+ $("#cvcNo").val()
//						+ "/"
//						+ $("#holderName").val(),
				
				url : "http://localhost:8280/paymentGateway/processCard/"
					+ $("#cardNo").val()
					+ "/"
					+ $("#cvcNo").val()
					+ "/"
					+ $("#holderName").val(),
				type : "GET",
				contentType : "application/json",
				dataType : 'json',
				success : function(data, textStatus, errorThrown) {
					var cardNo = data.creditCardNo;
					var limit = data.limit;
					var currentAmount = data.currentAmount;
					var availableBalance = limit - currentAmount;
					var ticketPrice = $("#total").val();
					if (availableBalance > 0) {
						if (availableBalance >= ticketPrice) {
							updateBalance(cardNo, ticketPrice);
							var modal = document.getElementById('myModal');
							modal.style.display = "block";
						} else
							alert("Credit Card Balance not Sufficient");
					} else
						alert("Card Limit has Exceeded, Contact your Bank");

				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Payment Failed, Invalid Card Details");

				},
				timeout : 12000,
			});
};

function updateBalance(cardNo, amount) {
	jQuery
			.ajax({
				url : "http://localhost:8080/train_service/rest/paymentgateway/cards/updateAmount/"
						+ cardNo + "/" + amount,
				type : "POST",
				contentType : "application/json",
				dataType : 'json',
				success : function(data, textStatus, errorThrown) {
					alert("Payment Success");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Payment Failed");
				},
				timeout : 120000,
			});
};