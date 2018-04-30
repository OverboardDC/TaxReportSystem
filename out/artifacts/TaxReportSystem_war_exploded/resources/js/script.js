
$(document).ready(function() {
    $('#client_type_select').change(function(event) {
        if($(this).val() === 'company'){
            $('#company_items').show();
            $('#individual_items').hide();
        }
        if($(this).val() === 'individual'){
            $('#individual_items').show();
            $('#company_items').hide();
        }
    });
});

