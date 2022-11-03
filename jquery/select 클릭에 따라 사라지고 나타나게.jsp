<script type="text/javascript">
	function searchForDate(Index) {
		if (Index == 3) {
			$('#searchDate').appendTo(".moveBox1");
			$('#searchText').appendTo(".moveBox2");
		} else {
			$('#searchDate').appendTo(".moveBox2");
			$('#searchText').appendTo(".moveBox1");
		}
	}
	function selectForOption(Index) {
		alert(Index);
	}
	</script> 
	<%
	String no = "", room = "", user = "", date = "";
	%>
<div class="d-none moveBox2">
	<input type="date" id="searchDate">
</div>
<form action="/admin/book/list" method="POST">
	<c:if test="${paging != null}">
		<c:if test="${paging.title eq 'no'}">
			<%
			no = "selected";
			%>
		</c:if>
		<c:if test="${paging.title eq 'room'}">
			<%
			room = "selected";
			%>
		</c:if>
		<c:if test="${paging.title eq 'user'}">
			<%
			user = "selected";
			%>
		</c:if>
		<c:if test="${paging.title eq 'date'}">
			<%
			date = "selected";
			%>
			<script type="text/javascript">
			$( document ).ready(function(){
				searchForDate('3');
			});
			</script>
		</c:if>
	</c:if>
	<select name="title" onchange="searchForDate(this.selectedIndex)">
		<option value="no" <%=no%>>방번호</option>
		<option value="room" <%=room%>>방이름</option>
		<option value="user" <%=user%>>고객</option>
	</select> <input type="text" name="content"
		value="${paging.content}">
		
	<select name="option">
			<option>옵션</option>
		<c:forEach items="${options }" var="option">
			<option value="${option.bookingCode}" >${option.info }</option>
		</c:forEach>
	</select> <input type="text" name="content"
		value="${paging.content}">
		
	<label for="startDate">체크인</label>
	<input type="date" name="startDate"/>	
	<label for="EndDate">체크아웃</label>
	<input type="date" name="EndDate"/>	
	<div class="d-inline-block moveBox1"></div>
	<input type="submit" value="검색">
	<%-- <input type="hidden" name="endPage"
		value="${page.endPage }"> <input type="hidden"
		name="startPage" value="${page.startPage }"> <input
		type="hidden" name="total" name="total" value="${page.total }"> --%>
</form>