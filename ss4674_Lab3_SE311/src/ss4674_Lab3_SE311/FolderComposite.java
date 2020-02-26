package ss4674_Lab3_SE311;

import java.util.ArrayList;
import java.util.Date;

public class FolderComposite extends FolderComponent {

	private ArrayList<FolderComponent> children;

	public FolderComposite(String name, Date createDate) {
		super(name, createDate);
		children = new ArrayList<FolderComponent>();
	}

	@Override
	public void add(FolderComponent component) {
		children.add(component);
	}

	@Override
	public ArrayList<FolderComponent> getChildren() {
		return children;
	}

	@Override
	public void acceptVisitor(Visitor visitor) {
		visitor.visitFolder(this);
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\t\t\t Created Date: " + this.getCreatedDate();
	}
	
	

}
