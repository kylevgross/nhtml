  //Begin auto generated javascript
 require(["baja!"], function (baja) {"use strict";



            
            var notifSub = new baja.Subscriber();
            function update(notifs) {

             var notifString = notifs.getOut().getValue().toString();
                                      if (notifString.includes('.')){
                                        var notifDisplay = notifString.substring(0, notifString.indexOf('.'));
                                      }
                                      else
                                        notifDisplay = notifString;
              document.getElementById("AllNotifications").innerHTML = "notificationConsoleName (" + notifDisplay + ")";
            var val = notifs.getOut().getValue();
              if (val > 0.5){
                document.getElementById("AllNotifications").style="animation:notification 2.5s infinite;"
              }
              else {
                document.getElementById("AllNotifications").style="animation:none;"
              }
            }
            notifSub.attach('changed', function (prop) {
            if (prop.getName() === 'out') { update(this); }
             });
            baja.Ord.make("notificationCountPath").get({
               subscriber: notifSub
            }).then(update); 
           
 
  
            


      });



