
// Update news panel
function updateNews() {
	$.ajax({
                    url : 'http://search.twitter.com/search.json?q=jcertif',
				dataType : 'JSONP', // for cross domain
                jsonpCallback : 'twitterCallback'
			});

}

// Callback method for twitter
function twitterCallback(data, textStatus) {
    var max_tweet = 7;
	$.each(data, function(i, tweet) {
        if(i == "results"){
            var index = 0;
            $.each(tweet,function(key,value){
                if(index < max_tweet){
                    $('#news').append('<div style="clear: both;"><div class="home-news-img">'
                        + '<a href="http://twitter.com/#!/' + value.from_user + '"><img src="' + value.profile_image_url +'" alt=""/></a></div><div class="home-news-text">'  + linkify(value.text) + '</div></div><br/>');
                }
                index++;
            });

        }
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