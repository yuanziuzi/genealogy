package com.tonglu.genealogy.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * <p>
 * Swagger3配置类
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-25
 */
@EnableOpenApi
@Configuration
public class Swagger3Config {

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.project-url}")
    private String projectUrl;

    @Value("${swagger.author}")
    private String author;

    @Value("${swagger.author-blog}")
    private String authorBlog;

    @Value("${swagger.author-email}")
    private String authorEmail;

    @Value("${swagger.licence}")
    private String licence = "-";

    @Value("${swagger.licence-url}")
    private String licenceUrl = "-";

    /**
     * 配置Swagger的Docket的bean实例
     *
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {
        //设置要配置的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .apiInfo(apiInfo());
    }

    /**
     * 配置Swagger信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                title,
                description,
                version,
                projectUrl,
                new Contact(author, authorBlog, authorEmail),
                licence,
                licenceUrl,
                new ArrayList<VendorExtension>());
    }

}
