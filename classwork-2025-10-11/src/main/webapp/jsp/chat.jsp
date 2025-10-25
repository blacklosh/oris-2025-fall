<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Fedor
  Date: 24.10.2025
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <script>
        addNewMessage = function (text) {
            let li = document.createElement('li');
            li.textContent = text;
            ul.appendChild(li);
        }

        window.onload = function () {
            let userName = document.getElementById('userName').value;
            ul = document.getElementById("chatList");
            ws = new WebSocket("/ws/chat");

            ws.onmessage = function (event) {
                addNewMessage(event.data);
            }

            ws.onclose = function () {
                addNewMessage('[System]: Соединение закрыто');
            }

            ws.onerror = function () {
                addNewMessage('[System]: Ошибка соединения');
            }

            ws.onopen = function () {
                ws.send("[System]: Пользователь " + userName + " подключился");
            }
        };

        function sendMsg() {
            let userName = document.getElementById('userName').value;
            let inp = document.getElementById("msgInput");
            let msg = inp.value.trim();
            if(msg.length === 0 || !ws || ws.readyState !== WebSocket.OPEN) return;
            ws.send("[" + userName + "]: " + msg);
            inp.value = '';
            inp.focus();
        }

        function sendOnEnter(event) {
            if(event.key === 'Enter') {
                sendMsg();
            }
        }
    </script>
</head>
<body>

<input type="hidden" id="userName" value="<%=request.getAttribute("name")%>"/>

You logged in as <%=request.getAttribute("name")%>
<hr>

<input id="msgInput" type="text" name="msg" onkeydown="sendOnEnter(event)"/>
<input type="submit" onclick="sendMsg()">

<ul id="chatList">
    <% for(String message : (List<String>) request.getAttribute("messages")) { %>
    <li><%=message%></li>
    <br>
    <% } %>
</ul>

</body>
</html>
