package ss4674_Lab3_SE311;

public class PrintVisitor extends Visitor {

	@Override
	public void visitFile(File file) {
		System.out.println(file + "\n");
	}

	@Override
	public void visitFolder(FolderComposite folderComposite) {
		System.out.println(folderComposite + "\n");

		for (FolderComponent child : folderComposite.getChildren()) {
			child.acceptVisitor(this);
		}

	}

}
