  //Begin auto generated javascript
 require(["baja!"], function (baja) {"use strict";

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

      });



