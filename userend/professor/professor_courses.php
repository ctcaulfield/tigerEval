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
			<?php 
		        $data = MyUtils::getURL("http://team-codd.ist.rit.edu:8080/ProjectCodd/course/getByProfessor/1");
       				foreach($data as $infos){
					echo "<tr>";
					echo "<td>".$infos->name."</td>";
                        		echo "<td>".$infos->sections[0]->number."</td>";
					echo "<td>2165</td>";
					echo "<td>".$infos->sections[0]->instruments[0]->name."</td>";
					echo "<td>".$infos->sections[0]->submitted."</td>";
					echo "</tr>";
				}
			?>
                    </tbody>
                </table>
            </div>
        </div> <!-- end of datatable container-->
    </div> <!-- end of panel-body -->
</div>
		  
		  
<?php	
	echo MyUtils::html_footer();
	/*
	$data = MyUtils::getURL("http://team-codd.ist.rit.edu:8080/ProjectCodd/course/getByProfessor/1");
	foreach($data as $infos){
		echo $infos->name;
		foreach($infos->sections as $section){
			echo $section->number;		       
			foreach($section->instruments as $ins){
				echo $ins->name;
				echo $ins->avgGrade;
			} 
		}
		echo $infos->term;
	}*/	
?>
