package com.yu.client;

/*
    使用RESTTemplate向Spring提供的服务发送请求（详见README.md）
    返回JSON数据格式为{type:xxx, value:{id:xxx, quote:xxx}}
    与domain包中对应
 */

import com.yu.domain.Hello;
import com.yu.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {
    private static final Logger log = LoggerFactory.getLogger(ClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    //RestTemplate用于发送REST请求，会自动封装对应的信息
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    //CommandLineRunner用于容器启动成功后的回调，可以用于初始化参数等
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
        return args -> {
//            //向Spring提供的服务获取请求
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
            log.info(quote.toString());
            //向hello项目获取请求
//            Hello hello = restTemplate.getForObject(
//                    "http://localhost:8081/greeting",Hello.class); //使用对应实体类接收RestTemplate的返回内容
//            log.info(hello.toString()); //把结果打印在日志里
        };
    }

}
