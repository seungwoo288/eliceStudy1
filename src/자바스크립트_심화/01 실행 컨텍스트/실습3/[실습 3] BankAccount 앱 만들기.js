const BankAccount = {
  deposit: 0,
  name: "",

  changeName: function (name) {
    this.name = name;
  },

  saveMoney: function (amount) {
    this.deposit += amount;
  },

  withdrawMoney: function (amount) {
    this.deposit -= amount;
  },

  getDeposit: function () {
    return this.deposit;
  },
};

export default BankAccount;
