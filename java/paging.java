// Model
public class Paging {
	private int begin;
	private int end;
	private int total;
	private int limit = 10;
	private Boolean forward;
	private Boolean backward;
	public Paging(int begin, int end, boolean forward, boolean backward) {
		this.begin = begin;
		this.end = end;
		this.forward = forward;
		this.backward = backward;
	}
	public Paging(int currentPage, int total) {
		this.total = total;
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
				if (begin <= 5)
					backward = false;
				else
					backward = true;
				break;
			}
		}
	}

	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Boolean getForward() {
		return forward;
	}
	public void setForward(Boolean forward) {
		this.forward = forward;
	}
	public Boolean getBackward() {
		return backward;
	}
	public void setBackward(Boolean backward) {
		this.backward = backward;
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
    
