package ru.lanit.demo.documentparserstub;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest/services/llm")
public class FileController {

    @Operation(summary = "Загрузка документа для разбора")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Сведения о файле",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FileDetail.class))),
            @ApiResponse(responseCode = "500", description = "Некорректный размер файла или ошибки валидации",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping(value = "/docverify", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<FileDetail> verifyDocument(
            @Schema(description = "Содержимое файла в виде массива байт", required = true)
            @RequestPart("file") byte[] file,
            @Schema(description = "Имя файла", example = "document.pdf", required = true)
            @RequestPart("fileName") String fileName,
            @Schema(description = "Тип документа", example = "passport", required = true)
            @RequestPart("context") String context,
            @Schema(description = "Идентификатор файла", example = "123e4567-e89b-12d3-a456-426614174000", required = true)
            @RequestPart("guid") String guid,
            @Schema(description = "Идентификатор файла", example = "123e4567-e89b-12d3-a456-426614174000", required = true)
            @RequestPart(value = "description", required = false) String description) {

        if (file.length > 5 * 1024 * 1024) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        FileDetail fileDetail = new FileDetail();
        fileDetail.setGuid(guid);
        fileDetail.setSeries("1234");
        fileDetail.setNumber("567890");
        fileDetail.setIssueDate("2020-01-01");
        fileDetail.setIssueOrganCode("770-001");
        fileDetail.setIssuePlace("Москва");
        fileDetail.setLastName("Иванов");
        fileDetail.setFirstName("Иван");
        fileDetail.setMiddleName("Иванович");
        fileDetail.setMale("Мужской");
        fileDetail.setBirthDate("1990-05-15");
        fileDetail.setBirthPlace("Москва");

        return ResponseEntity.ok(fileDetail);
    }

}
