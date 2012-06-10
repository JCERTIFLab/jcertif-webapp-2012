
// Update news panel
function updateNews() {
	$.ajax({
				url : "http://twitter.com/statuses/user_timeline/bonbhel.json?callback=twitterCallback&count=4",
				dataType : 'JSONP', // for cross domain
				error : function() {
					
				}
			});

}

// Callback method for twitter
function twitterCallback(data, textStatus) {
	$.each(data, function(i, tweet) {
		var text = tweet.text;
		
		$('#news').append('<div class="home-news-text">' + linkify(text) + '</div><br/>');
	});
	
	// Photo slider > Minimal
	startSlider();
}

//Start Slider
function startSlider() {
	$(".photoslider-mini").sliderkit({
		auto:true,
		autospeed:3000,
		panelbtnshover:true,
		circular:true,
		fastchange:true
	});
}

// Add link (<a></a>) for text 'http://..."
function linkify(text){
    if (text) {
        text = text.replace(
            /((https?\:\/\/)|(www\.))(\S+)(\w{2,4})(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/gi,
            function(url){
                var full_url = url;
                if (!full_url.match('^https?:\/\/')) {
                    full_url = 'http://' + full_url;
                }
                return '<a href="' + full_url + '" target="_blank">' + url + '</a>';
            }
        );
    }
    return text;
}

function modifyPasswordCallBack(xhr, status, args) {
    if(args.validationFailed || !args.newPasswordOK) {
        jQuery('#dialog').effect("modifyPassDialog", { times:3 }, 100);
    } else {
        modifyPassDialog.hide();
    }
}

PrimeFaces.locales ['fr'] = {
	    closeText: 'Fermer',
	    prevText: 'Precedent',
	    nextText: 'Suivant',
	    monthNames: ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre' ],
	    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Jun', 'Jul', 'Aou', 'Sep', 'Oct', 'Nov', 'Dec' ],
	    dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
	    dayNamesShort: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
	    dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
	    weekHeader: 'Semaine',
	    firstDay: 1,
	    isRTL: false,
	    showMonthAfterYear: false,
	    yearSuffix:'',
	    timeOnlyTitle: 'Choisir l\'heure',
	    timeText: 'Heure',
	    hourText: 'Heures',
	    minuteText: 'Minutes',
	    secondText: 'Secondes',
	    currentText: 'Maintenant',
	    ampm: false,
	    month: 'Mois',
	    week: 'Semaine',
	    day: 'Jour',
	    allDayText: 'Toute la journee'
	};