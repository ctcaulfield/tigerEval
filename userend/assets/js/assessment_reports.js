$(document).ready(function() {
    var table = $('table.display').DataTable( {
        responsive: true
    } );
 
    new $.fn.dataTable.FixedHeader( table );
} );