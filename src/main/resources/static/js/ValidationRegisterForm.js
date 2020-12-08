jQuery.validator.addMethod("testLength", function (value, element, param) {
        return value.length >= param;
    });
    
jQuery.validator.addMethod("checkPassword", function (value, element, param) {
		if($('#haslo').val().length > 0)
		{
		return /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/.test(value)
        }
        return value
       
    });
    
jQuery.validator.addMethod("checkPhone", function (value, element, param) {
    	return /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{3})$/.test(value);
    });
    
jQuery.validator.addMethod("checkEmail", function (value, element, param) {
    	return /^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$/.test(value);
    });
    
jQuery.validator.addMethod("checkTextField", function (value, element, param) {
    	return /^[a-zA-Z\s]*$/.test(value);
    });
    
    
// Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='signupFormRegister']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      imie: {
      	testLength : { required: true, param: 3 },
      	checkTextField: true
      },
      nazwisko: {
      	testLength: { required: true, param: 2 },
      	checkTextField:true
      },
      telefon: {
     		 checkPhone : true
     		 },
      login: "required",
      haslo: {
        checkPassword: true
      },
      email: {
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true,
        checkEmail: true
      },
    },
    // Specify validation error messages
    messages: {
      imie: "Imie jest nie poprawne co najmniej 3 znaki",
      nazwisko: "Nazwisko jest nie poprawne co najmniej 2 znaki ",
      telefon: "Telefon jest nie poprawny",
      login: "Login jest za krótki co najmniej 2 znaki",
      haslo: "Hasło nie spełnia wymagań (8 znaków, duża litera, znak specjalny)",
      email: "Email jest nie poprawny"
    },
	errorPlacement: function (error, element) {
            if (element.attr("name") == "imie")
                $("#nameErr").html(error);
            if (element.attr("name") == "nazwisko")
                $("#surnameErr").html(error);
            if (element.attr("name") == "telefon")
                $("#phoneErr").html(error);
            if (element.attr("name") == "login")
                $("#loginErr").html(error);
            if (element.attr("name") == "haslo")
                $("#passwordErr").html(error);
            if (element.attr("name") == "email")
                $("#emailErr").html(error);
        },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
