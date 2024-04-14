function mul(num) {
  let a = 10;
  let b = 20;
  function mul30(n) {
    return n * a * b;
  }
  return mul30(num);
}

function add30(num) {
  let a = 10;
  return (function () {
    let b = 20;
    function add() {
      return num + a + b;
    }

    return add();
  })();
}

const myModule = { mul, add30 };

export default myModule;
