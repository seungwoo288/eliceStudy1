import "./app.css";
import Counter from "./[실습 4] Counter 클로저 구현하기";

const App = () => {
  const counter = Counter();

  const increaseButton = document.getElementById("increase-button");
  const decreaseButton = document.getElementById("decrease-button");
  const currentCount = document.getElementById("current-count");

  increaseButton.addEventListener("click", () => {
    counter.increase();
    currentCount.innerHTML = counter.getCount();
  });

  decreaseButton.addEventListener("click", () => {
    counter.decrease();
    currentCount.innerHTML = counter.getCount();
  });
};

export default App;
