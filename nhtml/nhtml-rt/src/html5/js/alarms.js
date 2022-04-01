//Begin auto generated javascript
require(["baja!"], function (baja) {"use strict";
      var alarmSub = new baja.Subscriber();
      function update(alarms) {
            var alarmString = alarms.getOut().getValue().toString();
            if (alarmString.includes('.')){
                var alarmDisplay = alarmString.substring(0, alarmString.indexOf('.'));
            }
            else
                alarmDisplay = alarmString;
            document.getElementById("AllAlarms").innerHTML = "alarmConsoleName (" + alarmDisplay + ")";
            var val = alarms.getOut().getValue();
              if (val > 0.5){
                document.getElementById("AllAlarms").style="animation:alarm 2.5s infinite;"
              }
              else {
                document.getElementById("AllAlarms").style="animation:none;"
              }
            }
            alarmSub.attach('changed', function (prop) {
            if (prop.getName() === 'out') { update(this); }
             });
            baja.Ord.make("alarmCountPath").get({
               subscriber: alarmSub
            }).then(update);
      });



