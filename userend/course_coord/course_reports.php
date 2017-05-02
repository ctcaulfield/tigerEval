<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Course Coordinator - Reports", "../", "course_reports");
?>
	
<!-- <div class="col-md-8" style="margin-left: 25%;">
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
  </div> -->

		  <div class="col-md-6">
            <div class="panel with-nav-tabs panel-info">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1" data-toggle="tab">ISTE 120</a></li>
                            <li><a href="#tab2" data-toggle="tab">ISTE 121</a></li>
                            <li><a href="#tab3" data-toggle="tab">ISTE 260</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">Additional Courses<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#tab4" data-toggle="tab">More courses populated here</a></li>
                                </ul>
                            </li>
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        
						<!-- tab 1 -->
                        <div class="tab-pane in active" id="tab1">
                    	    <table id="" class="display table table-striped table-bordered nowrap" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                <th>Course</th>
						                <th>Section</th>
						                <th>Professor</th>
						                <th>Term</th>
						                <th>Grading Instrument</th>
						                <th>Grades Reported</th>
						            </tr>
						        </thead>
						        <tbody>
						            <tr>
						                <td>ISTE 121</td>
						                <td>01</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Practical 3</td>
						                <td>Submitted</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 121</td>
						                <td>02</td>
						                <td>Jeffrey Jockel</td>
						                <td>2161</td>
						                <td>Practical 1</td>
						                <td>Submitted</td>
						            </tr>
						        </tbody>
						    </table>
                        </div>

                        <!-- tab 2-->
                        <div class="tab-pane" id="tab2">
                    	    <table id="" class="display table table-striped table-bordered nowrap" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                <th>Course</th>
						                <th>Section</th>
						                <th>Professor</th>
						                <th>Term</th>
						                <th>Grading Instrument</th>
						                <th>Grades Reported</th>
						            </tr>
						        </thead>
						        <tbody>
						            <tr>
						                <td>ISTE 121</td>
						                <td>01</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Practical 3</td>
						                <td>Submitted</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 121</td>
						                <td>02</td>
						                <td>Jeffrey Jockel</td>
						                <td>2161</td>
						                <td>Practical 1</td>
						                <td>Submitted</td>
						            </tr>
						        </tbody>
						    </table>

                        </div>

                        <!-- tab 3 -->
                        <div class="tab-pane" id="tab3">
                    	    <table id="" class="display table table-striped table-bordered nowrap" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                <th>Course</th>
						                <th>Section</th>
						                <th>Professor</th>
						                <th>Term</th>
						                <th>Grading Instrument</th>
						                <th>Grades Reported</th>
						            </tr>
						        </thead>
						        <tbody>
						            <tr>
						                <td>ISTE 121</td>
						                <td>01</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Practical 3</td>
						                <td>Submitted</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 121</td>
						                <td>02</td>
						                <td>Jeffrey Jockel</td>
						                <td>2161</td>
						                <td>Practical 1</td>
						                <td>Submitted</td>
						            </tr>
						        </tbody>
						    </table>

                        </div>

                        <!-- tab 4 -->
                        <div class="tab-pane" id="tab4">


                        </div>

                        <!-- tab 5 -->
                        <div class="tab-pane" id="tab5">


                        </div>
                    

                    </div>
                </div>
            </div>
        </div>
		  
<?php	
	echo MyUtils::html_footer();
	//accordion and datatables script
	echo '<script>$(function(){$(".accordion").accordion({collapsible: true});});</script>';
	echo '<script>$(function(){$(".coordCourses").DataTable();});</script>';
?>
