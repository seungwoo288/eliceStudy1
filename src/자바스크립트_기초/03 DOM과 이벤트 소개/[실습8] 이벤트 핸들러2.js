var carrot_btn = document.getElementById('carrot');

function showText() {
    document.getElementById("text").innerHTML = "토끼가 나타났어요!!";
};

carrot_btn.addEventListener('click', showText) ;