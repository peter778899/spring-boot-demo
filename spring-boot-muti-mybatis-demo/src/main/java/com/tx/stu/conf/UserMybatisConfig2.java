package com.tx.stu.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by peter.
 */
@Configuration
@MapperScan(basePackages = {"com.tx.stu.interfaces2"}, sqlSessionTemplateRef = "userSqlSessionTemplate2",
        sqlSessionFactoryRef = "userSqlSessionFactory2")
public class UserMybatisConfig2 {

    @Primary
    @Bean(name = "userDataProperties2")
    @Qualifier("userDataProperties2")
    @ConfigurationProperties(prefix = "spring.datasource.ads")
    public DataSourceProperties userDataProperties2(){
        return new DataSourceProperties();
    }

    @Bean(name = "adsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ads") // prefix值必须是application.properteis中对应属性的前缀
    public DataSource userDataSource2() {
        return userDataProperties2().initializeDataSourceBuilder().build();
    }

    @Bean
    public SqlSessionFactory userSqlSessionFactory2(@Qualifier("adsDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath*:com/tx/stu/interfaces2/mapping/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate userSqlSessionTemplate2(@Qualifier("userSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
