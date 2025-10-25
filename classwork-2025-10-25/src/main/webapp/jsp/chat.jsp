<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <script>

        addNewMessage = function (text) {
            let ul = document.getElementById("messagesList");
            let li = document.createElement('li');
            li.textContent = text;
            ul.appendChild(li);
        }

        window.onload = function () {
            let userName = document.getElementById("userName").value;
            ws = new WebSocket("/ws");
            ws.onmessage = function (event) {
                addNewMessage(event.data);
            }
            ws.onclose = function () {
                addNewMessage('[System]: Connection closed');
            }
            ws.onerror = function () {
                addNewMessage('[System]: Connection error');
            }
            ws.onopen = function () {
                ws.send('[System]: User ' + userName + ' connected');
            }
        };

        function sendMsg() {
            let userName = document.getElementById("userName").value;
            let msgInput = document.getElementById('msgInput');
            let msg = msgInput.value;
            if(msg.length === 0 || !ws || ws.readyState !== WebSocket.OPEN) return;
            ws.send('[' + userName + ']: ' + msg);
            msgInput.value = '';
            msgInput.focus();
        }

        function checkEnterAndSend(event) {
            if(event.key === 'Enter') {
                sendMsg();
            }
        }

    </script>
</head>
<body>

    <h1>Chat</h1>
    <h2>You logged in as <%=request.getAttribute("name")%></h2>

    <hr>

    <input id="userName" type="hidden" value="<%=request.getAttribute("name")%>"/>
    <input id="msgInput" type="text" placeholder="Enter message..." onkeydown="checkEnterAndSend(event)"/>
    <input type="button" value="Send" onclick="sendMsg()"/>

    <hr>

    <ul id="messagesList">
        <% for(String message : (List<String>) request.getAttribute("messages")) {%>

        <li><%=message%></li>

        <% } %>
    </ul>

</body>
</html>
