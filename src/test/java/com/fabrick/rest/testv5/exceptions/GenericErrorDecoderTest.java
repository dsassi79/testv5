package com.fabrick.rest.testv5.exceptions;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import feign.Request;
import feign.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = GenericErrorDecoderConfig.class)
public class GenericErrorDecoderTest extends ModelBaseTest {
    @Autowired
    GenericErrorDecoder genericErrorDecoder;

    @Test()
    public void decode_OK() throws Exception {
        /* create the response mock */
        Request request = mock(Request.class);

        Response response = Response.builder()
                .request(request)
                .status(HttpStatus.BAD_REQUEST.value())
                .reason("Test")
                .headers(new HashMap<>())
                .body(readFile("responses/balance_response_KO.json"), StandardCharsets.UTF_8)
                .build();

        GenericException sut = (GenericException) genericErrorDecoder.decode("methodKey", response);
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo("REQ004");

    }

    @Test()
    public void decode_WithoutErrors_OK() throws Exception {
        /* create the response mock */
        Request request = mock(Request.class);

        Response response = Response.builder()
                .request(request)
                .status(HttpStatus.BAD_REQUEST.value())
                .reason("Test")
                .headers(new HashMap<>())
                .body(readFile("responses/balance_response_KO_WoutErrors.json"), StandardCharsets.UTF_8)
                .build();

        GenericException sut = (GenericException) genericErrorDecoder.decode("methodKey", response);
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo("UNK000");

    }

    @Test()
    public void decode_WithoutBody_OK() {
        /* create the response mock */
        Request request = mock(Request.class);

        Response response = Response.builder()
                .request(request)
                .status(HttpStatus.BAD_REQUEST.value())
                .reason("Test")
                .headers(new HashMap<>())
                .body("", StandardCharsets.UTF_8)
                .build();

        GenericException sut = (GenericException) genericErrorDecoder.decode("methodKey", response);
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo("UNK000");

    }



    @Test()
    public void decode_WithoutResponse_OK() {
        GenericException sut = (GenericException) genericErrorDecoder.decode("methodKey", null);
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo("UNK000");
    }

    public static String readFile(String filePath) throws Exception {
        String prefix = "mock/";
        Resource resource = new ClassPathResource(prefix + filePath);
        File file = resource.getFile();
        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        return content;
    }

}
