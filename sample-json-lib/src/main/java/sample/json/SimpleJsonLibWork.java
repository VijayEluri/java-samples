package sample.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;

public class SimpleJsonLibWork {
	
	// From Object to JSON Samples

	public void arraySample() {
		boolean[] boolArray = new boolean[] { true, false, true };
		JSONArray jsonArray = JSONArray.fromObject(boolArray);
		System.out.println(jsonArray);
	}

	public void collectionSample() {
		List list = new ArrayList();
		list.add("first");
		list.add("second");
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}

	public void mapSample() {
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");

		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json);
	}

	public void beanSample() {
        JSONObject jsonObject = JSONObject.fromObject( new MyBean() );
        System.out.println( jsonObject );
    }
	
	// From JSON to Object Samples
	
	
	public void convertToDynaBean() throws Exception {
		String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";
		   JSONObject jsonObject = new JSONObject( json );
		   Object bean = JSONObject.toBean( jsonObject );
		   System.out.println(jsonObject.get( "name" ));
		   System.out.println(PropertyUtils.getProperty( bean, "name" ) );

		   System.out.println( jsonObject.get( "bool" ));
		   System.out.println(PropertyUtils.getProperty( bean, "bool" ) );

		   System.out.println( jsonObject.get( "int" ));
		   System.out.println(PropertyUtils.getProperty( bean, "int" ) );

		   System.out.println( jsonObject.get( "double" ));
		   System.out.println(PropertyUtils.getProperty( bean, "double" ) );

		   System.out.println( jsonObject.get( "func" ));
		   System.out.println(PropertyUtils.getProperty( bean, "func" ) );

		   List expected = JSONArray.toList( jsonObject.getJSONArray( "array" ) );
		   for (int i=0; i <expected.size(); i++) {
			   System.out.println(expected.get(i));
		   }
	}

	public class MyBean {
		private String name = "json";
		private int pojoId = 1;
		private char[] options = new char[] { 'a', 'f' };
		private String func1 = "function(i){ return this.options[i]; }";
		private JSONFunction func2 = new JSONFunction(new String[] { "i" },
				"return this.options[i];");

		// getters & setters
		public String getFunc1() {
			return func1;
		}
		public void setFunc1(String func1) {
			this.func1 = func1;
		}
		public JSONFunction getFunc2() {
			return func2;
		}
		public void setFunc2(JSONFunction func2) {
			this.func2 = func2;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public char[] getOptions() {
			return options;
		}
		public void setOptions(char[] options) {
			this.options = options;
		}
		public int getPojoId() {
			return pojoId;
		}
		public void setPojoId(int pojoId) {
			this.pojoId = pojoId;
		}
		
	}

}
