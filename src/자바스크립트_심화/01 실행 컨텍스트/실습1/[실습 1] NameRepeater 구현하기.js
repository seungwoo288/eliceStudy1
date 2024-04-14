const NameRepeater = {
  name: "My Name",
  setName: function setName(name) {
    this.name = name
  },
  repeatName: function repeatName(num) {
    return this.name.repeat(num)
  },
};

export default NameRepeater;
