const fs = require("fs");
const path = require("path");

const inputPath = path.join(__dirname, 'input.txt');
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const length = Number(input[0]);
const dist = input[1].split(" ").map(BigInt);
const gas = input[2].split(" ").map(BigInt);

let totalCost = BigInt(0); // totalCost를 BigInt로 초기화
let currentPrice = gas[0]; // 첫 번째 도시의 기름 가격

for (let i = 0; i < length - 1; i++) {
    // 현재 도시의 기름 가격이 더 낮으면 갱신
    currentPrice = currentPrice < gas[i] ? currentPrice : gas[i];
    // 현재 가격으로 다음 도시까지의 거리만큼 기름 비용을 추가
    totalCost += currentPrice * dist[i];
}

console.log(totalCost.toString()); 
