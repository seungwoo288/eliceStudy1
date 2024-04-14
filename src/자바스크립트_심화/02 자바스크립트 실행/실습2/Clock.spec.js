import Clock from "./Clock";

describe("Test Clock", () => {
  test("1 - 현재 시간을 출력합니다.", () => {
    const d = new Date(2020, 1, 1, 12, 16, 30);
    const res = Clock.getCurrentTime(d);
    expect(res).toBe("현재 시간은 2020년 2월 1일 12시 16분 30초 입니다.");
  });

  test("2 - 현재 시간을 출력합니다.", () => {
    const d = new Date(2021, 2, 3, 14, 59, 22);
    const res = Clock.getCurrentTime(d);
    expect(res).toBe("현재 시간은 2021년 3월 3일 14시 59분 22초 입니다.");
  });

  test("3 - 에러 발생시 에러 메시지를 반환합니다.", () => {
    const res = Clock.getCurrentTime();
    expect(res).toBe("현재 시간을 구할 수 없습니다.");
  });
});
