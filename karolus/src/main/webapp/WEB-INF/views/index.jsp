<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기본 페이지</title>
</head>
<script>
window.onload = function() {
    console.log(123);

    let wSocket = new WebSocket('ws://localhost:8080/websocket');

    wSocket.onopen = function(e) {
        console.log('open server~!');
    }

    wSocket.onerror= function(e) {
        console.log(e);
    }

    wSocket.onmessage = function(e) {
        console.log(e.data);

        document.getElementById('msgArea').innerHTML = document.getElementById('msgArea').innerHTML + '<br>' + e.data;
    }

    document.querySelector('#sendBtn').addEventListener('click', function() {
        let content = document.querySelector('#content');
        wSocket.send(content.value);

        content.value = '';
    });
}
</script>
<body>
    <input type="text" placeholder="보낼 메세지를 입력하세요." id="content">
    <button type="button" value="전송" id="sendBtn">전송</button>
    <div>
        <span>메세지</span>
        <div id="msgArea"></div>
    </div>
</body>
</html>
