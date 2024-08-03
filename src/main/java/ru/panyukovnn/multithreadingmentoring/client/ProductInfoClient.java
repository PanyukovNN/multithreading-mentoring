package ru.panyukovnn.multithreadingmentoring.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.panyukovnn.multithreadingmentoring.dto.ProductInfo;
import ru.panyukovnn.multithreadingmentoring.util.JsonUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductInfoClient {

    private static final String base64ProductInfo = "ewogICAgImJyYW5kIjogIkFwcGxlIiwKICAgICJuYW1lIjogIklwaG9uZSIsCiAgICAicHJpY2UiOiAiNTAwMDAiCn0=";

    private final JsonUtil jsonUtil;
    private final RestTemplate restTemplate;

    public ProductInfo fetchProductInfo() {
        restTemplate.getForObject("https://httpbin.org/delay/2", String.class);

        log.info("Выполнен запрос с задержкой ProductInfo");

        String rawResponse = restTemplate.getForObject("https://httpbin.org/base64/" + base64ProductInfo, String.class);

        ProductInfo productInfo = jsonUtil.fromJson(rawResponse, ProductInfo.class);

        log.info("Данные продукта получены: {}", productInfo);

        return productInfo;
    }
}
