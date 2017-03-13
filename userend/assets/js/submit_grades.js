function validateForm(){
	//validate if grades were properly pasted.
	var gradeValues = $('textarea#gradesInput').val();
	console.log(gradeValues);
	//case 1 - separated by commas
	if(/[0-9]{1,3}[,][0-9]{1,3}/.test(gradeValues)){
		return true;
	}
	//case 2 - separated by spaces

	//case 3 - line by line separation

	//checks if number of values is equal to provided number 
	//of students


}