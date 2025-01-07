package day57;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MVC1 {
}
// === MVC 1 === //
class MVC1ViewController{}
class MVC1Dao{}

// === MVC 2 === //
class MVC2View{}
class MVC2Controller{}
class MVC2Dao{}

// === MVC2 3티어 === //
// view : resource 안에 (html/css/js)존재
class Mvc2tire3Controller{}
class Mvc2tire3Service{}
class Mvc2tire3Dao{}

// === Spring MVC2-3tire === //
@RestController
class MvcController{}
@Service
class MvcService{}
@Component
class MvcDao{}

