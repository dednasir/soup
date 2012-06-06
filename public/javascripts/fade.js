$(document).ready(function(){
//Set opacity on each span to 0%

$('.ts-display-pf-img').hover(
    function() {
        $(this).find('.rollover').stop().fadeTo(500, 0.60);
    },
    function() {
		$(this).find('.rollover').stop().fadeTo(500, 0);
    }
)


});