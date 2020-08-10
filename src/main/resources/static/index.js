function initialize(){
    login();
}

function login(){
    var username = document.getElementById("username");
    var password= document.getElementById("password");

   
    var xhttp = new XMLHttpRequest();
    var usernames = xhttp.open("GET", "http://localhost:8090/api/students/usernames", true);
    var usernames = xhttp.open("GET", "http://localhost:8090/api/students/passwords", true);

    for(var i = 0; i <= usernames.length; i++){
        if(username == usernames[i]){
            if(password == passwords[i]){
                console.log("YOU ENTERED THE RIGHT CREDENTIALS");
            }
            else{
                alert("You entered the wrong password");
            }
        }
        else{
            alert("You entered the wrong username");
        }
    }


}