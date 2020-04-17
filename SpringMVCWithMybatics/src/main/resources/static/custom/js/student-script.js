$(document).ready( function () {
	
	const FORM = $('#formStudent');
    const BASE_URL = window.location.origin;
    const pagination = $('#twbs-pagination');
    const TABLE = $('#table');
    const STUDENT_NAME_INPUT = $('#txtStudentName')
    
    getListStudent(1, 10, "")
    
    function getListStudent(pageNum, pageSize, search){
    	data = {
			"pageNum": pageNum,
		    "pageSize": pageSize,
		    "search": search
    	}
    	$.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: BASE_URL + "/api/student/findByName",
            data: JSON.stringify(data),
            success: function (response) {
                console.log(response);
                updatePagination(response.Response.currentPage, response.Response.totalPages)
                $('#table > tbody > tr').empty();
                $.each(response.Response.list, function(i, item) {
                	let editLink = $('<a>', {"href" : "#", "text" : "Edit", "class": "btnEdit"});
                	let deleteLink = $('<a>', {"href" : "#", "text" : "Delete", "class": "btnDelete"});
                	$('#table > tbody').append('<tr></tr>')
                	$('#table tr:last').attr("id", item.id).append(
                		$('<td>').text(i + (pageNum - 1)*pageSize + 1),
                        $('<td>').text(item.code),
                        $('<td>').text(item.name),	
                        $('<td>').text(item.birthday),
                        $('<td>').text(item.address),
                        $('<td>').text(item.score),
                        $('<td>').append(editLink, deleteLink),
                    );
                });
            }
        });
    }
    
    $('#btnAddStudent').on("click", function(){
    	window.location.href = BASE_URL + "/student"
    })
    
	TABLE.on("click", ".btnEdit", function(){
		let id = $(this).closest("tr").attr("id");
		window.location.href = BASE_URL + "/student/" + id
	})
	
	TABLE.on("click", ".btnDelete", function(){
		let id = $(this).closest("tr").attr("id");
//		$.ajax({
//            type: "DELETE",
//            contentType: 'application/json; charset=utf-8',
//            dataType: 'json',
//            url: BASE_URL + "/api/student/" + id,
//            data: JSON.stringify(data),
//            success: function (response) {
//                console.log(response);
//            }
//        });
	})
    
    
    FORM.bootstrapValidator({
        message: 'Bạn chưa điền vào trường này',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
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
                        	console.log(value)
                            var m = new moment(value, 'YYYY-MM-DD', true);
                            if (!m.isValid()) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
    });
    
    function updatePagination(currentPage, totalPages){
    	pagination.twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            startPage: currentPage,
        }).on('page', function (event, pageClicked) {
        	getListStudent(pageClicked,10, STUDENT_NAME_INPUT.val())
        });
    }

});