<?php
	include('LIB_tigerEval.php');
	my_Init();

	
	echo MyUtils::html_header();
	
	//html content
	
	
	//contents
	echo '<div id="contents" class="col-md-8" style="margin-left: 25%;">
			<label for="numStudents">Number of Students:</label> <input id="numStudents" type="text" style="width:25px;" value="5"><br/>
			<h5>Grade Results:</h5>
			<form action="professorGradeSubmission.php">
				<div id="gradeResults">
					<div class="gradeResultContainer"><input class="gradeResult" type="text" style="width:50px;"><br/></div>
					<div class="gradeResultContainer"><input class="gradeResult" type="text" style="width:50px;"><br/></div>
					<div class="gradeResultContainer"><input class="gradeResult" type="text" style="width:50px;"><br/></div>
					<div class="gradeResultContainer"><input class="gradeResult" type="text" style="width:50px;"><br/></div>
					<div class="gradeResultContainer"><input class="gradeResult" type="text" style="width:50px;"><br/></div>
				</div>
				<br/>
			</form>
			<button id="submitButton">Submit Grades</button>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//javascript for creating gradeResult text inputs as the numStudents input changes (on keyup)
	echo '<script>
			$("#numStudents").keyup(function(){
				numStudents = parseInt($("#numStudents").val());
				numGrades = $(".gradeResult").length;
				if(numStudents > numGrades){
					for(i = numGrades; i < numStudents; i++){
						$("#gradeResults").append("<div class=\"gradeResultContainer\"><input class=\"gradeResult\" type=\"text\" style=\"width:50px;\"><br/></div>");
					}
				}
				else if(numGrades > numStudents){
					for(i = numStudents; i < numGrades; i++){
						$(".gradeResultContainer").eq(-1).remove();
					}
				}
			});
		  </script>';
	
	//javascript for validating gradeResult text inputs
	echo '<script>
			$("#submitButton").click(function(){
				if(!$.isNumeric($("#numStudents").val())){
					$("#numStudents").css("border", "1px solid red");
				}
				for(i = 0; i < $(".gradeResult").length; i++){
					if(!$.isNumeric($(".gradeResult").eq(i).val())){
						$(".gradeResult").eq(i).css("border", "1px solid red");
					}
					else{
						if(parseInt($(".gradeResult").eq(i).val()) < 0 || parseInt($(".gradeResult").eq(i).val()) > 100){
							$(".gradeResult").eq(i).css("border", "1px solid red");
						}
					}
				}
			});
		  </script>';
		  
	//javascript for clearing validation errors as inputs change (on keyup)
	echo '<script>
			$("#numStudents").keyup(function(){
				$(this).css("border", "");
			});
			$(".gradeResult").keyup(function(){
				$(this).css("border", "");
			});
		  </script>';
	
?>
