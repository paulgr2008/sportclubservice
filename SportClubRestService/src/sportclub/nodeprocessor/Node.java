package sportclub.nodeprocessor;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@Embeddable
public class Node implements Comparable<Node>{
	int id;
	Node node;//=new Node();


	public Node() {
		//this.node=new Node();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", node=" + node + "]";
	}
	@Override
	public int compareTo(Node o) {
		return o.toString().hashCode()-this.toString().hashCode();
		
	}

}
