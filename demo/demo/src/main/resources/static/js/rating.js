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
function showRated(user){
    showAll(user);
    for(let i=0;i<user.done_traingins.length;i++){
        if(user.done_traingins[i].rating!=0)
            document.getElementById(user.done_traingins[i].id).style.display="";
        else
            document.getElementById(user.done_traingins[i].id).style.display="none";
    }
}
function showUnrated(user){
    showAll(user);
    for(let i=0;i<user.done_traingins.length;i++){
        if(user.watched_movies[i].rating==0)
            document.getElementById(user.done_traingins[i].id).style.display="";
        else
            document.getElementById(user.done_traingins[i].id).style.display="none";
    }
}
function showAll(user){
    for(let i=0;i<user.done_traingins.length;i++){
        document.getElementById(user.done_traingins[i].id).style.display="";
    }
}
