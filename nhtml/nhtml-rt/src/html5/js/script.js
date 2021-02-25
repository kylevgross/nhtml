     //Begin auto generated javascript
( function( $ ) {
$( document ).ready(function() {
$('#cssmenu').prepend('<div id="menu-button">Menu</div>');
 $('#cssmenu #menu-button').on('click', function(){
  var menu = $(this).next('ul');
  if (menu.hasClass('open')) {
   menu.removeClass('open');
  }
  else {
   menu.addClass('open');
  }
 });
  $('#cssmenu ul').on('click', 'a', function(){
  var menu = $('#cssmenu #menu-button').next('ul');
  if (menu.hasClass('open')) {
   menu.removeClass('open');
  }
  else {
   menu.addClass('open');
  }
 });
 $('#cssmenu ul ul').on('click', 'a', function(){
  var menu = $('#cssmenu #menu-button').next('ul');
  if (menu.hasClass('open')) {
   menu.removeClass('open');
  }
  else {
   menu.addClass('open');
  }
 });
});
} )( jQuery );





