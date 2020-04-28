$(document).ready(function() {

	$.validator.addMethod("regex", function(value, element, regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Please check your input.");

	$("#formLogin").validate({
		rules : {
			userName : {
				required : true,
				maxlength : 20,
				regex : "^[a-zA-Z0-9]+$"
			},
			password : {
				required : true,
				rangelength : [ 6, 15 ],
				regex : "^[a-zA-Z0-9]+$"
			}

		},
		messages : {
			userName : {
				required : "Please enter User Name",
				maxlength : "User Name is no longer than 20 characters",
				regex : "User Name contains only letters and numbers"
			},
			password : {
				required : "Please enter Password",
				rangelength : "Password contains from 6 to 15 characters",
				regex : "Password contains only letters and numbers"
			}
		},

	});
});