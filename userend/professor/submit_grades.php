<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
?>
	

<div id='container' class= 'col-lg-4 col-lg-offset-4'> 
	<h3>Submit Grades</h3>

	<form name="grades" onsubmit="return validateForm()" method="post">
		<!-- select course -->
		<div class="form-group">
			<label for="courseSelect">Course:</label>
			<select class="form-control" id="courseSelect" required>
			    <option value="" disabled="disabled" selected="selected">Select Course</option>
			    <option value="120">ISTE 120</option>
		    </select>
		</div>

		<!-- select section -->
		<div class="form-group">
			<label for="sectionSelect">Section:</label>
		    <select class="form-control" id="sectionSelect" required>
			    <option value="" disabled="disabled" selected="selected">Select Section</option>
			    <option value="1">01</option>
		    </select>
		</div>

		<!-- Number of students and enter grades -->
		<div class="form-group">

			<!-- number of students -->
			<label for="numStudents">Number of students in course:</label> 
			<input id="numStudents" type="text" style="width:50px;" value="5" required><br/>
			
			<!-- copy and paste input -->
		    <label for="gradesInput">Paste grades here:</label>
		    
		    <!-- Information about how to upload grades -->
			<a href="#" data-toggle="tooltip" data-placement="top"
       		title="" data-original-title="Pasted grades must be separated by spaces, commas, or line by line"
       		class="style-tooltip">Help pasting grades</a>

		    <textarea class="form-control" id="gradesInput" rows="3" required></textarea>
		</div>
		<input type="submit" value="submit" class="btn btn-primary">
	</form>

</div>
	

<?php
	echo MyUtils::html_footer("../");
?>
