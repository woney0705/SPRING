package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//basePackages = "hello.core.mamber",
//basePackageClasses = AutoAppConfig.class,
//미지정 시 package부터 시작
@Configuration
@ComponentScan(
        
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

