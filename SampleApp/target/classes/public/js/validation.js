	$( document ).ready(function() {	 
	    var form_data=$("#addForm").serializeArray(); 
	    for (var input in form_data){
		    var element=$("#input_"+form_data[input]['name']);
			var attr = element.attr('required');
			// For some browsers, `attr` is undefined; for others,
			// `attr` is false.  Check for both.
			if (typeof attr !== typeof undefined && attr !== false) {
		    	element.on('input', function() {
			    	var input=$(this);
				    var is_name=input.val();
				    if(is_name){input.removeClass("invalid").addClass("valid");input.parent().remove("span");}
				    else{input.removeClass("valid").addClass("invalid");}
				});
			}
		}
	});      
 	
	function formValidate(){
	    var form_data=$("#addForm").serializeArray();
	    var error_free=true;
	    for (var input in form_data){
	        var element=$("#input_"+form_data[input]['name']);
			var attr = element.attr('required');
			// For some browsers, `attr` is undefined; for others,
			// `attr` is false.  Check for both.
			if (typeof attr !== typeof undefined && attr !== false) {
		        var valid=element.hasClass("valid");
		        if (!valid){
		        	element.parent().append($("<span></span>").addClass("error_show").append("This field is required"));
		        	error_free=false;
		        }
		    }
	    }
	    if (!error_free){
	    	alert('Please enter all required fields and try again');
	        return false;
	    }
	    return true;
	}