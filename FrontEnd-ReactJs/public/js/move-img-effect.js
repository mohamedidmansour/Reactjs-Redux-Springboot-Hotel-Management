(function($) { "use strict";
	var pos = 0;
		if ($(window).width() > 1200) {
			window.setInterval(function(){
				pos++;
				document.getElementsByClassName('home-moving-image')[0].style.backgroundPosition = pos + "px 0px";
			}, 18
		)
	};
	
})(jQuery);




