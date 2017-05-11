<?php

class MyUtils{
	// contains all content from beginning of HTML to end of navbar
	//parameters
	
	// $title - provide a title to the html file
	
	// $location - the location of the child thats calling this parent
	//	function - ex: "../" -> for call from a file one folder down
	// from template.class.php
	
	// $script - name of javascript file used in this code
	static function html_header($title="", $location = "", $srcName = ""){
		$string = <<<END
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="utf-8" />
			<title>TigerEval - {$title}</title>

			<!-- JQuery, JQueryUI, Datatables, and Boostrap-->

			<script src="{$location}assets/jquery/jquery-3.1.1.min.js"></script>
			<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
			<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
			<script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
			<script src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js"></script>
			<script src="https://cdn.datatables.net/fixedheader/3.1.2/js/dataTables.fixedHeader.min.js"></script>
			<script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
			<script src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script>
			<script src="{$location}assets/bootstrap/js/bootstrap.min.js"></script>	
		    <link href="{$location}assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">			
			<!-- end JQuery and Boostrap-->

			<!-- exporting all data from datatables -->
			<script src='https://cdn.datatables.net/buttons/1.2.1/js/dataTables.buttons.min.js'></script>
			<script src='//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js'></script>
			<script src='//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js'></script>
			<script src='//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js'></script>
			<script src='//cdn.datatables.net/buttons/1.2.1/js/buttons.html5.min.js'></script>
			<!-- end of exporting-->


			<!--local javascript & css-->
			<script src="{$location}assets/js/{$srcName}.js"></script>
			<link href="{$location}assets/css/{$srcName}.css" rel="stylesheet">
			<!-- end Javascript-->
			
			<!--Datatables css-->
			<link href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css" rel="stylesheet">
			<link href="https://cdn.datatables.net/select/1.2.2/css/select.bootstrap.min.css" rel="stylesheet">

			<!-- end Datatables css-->

		</head>
		<body>

		  <!-- navigation bar -->

		  <nav class="navbar navbar-default">
		    <div class="container-fluid">
		      <!-- Brand and toggle get grouped for better mobile display -->
		      <div class="navbar-header">
		        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		          <span class="sr-only">Toggle navigation</span>
		          <span class="icon-bar"></span>
		          <span class="icon-bar"></span>
		          <span class="icon-bar"></span>
		        </button>
		        <a class="navbar-brand" href="#">TigerEval</a>
		      </div>

		      <!-- Collect the nav links, forms, and other content for toggling -->
		      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		        <ul class="nav navbar-nav">
		  <!--         <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
		          <li><a href="#">Link</a></li> -->
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Teaching <span class="caret"></span></a>
		            <ul class="dropdown-menu">
		              <li><a href="{$location}/professor/professor_courses.php">Current Courses</a></li>
		              <li><a href="{$location}/professor/submit_grades.php">Enter Grades</a></li>
		            </ul>
		          </li>
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Coordinating<span class="caret"></span></a>
		            <ul class="dropdown-menu">
		              <!-- Course Coordinators will see course results -->
		              <li><a href="{$location}/course_coord/course_reports.php">Course Coordinator</a></li>
		              <!-- Program Coordinators will see course results -->
		              <li><a href="{$location}/program_coord/program_reports.php">Program Coordinator</a></li>
		              <!-- Assessment Coordinators will see course results -->
		              <li><a href="{$location}/assessment_coord/assessment_reports.php">Assessment Coordinator</a></li>
		            </ul>
		          </li>
		        </ul>
		        <ul class="nav navbar-nav navbar-right">
		          <li><a href="#">Notifications</a></li>
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Christopher Caulfield<span class="caret"></span></a>
		            <ul class="dropdown-menu">
		              <li><a href="#">Log out</a></li>
		            </ul>
		          </li>
		        </ul>
		      </div><!-- /.navbar-collapse -->
		    </div><!-- /.container-fluid -->
		  </nav>

		  <!--end of navigation bar-->\n
END;
		return $string;
	}



	// contains all content after the main content.
	//jquery, bootstrap, and other js files
	//closure of <body> and <html> tags
	static function html_footer($location=""){
		$string = <<<END

		</body>
		</html>\n
END;
		return $string;
	}

	function getURL($route){
	    
	    $json = file_get_contents($route);
            $obj = json_decode($json);
            return $obj;
	}
} // end class


?>
