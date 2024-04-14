
const RotationEncryptor = {
  message: "",
  rotation: 0,

  encrypt: function () {
    return this.message
    .split("")
    .map(c => String.fromCharCode(c.charCodeAt(0) + this.rotation)).join("");
  },

  setMessage: function (message) {
    this.message = message;
  },

  setRotation: function (rotation) {
    this.rotation = rotation;
  },
};

export default RotationEncryptor;
