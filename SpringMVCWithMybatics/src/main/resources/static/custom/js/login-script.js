$(document).ready(function(){

    const FORM = $('#formLogin');
    const BASE_URL = window.location.origin;

    FORM.on("click", "#btnLogin", function () {
        const bootstrapValidator = FORM.data('bootstrapValidator');
        bootstrapValidator.validate();
        if (bootstrapValidator.isValid()) {
            let data = getData();
            $.ajax({
                type: "POST",
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                url: BASE_URL + "/api/user/login",
                data: JSON.stringify(data),
                success: function (response) {
                    if (response.Message === "SUCCESS") {
                    	Swal.fire("Thành công", response.Response, "success")
	                    	.then(function () {
	                            window.location = BASE_URL + "/student/list";
	                        });
                    } else {
                    	Swal.fire("Thất bại", response.Response, "error");
                    }
                },
                error: function () {
                    Swal.fire("Có lỗi xảy ra", "Vui lòng kiểm tra lại", "error");
                }
            })
        }
    });

    FORM.on("click", "#btnRegister", function () {
        window.location.href = BASE_URL + "/authentication/register"
    });
    
    FORM.bootstrapValidator({
        message: 'Bạn chưa điền vào trường này',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user_name: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                    	max: 20,
                    	message: 'User name không quá 20 ký tự'
                    },
                    regexp: {
                        regexp: /^[a-z0-9]+$/,
                        message: 'User name chỉ chứa số và chữ thường'
                    }
                }
            },
            password: {
            	validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                    	min: 6,
                    	max: 20,
                    	message: 'Password phải dài hơn 6 ký tự và không quá 20 ký tự'
                    },
                    regexp: {
                        regexp: /^[a-z0-9]+$/,
                        message: 'Password chỉ chứa số và chữ thường'
                    }
                }
            }
        }
    });

    function getData() {
        let data = {
        	"userName": $("#txtUsername").val(),
        	"password": $("#txtPassword").val()
        };
        console.log(data);
        return data;
    }

});