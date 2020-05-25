function firstTask() {
    let products = ["Phone", "Tablet", "Headphones"];
    if(products.length>0){
        alert(products[products.length-1]);
    } else {
        alert("Array is empty");
    }
}

function secondTask(){
    let styles = ["Джаз", "Блюз"];
    styles.push("Рок-н-Ролл");
    if(styles.length>0){
        styles.splice(styles.length-1, 1, "Класика");
    }
    console.log(styles.shift());
    styles.unshift("Реп", "Реггі");
    console.log(styles);
}

function find(arr, value){
    let position = -1;
    for(let i = 0; i<arr.length;i++){
        if(arr[i]==value){
            position=i;
            break;
        }
    }
    return position;
}

function thirdTask(arr, value){
     console.log(find(arr, value));
}

function fourthTaskB(arr){
    arr.sort((a, b) => b - a);
    console.log(arr);
}

function fourthTaskA(arr){
    arr.sort((a, b) => a - b);
    console.log(arr);
}

function fourthTaskC(arr){
    let arrPositive = arr.filter(a => a >= 0);
    let arrNegative = arr.filter(a => a < 0);
    console.log(arrPositive);
    console.log(arrNegative);
}

function filterRange(array, a, b){
    let newArray = array.filter(num => num>=a && num <= b);
    return newArray;
}

function fifthTask(array, a, b){
    console.log(filterRange(array, a, b));
}

function camelize(str){
    let arrStr = str.split("-");
    for(let i=0; i<arrStr.length;i++){
        if(i!=0){
            let subArr = arrStr[i].split('');
            let newStr = subArr[0].toUpperCase();
            subArr[0] = newStr;
            arrStr[i] = subArr.join('');
        }
    }
    let newStr = arrStr.join('');
    return newStr;
}

function sixthTask(str){
    console.log(camelize(str));
}

function seventhTask(){
    let student  = [{
    yearOfStuding: 1,
    facultyName : "Системний Аналіз"}, {
    yearOfStuding: 3,
    facultyName : "Комп'ютерна інженерія"},{
    yearOfStuding: 2,
    facultyName : "Системний Аналіз"},{
    yearOfStuding: 5,
    facultyName : "Філологія"},{
    yearOfStuding: 3,
    facultyName : "Філологія"},{
    yearOfStuding: 1,
    facultyName : "Комп'ютерні науки"},{
    yearOfStuding: 3,
    facultyName : "Системний Аналіз"},{
    yearOfStuding: 4,
    facultyName : "Біомедична інженерія"},{
    yearOfStuding: 4,
    facultyName : "Прикладна механіка"},{
    yearOfStuding: 5,
    facultyName : "Видавництво та поліграфія"}];
    let arrWith=[];
    let sum = 0;
    for(let i = 0; i < student.length; i++){
        for (let key in student[i]) { 
            if(key == "facultyName"){
                arrWith.push(student[i][key]);
            } 
            if(key = "yearOfStuding"){
                sum+=student[i][key];
            }
        }
    }
    console.log(arrWith);
    console.log(sum);
    
}
