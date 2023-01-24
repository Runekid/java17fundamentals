function getMessage() {
   const messageId = document.getElementById("messageId").value;
   const xhr = new XMLHttpRequest();
   xhr.onload = onLoad;
   xhr.open("GET", "messages/" + messageId, true);
   xhr.setRequestHeader("Accept", "application/json");
   xhr.send(null);
}

function onLoad() {
   const messageField = document.getElementById("messageField");
   let messageText ="";
   switch(this.status) {
      case 200:
         const message  = JSON.parse(this.responseText);
         messageText = message.author + " : " + message.text;
         break;
      case 404:
         messageText = "Message not found";
         break;
      default:
         messageText = "Error. Status: " + this.status;
   }
   messageField.innerText = messageText;
}

function init() {
   const button = document.getElementById("getButton");
   button.addEventListener("click", getMessage);
}

window.addEventListener("load", init);
