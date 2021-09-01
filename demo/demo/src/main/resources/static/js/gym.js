function addGym() {
    let email = document.getElementById('email_reg').value;
    let name = document.getElementById('name').value;
    let phone = document.getElementById('phone').value;
    let address = document.getElementById('address').value;
    var formData = JSON.stringify({
        "email": email,
        "name": name,
        "phone_number":phone,
        "address":address
    });
    console.log(formData);
    $.ajax({
        url: '/add-gym',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
            console.log("success");
            window.location.replace("/gyms");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}
function deleteGym(id) {

    $.ajax({
        url: '/gyms/'+id,
        type: 'delete',
        success: function(){
            console.log("success");
            window.location.replace("/gyms");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}
function edit(gym_id){
    window.location.replace("/gym/"+gym_id);
}
function editGym(gym_id){

    let name=document.getElementById("name").value;
    let address=document.getElementById("address").value;
    let phone_number=document.getElementById("phone_number").value;
    let email=document.getElementById("email").value;
    var formData = JSON.stringify({
        "id":gym_id,
        "name": name,
        "address": address,
        "email":email,
        "phone_number":phone_number,
        "schedule":null,
        "trainers":null,
        "rooms":null
    });
    $.ajax({
        url: '/edit_gym',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("Something's wrong!");
            }
            else {
                window.location.replace("/gyms");
            }
        }
    });

}

function getAllGyms() {
    $.ajax({
        url: '/getAllGyms',
        dataType: 'json',
        type: 'get',
        contentType: 'application/json',
        success: function(data){
            let table = document.getElementById('gymsTable');
            let tableHtml = table.innerHTML;
            data.forEach(item => {
                tableHtml += `<tr><td>${item.name}</td><td>${item.email}</td><td><button onClick="deleteGym(${item.id})">remove</button></td></tr>`;
            });
            table.innerHTML = tableHtml;
            console.log(data);
            // window.location.replace("/gyms");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
            }
        }
    });
}