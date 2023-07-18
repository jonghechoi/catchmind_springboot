    
function GetInfo() {

    var newName = document.getElementById("cityInput");
    var cityName = document.getElementById("cityName");
    $(cityInput).addListener
    console.log(newName);
fetch('https://api.openweathermap.org/data/2.5/forecast?q='+newName.value+'&appid=3e64f1b881f31d7847fdc76f14abcfed')
.then(response => response.json())
.then(data => {

    //Getting the min and max values for each day
    for (i = 0; i < 5; i++) {
  document.getElementById("day" + (i + 1) + "Min").innerHTML = "Min: " + Math.round(data.list[i].main.temp_min - 273.15) + "°";
}

for (i = 0; i < 5; i++) {
  document.getElementById("day" + (i + 1) + "Max").innerHTML = "Max: " + Math.round(data.list[i].main.temp_max - 273.15) + "°";
}
    //------------------------------------------------------------

    //Getting Weather Icons
     for(i = 0; i<5; i++){
        document.getElementById("img" + (i+1)).src = "http://openweathermap.org/img/wn/"+
        data.list[i].weather[0].icon
        +".png";
    }
    //------------------------------------------------------------
    console.log(data)


})

.catch(err => alert("Something Went Wrong: Try Checking Your Internet Coneciton"))
}

function DefaultScreen(){
    document.getElementById("cityInput").defaultValue = "Seoul";
    GetInfo();
}


//Getting and displaying the text for the upcoming five days of the week
var d = new Date();
var weekday = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT",];

//Function to get the correct integer for the index of the days array
function CheckDay(day){
    if(day + d.getDay() > 6){
        return day + d.getDay() - 7;
    }
    else{
        return day + d.getDay();
    }
}

    for(i = 0; i<5; i++){
        document.getElementById("day" + (i+1)).innerHTML = weekday[CheckDay(i)];
    }
    
    //------------------------------------------------------------


