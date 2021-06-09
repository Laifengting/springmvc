package com.lft.springmvc.handler;

import com.lft.springmvc.pojo.Address;
import com.lft.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping ("springmvc")
// @SessionAttributes (names = {"user"}, types = {String.class})
public class HelloWorld {
    
    private static final String SUCCESS = "success";
    
    /**
     * 1. 使用 @RequestMapping ("helloworld") 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为塑封的物理视图，对于 InternalResourceViewResolver 视图解析器，会做如下的解析：
     * //       通过 prefix + 返回值 + suffix 这样的方式得到实际的物理视图，然后做转发操作。
     * //       /WEB-INF/views/success.jsp
     * 3. @RequestMapping
     * //       类上：提供初步的请求映射信息。相对于 WEB 应用的根目录
     * //       方法上：提供进一步的细分映射信息。相对于类上的 URL。若类上未标注 @RequestMapping 则方法处理标记的 URL 相对于 WEB 应用的根目录。
     * @return
     */
    @RequestMapping ("helloworld")
    public String helloWorld() {
        System.out.println("Hello World");
        return SUCCESS;
    }
    
    /**
     * 使用 method 属性来指定请求的类型
     * @return
     */
    @RequestMapping (value = "testMethod", method = {RequestMethod.POST})
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }
    
    /**
     * 了解：可以使用 params 和 headers 来更加精确映射请求。 params 和 headers 支持简单的表达式。
     * @return
     */
    @RequestMapping (value = {"testParamHeaders"}, params = {"username", "age!=10"}, headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0;" +
            " WOW64)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36"})
    public String testParamHeaders() {
        System.out.println("testParamHeaders");
        return SUCCESS;
    }
    
    @RequestMapping ("testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }
    
    /**
     * 使用注解 @PathVariable 可以用来映射 URL 中的占位符到目标方法的参数
     * @param id
     * @return
     */
    @RequestMapping ("testPathVariable/{id}")
    public String testPathVariable(@PathVariable ("id") String id) {
        System.out.println("testPathVariable " + id);
        return SUCCESS;
    }
    
    @RequestMapping (value = "testRest/{id}", method = {RequestMethod.GET})
    public String testRestGet(@PathVariable ("id") String id) {
        System.out.println("testRest GET " + id);
        return SUCCESS;
    }
    
    @RequestMapping (value = "testRest", method = {RequestMethod.POST})
    public String testRestPost() {
        System.out.println("testRest POST");
        return SUCCESS;
    }
    
    @RequestMapping (value = "testRest/{id}", method = {RequestMethod.PUT})
    public String testRestPut(@PathVariable ("id") String id) {
        System.out.println("testRest Put " + id);
        return SUCCESS;
    }
    
    @RequestMapping (value = "testRest/{id}", method = {RequestMethod.DELETE})
    public String testRestDelete(@PathVariable ("id") String id) {
        System.out.println("testRest DELETE " + id);
        return SUCCESS;
    }
    
    @RequestMapping ("testRequestParam")
    public String testRequestParam(@RequestParam (value = "username", required = false) String username,
                                   @RequestParam (value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam username " + username);
        System.out.println("testRequestParam age " + age);
        return SUCCESS;
    }
    
    @RequestMapping ("testReuqestHeaders")
    public String testReuqestHeaders(@RequestHeader ("Accept-Language") String header) {
        System.out.println("testReuqestHeaders header " + header);
        return SUCCESS;
    }
    
    @RequestMapping ("testCookieValue")
    public String testCookieValue(@CookieValue ("JSESSIONID") String cookie) {
        System.out.println("testCookieValue cookie " + cookie);
        return SUCCESS;
    }
    
    /**
     * 使用 POJO 作为参数接收数据并封装成对象，级联属性赋值。
     * @param user
     * @return
     */
    @RequestMapping ("testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo user " + user);
        return SUCCESS;
    }
    
    /**
     * 支持 Servlet 原生 API 作为参数
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     * @param request
     * @param response
     * @return
     */
    @RequestMapping ("testServletApi")
    public void testServletApi(
            HttpServletRequest request,
            HttpServletResponse response,
            Writer writer) throws IOException {
        System.out.println("testServletApi request " + request);
        System.out.println("testServletApi response " + response);
        
        writer.write("Hello SpringMVC");
        // return SUCCESS;
    }
    
    /**
     * 目标方法的返回值可以是 ModelAndView 类型。
     * ModelAndView 里面可以包含视图和模型信息。
     * @return
     */
    @RequestMapping ("testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView mav = new ModelAndView(viewName);
        // 添加模型数据到 ModelAndView 中。
        mav.addObject("time", new Date());
        return mav;
    }
    
    /**
     * 目标方法可以添加 Map 类型（实际上也可以是 Model 类型 或 ModelMap 类型）的参数
     * @param map
     * @return
     */
    @RequestMapping ("testMap")
    public String testMap(Map<String, Object> map) {
        map.put("names", Arrays.asList("Tom", "Jerry", "Mary", "John"));
        map.put("time", new Date());
        return SUCCESS;
    }
    
    /**
     * 注解 @SessionAttributes (names = {"user"}, types = {String.class}) 如果在类上添加了。
     * 除了可以通过属性名指定需要放到会话中的属性外（使用的是 value 属性值）
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（使用的是 type 属性值）
     * 【注意】这个注解只能放在类上，不能放在方法上。
     * @param map
     * @return
     */
    @RequestMapping ("testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User(1, "Tom", "123456", 20, "tom@qq.com", new Address("江苏", "南通"));
        map.put("user", user);
        map.put("school", "SCHOOL");
        return SUCCESS;
    }
    
    /**
     * 模拟个性操作
     * 1. 原始数据：id=1,username=tom,password=123456,age=20,email=tom@qq.com,address={"江苏","南通"}
     * 2. 密码不能被个性
     * 3. 表单回显，模拟操作直接在表单填写对应的属性值
     * @param map
     * @return
     */
    @RequestMapping ("testModelAttribute")
    public String testModelAttribute(@ModelAttribute ("user") User user) {
        System.out.println("修改：" + user);
        return SUCCESS;
    }
    
    /**
     * 有 @ModelAttribute 标记的方法，会在每个目标方法执行之前被 SpringMVC 调用！
     * 运行流程：
     * 1. 执行  @ModelAttribute 注解修改的方法：从数据库中取出对象。把对象放入到 Map 中。键为：user
     * 2. SpringMVC 从 Map 中取出 User 对象，并把表单的请求参数赋给该 User 对象的对应属性。
     * 3. SpringMVC 把上述对象传入目标方法的参数。
     * <p>
     * 注意：在 @ModelAttribute 修饰的方法中。放入到 Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致。
     * <p>
     * <p>
     * SpringMVC 确定目标方法 POJO 类型入参的过程
     * 1. 确认一个 key，
     * *    1.1 若目标方法的 POJO 入参没有使用 @ModelAttribute 注解，则 key 为 POJO 类名首字母小写。
     * *    1.2 若目标方法的 POJO 入参使用了 @ModelAttribute 注解，则 key 就是 注解中的 value 或 name 属性的值。
     * 2. 在 implicitModel 中查找 key 对应的对象，若存在，则作为目标方法的入参传入。
     * *    2.1 在 @ModelAttribute 标记的方法中 在 Map 中保存过。且 key 跟 步骤 1 中的 key 一致。则会获取到。
     * 3. 在 implicitModel 中不存在 key 对应的对象，则检查当前的 Handler 是否使用了 @SessionAttributes 注解。若使用了该注解，且 @SessionAttributes 注解的 value 属性值中包含了
     * key，则会从 HttpSession 中来获取 key 对应的 value 值。若存入则直接传入到目标方法的入参中，若不存在则将抛出异常。
     * 4. 若 Handler 没有标识  @SessionAttributes 注解 或  @SessionAttributes 注解 的中不包含对应的 key,则会通过反射来创建 POJO 类型的对象，传入目标方法的入参中。
     * 5. SpringMVC 会把 key 和 value 保存到 implicitModel 中，进而会保存到 request 中。
     * <p>
     * <p>
     * 源代码分析流程：
     * 1. 调用 @ModelAttribute 注解修改的方法。实际上是把 @ModelAttribute 方法中 Map 中的数据放到了 implicitModel 中。
     * 2. 解析请求处理器的目标参数，实际上该目标参数来乍于。WebDataBinder 对象的 target 属性。
     * //   2.1 创建 WebDataBinder 对象
     * //       2.1.1 确定 objectName 属性：
     * //           2.1.1.1 若传入的 attrName 属性值为 ""，则 objectName 为类名第一个字母小写。
     * //           2.1.1.2 ★ 注意：attrName 若目标方法的 POJO 属性使用了 @ModelAttribute 注解来修改，则 attrName 值即为 @ModelAttribute 属性 value 或 name 的值。
     * //       2.1.2 确定 target 属性：
     * //           2.1.2.1 在 implicitModel 中查找 attrName 对应的属性值。若存在，直接赋值给 objectName
     * //           2.1.2.2 若不存在：则验证当前 Handler 是否使用了 @SessionAttributes 注解：
     * //               2.1.2.2.1若使用了，则尝试从 Session 中获取 attrName 所对应的值。
     * //               2.1.2.2.2 ★ 若 Session 中没有对应的属性值，则抛出异常。
     * //           2.1.2.3 如果当前  Handler 没有使用 @SessionAttributes 注解，或者 @SessionAttributes 中没有键 attrName 对应的值。则通过反射创建 POJO 对象。
     * //   2.2 SpringMVC 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性。
     * //   2.3 ★ SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel。从而传入 request 域对象中。
     * //   2.4 把 WebDataBinder 的 target 作为参数传递给目标方法的入参。
     */
    @ModelAttribute
    public void getUser(@RequestParam (value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            // 模拟从数据库中获取数据
            User user = new User(1, "Tom", "123456", 20, "tom@qq.com", new Address("江苏", "南通"));
            map.put("user", user);
            System.out.println("从数据库中获取对象 " + user);
        }
    }
}
