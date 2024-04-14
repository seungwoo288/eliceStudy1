const TwoDotDistance = {
  point1: {
    x: 0,
    y: 0,
  },

  point2: {
    x: 0,
    y: 0,
  },

  setPoints: function (x1, y1, x2, y2) {
    this.point1.x = x1
    this.point1.y = y1
    this.point2.x = x2
    this.point2.y = y2
  },

  calculateDistance: function () {
    const result = Math.sqrt(
        Math.pow(this.point1.x - this.point2.x, 2) +
        Math.pow(this.point1.y - this.point2.y, 2)
    )

    if(isNaN(result)) return '0'

    return result.toFixed(2)
  },
};

export default TwoDotDistance;
