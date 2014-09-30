package jp.canetrash.sample.morphia.composite;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Composite {

	@Embedded
	private Composite child;

	@Id
	private ObjectId id;
	private int rank;
	private boolean hasChild;

	public Composite getChild() {
		return child;
	}

	public void setChild(Composite child) {
		this.child = child;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}
