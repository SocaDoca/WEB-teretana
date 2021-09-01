function rateTraining(training_id,done_training_id){
    let rating=parseInt(document.getElementById("rated").value);
    var formData = JSON.stringify({
        "training_id": training_id,
        "done_training_id": done_training_id,
        "rating":rating
    });
    var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/rate',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                console.log(error);
                alert("Rating failed!");
            }
            else {
                window.location.replace("/account/"+id+"/done_trainings");
            }
        }
    });

}
function showAll(user){
    for(let i=0;i<user.doneTrainings.length;i++){
        document.getElementById(user.doneTrainings[i].id).style.display="";
    }
}
function showRated(user){
    showAll(user);
    for(let i=0;i<user.doneTrainings.length;i++){
        if(user.doneTrainings[i].rating!=0)
            document.getElementById(user.doneTrainings[i].id).style.display="";
        else
            document.getElementById(user.doneTrainings[i].id).style.display="none";
    }
}
function showUnrated(user){
    showAll(user);
    for(let i=0;i<user.doneTrainings.length;i++){
        if(user.doneTrainings[i].rating==0)
            document.getElementById(user.doneTrainings[i].id).style.display="";
        else
            document.getElementById(user.doneTrainings[i].id).style.display="none";
    }
}

