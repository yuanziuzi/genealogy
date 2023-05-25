package com.tonglu.genealogy.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 全局配置类
 * <p>
 *
 * @author  yuanzi
 * @date    2023-05-16
 */
@Data
@ConfigurationProperties(prefix = "genealogy")
@Component
public class GenealogyConfig {

    /** 项目名称 */
    private String name;

    /** 版本号 */
    private String version;

    /** 文件路径 */
    private String profile;

}
