import TwoDotDistance from "./TwoDotDistance";

describe("Test TwoDotDistance", () => {
  test("1 - 두 점 사이의 거리를 구하고, 소숫점 둘째자리 문자열을 리턴합니다.", () => {
    TwoDotDistance.setPoints(1, 1, 2, 2);
    expect(TwoDotDistance.calculateDistance()).toBe("1.41");
  });

  test("2 - 두 점 사이의 거리를 구하고, 소숫점 둘째자리 문자열을 리턴합니다.", () => {
    TwoDotDistance.setPoints(1.125, 4.403, 5.708, 3.123);
    expect(TwoDotDistance.calculateDistance()).toBe("4.76");
  });
});