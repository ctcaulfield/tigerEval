<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("export", "../", "export");
?>
	
<div class = "data_table_container">
	
	<div class="page-header">
	 	<h1>Assessment Coordinator<small>   Export</small></h1>
	</div>            
	<table id="example" class="display table table-striped table-bordered nowrap" cellspacing="0" width="100%" class="display row-border nowrap table-striped responsive-utilities jambo_table">
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
            <td>Notify Teacher</td>
        </tr>
        <tr>
            <td>ISTE 140</td>
            <td>Deborah LaBelle</td>
            <td>2161</td>
            <td>Final Exam</td>
            <td>86% above avg</td>
            <td>Notify Teacher</td>
        </tr>
    </tbody>
</table>
    <!-- Directs to where grades are exported to taskstream -->
    <a class="btn btn-warning" href="assessment_reports.php">Return to Assessment Reports</a>
</div>
	  
<?php
	echo MyUtils::html_footer();
?>
