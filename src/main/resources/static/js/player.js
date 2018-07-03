 $( document ).ready(function() {

 	var $playerName = $('#playerName');

 	$.ajax({
 		type: 'GET',
 		url: '/players',
 		success: function(data) {
 			console.log('success', data);
 		},
 		error: function() {
 			alert('Error loading players');
 		}
 	});

 	$('#add-player').on('click', function() {
 		var player = {
 		playerName: $playerName.val(),
 		lingoScore: 0,
 		memoryScore: 0,
 		};

 		$.ajax({
 		type: 'POST',
 		url: '/players',
 		contentType:"application/json",
 		dataType:"json",
 		data: JSON.stringify(player),
 		success: function(player){
 			console.log('success', player)
 			},
 		error: myError
 		});

 	});
 });

 function myError(jqx, textStatus, errStr) {
     alert(errStr);
 }