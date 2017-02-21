$ ->
  $.get "/messages", (messages) ->
    $.each messages, (index, message) ->
      $('#messages').append $("<li>").text message.name