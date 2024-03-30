
function move() {
    var box = document.getElementById('move');
    box.style.width = "600px";
    box.style.height = "600px";
    box.style.left = "300px";
};

var btn = document.getElementById('btn');
btn.addEventListener("click", move);