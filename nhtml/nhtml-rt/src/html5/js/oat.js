  //Begin auto generated javascript
 require(["baja!"], function (baja) {"use strict";

      var oatSub = new baja.Subscriber();

      function update(oat) {
      var oatString = oat.getOut().getValue().toString();
              if (oatString.includes('.')){
                var oatDisplay = oatString.substring(0, oatString.indexOf('.'));
              }
              else
                oatDisplay = oatString;
              document.getElementById("temp").innerHTML ="Outdoor Temp: " + oatDisplay+ " °F";
      }
      oatSub.attach('changed', function (prop) {
        if (prop.getName() === 'out') { update(this); }
        });
        baja.Ord.make("oatPath").get({
        subscriber: oatSub
        }).then(update);
      });



