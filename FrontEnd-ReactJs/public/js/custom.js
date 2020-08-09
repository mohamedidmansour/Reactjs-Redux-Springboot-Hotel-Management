(function($) { "use strict";

	document.documentElement.className="js";

	
	//Preloader
	
	$(window).on('load', function(e) { // makes sure the whole site is loaded
		$(".loader__figure").fadeOut(); // will first fade out the loading animation
		$(".loader").delay(500).fadeOut("slow"); // will fade out the white DIV that covers the website.
	})
		
		
	//Parallax & fade on scroll	
		
	function scrollBanner() {
	  $(document).on('scroll', function(){
		var scrollPos = $(this).scrollTop();
			if ($(window).width() > 1200) {
				$('.parallax-top').css({
				  'top' : (scrollPos/2.5)+'px'
				});
				$('.parallax-fade-top').css({
				  'top' : (scrollPos/2)+'px',
				  'opacity' : 1-(scrollPos/750)
				});
				$('.fade-top').css({
				  'opacity' : 1-(scrollPos/350)
				});
			}	
	  });    
	}
	scrollBanner();
	
	
	/* Scroll Animation */
	
	window.scrollReveal = new scrollReveal();
	
	
	/* Parallax effect */
	
	if ($(window).width() > 991) {
		$().enllax();
	}
		
		
	//Input number
	
    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up"></div><div class="quantity-button quantity-down"></div></div>').insertAfter('.quantity input');
    jQuery('.quantity').each(function() {
      var spinner = jQuery(this),
        input = spinner.find('input[type="number"]'),
        btnUp = spinner.find('.quantity-up'),
        btnDown = spinner.find('.quantity-down'),
        min = input.attr('min'),
        max = input.attr('max');

      btnUp.on('click', function() {
        var oldValue = parseFloat(input.val());
        if (oldValue >= max) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue + 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

      btnDown.on('click', function() {
        var oldValue = parseFloat(input.val());
        if (oldValue <= min) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue - 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

    });
		
	
	$(document).ready(function() {
		
		//Date Picker
		
		var dateSelect     = $('#flight-datepicker');
		var dateDepart     = $('#start-date');
		var dateReturn     = $('#end-date');
		var spanDepart     = $('.date-depart');
		var spanReturn     = $('.date-return');
		var spanDateFormat = 'ddd, MMMM D yyyy';

		dateSelect.datepicker({
			autoclose: true,
			format: "mm.dd.yyyy",
			maxViewMode: 0,
			startDate: "now"
		});	
		
		
		//Date Picker
		
		var dateSelect     = $('#flight-datepicker-1');
		var dateDepart     = $('#start-date-1');
		var dateReturn     = $('#end-date-1');
		var spanDepart     = $('.date-depart');
		var spanReturn     = $('.date-return');
		var spanDateFormat = 'ddd, MMMM D yyyy';

		dateSelect.datepicker({
			autoclose: true,
			format: "dd.M",
			maxViewMode: 0,
			startDate: "now"
		});

		
		//Scroll back to top
	
		var offset = 300;
		var duration = 400;
		jQuery(window).on('scroll', function() {
			if (jQuery(this).scrollTop() > offset) {
				jQuery('.scroll-to-top').fadeIn(duration);
			} else {
				jQuery('.scroll-to-top').fadeOut(duration);
			}
		});
				
		jQuery('.scroll-to-top').on('click', function(event) {
			event.preventDefault();
			jQuery('html, body').animate({scrollTop: 0}, duration);
			return false;
		})
				
		
		//Navigation	

		"use strict";

		$('.menu > ul > li:has( > ul)').addClass('menu-dropdown-icon');
		//Checks if li has sub (ul) and adds class for toggle icon - just an UI


		$('.menu > ul > li > ul:not(:has(ul))').addClass('normal-sub');
		//Checks if drodown menu's li elements have anothere level (ul), if not the dropdown is shown as regular dropdown, not a mega menu (thanks Luka Kladaric)

		$(".menu > ul").before("<a href=\"#\" class=\"menu-mobile\"></a>");

		//Adds menu-mobile class (for mobile toggle menu) before the normal menu
		//Mobile menu is hidden if width is more then 1199px, but normal menu is displayed
		//Normal menu is hidden if width is below 1199px, and jquery adds mobile menu
		//Done this way so it can be used with wordpress without any trouble

		$(".menu > ul > li").hover(function (e) {
			if ($(window).width() > 1170) {
				$(this).children("ul").stop(true, false).fadeToggle(300);
				e.preventDefault();
			}
		});
		//If width is more than 1170px dropdowns are displayed on hover

		$(".menu > ul > li").on('click', function () {
			if ($(window).width() <= 1170) {
				$(this).children("ul").fadeToggle(300);
			}
		});
		//If width is less or equal to 1170px dropdowns are displayed on click

		$(".menu-mobile").on('click', function (e) {
			$(".menu > ul").toggleClass('show-on-mobile');
			e.preventDefault();
		});
		//when clicked on mobile-menu, normal menu is shown as a list, classic rwd menu story	
		
		
		//Nice Select
		
		$('select').niceSelect();

		
		/* Quote Carousels */
	 
		$("#owl-sep-1").owlCarousel({
			navigation: false,
			pagination : true,
			transitionStyle : "fade",
			slideSpeed : 500,
			paginationSpeed : 500,
			singleItem:true,
			autoPlay: 5000
		});

		
		/* Gallery Carousels */
	 
		$("#owl-sep-2").owlCarousel({
			navigation: false,
			pagination : false,
			slideSpeed : 500,
			paginationSpeed : 500,
			items : 7,
			itemsDesktop : [1000,4], 
			itemsDesktopSmall : [900,3],
			itemsTablet: [600,2], 
			itemsMobile : false,
			autoPlay: 5000
		});
		
		
		//Rooms Carousel
 
		  var sync1 = $("#rooms-sync1");
		  var sync2 = $("#rooms-sync2");
		 
		  sync1.owlCarousel({
			singleItem : true,
			slideSpeed : 400,
			transitionStyle : "goDown",
			pagination:false,
			autoPlay : 6000,
			afterAction : syncPosition
		  });
		(function ($) { 
			var owl = $("#rooms-sync1");
			owl.owlCarousel();	
			
			// Custom Navigation Events
			$(".next-rooms-sync-1").on('click', function(){
				owl.trigger('owl.next');
			})
			$(".prev-rooms-sync-1").on('click', function(){
				owl.trigger('owl.prev');
			})	
		} )(jQuery);
		  
		  sync2.owlCarousel({
			items : 5,
			itemsDesktop      : [1199,4],
			itemsDesktopSmall     : [979,3],
			itemsTablet       : [768,3],
			itemsMobile       : [479,2],
			pagination: false,
			responsiveRefreshRate : 100,
			afterInit : function(el){
			  el.find(".owl-item").eq(0).addClass("synced");
			}
		  });
		 
		  function syncPosition(el){
			var current = this.currentItem;
			$("#rooms-sync2")
			  .find(".owl-item")
			  .removeClass("synced")
			  .eq(current)
			  .addClass("synced")
			if($("#rooms-sync2").data("owlCarousel") !== undefined){
			  center(current)
			}
		  }
		 
		  $("#rooms-sync2").on("click", ".owl-item", function(e){
			e.preventDefault();
			var number = $(this).data("owlItem");
			sync1.trigger("owl.goTo",number);
		  });
		 
		  function center(number){
			var sync2visible = sync2.data("owlCarousel").owl.visibleItems;
			var num = number;
			var found = false;
			for(var i in sync2visible){
			  if(num === sync2visible[i]){
				var found = true;
			  }
			}
		 
			if(found===false){
			  if(num>sync2visible[sync2visible.length-1]){
				sync2.trigger("owl.goTo", num - sync2visible.length+2)
			  }else{
				if(num - 1 === -1){
				  num = 0;
				}
				sync2.trigger("owl.goTo", num);
			  }
			} else if(num === sync2visible[sync2visible.length-1]){
			  sync2.trigger("owl.goTo", sync2visible[1])
			} else if(num === sync2visible[0]){
			  sync2.trigger("owl.goTo", num-1)
			}
			
		  }

		
		//Lang Open/Close
	
		$(".lang-wrap").on('click', function(e){
			$(".clicked").removeClass("clicked");
			$(this).addClass("clicked");
			e.stopPropagation();
		});   
		$(document).on('click', function(){ 
			$(".clicked").removeClass("clicked");
		});
		
		
		/* Video */
		
		$(".container").fitVids();
						
		$('.vimeo a,.youtube a').on('click', function (e) {
			e.preventDefault();
			var videoLink = $(this).attr('href');
			var classeV = $(this).parent();
			var PlaceV = $(this).parent();
			if ($(this).parent().hasClass('youtube')) {
				$(this).parent().wrapAll('<div class="video-wrapper">');
				$(PlaceV).html('<iframe frameborder="0" height="333" src="' + videoLink + '?autoplay=1&showinfo=0" title="YouTube video player" width="547"></iframe>');
			} else {
				$(this).parent().wrapAll('<div class="video-wrapper">');
				$(PlaceV).html('<iframe src="' + videoLink + '?title=0&amp;byline=0&amp;portrait=0&amp;autoplay=1&amp;color=6dc234" width="500" height="281" frameborder="0"></iframe>');
			}
		});	
		
		
		/* Range slider */
		
		var range = $('.input-range'),
		value = $('.range-value');

		value.html(range.attr('value') + ' $');

		range.on('input', function() {
			value.html(this.value + ' $');
		});		
					
	});

	
	
	
  })(jQuery); 