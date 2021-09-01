function cancelReservation(schedule_id){
    document.getElementById(schedule_id).style.display="none"


    /*
    var id=sessionStorage.getItem("id");

    let row =document.getElementsByTagName("tr");

    var formData = JSON.stringify({
        "member_id": id,
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
            alert(err);
            /*window.location.replace("/account/"+id+"/reservations");
        }
    });
*/
}