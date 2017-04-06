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
			<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
			<script src="{$location}assets/bootstrap/js/bootstrap.min.js"></script>	
		    <link href="{$location}assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<!-- end JQuery and Boostrap-->

			<!--local javascript & css-->
			<script src="{$location}assets/js/{$srcName}.js"></script>
			<link href="{$location}assets/css/{$srcName}.css" rel="stylesheet">
			<!-- end Javascript-->
			
			<!--Datatables css-->
			<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
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
		              <li><a href="#">Course Results</a></li>
		              <!-- Degree Coordinators will see course results -->
		              <li><a href="#">Degree Results</a></li>
		              <!-- Program Coordinators will see course results -->
		              <li><a href="#">Program Results</a></li>
		            </ul>
		          </li>
		        </ul>
		        <ul class="nav navbar-nav navbar-right">
		          <li><a href="#">Foo</a></li>
		          <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Christopher Caulfield<span class="caret"></span></a>
		            <ul class="dropdown-menu">
		              <li><a href="#">Log out</a></li>
		              <li role="separator" class="divider"></li>
		              <li><a href="#">Settings</a></li>
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

} // end class


?>
