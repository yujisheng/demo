package com.yjs.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.yjs.utils.DataSourceNames;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("masterDataSource") DataSource firstDataSource, @Qualifier("slaveDataSource") DataSource secondDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.Master, firstDataSource);
        targetDataSources.put(DataSourceNames.SLAVE, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }

   /* @Bean
    public DynamicDataSource dyDataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<String, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceNames.Master, masterDataSource);
        targetDataSource.put(DataSourceNames.SLAVE, slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSource);
    }*/
    /*@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dyDataSource(masterDataSource(), slaveDataSource()));
    }*/

    /*public AbstractRoutingDataSource routingDataSource(){

    }*/
}
