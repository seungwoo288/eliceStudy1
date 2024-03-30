// select 클래스를 가지고 있는 3개의 요소를 가져옵니다.
var one = document.getElementsByClassName('.select');
var two = document.getElementsByClassName('.select');
var three = document.getElementsByClassName('.select');

function handleOnclick() {
  this.classList.toggle("on"); // 선택된 요소에 on 클래스를 추가
}

// 가져온 3개의 요소에 이벤트를 등록합니다.
one.addEventListener("click", handleOnclick);
two.addEventListener("click", handleOnclick);
three.addEventListener("click", handleOnclick);
