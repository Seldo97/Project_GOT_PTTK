$(document).ready(function() {
	
	function removeFieldError(field) {
    const errorText = field.nextElementSibling;
    if (errorText !== null) {
        if (errorText.classList.contains("form-error-text")) {
            errorText.remove();
        }
    }
};

function createFieldError(field, text) {
    removeFieldError(field); //przed stworzeniem usuwam by zawsze był najnowszy komunikat

    const div = document.createElement("div");
    div.classList.add("form-error-text");
    div.innerText = text;
    if (field.nextElementSibling === null) {
        field.parentElement.appendChild(div);
    } else {
        if (!field.nextElementSibling.classList.contains("form-error-text")) {
            field.parentElement.insertBefore(div, field.nextElementSibling);
        }
    }
};
		 
		 function markFieldAsError(field, show) {
    if (show) {
        field.classList.add("field-error");
    } else {
        field.classList.remove("field-error");
        removeFieldError(field);
    }
};

function checkPassword(inputtxt) 
{ 
var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	return decimal.test(inputtxt)
}

function validatePhone(phone) {
  const regex = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{3})$/;
  return regex.test(phone)
}

//funkcje testujące

function testLength(field, lng) {
    return field.value.length >= lng;
};

function testPassword(field) {
    return checkPassword(field.value)
};

function testPhone(field) {
    return validatePhone(field.value)
};

function testEmail(field) {
    const reg = /^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$/;
    return reg.test(field.value);
};

//pobieram elementy
const form = document.querySelector("#signupFormRegister");
const inputName = form.querySelector("input[name=imie]");
const inputSurname = form.querySelector("input[name=nazwisko]");
const inputPhone = form.querySelector("input[name=telefon]");
const inputLogin = form.querySelector("input[name=login]");
const inputPassword = form.querySelector("input[name=haslo]");
const inputEmail = form.querySelector("input[name=email]");

const formMessage = form.querySelector(".form-message");

//etap 1 : podpinam eventy
inputName.addEventListener("input", e => markErrorField(e.target, !testLength(e.target, 3)));
inputSurname.addEventListener("input", e => markErrorField(e.target, !testLength(e.target,1)));
inputPhone.addEventListener("input", e => markErrorField(e.target, !testPhone(e.target)));
inputLogin.addEventListener("input", e => markErrorField(e.target, !testLength(e.target,1)));
inputPassword.addEventListener("input", e => markErrorField(e.target, !testPassword(e.target,60)));
inputEmail.addEventListener("input", e => markErrorField(e.target, !testEmail(e.target)));

form.addEventListener("submit", e => {
    e.preventDefault();

    let formErrors = false;

    //2 etap - sprawdzamy poszczególne pola gdy ktoś chce wysłać formularz
    for (const el of [inputName,inputSurname,inputPhone,inputLogin,inputPassword,inputEmail]) {
        markFieldAsError(el, false);
        removeFieldError(el);
    }

    if (!testLength(inputName, 3)) {
        markFieldAsError(inputName, true);
        createFieldError(inputName, "Imie jest niepoprawne ");
        formErrors = true;
    }
    
     if (!testLength(inputSurname, 1)) {
        markFieldAsError(inputSurname, true);
        createFieldError(inputSurname, "Nazwisko jest nie poprawne co najmniej 2 znaki ");
        formErrors = true;
    }
    
     if (!testPhone(inputPhone)) {
        markFieldAsError(inputPhone, true);
        createFieldError(inputPhone, "Telefon jest nie poprawny ");
        formErrors = true;
    }
    
     if (!testLength(inputLogin, 2)) {
        markFieldAsError(inputLogin, true);
        createFieldError(inputLogin, "Login jest za krótki co najmniej 2 znaki ");
        formErrors = true;
    }
    
       if (!testPassword(inputPassword)) {
        markFieldAsError(inputPassword, true);
        createFieldError(inputPassword, "Hasło nie spełnia wymagań (8 znaków, duża litera, znak specjalny) ");
        formErrors = true;
    }

    if (!testEmail(inputEmail)) {
        markFieldAsError(inputEmail, true);
        createFieldError(inputEmail, "Email jest niepoprawny");
        formErrors = true;
    }
    
    if (!formErrors) {
        e.target.submit();
    }
});
});