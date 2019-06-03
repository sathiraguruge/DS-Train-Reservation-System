function payMobile() {
	jQuery
			.ajax({
					url : "http://localhost:8280/dialogPayment/processMobilePayment/"
					+ $("#mobileNo").val() + "/" + $("#pin").val(),					
					
					
				type : "GET",
				contentType : "application/json",
				dataType : 'json',
				success : function(data, textStatus, errorThrown) {
					var mobileNo = data.mobileNo;
					var mobileBalance = data.balance;
					var ticketPrice = $("#total").val();
					if (mobileBalance > 0) {
						if (mobileBalance >= ticketPrice) {
							updateMobileBalance(mobileNo, ticketPrice);
							var modal = document.getElementById('myModal');
							modal.style.display = "block";
						} else
							alert("Mobile Balance not Sufficient");
					} else
						alert("Insufficient Mobile Balance !");

				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Payment Failed, Invalid Mobile Details");

				},
				timeout : 12000,
			});
};

function updateMobileBalance(mobileNo, amount) {
	jQuery
			.ajax({
				url : "http://localhost:8080/train_service/rest/mobilepaymentgateway/dialogezcash/updateMobileAmount/"
						+ mobileNo + "/" + amount,
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