
// Update news panel
function updateNews() {
	$.ajax({
				url : "http://twitter.com/statuses/user_timeline/bonbhel.json?callback=twitterCallback&count=4",
				dataType : 'JSONP', // for cross domain
				error : function() {
					
				},
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