
        // application code here!
		function CustomersViewModel() {
	        var self = this;
	        self.customers = ko.observableArray();
	        	        
	        $.getJSON("/customers",
         	function(data) {
				for (var i = 0; i < data.length; i++) {
	                self.customers.push({
	                	id: ko.observable(data[i].id),
	                    name: ko.observable(data[i].name),
	                    email: ko.observable(data[i].email),
	                    phone: ko.observable(data[i].phone),
	                    street: ko.observable(data[i].street),
	                    city: ko.observable(data[i].city),
	                    state: ko.observable(data[i].state),
	                    zip: ko.observable(data[i].zip)
	                });
	            }            	        
          	});
	        self.beginAdd = function() {
	            $('#add').modal('show');
	        }
	        self.beginEdit = function(customer) {
	        	editCustomerViewModel.setCustomer(customer);
	            $('#edit').modal('show');
	        }
	        self.remove = function(customer) {
	        	$.ajax({
				    type: 'DELETE',
				    url: '/customer',
				    data:  JSON.stringify ({id: customer.id()}),
				    success: function() {
				    	for (var i = 0; i < self.customers().length; i++) {
				    		var lcust = self.customers()[i];
				    		if (lcust.id() == customer.id()){
				    			self.customers().splice(i,1);
				    		}
				    	}	
				    },
				    contentType: "application/json",
				    dataType: 'html'
				});
	        }
	    }
	    
		function AddCustomerViewModel() {
	        var self = this;
	        self.name = ko.observable();
	        self.email = ko.observable();
	        self.phone = ko.observable();
	        self.street = ko.observable();
	        self.city = ko.observable();
	        self.state = ko.observable();
	        self.zip = ko.observable();
	
	        self.addCustomer = function() {
	        
	        	if (!formValidate()) return;
	        	$('#add').modal('hide');
				
				$.ajax({
				    type: 'POST',
				    url: '/customer',
				    data: JSON.stringify ({name: self.name(), email: self.email(), phone: self.phone(), street: self.street(), city: self.city(), state: self.state(), zip: self.zip()}),
				    success: function(data) {
				    customersViewModel.customers.push({
	                	id: ko.observable(data.id),
	                    name: ko.observable(data.name),
	                    email: ko.observable(data.email),
	                    phone: ko.observable(data.phone),
	                    street: ko.observable(data.street),
	                    city: ko.observable(data.city),
	                    state: ko.observable(data.state),
	                    zip: ko.observable(data.zip)
	                });
				    },
				    contentType: "application/json",
				    dataType: 'json'
				});
	        }
    	}
    	
    	function EditCustomerViewModel() {
    	    var self = this;
	        self.id = ko.observable();
	        self.name = ko.observable();
	        self.email = ko.observable();
	        self.phone = ko.observable();
	        self.street = ko.observable();
	        self.city = ko.observable();
	        self.state = ko.observable();
	        self.zip = ko.observable();
	
	        self.setCustomer = function(customer) {
	            self.customer = customer;
	            self.id(customer.id());
	            self.name(customer.name());
	            self.email(customer.email());
	            self.phone(customer.phone());
	            self.street(customer.street());
	            self.city(customer.city());
	            self.state(customer.state());
	            self.zip(customer.zip());
	            $('edit').modal('show');
	        }
	        self.editCustomer = function() {
				
				$.ajax({
				    type: 'POST',
				    url: '/customer',
				    data: JSON.stringify ({id: self.id(), name: self.name(), email: self.email(), phone: self.phone(), street: self.street(), city: self.city(), state: self.state(), zip: self.zip()}),
				    success: function(data) {
				    	for (var i = 0; i < customersViewModel.customers().length; i++) {
				    		customer = customersViewModel.customers()[i];
				    		if (data.id == customer.id())
				    		{
				    			customer.id(data.id);
				    			customer.name(data.name);
				    			customer.email(data.email);
				    			customer.phone(data.phone);
				    			customer.street(data.street);
				    			customer.city(data.city);
				    			customer.state(data.state);
				    			customer.zip(data.zip);
				    			customersViewModel.customers[i] = customer;
				    		}
				    	}
				    },
				    contentType: "application/json",
				    dataType: 'json'
				});
				$('#edit').modal('hide');
	        }
    	}
    		
 		var customersViewModel = new CustomersViewModel();
    	var addCustomerViewModel = new AddCustomerViewModel();
    	var editCustomerViewModel = new EditCustomerViewModel(); 
    	   	    
	    ko.applyBindings(customersViewModel, $('#main')[0]);
	    ko.applyBindings(addCustomerViewModel, $('#add')[0]); 
	    ko.applyBindings(editCustomerViewModel, $('#edit')[0]);    

