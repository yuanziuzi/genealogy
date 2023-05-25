package com.tonglu.genealogy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Profiles;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 * 启动类
 * <p>
 *
 * @author yuanzi
 * @date 2023-05-09
 */
@Slf4j
@SpringBootApplication
public class GenealogyApplication {

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication.run(GenealogyApplication.class, args).getEnvironment();
        logApplicationStartup(environment);
    }

    /**
     * 完善启动日志信息
     *
     * @param environment 环境
     */
    private static void logApplicationStartup(ConfigurableEnvironment environment) {
        String protocol = "http";
        String hostAddress = "127.0.0.1";
        String applicationName = environment.getProperty("spring.application.name");
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String[] profiles = environment.getActiveProfiles();

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        Profiles activeProfiles = Profiles.of("dev", "test");
        boolean swagger = environment.acceptsProfiles(activeProfiles);
        String swaggerUrl = "";
        if (swagger) {
            swaggerUrl = "Swagger: \t" + protocol + "://" + hostAddress + ":" + serverPort + contextPath + "swagger-ui/ " + "\n\t";
        }

        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "{}" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                applicationName,
                protocol, serverPort, contextPath,
                protocol, hostAddress, serverPort, contextPath,
                swaggerUrl,
                profiles);
    }


}
