import "./app.css";
import RotationEncryptor from "./[실습 6] RotationEncryptor 구현하기";

const App = () => {
  const encryptButton = document.getElementById("encrypt-button");
  const input = document.getElementById("message");
  const result = document.getElementById("result");

  encryptButton.addEventListener("click", () => {
    RotationEncryptor.setMessage(input.value);
    RotationEncryptor.setRotation(10);
    result.innerHTML = `결과 : ${RotationEncryptor.encrypt()}`;
  });
};

export default App;
