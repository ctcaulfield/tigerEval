<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
	
	//html content
	
	//table
	echo '<div class="col-md-8" style="margin-left: 25%;">
			<h2 class="text-center">Current Courses</h2>
			<div class="accordion">
				<h3 id="class1name" class="text-center" style="cursor:pointer;">Web and Mobile Computing(1/2)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class1">
					<table class="assessCourses">
					  <thead>
						<tr><th>Course</th><th>Course Coordinator</th><th>Term</th><th>Grading Instrument</th><th>Grades Reported</th><th>Benchmark</th><th>Achieved</th></tr>
					  </thead>
					  <tbody>
						<tr><td>ISTE - 120</td><td>Michael Floeser</td><td>2161</td><td>Practical 3</td><td>Submitted</td><td>86% above average</td><td>83% better than 80%</td></tr>
						<tr><td>ISTE - 140</td><td>Deborah Labelle</td><td>2161</td><td>Final Exam</td><td>Not Submitted</td><td>86% above average</td><td>83% better than 80%</td></tr>
					  </tbody>
					</table>
				</div>
				<h3 style="margin-top:130px;" id="class2name" class="text-center" style="cursor:pointer;">Computer Information Technology(4/4)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class2">
					<table class="assessCourses">
					  <thead>
						<tr><th>Course</th><th>Course Coordinator</th><th>Term</th><th>Grading Instrument</th><th>Grades Reported</th><th>Benchmark</th><th>Achieved</th></tr>
					  </thead>
					  <tbody>
						<tr><td>CIT - 120</td><td>Michael Floeser</td><td>2161</td><td>Practical 3</td><td>Submitted</td><td>86% above average</td><td>83% better than 80%</td></tr>
						<tr><td>CIT - 140</td><td>Deborah Labelle</td><td>2161</td><td>Final Exam</td><td>Not Submitted</td><td>86% above average</td><td>83% better than 80%</td></tr>
					  </tbody>
					</table>
				</div>
			</div>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//accordion and datatables script
	echo '<script>$(function(){$(".accordion").accordion({collapsible: true});});</script>';
	echo '<script>$(function(){$(".assessCourses").DataTable();});</script>';
?>
