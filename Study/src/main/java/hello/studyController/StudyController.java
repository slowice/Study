package hello.studyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class StudyController {

    public String contextStudy(){
       return "context";
    }
}
