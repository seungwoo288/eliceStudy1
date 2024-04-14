import "./app.css";
import AlphabetCounter from "./AlphabetCounter";

const App = () => {
  const buildButton = document.getElementById("build-button");
  const result = document.getElementById("result");
  const sentenceInput = document.getElementById("sentence");

  buildButton.addEventListener("click", () => {
    result.innerHTML = AlphabetCounter.setSentence(sentenceInput.value)
    .buildAlphabetMap()
    .buildResult();
  });
};

export default App;
