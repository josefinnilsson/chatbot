// Generated by CoffeeScript 1.12.4
(function() {
  $(function() {
    return $.get("/messages", function(messages) {
      return $.each(messages, function(index, messages) {
        return $('#messages').append($("<li>").text(message.name));
      });
    });
  });

}).call(this);
