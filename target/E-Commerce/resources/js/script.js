// Disable form submissions if there are invalid fields.  Copied from bootstrap documentation
function pageValidation() {
    'use strict';
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', addValidationToEachElement(event, form), false);
    });
}

function addValidationToEachElement(event, form){
    if (form.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
    }
    form.classList.add('was-validated');
}