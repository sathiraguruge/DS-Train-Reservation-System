function validateEmployee() {
	jQuery.ajax({
//		url : "http://localhost:8080/train_service/rest/nic/niccards/"
//				+ $("#nic").val(),
		url : "http://localhost:8280/governmentRegistry/validateEmployee/"
			+ $("#nic").val(),								
		type : "GET",
		contentType : "application/json",
		dataType : 'json',
		success : function(data, textStatus, errorThrown) {
			var isGovernmentEmployee = data.governmentEmployee;
			if (isGovernmentEmployee == 'true' || isGovernmentEmployee == true){
				$("#NICStatus").text("Verified as a Government Employee");
				var total = localStorage.getItem('totalAmount');
				var myDiscount = (total * 10) / 100;
				$("#discount").val(myDiscount);
				total = (total * 90)/ 100;
				$("#total").val(total);
			}
			else{
				$("#NICStatus").text("Sorry not a Government Employee");
				var total = localStorage.getItem('totalAmount');
				$("#discount").val(0);
				$("#total").val(total);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#NICStatus").text("Sorry try again, the NIC does not exist");
			var total = localStorage.getItem('totalAmount');
			$("#discount").val(0);
			$("#total").val(total);
		},
		timeout : 12000,
	});
};