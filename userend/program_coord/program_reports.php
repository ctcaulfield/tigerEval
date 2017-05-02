<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
	
	//html content
	
	//table
	echo '<div class="col-md-8" style="margin-left: 25%;">
			<h2 class="text-center">Current Semester</h2>
			<h4>Web and Mobile Computing</h4>
			<div>
				<table class="progCourses">
				  <thead>
					<tr><th>Course</th><th>Course Coordinator</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
				  </thead>
				  <tbody>
					<tr><td>ISTE - 120</td><td>Michael Floeser</td><td>2161</td><td>Practical 3</td><td>Submitted</td></tr>
					<tr><td>ISTE - 121</td><td>Jeffrey Jockel</td><td>2161</td><td>Practical 2</td><td><a href="#">Notify Coordinator</a></td></tr>
				  </tbody>
				</table>
			</div>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//datatables script
	echo '<script>$(function(){$(".progCourses").DataTable();});</script>';
?>
