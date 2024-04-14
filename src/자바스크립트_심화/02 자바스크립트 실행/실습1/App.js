import "./app.css";
import TwoDotDistance from "./TwoDotDistance";

const App = () => {
  const point1X = document.getElementById("point1-x");
  const point1Y = document.getElementById("point1-y");
  const point2X = document.getElementById("point2-x");
  const point2Y = document.getElementById("point2-y");
  const calculateButton = document.getElementById("calculate-button");
  const result = document.getElementById("result");

  calculateButton.addEventListener("click", () => {
    const [p1x, p1y, p2x, p2y] = [
      point1X.value,
      point1Y.value,
      point2X.value,
      point2Y.value,
    ];

    TwoDotDistance.setPoints(p1x, p1y, p2x, p2y);
    const distance = TwoDotDistance.calculateDistance();

    result.innerHTML = `<h4>두 점 사이의 거리 : ${distance}</h4>`;
  });
};

export default App;
