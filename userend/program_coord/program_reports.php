<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Program Coordinator - Reports", "../", "program_reports");
?>
	
<div class = "data_table_container">
	
	<div class="page-header">
	 	<h1>Program Coordinator <small>Current Program(s)</small></h1>
	</div>

  	<div class="">
    	<div class="panel with-nav-tabs panel-info">
        	<div class="panel-heading">
           	     <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab1" data-toggle="tab">Web and Mobile Computing</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown">Additional Programs<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#tab4" data-toggle="tab">More programs populated here</a></li>
                        </ul>
                    </li>
                </ul>
        	</div>
        <div class="panel-body">
            <div class="tab-content">
            	<div class="progress">
				  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1"
				  aria-valuemin="0" aria-valuemax="4" style="width:25%">
				    1/4 Complete
				  </div>
				</div>
				<!-- tab 1 -->
                <div class="tab-pane in active" id="tab1">
            	    <table id="" class="display table table-striped table-bordered nowrap" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Course</th>
				                <th>Course Coordinator</th>
				                <th>Term</th>
				                <th>Grading Instrument</th>
				                <th>Benchmark</th>
				                <th>Grades Reported</th>
				            </tr>
				        </thead>
				        <tbody>
				            <tr>
				                <td>ISTE 120</td>
				                <td>Michael Floeser</td>
				                <td>2161</td>
				                <td>Practical 3</td>
				                <td>86% above avg</td>
				                <td>Submitted</td> <!-- This will be a url to submit grades -->
				            </tr>
				            <tr>
				                <td>ISTE 121</td>
				                <td>Jeffrey Jockel</td>
				                <td>2161</td>
				                <td>Practical 3</td>
				                <td>86% above avg</td>
				                <td>Notify Coordinator</td>
				            </tr>
				            <tr>
				                <td>ISTE 140</td>
				                <td>Deborah LaBelle</td>
				                <td>2161</td>
				                <td>Final Exam</td>
				                <td>80% above avg</td>
				                <td>Notify Coordinator</td>
				            </tr>
				            <tr>
				                <td>ISTE 330</td>
				                <td>Michael Floeser</td>
				                <td>2161</td>
				                <td>Final Exam</td>
				                <td>80% above avg</td>
				                <td>Notify Coordinator</td>
				            </tr>
				        </tbody>
				    </table>
                </div>
            </div>
        </div>
    </div>
</div>

	  
<?php
	echo MyUtils::html_footer();
?>
