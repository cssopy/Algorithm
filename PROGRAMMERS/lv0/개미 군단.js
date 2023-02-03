function solution(hp) {
  return [5, 3, 1].reduce((a, b) => {
    let thp = hp;
    hp -= parseInt(hp / b) * b;
    return a + parseInt(thp / b);
  }, 0);
}

let inps = [23, 24, 999];

inps.forEach((v) => console.log(solution(v)));
