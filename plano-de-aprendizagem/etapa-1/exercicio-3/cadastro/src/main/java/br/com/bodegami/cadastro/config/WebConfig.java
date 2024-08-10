package br.com.bodegami.cadastro.config;

import br.com.bodegami.cadastro.utils.exception.interceptor.MdcInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MdcInterceptor mdcInteceptor;

    public WebConfig(MdcInterceptor mdcInteceptor) {
        this.mdcInteceptor = mdcInteceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcInteceptor);
    }
}
