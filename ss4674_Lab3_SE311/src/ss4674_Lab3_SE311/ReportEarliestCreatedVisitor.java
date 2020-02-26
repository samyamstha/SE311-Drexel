package ss4674_Lab3_SE311;

import java.util.ArrayList;

public class ReportEarliestCreatedVisitor extends Visitor {

	ArrayList<File> fileList = new ArrayList<File>();

	@Override
	public void visitFile(File file) {
		if (fileList.isEmpty()) {
			fileList.add(file);
		} else if (file.getCreatedDate().compareTo(fileList.get(0).getCreatedDate()) > 0) {
			fileList.clear();
			fileList.add(file);
		} else if (file.getCreatedDate().compareTo(fileList.get(0).getCreatedDate()) == 0) {
			fileList.add(file);
		}

	}

	@Override
	public void visitFolder(FolderComposite folderComposite) {
		visitFolderHelper(folderComposite);
		System.out.println("The file(s) with earliest date: ");
		for (File file : fileList) {
			System.out.println(file.getName());
		}
	}

	private void visitFolderHelper(FolderComposite folderComposite) {
		for (FolderComponent child : folderComposite.getChildren()) {
			if (child.getChildren() != null) {
				visitFolderHelper((FolderComposite) child);
			} else {
				child.acceptVisitor(this);
			}
		}

	}
}
