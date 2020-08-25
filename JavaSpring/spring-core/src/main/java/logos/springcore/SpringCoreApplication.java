package logos.springcore;

import logos.springcore.entity.Student;
import logos.springcore.repository.StudentRepository;
import logos.springcore.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"logos.springcore.repository", "logos.springcore.service"})
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
		StudentService studentService = context.getBean(StudentService.class);
		studentService.findByName("Name");
		studentService.deleteById(1);
		studentService.findAll();
		studentService.findById(1);
		studentService.save(new Student(1, "Name", 19));
		studentService.update(new Student(1, "Name", 19));
	}

}
