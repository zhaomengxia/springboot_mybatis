# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Security](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-security)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

本项目中
springcloud 是微服务注册中心实例，启动SpringcloudApplication类，在浏览器访问 http://localhost:8760/

producer是 微服务服务提供者实例 ，启动ProducerApplication类

consumer是微服务消费者实例，启动CustomerApplication类，在浏览器访问http://localhost:8763/hello?name=meng，这里引入了Spring Cloud断路器，之后可以关闭上诉producer启动类，再在浏览器访问http://localhost:8763/hello?name=meng既可验证
具体实现的详细信息可以访问（https://blog.csdn.net/zhaomengxia123/article/details/100106930）

feign是另一种使用断路器的实例，启动FeignApplication类，在浏览器访问http://localhost:8764/sayHello?name=xia，接着关闭关闭上诉producer启动类，再在浏览器访问http://localhost:8764/sayHello?name=xia
具体实现的详细信息可以访问（https://blog.csdn.net/zhaomengxia123/article/details/100113426）





