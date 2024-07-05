package Mo.flegma.deserializer;

import Mo.flegma.dto.UserDto;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.UUID;

public class UserDtoDeserializer extends JsonDeserializer<UserDto> {

    @Override
    public UserDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        UserDto userDto = new UserDto();
        if (node.isTextual()){
            UUID id = UUID.fromString(node.asText());
            userDto.setId(id);
        }
        return userDto;
    }
}
