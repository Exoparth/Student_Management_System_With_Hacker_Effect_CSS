let registered=JSON.parse(localStorage.getItem('rdata'));
let email=document.getElementById('uemail')
let pwd=document.getElementById('upwd')
let btn=document.getElementById('btn')
btn.addEventListener('click',(e)=>{
    e.preventDefault();
    let userdetails=registered.find(ele=>email.value===ele.email && pwd.value===ele.password)
    if(userdetails){
        location.href='./dashboard.jsp'
    }
    else{
        alert('incorrect credentials or user not found')
    }
})