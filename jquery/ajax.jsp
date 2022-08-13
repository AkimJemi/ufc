<script type="text/javascript">
function ajaxFunciton() {
			$.get('/ajax', {
				test : 5,
				test1 : 1
			}, function(data) {
				alert(data);
			}, 'html');
		}
</script>
<script type="text/javascript">
	 $.ajax({
	      url: "/",
	      type: "POST",
	      data:  送信データを指定 ,
	       dataType:"html"
	    })
	    .done(function(data) {
	    	alert(data);
	      // (1) リクエストが成功した場合に行う処理
	    })
	    .fail(function() {
	    	alert("fail");
	      // (2) リクエストが成功しなかった場合に行う処理
	    })
	    .always(function() {
	    	alert("always");
	      // (3) リクエストの成功・失敗に関わらず行う処理
	    }); 
</script>
