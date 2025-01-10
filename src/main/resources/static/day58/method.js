function _regist(){
let no = document.querySelector('.sno');
let name = document.querySelector('.sname');
let kor = document.querySelector('.skor');
let math = document.querySelector('.smath');
let eng = document.querySelector('.seng');

let sno = no.value;
let sname = name.value;
let skor = kor.value;
let smath = math.value;
let seng = eng.value;

//sql로 보낼때 " " 사용해서 입력 값을 " "로 대입  
let studentDto = { "sno" : sno, "sname" : sname, "skor" : skor, "smath" : smath, "seng" : seng}


.fetch("/upload",{method : "POST", header : {"Content - Type" : "application/json"}, body : JSON.stringify(studentDto)} )
    .then(r=>r.json())
    .then(d=>console.log(d))
    .catch(e=>console.log(e))
}