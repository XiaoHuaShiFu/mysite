package top.xiaohuashifu.learn.jvm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import top.xiaohuashifu.learn.jvm.converter.GenderConverter;

import javax.annotation.PostConstruct;

/**
 * 描述: 添加参数绑定转换器
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-22 18:05
 */
@Configuration
public class BindingConverterConfig {

    @Autowired
    private RequestMappingHandlerAdapter  requestMappingHandlerAdapter;

    @PostConstruct
    public void addBindingConverter() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        if (initializer != null && initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new GenderConverter());
        }
    }

}
