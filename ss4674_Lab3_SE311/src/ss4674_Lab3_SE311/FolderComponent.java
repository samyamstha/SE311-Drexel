package ss4674_Lab3_SE311;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FolderComponent {

	private String name;
	private Date createdDate;

	public FolderComponent(String name, Date createDate) {
		this.name = name;
		this.createdDate = createDate;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void add(FolderComponent component) {

	}

	public ArrayList<FolderComponent> getChildren() {
		return null;
	}
	
	public abstract void acceptVisitor(Visitor visitor);

}
