/**
 * 
 */
let fullname = document.getElementById("uname");
let email = document.getElementById("uemail");
let phone = document.getElementById("uphone");
let std = document.getElementById("ustd");
let pwd = document.getElementById("upwd");
let btn = document.getElementById("btn");
registereddata = [];

btn.addEventListener("click", (e) => {
  e.preventDefault();
  let registereddata = JSON.parse(localStorage.getItem("rdata"));
  registereddata.push({
    uname: fullname.value,
    uemail: email.value,
    uphone: phone.value,
    ustd: std.value,
    upwd: pwd.value,
  });
  localStorage.setItem("rdata", JSON.stringify(registereddata));
});
