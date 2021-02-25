     //Begin auto generated javascript
 require(["baja!"], function (baja) {"use strict";



        var allAlarmSub = new baja.Subscriber();

            allAlarmSub.attach("changed", function(prop) {

            document.getElementById("AllAlarms").innerHTML = "alarmConsoleName (" + this.getAlarmCount() + ")";

                  var val = this.getAlarmCount();

                 if (val > 0.5){
                document.getElementById("AllAlarms").style="animation:alarm 2.5s infinite;"
            }
            else {
                                document.getElementById("AllAlarms").style="animation:none;"


            }

            });
             //this is the link to the alarm count on the alarm service wiresheet, either name it AllAlarms or copy your name here
            baja.Ord.make("station:|slot:/Services/serviceName").get({
               subscriber: allAlarmSub
            });

            var allNotifSub = new baja.Subscriber();

            allNotifSub.attach("changed", function(prop) {

            document.getElementById("AllNotifications").innerHTML = "notificationConsoleName (" + this.getNotificationCount() + ")";
                  var val = this.getNotificationCount();

                 if (val > 0.5){
                document.getElementById("AllNotifications").style="animation:notification 2.5s infinite;"
            }
            else {
                                document.getElementById("AllNotifications").style="animation:none;"


            }


            });
             //this is the link to the alarm count on the alarm service wiresheet, either name it AllAlarms or copy your name here
            baja.Ord.make("station:|slot:/Services/serviceName").get({
               subscriber: allNotifSub
            });


            var oatSub = new baja.Subscriber();

            oatSub.attach("changed", function(prop) {



            document.getElementById("temp").innerHTML ="Outdoor Temp: " + this.getOat() + " °F";
           var hasOAT = this.getHasOat();

            if (hasOAT == true){
                        document.getElementById("temp").style ="display:inline;";
            }
            else{
            document.getElementById("temp").style ="display:none;";

}
            });
             //this is the link to the OAT, copy your ORD here
            baja.Ord.make("station:|slot:/Services/serviceName").get({
               subscriber: oatSub
            });


            var oahSub = new baja.Subscriber();

            oahSub.attach("changed", function(prop) {

            document.getElementById("humid").innerHTML ="Outdoor Humidity: " + this.getOah() + " %";

            var hasOAH = this.getHasOah();

            if (hasOAH == true){
                        document.getElementById("humid").style ="display:inline;";
            }
            else{
            document.getElementById("humid").style ="display:none;";

}

            });
             //this is the link to the OAH, copy your ORD here
            baja.Ord.make("station:|slot:/Services/serviceName").get({
               subscriber: oahSub
            });







     //get username & append to header
    $(".header-info-username").empty().append(baja.getUserName());
    $("#header-info-arrow-down").on("click", function () {
     $("#header-info-arrow-down").css( "display", "none" );
     $("#header-info-arrow-up").css( "display", "table-cell" );
     $(".header-info-username").animate({top: "-100%"}, 150, function() {
      $(".header-info-logout").animate({top: 20}, 150);
     });
    });
    //logoff code
    $("#header-info-arrow-up").on("click", function () {
     $("#header-info-arrow-up").css( "display", "none" );
     $("#header-info-arrow-down").css( "display", "table-cell" );
     $(".header-info-logout").animate({top: "-100%"}, 150, function() {
      $(".header-info-username").animate({top: 20}, 150);
     });
     });

      baja.start();

      });



