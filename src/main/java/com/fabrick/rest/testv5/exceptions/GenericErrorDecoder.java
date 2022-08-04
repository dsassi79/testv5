package com.fabrick.rest.testv5.exceptions;

import com.fabrick.rest.testv5.models.response.GenericResponseWithGenericPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
@Slf4j
public class GenericErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String body = "Bad request";
        ObjectMapper mapper = new ObjectMapper();
        try {
            body = IOUtils.toString(response.body().asReader(Charset.defaultCharset()));
            GenericResponseWithGenericPayload message = null;
            message = mapper.readValue(body, GenericResponseWithGenericPayload.class);
            if (!message.getErrors().isEmpty()) {
                return new GenericException(message.getErrors().get(0).getCode(), message.getErrors().get(0).getDescription());
            }
        } catch (Exception ignored) {log.error(ignored.toString());}
        return new GenericException("UNK000", body + "->" + methodKey);
    }


}
