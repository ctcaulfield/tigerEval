<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor Courses", "../", "professor_courses");
?>
<div class="data_table_container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Current Courses</h3>
        </div>
        <div class="panel-body">
            <div class="panel panel-info">
                <table id="professor_course" class="table table-striped table-bordered nowrap" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>Course</th>
                            <th>Section</th>
                            <th>Term</th>
                            <th>Grading Instrument</th>
                            <th>Grades Reported</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>ISTE 120</td>
                            <td>01</td>
                            <td>2161</td>
                            <td>Practical 3</td>
                            <td>Submit Now</td> <!-- This will be a url to submit grades -->
                        </tr>
                        <tr>
                            <td>ISTE 121</td>
                            <td>02</td>
                            <td>2161</td>
                            <td>Practical 1</td>
                            <td>Submitted</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div> <!-- end of datatable container-->
    </div> <!-- end of panel-body -->
</div>
		  
		  
<?php	
	echo MyUtils::html_footer();
?>
