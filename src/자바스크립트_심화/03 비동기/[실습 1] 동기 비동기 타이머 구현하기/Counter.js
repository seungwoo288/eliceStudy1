const Counter = {
  count: 0,

  getCount: function () {
    return this.count;
  },

  resetCount: function () {
    this.count = 0;
  },

  incrementSync: function () {
    const currentTime = Date.now()
    while(true) {
      const now = Date.now()
      if(now - currentTime > 3000) break
    }

    this.count++
  },

  incrementAsync: function (callback) {
    setTimeout(() => {
      this.count++
      callback()
    }, 3000)
  },
};

export default Counter;
