$(document).ready(function() {
  $('#example').DataTable({
                    "lengthMenu": [5, 10, 50, 100],
                    "pageLength": 50,
                    "scrollX": true,
                    dom: 'Bfrtip',
                    buttons: [{
                            extend: 'excelHtml5',
                            text: '<button type="button" style="margin: 10px" class="btn btn-info">Export All</button>',
                            exportOptions: {
                                columns: ':visible:not(.not-exported)'
                            },
                            title: 'Data export'
                        }, {
                            extend: 'excelHtml5',
                            text: '<button type="button" class="btn btn-success">Export Selected</button>',
                            exportOptions: {
                                columns: ':visible:not(.not-exported)',
                                modifier: {
                                    selected: true
                                }
                            },
                            title: 'Data export'
                        }
                    ],
                    select: {
                        style : "multi"
                    }
                });
});