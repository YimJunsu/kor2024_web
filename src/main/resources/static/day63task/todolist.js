_view()

function _upload(){
    const lcontentInput = document.querySelector('.lcontentInput')
    const lcontent = lcontentInput.value;

    const list = { "lcontent" : lcontent, "lstatus" : false }

    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(list)
    }
    fetch('/upload', option)
    .then(r=>r.json())
    .then(data=>{console.log(data);
        alert('할일 등록 성공!');
        _view();});
    .catch(e=>{console.log(e)})
}
function _view(){
    const todoBottom = document.querySelector('.todoBottom');
    fetch('/view')
    .then(r=>r.json())
    .then(d=> {let todolist=d;
        let HTML ='';
        for(let index = 0; index <= todolist.length - 1; index++ ){
            const 할일 = todolist[index]; // -index번째의 객체 꺼내기
            
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

function _change(lno){
    fetch(`/change?bno=${lno}` , {method : 'PUT'})
    .then(r=>r.json)
    .then(d=>{console.log(d)
    alert('변경 성공')
    _print();
    })
    .catch(e=>console.log(e))
    return;
}
function _remove(lno){
    fetch(`/remove?bno=${lno}` , {method : 'DELETE'})
    .then(r=>r.json)
    .then(d=>{console.log(d)
    alert('삭제 성공')
        _print();
})
    .catch(e=>console.log(e))
    return;
}