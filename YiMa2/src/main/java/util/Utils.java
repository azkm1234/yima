package util;

import java.util.List;

import domain.SearchHorseOption;

public class Utils {
	/**
	 *
	 * @param pageSize
	 * @param currentPage
	 * @return 0 currentpage, 1 pagesize
	 */
	public static int[] checkPageSizeAndCurrentPage(Integer pageSize, Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		currentPage = (currentPage - 1) * pageSize + 1;
		int [] results = {currentPage, pageSize};
		return results;
	}
	
	public static String checkSQL(List<String> list, String colum) {
		StringBuffer buffer = new StringBuffer();
		if (list != null && !list.isEmpty()) {
			buffer.append('(');
			for (int i = 0 ; i < list.size() - 1; i++) {
				buffer.append(colum + " = " + "'" + list.get(i) + "'");
				buffer.append(" or ");
			}
			buffer.append(colum + " = " + "'" + list.get(list.size() - 1) + "'");
			buffer.append(')');
		}
		return buffer.toString();
	}
	private static String checkSQLHelper(List<Integer> list1, List<Integer> list2, String colum) {
		if (list1.size() != list2.size()) {
		     System.out.println("list1 和 list2 的size不一样");
		}
		StringBuffer buffer = new StringBuffer();
		if (list1 != null && !list1.isEmpty() && list2 != null && !list2.isEmpty()) {
			buffer.append('(');
			for (int i = 0 ; i < list1.size() - 1; i++) {
				buffer.append('(');
				buffer.append(colum + " > " + list1.get(i));
				buffer.append(" and ");
				buffer.append(colum + " < " + list2.get(i));
				buffer.append(')');
				buffer.append(" or ");
			}
			buffer.append('(');
			buffer.append(colum + " > " + list1.get(list1.size() - 1));
			buffer.append(" and ");
			buffer.append(colum + " < " + list2.get(list1.size() - 1));
			buffer.append(')');
			buffer.append(')');
		}
		return buffer.toString();
	}
	public static String checkSQL(SearchHorseOption options, boolean flag) {
		StringBuffer buffer = new StringBuffer();
		if (options.getAge1() != null && options.getAge2() != null) {
			if (flag) {
				buffer.append(" and ");
			}
			buffer.append(checkSQLHelper(options.getAge1(), options.getAge2(), "age"));
			flag = true;
		}
		if (options.getHeight1() != null && options.getHeight2() != null) {
			if (flag) {
				buffer.append(" and ");
			}
			buffer.append(checkSQLHelper(options.getHeight1(), options.getHeight2(), "height"));
		}
		return buffer.toString();
	}
}
