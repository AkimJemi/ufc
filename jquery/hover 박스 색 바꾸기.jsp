<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	display: inline-block;
	background-color: blue;
}
</style>
</head>
<body>
<span class="init">초기화</span>
<br>
<%for(int i = 0; i<100;i++){ %>
	<div class="box<%=i%>">box</div>
	<% } %>
	
	<script type="text/javascript">
$('body > .init').click(function(){
	$('body > div').css('background-color', 'blue');
});
<%
for(int a = 0; a<100; a++){
%>
var $box = $('body > .box'+<%=a%>);
$box.mouseover(function(){
	$('body >.box'+<%=a%>).css("background-color", "red");
});
$box.mouseleave(function(){
	$('body >.box'+<%=a%>).css("background-color", "white");
});
<%
}
%>
</script>
</body>
