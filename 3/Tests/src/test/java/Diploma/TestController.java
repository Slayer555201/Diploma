package Diploma;

import Diploma.vstu.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/personal")
    public String startTestPersonal() {
        TestRunner.runTest(PersonalTest.class);

        return "redirect:/index";
    }

    @GetMapping("/address")
    public String startTestAddress() {
        TestRunner.runTest(AdressTest.class);

        return "redirect:/index";
    }

    @GetMapping("/study")
    public String startTestStudy() {
        TestRunner.runTest(StudyTest.class);

        return "redirect:/index";
    }

    @GetMapping("/additional")
    public String startTestAdditional() {
        TestRunner.runTest(AdditionalTest.class);

        return "redirect:/index";
    }

    @GetMapping("/cer")
    public String startTestCer() {
        TestRunner.runTest(CerTest.class);

        return "redirect:/index";
    }

    @GetMapping("/document")
    public String startTestDocument() {
        TestRunner.runTest(DocumentTest.class);

        return "redirect:/index";
    }

    @GetMapping("/sign-up-bad")
    public String startTestSignUpBad() {
        TestRunner.runTest(SignUpBadTest.class);

        return "redirect:/index";
    }

    @GetMapping("/all")
    public String startAllTest() {
        TestRunner.runTest(All.class);

        return "redirect:/index";
    }
}
