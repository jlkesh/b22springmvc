// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
})();

window.addEventListener("load", (event) => {
    const limit = sessionStorage.getItem("limit");
    const select = document.getElementById("limit");
    let options = '';
    for (let i = 8; i <= 28; i = i + 4) {
        console.log(i === parseInt(limit));
        options = options + `<option value="${i}" ${i === parseInt(limit) ? 'selected' : ''} >${i}</option>`;
    }
    select.insertAdjacentHTML('beforeend',options);
});


document.getElementById('limit')
    .addEventListener('change', function () {
        sessionStorage.setItem("limit", this.value);
        const select = document.querySelector("select");
        for (let option of select.options) {
            if (option.value === this.value) {
                option.setAttribute("selected", "selected");
            } else {
                option.removeAttribute("selected")
            }
        }
    });

function addLimit() {
    const limit = sessionStorage.getItem("limit");
    window.location = '/home?limit=' + limit;
}

function addInput(elementID) {
    const newID = new Date().getTime();
    const tag = document.getElementById(elementID + 's');
    const div = `
        <div class="input-group mb-3" id="${newID}">
              <input type="text" class="form-control" placeholder="${elementID}" name="${elementID + 's'}" required >
              <button class="btn btn-danger" type="button" onclick="deleteElement(${newID})" ><i class="fa fa-trash" aria-hidden="true"></i></button>
              <div class="invalid-feedback">
                Please add ${elementID}
              </div>
        </div>`;
    tag.insertAdjacentHTML('beforeend', div)
}


function deleteElement(id) {
    document.getElementById(id).remove()
}

