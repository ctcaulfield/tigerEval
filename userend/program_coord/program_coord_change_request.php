<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
?>
	

<div id='container' class= 'col-lg-4 col-lg-offset-4'> 
	<h3>Change Request</h3>

	<form name="change" onsubmit="return validateForm()" method="post">
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

		<!-- Grading Instrument and/or benchmark -->
		<div class="form-group">
			<input type="checkbox" id="gradingInstrument"> Grading Instrument <br/>
			<input type="checkbox" id="benchmark"> Benchmark <br/>
		</div>
		<input type="submit" value="submit" class="btn btn-primary">
	</form>

</div>
	

<?php
	echo MyUtils::html_footer("../");
?>
