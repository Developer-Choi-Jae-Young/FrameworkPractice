onload = () => {
	document.getElementById('btn-auth').onclick = () => {
		$('#spinner').removeClass('d-none');
		$('#btn-auth').addClass('disabled');
	
		$.ajax({
			url: 'mail',
			method: 'post',
			data: {
				email: $('#email').val()
			},
			success: function(result) {
				$('#spinner').addClass('d-none');
				$('#btn-auth').removeClass('disabled');
				alert(result);
			},
			error: function(err) {
				$('#spinner').addClass('d-none');
				$('#btn-auth').removeClass('disabled');
				console.log(err);
			}
		});
	}
	
	document.getElementById('btn-check').onclick = () => {
		$.ajax({
			url: 'check',
			method: 'post',
			data: {
				email: $('#email').val(),
				code: $('#authCode').val()
			},
			success: function(result) {
				alert(result);
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
}