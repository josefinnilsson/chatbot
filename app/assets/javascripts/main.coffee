$ ->
	$.get "/answers", (answers) ->
		$.each answers, (index, answer) ->
			$('#messages').append $("<li>").text answer.message.name
			$('#messages').append $("<li>").text answer.answer
			$('ul').scrollTop($('ul')[0].scrollHeight)
			$('#textarea').focus()

$(document).keypress (event) ->
	if event.keyCode == 13 && !event.shiftKey
		$('#submit-button').click()
return