package ss4674_Lab3_SE311;

public abstract class Visitor {

	public abstract void visitFile(File file);
	public abstract void visitFolder(FolderComposite folderComposite);
}
