package com.lqb.ss.MyShardingSphere.common.converter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lqb
 * @date 2019/4/8 23:03
 * @since 1.0
 */
public class LocalDateTimeJsonConverter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return  LocalDateTime.parse(json.getAsString(),
				  dateTimeFormatter); 
	}

	public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
		return new
				  JsonPrimitive(src.format(dateTimeFormatter)); 
	}
}
