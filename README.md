> oss-spring-boot-starter  ——  自定义starter项目

> test-oss-spring-boot-starter  ——  测试starter的项目



## 手写一个基于AmazonS3的starter


实现步骤:
1. 先创建一个springboot项目，在pom.xml中引入aws-java-sdk-s3依赖
```xml
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk-s3</artifactId>
    <version>1.12.423</version>
</dependency>
```
2. 在application.properties配置文件中添加oss相关的配置
```properties
oss.endpoint=xxx
oss.accessKey=xxx
oss.secretKey=xxx
```
3. 创建一个映射配置项信息的实体类，主要使用类注解@ConfigurationProperties(prefix = "oss")
4. 创建oss服务接口
5. 创建oss服务接口实现类
6. 最核心的，创建一个自动配置类OssAutoConfiguration，自动装配 AmazonS3，OssTemplate 这些bean。主要使用类注解@Configuration和方法注解@Bean搭配实现
7. 在resources目录下新建一个META-INF文件夹，在文件夹中创建一个spring.factories文件，里面的内容以key=value方式填写，key固定为springboot的EnableAutoConfiguration的类路径，
value为自定义的自动配置类的类路径（如果有多个，以，隔开，或\换行）
8. 编写完之后，在pom.xml中添加：
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <!-- 去掉springboot的打包插件 -->
                <skip>true</skip>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```
9. 然后依次执行 mvven ——> clean ——> compile ——> install，安装完成后，在本地maven仓库中会生成一个jar包文件夹
10. 后面在需要使用该starter的springboot项目中：
- 直接引入starter依赖
- 然后在配置文件中添加相关配置
- 在使用的地方，通过@Autowired注解注入ossTemplate的bean，然后在方法中直接使用即可
