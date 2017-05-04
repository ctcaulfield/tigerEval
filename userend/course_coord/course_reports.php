<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Course Coordinator - Reports", "../", "course_reports");
?>
  		<div class = "data_table_container">
  			<div class="page-header">
			 	<h1>Course Coordinator <small>Current Sections</small></h1>
			</div>
		  	<div class="">
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
                    	    
                    	    <div class="progress">
								 <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="1"
								  aria-valuemin="0" aria-valuemax="2" style="width:50%">
								    1/2 Complete
								  </div>
							</div>
                    	    
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
						                <td>ISTE 120</td>
						                <td>01</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Practical 3</td>
						                <td>Submitted</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 120</td>
						                <td>02</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Final Exam</td>
						                <td>Notify Teacher</td>
						            </tr>
						        </tbody>
						    </table>
                        </div>

                        <!-- tab 2-->
                        <div class="tab-pane" id="tab2">
                        	<div class="progress">
							 <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="0"
						    	aria-valuemin="0" aria-valuemax="2" style="width:0%">
							    0/2 Complete
							  </div>
							</div>
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
						                <td>Notify Teacher</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 121</td>
						                <td>02</td>
						                <td>Jeffrey Jockel</td>
						                <td>2161</td>
						                <td>Practical 1</td>
						                <td>Notify Teacher</td>
						            </tr>
						        </tbody>
						    </table>

                        </div>

                        <!-- tab 3 -->
                        <div class="tab-pane" id="tab3">
                    	<div class="progress">
							 <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="2"
							  aria-valuemin="0" aria-valuemax="2" style="width:100%">
							    2/2 Complete
							  </div>
						</div>
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
						                <td>ISTE 260</td>
						                <td>01</td>
						                <td>Michael Floeser</td>
						                <td>2161</td>
						                <td>Final Exam</td>
						                <td>Submitted</td> <!-- This will be a url to submit grades -->
						            </tr>
						            <tr>
						                <td>ISTE 260</td>
						                <td>02</td>
						                <td>Jeffrey Jockel</td>
						                <td>2161</td>
						                <td>Final Exam</td>
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
    </div>
		  
<?php	
	echo MyUtils::html_footer();
	//accordion and datatables script
	echo '<script>$(function(){$(".accordion").accordion({collapsible: true});});</script>';
	echo '<script>$(function(){$(".coordCourses").DataTable();});</script>';
?>
