package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AdditionalPage implements BaseHtmlId {

    FATHER_FIO("fatherFIO"),
    FATHER_PHONE("fatherPhone"),
    FATHER_WORK("fatherWork"),
    MOTHER_FIO("motherFIO"),
    MOTHER_PHONE("motherPhone"),
    MOTHER_WORK("motherWork"),
    MINOR_COUNT("minorCount"),
    WORK_PLACE("workPlace"),
    EXPERIENCE("experience");

    private final String htmlId;
}
