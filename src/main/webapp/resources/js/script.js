
$(function () {
    let lastType = $('#last_client_type').val();
    console.log("LT" + lastType);
    if (lastType === 'individual') {
        $('#individual_items').show();
        $('#company_items').hide();
    } else if (lastType === 'company') {
        $('#company_items').show();
        $('#individual_items').hide();
    }
});


$('#client_type_select').change(function (event) {
    if ($(this).val() === 'company') {
        $('#company_items').show();
        $('#individual_items').hide();
    }
    if ($(this).val() === 'individual') {
        $('#individual_items').show();
        $('#company_items').hide();
    }
});




