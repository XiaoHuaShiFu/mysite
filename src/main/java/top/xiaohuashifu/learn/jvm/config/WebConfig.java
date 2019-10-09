package top.xiaohuashifu.learn.jvm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import top.xiaohuashifu.learn.jvm.interceptor.TestInterceptor;

import java.util.Locale;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 14:44
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private LocaleChangeInterceptor lci = null;

    @Bean(name = "localeResolver")
    public LocaleResolver initLocaleResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认国际化区域
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        if (lci != null) {
            return lci;
        }

        lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new TestInterceptor());
        interceptorRegistration.addPathPatterns("/mvc/*");
    }
}
