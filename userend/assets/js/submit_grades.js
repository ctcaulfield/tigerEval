//checks if the grades match the correct input format
//
function validateForm(){
	//validate if grades were properly pasted.
	var gradeValues = $('textarea#gradesInput').val();
	console.log("grade values: "+gradeValues);

	//comma separation?
	if(/^[0-9]{1,3}(,[0-9]{1,3})*$/.test(gradeValues)){
		console.log("valid input - commas");
		return true;
	}
	//separated by spaces or line by line separation?
	else if(/^(\s*[0-9]{1,3}\s*)+$/.test(gradeValues)){
		console.log("valid input - line/line");
		return true;
	}
	//did not follow the correct guideline for grade submission
	else{
		console.log("invalid");
		return false;
	}
}

//checks if the input values equals # students in course
//checks if each value is within range of 0-100
function correctValues(gradeValues){
	

}

