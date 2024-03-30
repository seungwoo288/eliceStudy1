function isPrime(n){
    var divisor = 2;

    if(n == 1) return false;

    while(n > divisor) {
        if(n % divisor == 0) {
            return false;
        }
        else {
            divisor++;
        }
    }
    return true;
}

for(var i = 1; i <= 10; i++) {
    document.writeln(i, isPrime(i));
}