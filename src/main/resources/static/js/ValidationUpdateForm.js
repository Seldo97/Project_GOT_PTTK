$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='signupFormUpdate']").validate({
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
      	checkPassword: false
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
