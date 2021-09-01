function approveTrainer(id) {
    $.ajax({
        url: `/account/${id}/verify`,
        type: 'get',
        contentType: 'application/json',
        complete: function () {
            window.location.reload();
            window.message('Success!');
        },
        error: function () {
            window.message('Error!');
        }
    });
}