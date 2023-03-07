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

window.onload = function () {
    load();
    const myInput = document.querySelector('input[name="inp"]');
    myInput.addEventListener("keydown", (e) => {
        if (e.keyCode === 13) {
            updateTodo(e.target.id, e.target.value)
            console.log(todos)
        }
    });
};

function updateTodo(id, title) {
    todos.find(t => t.id === parseInt(id)).title = title;
}


function load() {
    let todosElement = document.getElementById("todos");
    todos.forEach(todo => {
        todosElement.appendChild(newTodoElement(todo));
    });
}


function add() {
    const inputElement = document.getElementById("input");
    const todosElement = document.getElementById("todos");
    const todo = {"id": new Date().getTime(), "title": inputElement.value};
    todosElement.appendChild(newTodoElement(todo))
    console.log("123")

}


function newTodoElement(todo) {
    let newelement = document.createElement('div');
    newelement.className = 'input-group mb-3';
    newelement.id = "ie-" + todo.id;
    newelement.innerHTML =
        `<div class="input-group-text">
                    <input class="form-check-input mt-0" ${todo.done ? 'checked' : ''} type="checkbox" value="">
                </div>
                <input type="text" class="form-control" value="${todo.title}" id="${todo.id}" name="inp">
                <button class="btn btn-danger" type="button" onclick="deleteTodo(${todo.id})" >Delete</button>`;
    return newelement;
}

function deleteTodo(id) {
    let todos = document.getElementById('todos');
    let todo = document.getElementById('ie-' + id);
    todo.remove()
}

// https://www.javascripttutorial.net/