<?php
	include('LIB_tigerEval.php');
	my_Init();

	
	echo MyUtils::html_header();
	
	//html content
	
	//sidebar
	echo '<div class="col-sm-3 col-md-2 sidebar" style="background-color: #f5f5f5;padding-top:15px;padding-bottom:15px;margin-top:-20px;height:100%;position:fixed;">
          <ul class="nav nav-sidebar">
            <li><strong>My Teaching</strong></li>
            <li class="active"><a href="#">Courses</a><span class="sr-only">(current)</span></li>
            <li><a href="#">Enter Grades</a></li>
            <li style="padding-top:10px;"><strong>Coordinating</strong></li>
			<li><a href="#">Course Results</a></li>
          </ul>
        </div>';
	
	//table
	echo '<div class="col-md-8" style="margin-left: 25%;">
			<h2 class="text-center">Current Courses</h2>
			<div class="accordion">
				<h3 id="class1name" class="text-center" style="cursor:pointer;">ISTE - 120 - (1/2)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class1">
					<table class="table table-bordered table-striped table-hover">
					  <tbody>
						<tr><th>Course</th><th>Section</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
						<tr><td>ISTE - 120</td><td>01</td><td>2161</td><td>Practical 3</td><td>Submitted</td></tr>
						<tr><td>ISTE - 120</td><td>02</td><td>2161</td><td>Practical 3</td><td><a href="#">Notify Teacher</a></td></tr>
					  </tbody>
					</table>
				</div>
				<h3 id="class2name" class="text-center" style="cursor:pointer;">ISTE - 121 - (4/4)<span class="glyphicon glyphicon-plus pull-right" aria-hidden="true"></span></h3>
				<div id="class2">
					<table class="table table-bordered table-striped table-hover">
					  <tbody>
						<tr><th>Course</th><th>Section</th><th>Term</th><th>Grading Instrument</th><th>Grades Submitted</th></tr>
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
	//accordion script
	echo '<script>$(function(){$(".accordion").accordion({collapsible: true});});</script>';
?>
