$ ->
	$.get "/answers", (answers) ->
		$.each answers, (index, answer) ->
			$('#messages').append $("<li>").text answer.message.name
			$('#messages').append $("<li>").text answer.answer