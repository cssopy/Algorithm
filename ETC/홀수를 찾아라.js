function solution(arr){
    arr.sort();

    for(let i =0; i<arr.length; i+=2){
        if(arr[i] != arr[i+1]){
            return arr[i];
        }
    }
}

let inps = [
    [3,2,5,5,1,2,3],
]

inps.forEach(v=>console.log(solution(v)));