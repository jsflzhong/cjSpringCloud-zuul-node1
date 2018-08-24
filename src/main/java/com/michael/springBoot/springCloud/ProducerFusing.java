package com.michael.springBoot.springCloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jsflz on 2018/7/28.
 * 针对:SPRING-CLOUD-PRODUCER服务的zuul熔断器
 *
 * @author cj
 */
@Component
public class ProducerFusing implements FallbackProvider {

    Logger logger = LoggerFactory.getLogger(ProducerFusing.class);

    /**
     * 指定本熔断器要处理eureka中的哪个service
     * service的名字要对应目标service provider在eureka中的注册名
     *
     * @return 服务名
     * @author cj
     */
    @Override
    public String getRoute() {
        return "spring-cloud-producer";
    }

    /**
     * 定制返回响应的内容(带异常)
     *
     * @param cause throwable
     * @return 被spring封装好的http响应体
     * @author cj
     */
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        //如果有异常,则记录日志.
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            logger.info("@@@Exception happened in ProducerFusing: {}", reason);
        }
        //然后回不正常的响应信息.表示本次请求的eureka中的目标服务不可用,本次请求被熔断.
        return fallbackResponse();
    }

    /**
     * 定制返回响应的内容(非异常)
     * 该方法会在上面被fallbackResponse()方法所调用
     * 作用:返回不正常的响应信息.表示本次请求的eureka中的目标服务不可用,本次请求被熔断.
     *
     * @return 被spring封装好的http响应体
     * @author cj
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {
                //No need to do anything.
            }

            /**
             * 返回给页面的消息.
             * @return InputStream
             * @throws IOException IOException
             * @author cj
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("@@@The fusing works in zuul," +
                        "the service is unavailable.").getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
