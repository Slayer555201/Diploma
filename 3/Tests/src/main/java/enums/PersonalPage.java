package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonalPage implements BaseHtmlId {

    ID("id"),
    EMAIL("email"),
    INPUT_PASSWORD("inputPassword"),
    DOCSERIA("docseria"),
    DOCUMENT_NUMBER("documentNumber"),
    DOCDATE("docdate"),
    ISSUED("issued"),
    SURNAME("surname"),
    NAME("name"),
    LASTNAME("lastname"),
    SURNAME_EN("surname_en"),
    NAME_EN("name_en"),
    BIRTHDATE("birthdate"),
    BIRTHPLACE("birthplace"),
    IDENTIFICATION("identification");

    private final String htmlId;
}
