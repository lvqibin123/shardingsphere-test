package com.lqb.ss.MyShardingSphere.common;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lqb.ss.MyShardingSphere.common.converter.LocalDateJsonConverter;
import com.lqb.ss.MyShardingSphere.common.converter.LocalDateTimeJsonConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DataAngularResult<T> {
	private long total;
	private List<T> list = null;
	
	public DataAngularResult(long total, List<T> list) {
		this.total = total;
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}


	public List<T> getList() {
		return  list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		JsonObject jn = new JsonObject();
		jn.addProperty("total", total);
		JsonArray  returnJson = new JsonArray();
		JsonArray jsonArray =  new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(list, new TypeToken<List<T>>() {}.getType()).getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject json = jsonArray.get(i).getAsJsonObject();
			json.addProperty("key",UUIDUtil.getUuid());
			returnJson.add(json);
		}
		jn.add("list", returnJson);
		return jn.toString();
	}
	public JsonObject addKeyWhisData() {
		JsonObject jn = new JsonObject();
		jn.addProperty("total", total);
		JsonArray jsonArray =  new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class,new LocalDateTimeJsonConverter())
				.registerTypeAdapter(LocalDate.class,new LocalDateJsonConverter())
				.create().
						toJsonTree(list, new TypeToken<List<T>>() {}.getType()).getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonArray.get(i).getAsJsonObject().addProperty("key",jsonArray.get(i).getAsJsonObject().get("id").getAsString());
		}
		jn.add("list", jsonArray);
		return jn;
	}

	public JsonObject addKeyWhisReact() {
		JsonObject jn = new JsonObject();
		jn.addProperty("total", total);
		JsonArray jsonArray =  new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class,new LocalDateTimeJsonConverter())
				.registerTypeAdapter(LocalDate.class,new LocalDateJsonConverter())
				.create().
						toJsonTree(list, new TypeToken<List<T>>() {}.getType()).getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonArray.get(i).getAsJsonObject().addProperty("key",jsonArray.get(i).getAsJsonObject().get("id").getAsString());
		}
		jn.add("data", jsonArray);
		jn.addProperty("success", true);
		return jn;
	}
}
