package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String PORT = null;
    String MEMORY_LIMIT = null;
    String CF_INSTANCE_INDEX = null;
    String CF_INSTANCE_ADDR = null;

    public EnvController(
                            @Value("${port:NOT SET}") String setPort,
                            @Value("${memory_limit:NOT SET}") String setMemLmt,
                            @Value("${cf.instance.index:NOT SET}") String setCfInstanceIndex,
                            @Value("${cf.instance.addr:NOT SET}") String setCfInstanceAddr
    ) {
        this.PORT = setPort;

        this.MEMORY_LIMIT = setMemLmt;
        this.CF_INSTANCE_INDEX = setCfInstanceIndex;
        this.CF_INSTANCE_ADDR =setCfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap();
        env.put("PORT",PORT);
        env.put("MEMORY_LIMIT",MEMORY_LIMIT);
        env.put("CF_INSTANCE_INDEX",CF_INSTANCE_INDEX);
        env.put("CF_INSTANCE_ADDR",CF_INSTANCE_ADDR);
        return env;
    }
}
