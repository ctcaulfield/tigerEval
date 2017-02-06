<?php

class MyUtils{
	// contains all content from beginning of HTML to end of navbar
	static function html_header($title="Untitled"){
		$string = <<<END
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="utf-8" />
			<title>TigerEval</title>

			<!-- Bootstrap -->
		    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">



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
		              <li><a href="#">Current Courses</a></li>
		              <li><a href="#">Enter Grades</a></li>
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
	static function html_footer($text=""){
		$string = <<<END
		<!-- JQuery and Boostrap-->
		<script src="assets/jquery/jquery-3.1.1.min.js"></script>
		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<!-- end JQuery and Boostrap-->
		</body>
		</html>\n
END;
		return $string;
	}

} // end class


?>
