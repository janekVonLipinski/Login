const loginForm = document.getElementById("form");

loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const username = document.getElementById("username");
    const password = document.getElementById("password");

    const login = {
        username: username,
        password: password,
    };

    const response = await fetch('http://localhost:8080/api/login', {method: 'get'})

    username = "";
    password = "";
})