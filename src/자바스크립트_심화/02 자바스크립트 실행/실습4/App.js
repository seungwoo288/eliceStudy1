import "./app.css";
import RelativeTime from "./RelativeTime";

const timeList = [
  {
    text: "5일 전",
    time: new Date().setDate(new Date().getDate() - 5), // 5일 전
  },

  {
    text: "1주 전",
    time: new Date().setDate(new Date().getDate() - 7), // 1주 전
  },

  {
    text: "1개월 전",
    time: new Date().setDate(new Date().getDate() - 28), // 1개월 전
  },

  {
    text: "2개월 전",
    time: new Date().setDate(new Date().getDate() - 28 * 2), // 2개월 전
  },

  {
    text: "2년 전",
    time: new Date().setDate(new Date().getDate() - 28 * 24), // 2년 전
  },
];

const App = () => {
  console.log("App called.");
  const ul = document.getElementById("relative-time-list");
  ul.innerHTML = timeList
  .map(
      ({ text, time }) =>
          `<li>${text}(${time}) - ${RelativeTime.diff(time)}</li>`
  )
  .join("");
};

export default App;
