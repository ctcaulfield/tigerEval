<?php
	include('../LIB_tigerEval.php');
	my_Init();
	echo MyUtils::html_header("Professor", "../", "submit_grades");
?>
	

<div id='container' class= 'col-lg-4 col-lg-offset-4'> 
	<h3>Enter Change Details</h3>

	<form name="changeRequest" onsubmit="return validateForm()" method="post">
		<h3>Current Benchmark:</h3>
		<textarea class="form-control" id="newBenchmark" rows="3" disabled="yes">The current benchmark</textarea>
		
		<h3>New Benchmark:</h3>
		<textarea class="form-control" id="newBenchmark" rows="3" placeholder="Enter new benchmark" required></textarea>
		
		<h3>Other Notes:</h3>
		<textarea class="form-control" id="otherNotes" rows="3" placeholder="Enter other notes"></textarea>
		<br/>
		<br/>
		<input type="submit" value="submit" class="btn btn-primary">
	</form>

</div>
	

<?php
	echo MyUtils::html_footer("../");
?>
