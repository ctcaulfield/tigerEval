<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
	
	//html content
	
	//table
	echo '<div class="col-md-8" style="margin-left: 25%;">
			<h2 class="text-center">Current Courses</h2>
			<div>
				<table class="profCourses">
				  <thead>
					<tr><th>Course</th><th>Section</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
				  </thead>
				  <tbody>
					<tr><td>ISTE - 120</td><td>01</td><td>2161</td><td>Practical 3</td><td>Submitted</td></tr>
					<tr><td>ISTE - 120</td><td>02</td><td>2161</td><td>Practical 3</td><td><a href="./submit_grades.php">Submit Grades</a></td></tr>
				  </tbody>
				</table>
			</div>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//datatables script
	echo '<script>$(function(){$(".profCourses").DataTable();});</script>';
?>
