function addRoom(gym_id){

    var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "mark": mark,
        "capacity": capacity,
        "cinema_id":gym_id
    });
    $.ajax({
        url: '/add_room',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/cinema");
            }
        }
    });

}
function deleteRoom(room_id,gym_id){

    var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/delete_room/'+gym_id+'/room/'+room_id,
        dataType: 'json',
        type: 'delete',
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/gym");
            }
        }
    });

}
function editRoom(room_id){

    var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "id":room_id,
        "mark": mark,
        "capacity": capacity,
    });
    $.ajax({
        url: '/edit_room',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/account/"+id+"/gym");
            }
        }
    });

}
function edit(room_id){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/gym/room/"+room_id);
}
function gym(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/gym");
}
function schedule(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/schedule");
}
