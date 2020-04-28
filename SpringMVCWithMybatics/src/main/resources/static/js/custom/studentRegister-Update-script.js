$(document).ready(function() {
	const BASE_URL = window.location.origin;

	$('#btnGenerateCode').on('click', function() {
		$.ajax({
			url : BASE_URL + "/api/student/generateCode",
			success : function(code) {	
				if (code != '') {
					$('#student_code').val(code);
				} else {
					Swal.fire("Error", "Cannot gererate code", "error");
				}
			},
			error : function() {
				Swal.fire("Error", "Cannot gererate code", "error");
			}
		})
	})
	
	$("#formStudent").validate({
		rules : {
			code : {
				required : true,
				maxlength : 10
			},
			name : {
				required : true,
				maxlength : 20
			},
			dateOfBirth : {
				required : true,
				date : true
			},
			address : {
				required : true
			},
			averageScore : {
				required : true,
				number : true,
				range : [0, 10]
			}
		},
		messages : {
			code : {
				required : "Please enter Student Code",
				maxlength : "Student Code is no longer than 10 characters"
			},
			name : {
				required : "Please enter Student Name",
				maxlength : "Student Name is no longer than 20 characters"
			},
			dateOfBirth : {
				required : "Please enter Birthday",
				date : "Please enter a valid date"
			},
			address : {
				required : "Please enter Address"
			},
			averageScore : {
				required : "Please enter Average Score",
				number : "Please enter a number",
				range : "Average Score between 0 and 10"
			}
		}

	});
});