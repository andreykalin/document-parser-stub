package ru.lanit.demo.documentparserstub;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сведения о файле")
public class FileDetail {

    @Schema(description = "Идентификатор файла", example = "123e4567-e89b-12d3-a456-426614174000", required = true)
    private String guid;

    @Schema(description = "Серия паспорта", example = "1234", required = true)
    private String series;

    @Schema(description = "Номер паспорта", example = "567890", required = true)
    private String number;

    @Schema(description = "Дата выдачи паспорта", example = "2020-01-01", required = false)
    private String issueDate;

    @Schema(description = "Код подразделения", example = "770-001", required = false)
    private String issueOrganCode;

    @Schema(description = "Где выдан", example = "Москва", required = false)
    private String issuePlace;

    @Schema(description = "Фамилия", example = "Иванов", required = false)
    private String lastName;

    @Schema(description = "Имя", example = "Иван", required = true)
    private String firstName;

    @Schema(description = "Отчество", example = "Иванович", required = true)
    private String middleName;

    @Schema(description = "Пол", example = "Мужской", required = false)
    private String male;

    @Schema(description = "Дата рождения", example = "1990-05-15", required = false)
    private String birthDate;

    @Schema(description = "Место рождения", example = "Москва", required = false)
    private String birthPlace;
}
