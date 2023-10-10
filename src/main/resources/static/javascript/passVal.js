var password = document.getElementById("password")
  , re_password = document.getElementById("re_password");

function validatePassword(){
  if(password.value != re_password.value) {
    re_password.setCustomValidity("Passwords Don't Match");
  } else {
    re_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
re_password.onkeyup = validatePassword;