$(document).ready(function () {
    $('.onClickDisabled').on('click', function () {
        const element = $(this);
        $('body').addClass('loading');
        setTimeout(function () {
            element.attr('disabled', true);
        }, 30)
    });
    $(".autoRemove").fadeTo(2000, 500).slideUp(500, function () {
        $(".autoRemove").slideUp(500);
    });
    $('.onClickAddLoader').on('click', function () {
        $('body').addClass('loading');
    })
});