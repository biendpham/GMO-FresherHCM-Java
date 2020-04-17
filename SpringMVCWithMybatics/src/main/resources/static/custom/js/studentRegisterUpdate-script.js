$(document).ready( function () {
	
	const FORM = $('#formStudentRegisterUpdate');
    const BASE_URL = window.location.origin;
    
    $('#btnBack').on("click", function(){
    	window.location.href = BASE_URL + "/student/list"
    })
    
    $('#btnSave').on("click", function(){
    	const bootstrapValidator = FORM.data('bootstrapValidator');
        bootstrapValidator.validate();
        if (bootstrapValidator.isValid()) {
	    	let data = getData();
	    	if (isInsert()){
	    		insert(data);
	    	} else {
	    		update(data);
	    	}
	    }
    })
    
    function isInsert(){
    	let urlPath = window.location.href.split("/")
    	if($.isNumeric(urlPath[urlPath.length-1])) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    function insert(data){
    	delete data["id"];
    	$.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: BASE_URL + "/api/student",
            data: JSON.stringify(data),
            success: function (response) {
                if (response.Message === "SUCCESS") {
                	Swal.fire("Thành công", response.Response.message, "success")
	                	.then(function () {
	                        window.location = BASE_URL + "/student/" + response.Response.id;
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
    
    function update(data){
    	$.ajax({
            type: "PUT",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: BASE_URL + "/api/student",
            data: JSON.stringify(data),
            success: function (response) {
                if (response.Message === "SUCCESS") {
                	Swal.fire("Thành công", response.Response, "success")
                } else {
                	Swal.fire("Thất bại", response.Response, "error");
                }
            },
            error: function () {
                Swal.fire("Có lỗi xảy ra", "Vui lòng kiểm tra lại", "error");
            }
        })
    }
    
    function getData() {
        let data = {
        	"id": $('#txtStudentId').val(),
    		"code": $('#txtStudentCode').val(),
    		"name": $('#txtStudentName').val(),
    		"studentInfo": {
    			"id": $('#txtStudentInfoId').val(),
    			"student_id": $('#txtStudentId').val(),
    			"dateOfBirth": $('#txtDayOfBirth').val(),
    			"address": $('#txtAddress').val(),
    			"averageScore": $('#txtAverageScore').val()
    		}
        };
        console.log(data)
        return data;
    }
    
    FORM.bootstrapValidator({
        message: 'Bạn chưa điền vào trường này',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	student_id: {
                validators: {
                	callback: {
                        message: 'Student Id không hợp lệ',
                        callback: function(value, validator) {
                        	let urlPath = window.location.href.split("/")
                        	if($.isNumeric(urlPath[urlPath.length-1])) {
                        		return value == urlPath[urlPath.length-1];
                        	} else {
                        		return true;
                        	}   
                        }
                    }
                }
            },
            student_code: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                    	max: 10,
                    	message: 'Student Code không quá 10 ký tự'
                    }
                }
            },
            student_name: {
                validators: {
                    notEmpty: {

                    },
                    stringLength: {
                        max: 20,
                        message: 'Student Name không quá 20 ký tự'
                    }
                }
            },
            date_of_birth: {
            	validators: {

                    date: {
                        message: 'Ngày không đúng định dạng',
                        format: 'DD/MM/YYYY'
                    },
                    callback: {
                        message: 'Ngày không đúng định dạng',
                        callback: function(value, validator) {
                            var m = new moment(value, 'YYYY-MM-DD', true);
                            if (!m.isValid()) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {

                    }
                }
            },
            avegare_score: {
                validators: {
                    notEmpty: {

                    },
                    numeric: {
                    	message: 'Average Score không đúng định dạng số'
                    },
                    between: {
                        min: 0,
                        max: 10,
                        message: 'Average Score phải từ 0 đến 10'
                    }
                }
            },
        }
    });

});