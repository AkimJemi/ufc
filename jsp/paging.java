// Model
public Paging(int total, int currentPage, int searchTitle, String searchContent) {
		this.total = total;
		this.currentPage = currentPage;
		this.searchTitle = searchTitle;
		this.searchContent = searchContent;
		for (int i = 1; i > -1; i++) {
			if (currentPage >= (i - 1) * 5 + 1 && currentPage <= i * 5) {
				begin = (i - 1) * 5 + 1;
				if (begin + 4 <= total / limit) {
					end = i * 5;
					forward = true;
				} else {
					if (total % limit == 0)
						end = total / limit;
					else
						end = total / limit + 1;
				}
				if (currentPage >= end) {
					this.currentPage = end;
					for (int j = 1; j > -1; j++) {
						if (end >= (j - 1) * 5 + 1 && end <= j * 5) {
							begin = (j - 1) * 5 + 1;
							break;
						}
					}
				}
				if (begin <= 5)
					backward = false;
				else
					backward = true;
				break;
			}
		}
	}

// Controller
int paging = 1;
		if (rq.getParameter("paging") != null)
			paging = Integer.parseInt(rq.getParameter("paging"));
		
		int total = bookService.bookTotalCount();
		bookings = bookService.adminBookList(bookings, paging);
		
		rq.setAttribute("paging", new Paging(paging,total));

// View
<div class="paging_css">
		<div class="paging_css_inner">
			<div>
				<c:if test="${paging.backward}">
					<a href="adminBookList.do?paging=${paging.begin-1 }">前へ</a>
				</c:if>
			</div>
			<c:forEach var="paging" begin="${paging.begin }" end="${paging.end }">
				<div>
					<a href="adminBookList.do?paging=${paging}">${paging}</a>
				</div>
			</c:forEach>
			<div>
				<c:if test="${paging.forward}">
					<a href="adminBookList.do?paging=${paging.end+1 }">次へ</a>
				</c:if>
			</div>
		</div>
	</div>
    
<style>               
.paging_css {
	margin-top: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.paging_css_inner {
	display: flex;
	text-align:center;
	gap: 20px;
	width: 215px;
}
</style>
    
