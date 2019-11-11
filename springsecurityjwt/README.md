# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

第一种
1.启动SpringsecurityjwtApplication.java类

2.在postman测试,注册一个用户
url:localhost:18081/user/signup
post
header: key--Content-Type ，values--application/json
body:{
     	"username":"user",
     	"password":"123456"
     }
3. 在postman登录
url: localhost:18081/login    //spring specurity框架提供的默认登录url
post
header: key--Content-Type ，values--application/json
body:{
    "username":"user",
    "password":"123456"
}

token值是 postman返回结果的header里的key--Authorization对应values
  
4. 浏览器访问 http://localhost:18081/swagger-ui.html#
   根据拿到的Authorization对应values
   放到swagger查询用户信息接口http://localhost:18081/user/findByUserName，Authorization，放token
   接着userName对应输入admin
   点击Try it out即可，根据返回结果 可以测试得出拿到的token可用不可用
   
另一种
1.添加JwtTokenProvider.java和JwtAuthenticationTwoFilter.java并继承OncePerRequestFilter类
2.启动SpringsecurityjwtApplication.java类
3.浏览器访问http://localhost:18081/swagger-ui.html#
4.在swagger  注册一个用户信息
5.在swagger 调用http://localhost:18081/user/login这个接口登录，Authorization随便填，用户名密码输入正确即可登陆成功，在Response Body下面即可获得token（accessToken对应的值）
6.在swagger 将5拿到的token用来测试接口http://localhost:18081/user/findByUserName，Authorization放token， 接着userName对应输入刚第4步注册的用户名，即可测试token可用不可用
