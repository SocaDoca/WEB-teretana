function AddSchedule(gym){
    console.log(gym)
    var id=sessionStorage.getItem("id");

    let training=document.getElementById("training").value;
    let room = document.getElementById("room").value;
    let date=document.getElementById("date").value;
    let time=document.getElementById("time").value;
    let price=document.getElementById("price").value;
    var formData = JSON.stringify({
        "room_id" : room,
        "training_id": training,
        "day":date,
        "time":time,
        "price":price,
        "gym_id":gym.id
    });

    console.log(formData);

    $.ajax({
        url: '/add_schedule',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/schedule");
            }
        }
    });

    /*
    $.ajax({
        url: '/scheduleALL',
        dataType: 'json',
        type: 'get',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/schedule");
            }
        }
    });*/
}