function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("Trainings");
    switching = true;
    dir = "asc";
    var thead=document.getElementById("th"+n);
    thead.classList.add('fa-sort-asc');
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                thead.classList.remove('fa-sort-asc');
                thead.classList.add('fa-sort-desc');
                switching = true;
            }
        }
    }
    for (i = 1; i <6 ; i++)
    {
        var trows=document.getElementById("th"+i);
        if(i!=n)
        {
            if(trows.classList.contains('fa-sort-asc')){
                trows.classList.remove('fa-sort-asc');
            } else if(trows.classList.contains('fa-sort-desc')){
                trows.classList.remove('fa-sort-desc');
            }
        }
    }
}


function filterData(trainingsDTO)
{
    var trainingname=document.getElementById("trainingname").value;
    var type=document.getElementById("type").value;
    var time=document.getElementById("time").value;
    var rating=document.getElementById("rating").value;
    var description=document.getElementById("description").value;
    var price=document.getElementById("price").value;
    var filter=[];
    var trainings=trainingsDTO.trainings;
    for(let i=0;i<trainings.length;i++)
    {
        document.getElementById(trainings[i].id).style.display="";
    }
    if(trainingname!="")
        filter["name"]=trainingname;

    if(type!="Type")
        filter["type"]=type;


    if(rating!="")
        filter["rating"]=rating;


    if(description!="")
        filter["description"]=description;


    if(price!="")
        filter["price"]=price;


    if(time!="")
        filter["time"]=time;;
    for (const [key, value] of Object.entries(filter)) {
        filterOne(trainings,key,value);
    }
}

function filterOne(trainings,key,value)
{
    for(let i=0;i<trainings.length;i++)
    {
        finalFilter(trainings[i],key,value);
    }
}

function finalFilter(training,key,value)
{
    if(document.getElementById(training.id).style.display=="none")
    {
        return;
    }
    let flag=false;
    if(key=="price"){
        for(let i=0;i<training.schedules.length;i++){
            if(parseInt(value)>=training.schedules[i].price)
                flag=true;
        }
    }
    else if(key=="time"){
        let help=value.split(":");
        for(let i=0;i<training.schedules.length;i++)
        {
            let arr=training.schedules[i].time.split(":");
            if(parseInt(help[0])>=parseInt(arr[0]))
            {
                if(parseInt(help[1])>=parseInt(arr[1]))
                    flag=true;
            }
        }
    }
    else if(key=="rating"){
        if(parseFloat(value)<=parseFloat(training.rating))
            flag=true;
    }else if(key=="name"){
        if(training.name.toLowerCase().indexOf(value.toLowerCase())>-1)
            flag=true;
    }else if(key=="description"){
        if(training.description.toLowerCase().indexOf(value.toLowerCase())>-1)
            flag=true;
    }else if(key=="type"){
        if(value!="Type")
        {
            if(training.type==value)
                flag=true;
        }
        else
            flag=true;
    }

    if(flag){
        document.getElementById(training.id).style.display="";
    }
    else{
        document.getElementById(training.id).style.display="none";
    }


}

function getTraining(id) {
    $.ajax({
        url: '/training/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/training/"+id);
        },
        error: function(){
            alert("Server error");
            return;
        }
    });
}
function reserve(schedule_id){

    var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "schedule_id": schedule_id,
    });
    $.ajax({
        url: '/reserve_training',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
            if (status === 'error') {
                alert("You either already reserved a training for this schedule or it isn't currently playing in any room!");
            }
            else {
                window.location.replace("/account/"+id+"/reservations");
            }
        }
    });

}
