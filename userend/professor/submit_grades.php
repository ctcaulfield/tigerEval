<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("professor", "../", "submit_grades.js");
?>
	

<div id='container' class= 'col-lg-4 col-lg-offset-4'> 
	<h3>Select Course Information</h3>

	<form name="grades" onsubmit="return validateForm()" method="post">
		<!-- select course -->
		<div class="form-group">
			<label for="courseSelect">Course:</label>
			<select class="form-control" id="courseSelect">
			    <option value="" disabled="disabled" selected="selected">Select Course</option>
			    <option value="120">ISTE 120</option>
		    </select>
		</div>

		<!-- select section -->
		<div class="form-group">
			<label for="sectionSelect">Section:</label>
		    <select class="form-control" id="sectionSelect">
			    <option value="" disabled="disabled" selected="selected">Select Section</option>
			    <option value="1">01</option>
		    </select>
		</div>

		<!-- Number of students and enter grades -->
		<div class="form-group">

			<!-- number of students -->
			<label for="numStudents">Number of students in course:</label> 
			<input id="numStudents" type="text" style="width:50px;" value="5"><br/>
			
			<!-- copy and paste input -->
		    <label for="exampleTextarea">Paste grades here:</label>
		    <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
		</div>
		<input type="submit" value="submit" class="btn btn-primary">
	</form>



</div>
	

<?php
	echo MyUtils::html_footer("../");
?>
