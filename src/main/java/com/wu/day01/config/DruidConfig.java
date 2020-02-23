package com.wu.day01.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return  new DruidDataSource();
    }

    //配置 阿里Druid 数据源的监控

    /**
     * 配置后台的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean= new ServletRegistrationBean(new StatViewServlet(),"/drud/");
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("loginUsername","admin");
        hashMap.put("loginPassword","123456");
        bean.setInitParameters(hashMap);
        return bean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.addUrlPatterns("/*");
        return bean;
    }
}
