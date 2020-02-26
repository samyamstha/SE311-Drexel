package ss4674_Lab3_SE311;

import java.util.Date;

public class File extends FolderComponent {

	private int size;

	public File(String name, int size, Date createdDate) {
		super(name, createdDate);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visitFile(this);
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\t\t\t Created Date: " + this.getCreatedDate() + "\t Size: " + this.getSize();
	}
}
