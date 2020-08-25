function firstTask() {
    let ulElements = document.getElementsByTagName('ul')
    let liElements = [];
    for(let i = 0; i < ulElements.length; i++){
        let arr = ulElements[i].getElementsByTagName('li');
        for(let j = 0; j < arr.length; j++){
            liElements.push(arr[j]);
        }
    }

    for (let i = 0; i < liElements.length; i++){
        liElements[i].innerHTML = "li element";
    }
    let countOfLiElements = document.getElementById('firstTask');
    countOfLiElements.innerHTML = liElements.length;
}


function secondTask() {
    document.getElementById('text').hidden = true;
}

function thirdTask() {
    document.getElementById('buttonThirdTask').hidden = true;
}

function thirdTaskClasses() {
    class Robot{
        work(){
            console.log("Я Robot – я просто працюю");
        }
    }
    class CoffeRobot extends Robot{
        work(){
            console.log("Я CoffeRobot – я варю каву");
        }
    }
    class RobotDancer extends Robot{
        work(){
            console.log("Я RobotDancer – я просто танцюю");
        }
    }
    class RobotCoocker extends Robot{
        work(){
            console.log("Я RobotCoocker – я просто готую");
        }
    }

    let arr = [new Robot(),
    new CoffeRobot(),
    new RobotDancer(), 
    new RobotCoocker()];
    for (let i = 0; i < arr.length; i++) {
        arr[i].work();
    }

}
function fourthTask(){
    let menuElem = document.getElementById('fourthTask');
    menuElem.classList.toggle('open');
}

function fifthTask(){
    let linksHTTP = document.querySelectorAll('a[href^="http://"]');
    let linksFTP = document.querySelectorAll('a[href^="ftp://"]');
    linksHTTP.forEach(element => element.setAttribute('class', 'external-red'));
    linksFTP.forEach(element => element.setAttribute('class', 'external-red'));
}