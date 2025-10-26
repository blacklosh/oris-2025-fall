<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <link href="style.css" rel="stylesheet">
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

    <style>
        * {
            margin: 0;
        }

        body {
            background-color: darkgray;
        }

        li {
            display: flex;
            background-color: lightgray;
            align-content: flex-start;
            justify-content: flex-start;
            padding: 5px;
            border-radius: 10px;
            margin: 5px 0;
            border-left-width: 2px;
            border-left-color: darkred;
        }

        header {
            display: flex;
            justify-content: center;
            flex-direction: column;
            align-items: center;
            padding: 30px 0;
        }

        .input-box {
            display: flex;
            align-content: flex-start;
            justify-content: flex-start;
            padding: 15px;
            align-self: flex-start;
        }

        #button {
            padding: 10px;
            border-radius: 10px;
            border-width: 2px;
            border-color: dimgray;
            background-color: darkgreen;
            color: aliceblue;
        }

        ul {
            padding: 0;
        }

        .chat-box {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-content: flex-start;
            width: 80%;
            background-color: black;
            padding: 10px;
            border-radius: 10px;
        }

        main {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
    </style>
</head>
<body>
    <header>
        <h1>Chat</h1>
        <h2>You logged in as <%=request.getAttribute("name")%></h2>
    </header>

    <hr>

    <main>
        <div class="input-box">
            <input id="userName" type="hidden" value="<%=request.getAttribute("name")%>"/>
            <input id="msgInput" type="text" placeholder="Enter message..." onkeydown="checkEnterAndSend(event)"/>
            <input id="button" type="button" value="Send" onclick="sendMsg()"/>
        </div>
        <div class="chat-box">
            <ul id="messagesList">
                <% for(String message : (List<String>) request.getAttribute("messages")) {%>

                <li><%=message%></li>

                <% } %>
            </ul>
        </div>
    </main>

</body>
</html>
