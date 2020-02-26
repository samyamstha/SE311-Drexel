package ss4674_Lab3_SE311;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {


	public static void main(String[] args) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		File file1 = new File("file1.txt", 50, dateFormat.parse("2011-01-01"));
		File file2 = new File("file2.txt", 128, dateFormat.parse("2012-01-01"));
		File file3 = new File("file3.txt", 256, dateFormat.parse("2013-01-01"));
		File file4 = new File("file4.txt", 68, dateFormat.parse("2013-01-01"));
		File file5 = new File("file5.txt", 76, dateFormat.parse("2012-01-01"));
		File file6 = new File("file6.txt", 55, dateFormat.parse("2020-01-01"));
		File file7 = new File("file7.txt", 100, dateFormat.parse("2020-11-01"));
		File file8 = new File("file8.txt", 256, dateFormat.parse("2020-12-15"));
		File file9 = new File("file9.txt", 256, dateFormat.parse("2020-09-12"));
		File file10 = new File("file10.txt", 128, dateFormat.parse("2020-03-11"));
		File file11 = new File("file11.txt", 128, dateFormat.parse("2020-12-15"));

		FolderComposite folder1 = new FolderComposite("folder1", dateFormat.parse("2010-01-01"));
		FolderComposite folder2 = new FolderComposite("folder2", dateFormat.parse("2004-01-01"));
		FolderComposite folder3 = new FolderComposite("folder3", dateFormat.parse("2003-01-01"));
		FolderComposite folder4 = new FolderComposite("folder4", dateFormat.parse("2005-01-01"));
		FolderComposite folder5 = new FolderComposite("folder5", dateFormat.parse("2006-01-01"));
		FolderComposite folder6 = new FolderComposite("folder6", dateFormat.parse("2001-01-01"));
		FolderComposite folder7 = new FolderComposite("folder7", dateFormat.parse("2015-01-01"));
		FolderComposite folder8 = new FolderComposite("folder8", dateFormat.parse("2013-01-01"));
		FolderComposite folder9 = new FolderComposite("folder9", dateFormat.parse("2012-01-01"));
		FolderComposite folder10 = new FolderComposite("folder10", dateFormat.parse("2002-01-01"));
		FolderComposite folder11 = new FolderComposite("folder11", dateFormat.parse("2015-01-11"));

		FolderComposite root = new FolderComposite("root", dateFormat.parse("2020-01-01"));

		folder1.add(folder4);
		folder1.add(folder5);
		folder1.add(file1);

		folder4.add(folder11);
		folder4.add(file2);
		folder4.add(file3);
		folder4.add(file4);

		folder11.add(file6);

		folder5.add(file5);
		folder5.add(file7);

		folder2.add(folder6);
		folder2.add(folder7);
		folder2.add(file2);
		folder2.add(file3);

		folder6.add(file8);

		folder3.add(folder8);
		folder3.add(folder9);
		folder3.add(folder10);
		folder3.add(file9);

		folder8.add(file10);
		folder9.add(file11);

		root.add(folder1);
		root.add(folder2);
		root.add(folder3);

		Visitor print = new PrintVisitor();

		Visitor count = new ReportCountVisitor();

		Visitor earliestFiles = new ReportEarliestCreatedVisitor();

		System.out.println("**************Output from PrintVisitor**************\n\n");

		root.acceptVisitor(print);

		System.out.println("\n\n**************Output from ReportCountVisitor**************\n\n");

		root.acceptVisitor(count);

		System.out.println("\n\n**************Output from ReportEarliestCreatedVisitor**************\n\n");

		root.acceptVisitor(earliestFiles);

	}

}
