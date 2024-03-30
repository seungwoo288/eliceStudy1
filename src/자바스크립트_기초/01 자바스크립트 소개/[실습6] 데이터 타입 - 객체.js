var student= {
  name : "Elice",
  age : 20,
  skills : ["Java", "HTML", "CSS", "JavaScript"],
  sum : function (num1, num2) {
      return num1 + num2;
  }
}

student.name = "park";
document.write(student.name);
document.write(student.sum(10, 20));