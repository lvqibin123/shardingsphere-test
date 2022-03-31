package com.lqb.ss.MyShardingSphere.common.converter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lqb
 * @date 2019/4/8 23:03
 * @since 1.0
 */
public class LocalDateJsonConverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDate.parse(json.getAsString(),
				  dateTimeFormatter);
	}

	public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
		return  new
				  JsonPrimitive(src.format(dateTimeFormatter));
	}
}
