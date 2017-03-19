//checks if the grades match the correct input format
//
function validateForm(){
	//validate if grades were properly pasted.
	var gradeValues = $('textarea#gradesInput').val();
	console.log("grade values: "+gradeValues);

	//comma separation?
	if(/^[0-9]{1,3}(,[0-9]{1,3})*$/.test(gradeValues)){
		console.log("valid input - commas");
		if(!correctValues(gradeValues)){
			return false;
		}	
	}
	//separated by spaces or line by line separation?
	else if(/^(\s*[0-9]{1,3}\s*)+$/.test(gradeValues)){
		console.log("valid input - line/line");
		if(!correctValues(gradeValues)){
			return false;
		}		
	}
	//did not follow the correct guideline for grade submission
	else{
		console.log("invalid");
		return false;
	}
	return true;
}

//checks if the input values equals # students in course
//checks if each value is within range of 0-100
function correctValues(gradeValues){
	//repaces new lines with a comma, will split by whitespace or comma
	//and appends grade to array.
	var gradesArray = gradeValues.replace(/\n/g, ",").split(/[ ,]+/);
	var totalStudents = document.getElementById("numStudents").value;
	if(gradesArray.length != totalStudents){
		console.log("total students and input not equal");
		return false;
	}
	else{
		console.log("equal!")
		return true;
	}

}

