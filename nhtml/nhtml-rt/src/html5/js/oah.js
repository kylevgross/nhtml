  //Begin auto generated javascript
 require(["baja!"], function (baja) {"use strict";

      var oahSub = new baja.Subscriber();

      function update(oah) {

       var oahString = oah.getOut().getValue().toString();
                    if (oahString.includes('.')){
                        var oahDisplay = oahString.substring(0, oahString.indexOf('.'));
                    }
                    else
                        oahDisplay = oahString;
        document.getElementById("humid").innerHTML ="Outdoor Humidity: " + oahDisplay + " %";
      }
      oahSub.attach('changed', function (prop) {
        if (prop.getName() === 'out') { update(this); }
        });
        baja.Ord.make("oahPath").get({
        subscriber: oahSub
        }).then(update);
      });



