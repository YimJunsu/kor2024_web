/*
옵션
const option = {
        method : 'POST',
        Headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify(),
        }
패치
fetch('자바컨트롤러URL', 옵션)
.then(response => response.json())
.then(data => {응답결과코드})
.catch(error=>{ console.log(err); } );
*/

//(1) 글 쓰기 함수 : write(), 사용처:[등록] 버튼 클릭시, 매개변수x, 반환값 x
function bwrite(){ //js함수중 내장된 write함수가 존재하므로 중복. write() -> bwrite()

    //[1] input 마크업의 입력받은 값 가져오기.
        //1. document.querySelector() 함수 이용하여(DOM) 마크업 객체 가져온다.
    let titleInput = document.querySelector(`.titleInput`);
    let contentInput = document.querySelector(`.contentInput`);
    let pwdInput = document.querySelector(`.pwdInput`);
        //2. 가져온 dom객체의 value 속성 가져온다.
    let title = titleInput.value;
    let content = contentInput.value;
    let pwd = pwdInput.value;
    
    //[2] 입력받은 값들을 객체화
    let board = {title:title, content:content, pwd:pwd};
    
    //[3] fetch함수를 이용한 자바의 컨트롤러에게 입력받은 값 전달하고 응답
    const option = {    // fetch 함수가 HTTP통신할 때 사용할 부가정보가 담긴 객체
        method : 'POST',    // (1) method: HTTP통신할 떄 사용할 메소드 선택(post:저장, get:호출, put:수정, delete:삭제)
        // 글쓰기 이므로 4개중 POST 선택
        Headers : {'Content-Type' : 'application/json'}, // HTTP통신의 부가정보,
        // 'Content-Type'이란, 보내고자 하는 데이터의 타입 설정, 'application/json':JSON타입
        body : JSON.stringify(board),                   // HTTP통신의 본문
        // JSON.stringify(객체) : JSON객체타입을 문자열 타입으로 변환 함수
        // <-- input으로 부터 입력받은 JSON형식의 문자열타입으로 전송
        }
    fetch('자바컨트롤러URL', option) // fetch('통신할URL',옵션)
        .then(response => response.json())  //.then(매개변수명 => 매개변수명.json()) : 응답결과를 json타입으로 변환
        .then(data => {                     //.then(매개변수명/응답값 => {응답결과 코드})
            //[4] 응답 결과에 따른 메시지 출력한다.
            if(data==true){
                alert('write success');}
            else{alert('write fail')}
        })
        .catch(error=>{ console.log(err); } ); //.catch(매개변수명 => {오류결과 코드;})

}

//(2) 글 출력 함수
function findAll(){

}