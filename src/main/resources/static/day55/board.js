/*
- fetch( '요청할URL' , 옵션 )                    <--- 자바의 컨트롤러URL 작성.
.then( respone => respone.json() )  <--- 요청 결과를 JSON(JS객체) 형식으로 변환
.then( data => { 실행문; } )        <--- 요청 결과후 실행할 코드 작성.
.catch( error => { 실행문; } )      <--- 예외 발생시 실행할 코드 작성.
- 옵션 
{ 
    method : 'GET'/'POST'/'PUT'/'DELETE',                   <---- 4중에 사용할 HTTP메소드를 작성한다. 생략시 GET 이 된다.
    headers : { 'Content-Type' : 'application/json'} ,      <---- 서버에게 보낼 자료를 json 형식으로 보내기.
    body : JSON.stringify( 전송할객체 ),                    <--- 서버에게 보낼 객체
}
*/

// ' ' 안에는 뛰어쓰기 금지 = 정해진 값일때 ex) 주소, fet 등등

// 글쓰기 함수
function onWrite(){ console.log('onWrite load');
    //[1] 저장할 게시물 정보 샘플, 추후에 document.querySelector 이용하여 입력받아 할 예정
    let sampleBoard = { "btitle" : "테스트제목", "bcontent" : "테스트내용", "bwriter" : "유재석", "bpwd" : "1234" }

    //[2] fetch 함수에 사용할 옵션 객체
    let option = {
        method : 'POST', // HTTP가 제공하는 method 선택
        headers : { 'Content-Type' : 'application/json'}, // HTTP 데이터 전송시 body 사용.
        body : JSON.stringify(sampleBoard) //HTTP에 보낼 데이터를 body에 작성
    }

    //[3] fetch 함수 사용.
    fetch('/write', option)
        .then( response => response.json() )
        .then( data => {console.log(data); })
        .catch( error => { console.log(error) });

}


//전체 조회
function onFindAll(){ console.log('onFindAll load')
    // [1] fetch
    fetch('/findall')
    .then( response => response.json() )
    .then( data => {console.log(data); })
    .catch( error => { console.log(error) });
}


//개별 조회
function onFindId(){ console.log('onFindId load')
    // [1] 조회할 게시물 번호 필요, 
    let sampleBno = 3;
    // [2] fetch
    fetch(`/findid?bno=${sampleBno}`)
        .then(r => r.json() )
        .then(d => {console.log(d) })
        .catch(e => {console.log(e) });
}

//수정
function onUpdate(){ console.log('onUpdate load')
    // [1] 수정할 게시물 번호 필요
    let sampleBoard = {"bno" : 3 ,  "btitle" : "수정한제목" ,  "bcontent" : "수정한내용" }
    // [2] fetch
    fetch(`/update`, {
        method : 'PUT', headers:{'Content-Type' : 'application/json'},
        body : JSON.stringify(sampleBoard)
    })
    .then(r => r.json() )
    .then(d => {console.log(d) })
    .catch(e => {console.log(e) });
}

//삭제
function onDelete(){ console.log('onDelete load')
    // [1] 삭제할 게시물 번호, 샘플은 DB에 존재하는 게시물 번호 진행
    let sampleBno = 4;
    // [2] fetch
    fetch(`/delete?bno=${sampleBno}`,{method:`delete`})
        .then(r => r.json() )
        .then(d => {console.log(d) })
        .catch(e => {console.log(e) });
}