const fs = require("fs");
const path = require("path");

//const input = fs.readFileSync(__dirname+'/input.text').toString().split("\n");
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const q = 25;
const d = 10;
const n = 5;
const p = 1;
var arr = [0, 0, 0, 0];

for (let i = 1; i <= parseInt(input[0]); i++) {
  let price = parseInt(input[i]);

  
  arr[0] = parseInt(price / q);
  price = price - (parseInt(price / q)*q);

  arr[1] = parseInt(price / d);
  price = price - (parseInt(price / d)*d);

  arr[2] = parseInt(price / n);
  price = price - (parseInt(price / n)*n);

  arr[3] = parseInt(price / p);
  price = price - (parseInt(price / p)*p);

  console.log(arr[0], arr[1], arr[2], arr[3]);
  arr = [0, 0, 0, 0];
}
