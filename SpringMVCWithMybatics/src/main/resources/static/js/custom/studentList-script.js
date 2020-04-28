$(document).ready(function() {
	const BASE_URL = window.location.origin;
	const TABLE = $("#table");

	TABLE.on('click', '.btnDelete', function() {
		let studentName = $(this).closest('tr').find('td:eq(2)').text();
		let id = $(this).attr('id');
		Swal.fire({
			title : 'Confirm',
			text : "Are you sure delete student " + studentName + "?",
			type : 'question',
			showCancelButton : true,
			confirmButtonColor : '#3085d6',
			cancelButtonColor : '#d33',
			confirmButtonText : 'OK',
			cancelButtonText : 'Cancel',
			allowOutsideClick : false,
			allowEscapeKey : false
		}).then(function(result) {
			if (result.value) {
				let path = BASE_URL + '/student/delete';
				let params = {
					id : id
				};
				post(path, params, 'post');
			}
		})
	});

	$('#btnGenerateCode').on('click', function() {
		console.log("sd")
		$.ajax({
            url: BASE_URL + "/api/student/generateCode",
            success: function (code) {
            	console.log(code)
                if (code != '') {
                	$('#studentCode').val(code);
                } else {
                	Swal.fire("Error", "Cannot gererate code", "error");
                }
            },
            error: function () {
            	Swal.fire("Error", "Cannot gererate code", "error");
            }
        })
	})

	function post(path, params, method) {
		const form = document.createElement('form');
		form.method = method;
		form.action = path;

		for ( const key in params) {
			if (params.hasOwnProperty(key)) {
				const hiddenField = document.createElement('input');
				hiddenField.type = 'hidden';
				hiddenField.name = key;
				hiddenField.value = params[key];

				form.appendChild(hiddenField);
			}
		}

		document.body.appendChild(form);
		form.submit();
	}

	$('#twbs-pagination').twbsPagination({
		totalPages : totalPages,
		visiblePages : totalPages > 5 ? totalPages / 2 : 3,
		startPage : startPage,
		onPageClick : function(event, pageClicked) {
		}
	}).on('page', function(event, pageClicked) {
		var href = new URL(window.location.href);
		href.searchParams.set('pageNum', pageClicked);
		href.searchParams.set('pageSize', 10);
		window.location.href = href.toString();
	});
});
