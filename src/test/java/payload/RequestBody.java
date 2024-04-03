package payload;

import java.util.HashMap;

public class RequestBody {

	public static Object postBody() {
		HashMap<String, Object> mData = new HashMap<String, Object>();
		mData.put("name", "Samsung s23 Ultra");
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("year", 2023);
		datas.put("price", 130000.00);
		datas.put("CPU model", "Snapdragon 8 Gen3");
		datas.put("Hard disk size", "512 GB");
		mData.put("data", datas);
		return mData;
		
	}
	
	public static Object updateBody() {
		HashMap<String, Object> mData = new HashMap<String, Object>();
		mData.put("name", "Samsung s24 Ultra");
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("year", 2024);
		datas.put("price", 150000.00);
		datas.put("CPU model", "SnapDragon 8 Gen4");
		datas.put("Hard disk size", "1 TB");
		datas.put("color", "Green");
		mData.put("data", datas);
		return mData;
		
	}
	
}
