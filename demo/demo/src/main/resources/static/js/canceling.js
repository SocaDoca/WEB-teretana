function cancelReservation(schedule_id){
    var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "schedule_id": schedule_id,
    });
    $.ajax({
        url: '/cancel_reservation',
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        data: formData,
        success: function(){
            window.location.replace("/account/"+id+"/reservations");
        },
        error: function(){
            window.location.replace("/account/"+id+"/reservations");
        }
    });

}