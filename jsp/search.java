// View
<form action="adminBookList.do">
		<div class="paging_css">
			<div class="paging_css_inner">
				<input type="hidden" name="currentPage" value="${paging.currentPage }"> 
        <select name="searchTitle">
					<option value="0">-</option>
					<option value="1">予約番号</option>
					<option value="2">部屋番号</option>
					<option value="3">姓名</option>
				</select>
				<script type="text/javascript">
				$('select[name="searchTitle"]').val('${paging.searchTitle}');
				</script>
				<input type="text" name="searchContent" value="${paging.searchContent }"
					placeholder="入力してください" /> <input type="submit" value="検索">
			</div>
		</div>
	</form>
  
          
// Model
    private int begin;
	private int end;
	private int total;
	private int limit = 10;
	private int currentPage;
	private Boolean forward;
	private Boolean backward;
	private int searchTitle;
	private String searchContent;

	public Paging(int begin, int end, boolean forward, boolean backward) {
		this.begin = begin;
		this.end = end;
		this.forward = forward;
		this.backward = backward;
	}

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
				if (begin <= 5)
					backward = false;
				else
					backward = true;

				break;
			}
		}
	}

// controller


// DAO PostgreSQL
public int bookTotalCount(Connection conn, int searchTitle, String searchContentParam) {
		int result = 0;
		String searchContent = " like '%" + searchContentParam + "%'";
		String search = null;
		switch (searchTitle) {
		case 0:
			search = "";
			break;
		case 1:
			search = "where CAST(no as text) " + searchContent;
			break;
		case 2:
			search = "where CAST( room_no as text) " + searchContent;
			break;
		case 3:
			search = "where name " + searchContent;
			break;
		}
		try {
			pstmt = conn.prepareStatement("select count(*) from booking " + search);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : BookDAO.bookTotalCount()");
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return result;
	}


public ArrayList<Booking> adminBookList(Connection conn, ArrayList<Booking> bookings, Paging paging) {
		ArrayList<Booking> bookingss = new ArrayList<Booking>();
		String searchContent = " like '%" + paging.getSearchContent() + "%'";
		String search = null;
		switch (paging.getSearchTitle()) {
		case 0:
			search = "";
			break;
		case 1:
			search = "where CAST(no as text) " + searchContent;
			break;
		case 2:
			search = "where CAST( room_no as text) " + searchContent;
			break;
		case 3:
			search = "where name " + searchContent;
			break;
		}
		try {
			pstmt = conn.prepareStatement(
					"select no, room_no,name,phone, adult, child, start_date,end_date,options,payment_flag, total_cost,bank_name,bank_branch_code,bank_account_number,created_at, updated_at, cancel_flag from booking "
							+ search + " order by no offset ? limit 10");
			pstmt.setInt(1, (paging.getCurrentPage() - 1) * 10);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String[] options = rs.getString(9).split("/");
				String option1 = options[0];
				String option2 = options[1];
				String option3 = options[2];
				bookingss.add(new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), option1, option2, option3, rs.getString(10),
						rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getDate(15),
						rs.getDate(16), rs.getString(17)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error : BookDAO.adminBookList()");
		} finally {
			JdbcUtil.close(pstmt, rs);
		}
		return bookingss;
	}
