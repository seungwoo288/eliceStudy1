function timesTable(n) {
    for(var i = 1; i < 10; i++) {
        document.write(n + " x " + i + " = " + n*i + '<br>');
    }
}

timesTable(2); // 2단만 출력
timesTable(3); // 3단만 출력