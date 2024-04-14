const arrayFunctions = {
  map(array, func) {
    let newArray = [];
    for(let i = 0; i < array.length; i++) {
      newArray.push(func(array[i]));
    }
    return newArray;
  },

  filter(array, func) {
    let newArray = [];
    for(let i = 0; i < array.length; i++) {
      if(func(array[i])) newArray.push(array[i]);
    }
    return newArray;
  },

  reduce(array, func, initialValue) {
    let result = initialValue;
    for(let i = 0; i < array.length; i++) {
      result = func(result, array[i]);
    }
    return result;
  },
};

export default arrayFunctions
