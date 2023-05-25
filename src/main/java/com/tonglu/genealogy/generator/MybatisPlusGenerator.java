package com.tonglu.genealogy.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.tonglu.genealogy.common.core.controller.BaseController;
import com.tonglu.genealogy.common.core.entity.BaseEntity;

import java.util.Collections;

/**
 * <p>
 * MybatisPlus代码生成器
 * <p>
 *
 * @author: yuanzi
 * @date: 2023-05-10
 */
public class MybatisPlusGenerator {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/genealogy?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8";
    private static final String USERNAME = "genealogy";
    private static final String PASSWORD = "genealogy";

    // 作者
    private static final String AUTHOR = "yuanzi";

    // 表前缀过滤
    private static final String TABLE_PREFIX = "sys_";

    // 字段后缀过滤
    private static final String TABLE_SUFFIX = "_flag";
    // 设置需要生成的表名，','隔开
    private static final String TABLE_NAMES = "sys_dict_type,sys_dict_data,sys_user";

    /**
     * 项目路径
     * 指定生成代码文件输出路径(绝对路径)
     * 文件生成的最终路径为： 项目路径（绝对路径） + 包名 + 模块名
     */
    private static final String OUT_PUT_DIR = "F:\\code\\genealogy" + "\\src\\main\\java";


    // 模块名
    private static final String MODULE_NAME = "auto";

    // xml文件生成路径
    private static final String XML_FILE_PATH = "F:\\code\\genealogy\\src\\main\\resources\\mapper\\" + MODULE_NAME;

    /**
     * 快速生成
     *
     * @param args
     */
    public static void main(String[] args) {

        // 数据源配置
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(URL, USERNAME, PASSWORD)
                .dbQuery(new MySqlQuery())
                .schema("mybatis-plus")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        FastAutoGenerator.create(dataSourceConfigBuilder)
                // 全局配置
                .globalConfig(builder -> {
                    builder.outputDir(OUT_PUT_DIR)
                            .author(AUTHOR)
                            // 开启swagger 模式
                            .enableSwagger()
                            // 日期类型
                            .dateType(DateType.TIME_PACK)
                            // 注释日期格式化
                            .commentDate("yyyy-MM-dd");
                })
                // 包配置
                .packageConfig(builder -> {
                    // 项目包名
                    builder.parent("com.tonglu.wheel")
                            .moduleName(MODULE_NAME)
                            // 实体包名
                            .entity("entity")
                            // service层包名
                            .service("service")
                            // service实现类包名
                            .serviceImpl("service.impl")
                            // mapper 包名
                            .mapper("mapper")
                            // Mapper XML 包名
                            .xml("mapper.xml")
                            // Controller 包名
                            .controller("controller")
                            // 输出自定义文件时所用到的包名
                            .other("other")
                            // xml 文件输入地址
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_FILE_PATH));
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            // 开启大写命名
                            // .enableCapitalMode()
                            // 开启跳过视图
                            // .enableSkipView()
                            // 禁用 sql 过滤
                            // .disableSqlFilter()
                            // 开启表前缀过滤
                            .addTablePrefix(TABLE_PREFIX)
                            // 开启字段后缀过滤
                            // .addFieldSuffix("_flag")
                            // 增加表匹配(内存过滤)
                            .addInclude(TABLE_NAMES)

                            // controller 策略配置
                            .controllerBuilder()
                            // service 策略配置
                            .serviceBuilder()
                            // mapper 策略配置
                            .mapperBuilder()

                            // 实体策略配置
                            .entityBuilder()
                            //设置父类
                            .superClass(BaseEntity.class)
                            // 禁用生成 serialVersionUID
                            // .disableSerialVersionUID()
                            // 开启链式模型
                            .enableChainModel()
                            // 开启 lombok 模型
                            .enableLombok()
                            // 开启 Boolean 类型字段移除 is 前缀
                            // .enableRemoveIsPrefix()
                            // 开启生成实体时生成字段注解
                            .enableTableFieldAnnotation()
                            // 开启 ActiveRecord 模型
                            // .enableActiveRecord()
                            // 乐观锁字段名(数据库)
                            .versionColumnName("version")
                            // 乐观锁属性名(实体)
                            .versionPropertyName("version")
                            // 逻辑删除字段名(数据库)
                            .logicDeleteColumnName("delete_flag")
                            // 逻辑删除属性名(实体)
                            .logicDeletePropertyName("deleteFlag")
                            // 数据库表映射到实体的命名策略
                            .naming(NamingStrategy.underline_to_camel)
                            // 数据库表字段映射到实体的命名策略
                            .columnNaming(NamingStrategy.underline_to_camel)
                            // 添加父类公共字段
                            .addSuperEntityColumns("create_by", "create_time", "update_by", "update_time", "version", "delete_flag")
                            //添加忽略字段
                            // .addIgnoreColumns("age")
                            //添加表字段填充
                            .addTableFills(new Column("create_by", FieldFill.INSERT))
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("version", FieldFill.INSERT))
                            .addTableFills(new Column("delete_flag", FieldFill.INSERT))

                            .addTableFills(new Property("createBy", FieldFill.INSERT))
                            .addTableFills(new Property("createTime", FieldFill.INSERT))
                            .addTableFills(new Property("version", FieldFill.INSERT))
                            .addTableFills(new Property("deleteFlag", FieldFill.INSERT))

                            .addTableFills(new Property("updateBy", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))

                            .addTableFills(new Column("update_by", FieldFill.INSERT_UPDATE))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            // 全局主键类型
                            .idType(IdType.AUTO)
                            // 格式化文件名称
                            .formatFileName("%s")

                            // controller 策略配置
                            .controllerBuilder()
                            // 设置父类
                            .superClass(BaseController.class)
                            // 开启驼峰转连字符
                            .enableHyphenStyle()
                            // 开启生成@RestController 控制器
                            .enableRestStyle()
                            // 格式化文件名称
                            .formatFileName("%sController")

                            // service 策略配置
                            .serviceBuilder()
                            // 设置 service 接口父类
                            .superServiceClass(IService.class)
                            // 设置 service 实现类父类
                            .superServiceImplClass(ServiceImpl.class)
                            // 格式化 service 接口文件名称
                            .formatServiceFileName("%sService")
                            // 格式化 service 实现类文件名称
                            .formatServiceImplFileName("%sServiceImpl")

                            // mapper 策略配置
                            .mapperBuilder()
                            // 设置父类
                            .superClass(BaseMapper.class)
                            // 开启 @Mapper 注解
                            .enableMapperAnnotation()
                            // 启用 BaseResultMap 生成
                            .enableBaseResultMap()
                            // 启用 BaseColumnList
                            .enableBaseColumnList()
                            // 设置缓存实现类
                            // .cache(MyMapperCache.class)
                            // 格式化 mapper 文件名称
                            .formatMapperFileName("%sMapper")
                            // 格式化 xml 实现类文件名称
                            .formatXmlFileName("%sMapper");
                })
                // 使用Freemarker引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
