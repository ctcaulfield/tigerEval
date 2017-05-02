<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
	
	//html content
	
	//search
	echo '<div class="col-md-3">
			<h2 class="text-center">Search</h2>
			<div style="margin-left:160px;margin-top:20px;">
				<strong>Professor </strong><select style="width:110px;float:right;margin-right:100px;"><option>Bryan French</option></select></br></br>
				<strong>Course </strong><select style="width:110px;float:right;margin-right:100px;"><option>ISTE-341</option></select></br></br>
				<strong>Section </strong><select style="width:110px;float:right;margin-right:100px;"><option>Select</option></select></br></br>
				<strong>Term </strong><select style="width:110px;float:right;margin-right:100px;"><option>Select</option></select></br></br>
				<strong>Year </strong><select style="width:110px;float:right;margin-right:100px;"><option>Select</option></select></br></br>
				<button>Refresh</button>
			</div>
		  </div>';
	
	//table
	echo '<div class="col-md-8" style="float:left;">
			<h2 class="text-center">Previous Courses</h2>
			<div>
				<table class="assessCourses">
				  <thead>
					<tr><th>Course</th><th>Section</th><th>Term</th><th>Professor</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
				  </thead>
				  <tbody>
					<tr><td>ISTE - 341</td><td>01</td><td>2161</td><td>Bryan French</td><td>Practical 3</td><td>Submitted</td></tr>
					<tr><td>ISTE - 341</td><td>03</td><td>2161</td><td>Bryan French</td><td>Practical 3</td><td>Submitted</td></tr>
				  </tbody>
				</table>
			</div>
		  </div>';
		  
		  
	
	echo MyUtils::html_footer();
	//datatables script
	echo '<script>$(function(){$(".assessCourses").DataTable();});</script>';
?>
