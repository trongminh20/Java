var fileReader = new fileReader();

fileReader.onload = function(e){
	var file = document.getElementByID("contents");

	file.innerText = fileReader.result;

}

fileReader.readAsText("./default.txt")