function registerTrainer() {
    let email = document.getElementById("email1").value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('surname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password1').value;
    let password1 = document.getElementById('password2').value;
    let username = document.getElementById('username').value;
    let date=document.getElementById('date_of_birth').value;
    let gym=document.getElementById('gym').value;
    let id=sessionStorage.getItem("id");
    if(password1==password){
        var formData = JSON.stringify({
            "email": email,
            "name": name,
            "phone_number":phone,
            "surname":lastname,
            "password":password,
            "username":username,
            "date_of_birth":date,
            "role":2,
            "active":false,
            "gym_id":Number.parseInt(gym)
        });
        $.ajax({
            url: '/create_trainer',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: formData,
            success: function(data){
                window.location.replace("/account/"+id+"/trainers");
            },
            error: function( jqXhr, textStatus, errorThrown ){
                // window.location.replace("/account/"+id+"/trainers");
            }
        });
    }else{
        alert("Passwords do not match!");
    }
}
function trainers(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/trainers");
}
function createTrainer(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/register_trainer");
}
function deleteTrainer(trainer_id){
    let id=sessionStorage.getItem("id");
    $.ajax({
        url: '/remove_trainer/'+trainer_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/account/"+id+"/trainers");
        },
        error: function(){
            window.location.replace("/account/"+id+"/trainers");
        }
    });
}

