let todos = [
    {
        "id": 1678190714090,
        "title": "Play Football",
        "done": false
    }, {
        "id": 1678190714092,
        "title": "Read book about microservices",
        "done": true
    }
]

window.onload = function() {
    load();
    const myInput = document.querySelector('input[name="inp"]');
    myInput.addEventListener("keydown", (e) => {
        if (e.keyCode === 13){
            updateTodo(e.target.id)
        }
    });
};

function load() {
    let todosElement = document.getElementById("todos");
    todos.forEach((todo=>{
        var newelement = document.createElement('div');
        newelement.className = 'input-group mb-3';
        newelement.innerHTML =
                `<div class="input-group-text">
                    <input class="form-check-input mt-0" ${todo.done ? 'checked' : ''} type="checkbox" value="">
                </div>
                <input type="text" class="form-control" value="${todo.title}" id="${todo.id}" name="inp">
                <button class="btn btn-danger" type="button" >Delete</button>`;
        todosElement.appendChild(newelement);
    }));
}


function add() {
    const inputElement = document.getElementById("input");
    const todosElement = document.getElementById("todos");
    let newDivElement = document.createElement('div');
    newDivElement.className = 'input-group mb-3';
    newDivElement.innerHTML = `
                <div class="input-group-text">
                    <input class="form-check-input mt-0" type="checkbox" value="">
                </div>
                <input type="text" class="form-control" value="${inputElement.value}">
                <button class="btn btn-danger" type="button" >Delete</button>`
    todosElement.appendChild(newDivElement)
    console.log("123")

}
