import "./app.css";
import Context from "./[실습 2] Context 연산 함수 만들기";

const App = () => {
  const input = document.getElementById("number");
  const mulButton = document.getElementById("mul-button");
  const addButton = document.getElementById("add-button");
  const result = document.getElementById("result");

  mulButton.addEventListener("click", () => {
    result.innerHTML = Context.mul(Number(input.value));
  });

  addButton.addEventListener("click", () => {
    result.innerHTML = Context.add30(Number(input.value));
  });
};

export default App;
