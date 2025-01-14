
console.log("student.js open")

// regist함수
function _upload(){ console.log("upload() open")
    const snameInput = document.querySelector('.sameInput')
    const skorInput = document.querySelector('skorInput')
    const smathInput = document.querySelector('smathInput')
    const sengInput = document.querySelector('.sengInput')

    const sname = smathInput.value;
    const skor = skorInput.value;
    const smath = smathInput.value;
    const seng = sengInput.value;

    const list = { sname : sname, skor : skor, smath : smath, seng : seng }

    const option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(info)
    }
    fetch('/upload', option)
    .then(r=>r.json())
    .then(data=>{console.log(data)
        alert("등록 되었습니다.")
    })
    .catch(e=>{console.log(e)})
}