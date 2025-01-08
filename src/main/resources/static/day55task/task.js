_print();
function _print(){
    const todoBottom = document.querySelector('.todoBottom');
    fetch('/view')
    .then(r=>r.json())
    .then(d=> {let todolist= d;
    let HTML = '';
    for( let index = 0 ; index <= todolist.length - 1 ; index++ ){
    const 할일 = todolist[index]; //- index번째의 객체 꺼내기
    
    HTML += `<div class="contBox ${ 할일.status ? 'success' : '' }"> 
                <div class="cont"> ${ 할일.content } </div>
                <div class="contBtns">
                    <button onclick="_update( ${ 할일.bno } )" class="updateBtn"> 수정 </button>
                    <button onclick="_delete( ${ 할일.bno } )" class="deleteBtn"> 삭제 </button>
                </div>
            </div>`

    }todoBottom.innerHTML = HTML;})
    .catch(e=>console.log(e))

}

_update();
function _update(bno){
    fetch(`/update?bno=${bno}` , {method : 'PUT'})
    .then(r=>r.json)
    .then(d=>console.log(d))
    .catch(e=>console.log(e))

    _print();
    return;
}