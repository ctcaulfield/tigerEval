$(document).ready(function() {
    var table = $('table.table').DataTable( {
        responsive: true
    } );
 
    new $.fn.dataTable.FixedHeader( table );
} );