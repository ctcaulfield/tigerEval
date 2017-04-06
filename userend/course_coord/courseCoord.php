<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
	
	//html content
	
	//table
	echo '<div class="col-md-8" style="margin-left: 25%;">
			<h2 class="text-center">Current Courses</h2>
			<div class="accordion">
				<h3 id="class1name" class="text-center" style="cursor:pointer;">ISTE - 120 - (1/2)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class1">
					<table class="coordCourses">
					  <thead>
						<tr><th>Course</th><th>Section</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
					  </thead>
					  <tbody>
						<tr><td>ISTE - 120</td><td>01</td><td>2161</td><td>Practical 3</td><td>Submitted</td></tr>
						<tr><td>ISTE - 120</td><td>02</td><td>2161</td><td>Practical 3</td><td><a href="#">Notify Teacher</a></td></tr>
					  </tbody>
					</table>
				</div>
				<h3 style="margin-top:100px;" id="class2name" class="text-center" style="cursor:pointer;">ISTE - 121 - (4/4)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class2">
					<table class="coordCourses">
					  <thead>
						<tr><th>Course</th><th>Section</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
					  </thead>
					  <tbody>
						<tr><td>ISTE - 121</td><td>01</td><td>2161</td><td>Practical 2</td><td>Submitted</td></tr>
						<tr><td>ISTE - 121</td><td>02</td><td>2161</td><td>Practical 2</td><td>Submitted</td></tr>
						<tr><td>ISTE - 121</td><td>03</td><td>2161</td><td>Practical 2</td><td>Submitted</td></tr>
						<tr><td>ISTE - 121</td><td>04</td><td>2161</td><td>Practical 2</td><td>Submitted</td></tr>
					  </tbody>
					</table>
				</div>
			</div>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//accordion and datatables script
	echo '<script>$(function(){$(".accordion").accordion({collapsible: true});});</script>';
	echo '<script>$(function(){$(".coordCourses").DataTable();});</script>';
?>
