$('#client_type_select').change(function(event) {
    if($(this).val() === 'Company'){
        $('#company_items').show();
        $('#individual_items').hide();
    }
    if($(this).val() === 'Individual'){
        $('#individual_items').show();
        $('#company_items').hide();
    }
});

