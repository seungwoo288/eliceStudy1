import "./app.css";
import Clock from "./Clock";

const App = () => {
  const result = document.getElementById("result");

  setInterval(() => {
    result.innerHTML = Clock.getCurrentTime(new Date());
  }, 1000);
};

export default App;
