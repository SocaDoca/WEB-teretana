function sortTable(n, isNumber) {
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
            x = rows[i].getElementsByTagName("TD")[n-1];
            y = rows[i + 1].getElementsByTagName("TD")[n-1];
            if (dir == "asc") {
                let xStr = x.innerHTML.toLowerCase();
                let yStr = y.innerHTML.toLowerCase();
                if(n === 5 || n === 6) {
                    xStr = xStr.substring(0, xStr.length-4);
                    yStr = yStr.substring(0, yStr.length-4);
                }
                if(isNumber) {
                    if(Number.parseFloat(xStr) > Number.parseFloat(yStr)) {
                        shouldSwitch = true;
                        break;
                    }
                } else {
                    if (xStr > yStr) {
                        shouldSwitch = true;
                        break;
                    }
                }
            } else if (dir == "desc") {
                let xStr = x.innerHTML.toLowerCase();
                let yStr = y.innerHTML.toLowerCase();
                if(n === 5 || n === 6) {
                    xStr = xStr.substring(0, xStr.length-4);
                    yStr = yStr.substring(0, yStr.length-4);
                }
                if(isNumber) {
                    if(Number.parseFloat(xStr) < Number.parseFloat(yStr)) {
                        shouldSwitch = true;
                        break;
                    }
                } else {
                    if (xStr < yStr) {
                        shouldSwitch = true;
                        break;
                    }
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
    for (i = 1; i <7 ; i++)
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
    let trainingname=document.getElementById("trainingName").value;
    let type=document.getElementById("type").value;
    let rating=document.getElementById("rating").value;
    let description=document.getElementById("description").value;
    let price=document.getElementById("price").value;
    let trainings=trainingsDTO.trainings;

    for(let i=0;i<trainings.length;i++)
    {
        document.getElementById(trainings[i].id).style.display="none";
    }
    if(trainingname!="") {
        trainings = filterNew(trainings, 'name', trainingname);
    }
    if(type!="Type") {
        trainings = filterNew(trainings, 'type', type);
    }

    if(rating!="") {
        trainings = filterNew(trainings, 'rating', rating);
    }
    if(description!="") {
        trainings = filterNew(trainings, 'description', description);
    }
    if(price!="") {
        trainings = filterNew(trainings, 'price', price);
    }

    if(trainings && trainings.length>0) {
        trainings.forEach(item => {
            document.getElementById(item.id).style.display="";
        });
    }


    // if(type!="Type")
    //     filter["type"]=type;
    //
    // if(rating!="")
    //     filter["rating"]=rating;
    //
    // if(description!="")
    //     filter["description"]=description;
    //
    // if(price!="")
    //     filter["price"]=price;
    //
    // for (const [key, value] of Object.entries(filter)) {
    //     filterOne(trainings,key,value);
    // }
}

function resetFilter(trainingsDTO) {
    var trainings=trainingsDTO.trainings;
    trainings.forEach(item => {
        document.getElementById(item.id).style.display="";
    })
}

function filterNew(trainings, key, value) {
    return trainings.filter(item => {
        return item[key] === value;
    });
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
        "member_id": id,
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
