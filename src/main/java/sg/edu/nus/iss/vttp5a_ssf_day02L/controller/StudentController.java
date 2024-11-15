package sg.edu.nus.iss.vttp5a_ssf_day02L.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>();


    // @GetMapping
    // @ResponseBody
    @RequestMapping(path = { "", "/allStudents" }, method = RequestMethod.GET)
    public String getStudentList(Model model) throws ParseException {

        // convert a date String to epoch (long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDoB = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Koh", epochDoB, "damien@nus.sg", "25 HKMT");
        students.add(s1);

        Student s2 = new Student(2, "Darryl", "Ng", epochDoB, "darryl@nus.sg", "25 SGMT");
        students.add(s2);

        // converts epoch Long to Date
        Long epochTime = 188103300000L;
        Date dTime = new Date(epochTime);
        String formattedDate = sdf.format(dTime);
        System.out.println(formattedDate);

        model.addAttribute("students", students);

        return "studentList";
    }

}
