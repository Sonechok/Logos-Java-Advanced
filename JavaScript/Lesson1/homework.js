function firstTask() {
    let name = 'John';
    let admin = name;
    alert(admin);
}

function secondTask(){
    let login = "Admin";
    if(login=="Cencel"){
        console.log("Canceled");
    } else if(login == "Admin"){
        let password = "TheMaster";
        if(password == "TheMaster"){
            console.log("Welcome!");
        } else if(password=="Cencel"){
            console.log("Canceled");
        } else {
            console.log("Wrong password");
        }
    } else{
        console.log("I don't know you");
    }
}

function thirdTask(){
    let user = {};
    user.name="ПИЛИП";
    user.surname="ШЕВЧЕНКО";
    console.log(Object.keys(user) + " Before changes");
    user.name = "СЕРГІЙ";
    delete user.name;
    console.log(Object.keys(user) + " After changes");
}

function fourthTask(){
    let employeeSalaries = {
        firstEmployee: 3000,
        secondEmployee: 4800,
        thirdEmploye: 1020
    };
    let sum = 0;
    for (var key in employeeSalaries) { 
        sum += parseFloat(employeeSalaries[key]);
    }
    alert("Sum = " + sum);
}

function fifthTask(firstNum, secondNum, operation){
    try{
        switch(operation) {
        case '+': 
                alert(Number(firstNum)+Number(secondNum));
                break;
        case '-':
                alert(parseFloat(firstNum)-parseFloat(secondNum));
                break;
        case '*':
                alert(parseFloat(firstNum)*parseFloat(secondNum));
                break;
        case '/':
                alert(parseFloat(firstNum)/parseFloat(secondNum));
                break;
        case '%':
                alert(parseFloat(firstNum)%parseFloat(secondNum));
                break;
        default: 
                alert("There is no such operation");
                break;
        }
    } catch(e){
        console.log(e.message);
    }
}

function sixthTask(){
    let login = "Admin";
    switch(login){
        case "Admin":
            let password = "TheMaster";
            switch(password){
                case "TheMaster":
                    console.log("Welcome!");
                    break;
                case "Cencel":
                    console.log("Canceled");
                    break;
                default:
                    console.log("Wrong password");
                    break;
            }
            break;
        case "Cencel":
            console.log("Canceled");
            break;
        default:
            console.log("I don't know you");
            break;            
    }
}

