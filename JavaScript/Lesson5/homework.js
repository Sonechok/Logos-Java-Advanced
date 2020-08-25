//Task1
registration.onsubmit = async (e) => {
    e.preventDefault();
    let age = document.querySelector('[name="age"] ');
    if (Number.parseInt(age.value) < 1 || Number.parseInt(age.value) > 100) {
        alert("Your age:"+ Number.parseInt(age.value) +". Age must be between 1 and 100");
        return;
    } else {
            let response = await fetch("http://localhost:8383/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            },
            body: JSON.stringify(Object.fromEntries(new FormData(registration)))
            });
        alert("User was added");
    }  
}
//Task2
async function showUsers() {
    let users = await fetch("http://localhost:8383/users");
    createTable(await users.json(), "users");
}
function createTable(json, id) {
        let table = document.createElement("table")
        let row = table.insertRow();
        for (let i in json[0]) {
            let th = document.createElement("th");
            th.innerHTML = i;
            row.appendChild(th);
        }
        for (let i = 0; i < json.length; i++) {
            row = table.insertRow();
            for (let j in json[i]) {
                row.insertCell().innerHTML = json[i][j];
            }
        }
        let element = document.getElementById(id);
        element.innerHTML = "";
        element.appendChild(table);
}
//Task3
formShow.onsubmit = async (e) => {
    e.preventDefault();
    let users = await fetch("http://localhost:8383/users");
    let json = await users.json();
    let userId = document.getElementById("userId").value;
    let response = await fetch("http://localhost:8383/users/" + userId);
    document.getElementById("showUserText").innerHTML = await response.text();
}
//Task4
async function getUsers(names) {
    let users = [];
    for (let userName of names) {
        let response = await fetch("https://api.github.com/users/" + userName);
        if (response.ok) {
            users.push(await response.json());
        } else {
            users.push(null);
        }
    }
    return users;
}
