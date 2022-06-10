public void autoSubInsert(Connection conn, int num) throws SQLException {
		SubDAO subdao = new SubDAO();
		System.out.println("sss");
		int i = 0;
		int j = 0;
		while (i <= 5) {
			while (true) {
				try (PreparedStatement pstmt = conn
						.prepareStatement("insert into water values(?,?)")) {
					pstmt.setInt(1, j);
					pstmt.setInt(2, 0);
					pstmt.executeUpdate();
				} catch (Exception e) {
				}
				try (PreparedStatement pstmt = conn
						.prepareStatement("insert into ele values(?,?,?)")) {
					pstmt.setInt(1, j);
					pstmt.setInt(2, 0);
					pstmt.setInt(3, 0);
					pstmt.executeUpdate();
				} catch (Exception e) {
				}
				conn.commit();
				j++;
				if (subdao.checkIsSubNullByNo(conn, j)) {
					break;
				}
			}
			i++;
		}
		JdbcUtil.close(pstmt);
	}
  
  public boolean checkIsSubNullByNo(Connection conn, int no) {
		boolean result = true;
		System.out.println("checkIsSubNullByNo");
		try {
			pstmt = conn.prepareStatement(
					"select w.no, w.water_ind, e.ele_basic, e.ele_ind from ele e, water w where w.no = e.no having w.no = ? ");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = false;
			}
		} catch (Exception e) {
			System.out.println(" error :  checkIsSubNullByNo");
			e.getMessage();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		System.out.println("result : " + result);
		return result;
	}
