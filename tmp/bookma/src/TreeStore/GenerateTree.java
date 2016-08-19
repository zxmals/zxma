package TreeStore;

import java.util.HashMap;
import java.util.Map;

public class GenerateTree {

	public static Map<String,Object> tree = new HashMap<String, Object>();

	public static Map<String, Object> getTree() {
		return tree;
	}

	public static void setTree(Map<String, Object> tree) {
		GenerateTree.tree = tree;
	}
	
	
}
