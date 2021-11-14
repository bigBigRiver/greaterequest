package com.river.web.function.smartrequst;

import com.river.web.function.smartrequst.manager.WebManager;
import com.river.web.function.smartrequst.serivce.UserSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartrequstApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserSerivce userSerivce;

    @Test
    public void testRequest() {
        String param = "{\"webClassList\":[{\"functionList\":[{\"functionName\":\"getUserByName\",\"functionParam\":{\"userName\":\"river\"},\"functionJSONResult\":\"\"},{\"functionName\":\"dealUserInfo\",\"functionParam\":{\"password\":\"xxxxxxxx\",\"userName\":\"river\",\"age\":25},\"functionJSONResult\":\"\"}],\"webClassName\":\"UserServiceImpl\"},{\"functionList\":[{\"functionName\":\"xxxxxx\",\"functionParam\":{\"name\":\"xxxxxx\"}}],\"webClassName\":\"xxxxxx\"}]}";
        System.out.println(WebManager.getWebResult(userSerivce, param));
    }

}
