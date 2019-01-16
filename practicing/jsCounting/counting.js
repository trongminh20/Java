/*
displace the times of visiting on html page
*/
var number =  localStorage.getItem('loading');

if(number === null){
	number = 0;
}
number++;

localStorage.setItem('loading',number);

 var visiter = number.toString().split('').map(Number);

//document.getElementById('contents').innerHTML = number;

 for(var i of visiter){
 	document.getElementById('contents').innerHTML += '<span class="counter-item">' + i + '</span>'
 }