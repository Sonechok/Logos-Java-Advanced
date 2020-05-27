function firstTask() {
    var bufer = makeBufer();
    bufer.pushElem('I');
    bufer.pushElem('am');
    bufer.pushElem(19);
    bufer.pushElem('years');
    bufer.pushElem('old');
    console.log("Task1");
    console.log("Bufer after filling");
    bufer.print();
}

function makeBufer() {
    let bufer = [];
    return {
        pushElem: function(value) {
            bufer.push(value);
        },
        print: function() {
            console.log(bufer.join(' '));
        },
        clear: function() {
            bufer = [];
            console.log('"' + bufer + '"')
        }
    }
}

function secondTask() {
    var bufer = makeBufer();
    bufer.pushElem('I');
    bufer.pushElem('am');
    bufer.pushElem(19);
    bufer.pushElem('years');
    bufer.pushElem('old');
    console.log("Task2");
    console.log("Bufer after filling");
    bufer.print();
    console.log("Bufer after clearing");
    bufer.clear();
}

function thirdTaskObj() {
    let robotObj = {
        work() {
            console.log("Я Robot – я просто працюю");
        }
    };

    let coffeRobotObj = {
        __proto__: robotObj
    };
    coffeRobotObj.work = function() {
        console.log("Я CoffeRobot – я варю каву");
    };

    let robotDancerObj = {
        __proto__: robotObj
    };
    robotDancerObj.work = function() {
        console.log("Я RobotDancer – я просто танцюю");
    };

    let robotCoockerObj = {
        __proto__: robotObj
    };
    robotCoockerObj.work = function() {
        console.log("Я RobotCoocker – я просто готую");
    };

    let arrObj = [robotObj, coffeRobotObj, robotDancerObj, robotCoockerObj];
    for (let i = 0; i < arrObj.length; i++) {
        arrObj[i].work();
    }

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