package com.info;

;

import com.dbcom.DBResult;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestString {
	private int curPage;// ��ǰҳ��
	private int maxPage;// ���ҳ��
	private int maxRowCount;// �ܼ�¼��(�������ݿ��в�������м�¼)
	private int pageSize = 2;// ÿҳҪ��ʾ�ļ�¼��
	private DBResult db;// ��¼������
	private String httpFile;// ��ǰ��ַ�����ļ����������JSP�ļ�
	private String cif;// ѡ��Ĳ�ѯ�ֶ�
	private String ccif;// ѡ��Ĳ�ѯ���������
	private String qvalue;// ��ѯ�ؼ���
	private String countSql = null;// �����洢select count (*) �������
	private String topSql = null;// �����洢 select top 2�������
	private String nowPage = null;// ��ʼ����ǰҳcurPage����,����ǰҳ�ľ���ҳ��
	private String str_parameter;// ������ҳ��ʱ���ݵĳ�pages�������������
	private String andor;// ��ѯ����/������
	private String sdate;// ��ѯ��ʼʱ��,����ʲô���ڿ�ʼ��ѯ
	private String edate;// ��ѯ����ʱ��,����ʲô���ڽ���
	private String orderby;// ��������,����ʲô����
	private String paixu;// ���򷽷�,���������

	public QuestString() {
		db = new DBResult();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxRowCount() {
		return maxRowCount;
	}

	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getHttpFile() {
		return httpFile;
	}

	public void setHttpFile(String httpFile) {
		this.httpFile = httpFile;
	}

	public String getCcif() {
		return ccif;
	}

	public void setCcif(String ccif) {
		this.ccif = ccif;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getQValue() {
		return qvalue;
	}

	public void setQValue(String qValue) {
		this.qvalue = qValue;
	}

	public String getStr_parameter() {
		return str_parameter;
	}

	public void setStr_parameter(String str_parameter) {
		this.str_parameter = str_parameter;
	}

	public String getAndor() {
		return andor;
	}

	public void setAndor(String andor) {
		this.andor = andor;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getPaixu() {
		return paixu;
	}

	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}

	/**
	 * ͨ����������������Bean�е�����
	 */

	public void setQuerySql(String httpfile, String pages, String strCount) {
		this.nowPage = pages;// �����ύ�����Ĳ���pages(�ڼ�ҳ)��ֵ���ݸ�����nowPage����
		this.httpFile = httpfile;// ������̬���ô���������JSP�ļ�
		this.countSql = strCount;// ��������ִ��select count(*)������SQL���
		try {
			querySql(countSql);// ����querySql��������������countSql���ݵ��÷�����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ִ��SQL��䣬��÷�ҳ��ʾʱ�ĸ�������
	 */
	public void querySql(String countSql) throws SQLException {
		// ��setQuerySql�������Ѿ�������nowPage��ֵ,��ֵ����pages
		if (this.nowPage == null||"0".equals(this.nowPage)) {// ���nowPage��ֵΪ�գ�Ҳ���Ǵ���pages��ֵΪ��
			this.curPage = 1;// ��ô�ͽ���ǰҳ��ֵ��Ϊ1��
		} else {
			this.curPage = Integer.parseInt(this.nowPage);
			if (this.curPage < 1) {// �����ǰҳС��1����ô�ͽ���ǰҳ��ֵ��Ϊ1
				this.curPage = 1;
			}
		}
		ResultSet rsCount = db.getResult(countSql);// ִ��SQL����ü�¼����
		if (rsCount.next()) {
			this.maxRowCount = rsCount.getInt(1);// ��ȡ��¼����������Ҫ��ѯ��¼��������
		}
		// ��ȡ��ҳ������������ܼ�¼������ÿҳ��ʾ�ļ�¼������Ϊ0ʱ����ҳ���͵������������Ľ��
		// �������������0����ô��ҳ���͵������������Ľ����1
		this.maxPage = (this.maxRowCount % this.pageSize == 0) ? (this.maxRowCount / this.pageSize)
				: (this.maxRowCount / this.pageSize + 1);
		if (this.curPage > this.maxPage) {// �����ǰҳ������ҳ������ǰҳ������ҳ��
			this.curPage = this.maxPage;// ��ô��ǰҳ�������ҳ
		}
		rsCount.close();// �ر��ܼ�¼���ĽἯ
	}

	/**
	 * һ���ַ�����������̬�ĸ���һ���� �ñ��������з�ҳ��ͳͳҳ������ת
	 */
	public String pageFooter() {
		// ����һ����
		String str = "<form action=" + this.httpFile
				+ " name=formBean methord=post>";
		int prev = this.curPage - 1;// ��ǰ��ҳ������ǰҳ��1
		int next = this.curPage + 1;// ���ҳ������ǰҳ��1

		str = str + "<font style='font-size: 10pt'>�ܼ�<font color='red'>"
				+ this.getMaxRowCount() + "</font>����¼,"
				+ "����<font  color='red'>" + this.getMaxPage() + "</font>ҳ��";
		str = str + "�� <font color='red'>" + this.pageSize
				+ "</font>��/ҳ�� ��ǰ��<font color='red'>" + this.getCurPage()
				+ "</font>ҳ &nbsp; ";
		if (this.curPage > 1)
			str = str + " <A href=" + this.httpFile + "?pages=1"
					+ str_parameter + ">��ҳ</A> ";
		else
			str = str + " ��ҳ ";
		if (this.curPage > 1)
			str = str + " <A href=" + this.httpFile + "?pages=" + prev
					+ str_parameter + ">��һҳ</A> ";
		else
			str = str + " ��һҳ ";
		if (this.curPage < this.maxPage)
			str = str + " <A href=" + this.httpFile + "?pages=" + next
					+ str_parameter + ">��һҳ</A> ";
		else
			str = str + " ��һҳ ";
		if (this.maxPage > 1 && this.curPage != this.maxPage)
			str = str + " <A href=" + this.httpFile + "?pages=" + this.maxPage
					+ str_parameter + ">βҳ</A>";
		else
			str = str + " βҳ</font>";
		// ��ҳ����ת���������ر��������治ͬ������
		str = str + "ת��<input type ='text' name='pages' size='2'>ҳ"
				+ "<input type='hidden' name='ccif' value='" + this.ccif
				+ "'><input type ='hidden' name='cif' value='" + this.cif
				+ "'><input type ='hidden' name='qvalue' value='" + this.qvalue
				+ "'><input type ='hidden' name='andor' value='" + this.andor
				+ "'><input type ='hidden' name='sdate' value='" + this.sdate
				+ "'><input type ='hidden' name='edate' value='" + this.edate
				+ "'><input type ='hidden' name='orderby' value='"
				+ this.orderby + "'><input type ='hidden' name='paixu' value='"
				+ this.paixu
				+ "'><input type='submit' name='sumbmit' value='go'></form>";
		return str;
	}

	/**
	 * ���ݲ�ͬ��������ȡ��ͬ�Ĳ�ѯǰN����SQL���
	 */
	public String getString(String table) {
		if (ccif.equals("=")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where" + " " + cif + "=" + "'"
					+ qvalue + "'";
			return strSql;
		} else if (ccif.equals("LIKE")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where" + " " + cif + " " + "like"
					+ " " + "'%" + qvalue + "%'";
			return strSql;
		} else if (ccif.equals("ALL")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table;
			return strSql;
		} else if (ccif.equals("<")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where " + cif + " < '" + qvalue
					+ "'";
			return strSql;
		}
		return null;
	}

	/**
	 * ���ݲ�ͬ��������ò�ͬ�ļ����¼������SQL���
	 */
	public String getCount(String table) {
		if (ccif.equals("=")) {
			String strSql = "select count(*) from " + table + " where " + cif
					+ "='" + qvalue + "'";
			return strSql;
		} else if (ccif.equals("LIKE")) {
			String strSql = "select count(*) from " + table + " where " + cif
					+ " like" + " %" + qvalue + "%";
			return strSql;
		} else if (ccif.equals("ALL")) {
			String strSql = "select count(*) from " + table;
			return strSql;
		}
		return null;
	}

	public String getXSCount(String table) {
		if (ccif.equals("=")) {
			String strSql = "select count(*) from " + table + " where" + " "
					+ cif + "=" + "'" + qvalue + "' and whether='��'";
			return strSql;
		} else if (ccif.equals("LIKE")) {
			String strSql = "select count(*) from " + table + " where" + " "
					+ cif + " " + "like" + " " + "'%" + qvalue
					+ "%' and whether='��'";
			return strSql;
		}
		return null;
	}

	public String getXSString(String table) {
		if (ccif.equals("=")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where" + " " + cif + "=" + "'"
					+ qvalue + "' and whether='��'";
			return strSql;
		} else if (ccif.equals("LIKE")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where" + " " + cif + " " + "like"
					+ " " + "'%" + qvalue + "%'and whether='��'";
			return strSql;
		}
		return null;
	}

	/**
	 * ���ݲ�ͬ�����Ͳ�ͬ������ʼ���ںͽ�����������ò�ͬ�ļ��� ��¼������SQL���
	 */
	public String getDateCount(String table) {
		if (ccif.equals("="))// ��sdate��edateʱ����н���׼ȷֵ��ѯ
		{
			String strSql = "select count(*) from " + table + " where " + cif
					+ "='" + qvalue + "' " + andor + " xsdate between '"
					+ sdate + "' and '" + edate + "'";
			return strSql;
		} else if (ccif.equals("LIKE"))// ��sdate��edateʱ����н���ģ����ѯ
		{
			String strSql = "select count(*) from " + table + " where " + cif
					+ " like '%" + qvalue + "%'" + andor + " xsdate between '"
					+ sdate + "' and '" + edate + "'";
			return strSql;
		} else if (ccif.equals("ALL"))// ȡ���������м�¼
		{
			String strSql = "select count(*) from " + table;
			return strSql;
		}
		return null;
	}

	/**
	 * ���ݲ�ͬ�����Ͳ�ͬ������ʼ���ںͽ�����������ò�ͬ�Ĳ�ѯ ǰN����SQL���
	 */
	public String getDateString(String table) {
		if (ccif.equals("=")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where " + cif + " = '" + qvalue
					+ "'" + andor + " xsdate between '" + sdate + "' and '"
					+ edate + "'";
			return strSql;
		} else if (ccif.equals("LIKE")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table + " where " + cif + " like '%"
					+ qvalue + "%'" + andor + " xsdate between '" + sdate
					+ "' and '" + edate + "'";
			return strSql;
		} else if (ccif.equals("ALL")) {
			String strSql = "select top " + this.pageSize * this.curPage
					+ " * from " + table;
			return strSql;
		}
		return null;
	}

	/**
	 * �Ӳ�ѯ�еõ�����ʼ���ڵ������������ʱ�����в��ظ���spid(��Ʒid) �����ز��ظ���spid������
	 */
	public String getOrderCount(String table) {
		String strSql = "select count(*) from (select spid from " + table
				+ " where xsdate between '" + sdate + "' and '" + edate
				+ "' group by spid) as aa";
		return strSql;
	}

	/**
	 * ���ϲ�ѯ ��ѯ��ĳһ���д���ʼ���������ڼ����в��ظ���spid(��Ʒid)
	 * ���ҽ�������ͬspid�µ�sl(����)��je(���)���,�������ĳһ��Ʒ�� ĳһʱ����ڵ������������������ܶ�
	 * ���ͨ�����ϲ�ѯ��tb_brand��(��Ʒ��Ϣ��)�н���spid����Ӧ��Ʒ�� ����һЩ��Ϣ��ѯ����
	 */
	public String getOrderString(String table) {
		String strSql = "select top "
				+ this.pageSize
				* this.curPage
				+ "* from tb_brand a inner join (select spid,sum(sl) as sl,sum(je) as je"
				+ " from " + table + " where  xsdate between '" + sdate
				+ "' and '" + edate + "' group by spid ) as b"
				+ " on a.id=b.spid order by " + orderby + " " + paixu;
		return strSql;
	}
}
