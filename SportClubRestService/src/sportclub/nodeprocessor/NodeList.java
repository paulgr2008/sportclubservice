package sportclub.nodeprocessor;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class NodeList {
	@JsonInclude(Include.NON_NULL)
	int id;
	@JsonInclude(Include.NON_NULL)
	ArrayList<NodeList> nodes;
	public int getId() {
		return id;
	}
	public ArrayList<NodeList> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<NodeList> nodes) {
		this.nodes = nodes;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "NodeSet [id=" + id + ", nodes=" + nodes + "]";
	}



}
