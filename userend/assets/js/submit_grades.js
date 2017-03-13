function validateForm(){
	//validate if grades were properly pasted.
	var gradeValues = $('textarea#gradesInput').val();
	console.log(gradeValues);

	switch(gradeValues){
		//case 1 - separated by commas
		case (/^(\s*[0-9]{1,3}\s*[,]\s*[0-9]{1,3}\s*)+$/.test(gradeValues)):
			
			return true;

		//case 2 - separated by spaces or line by line separation
		case (/^(\s*[0-9]{1,3}\s*)+$/.test(gradeValues)):
			
			return true;

		//default - if input not valid --> feedback
		default:

			return false;

	}
}