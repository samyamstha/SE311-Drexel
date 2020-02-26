package ss4674_Lab3_SE311;

public class ReportCountVisitor extends Visitor {

	private int totalNumOfFiles = 0;

	@Override
	public void visitFile(File file) {
		totalNumOfFiles++;
	}

	@Override
	public void visitFolder(FolderComposite folderComposite) {
		countHelper(folderComposite);
		System.out.println("Total number of files in the system is " + totalNumOfFiles);

	}

	private void countHelper(FolderComposite folderComposite) {
		for (FolderComponent child : folderComposite.getChildren()) {
			if (child.getChildren() != null) {
				countHelper((FolderComposite) child);
			} else {
				child.acceptVisitor(this);
			}
		}
		
	}

}
