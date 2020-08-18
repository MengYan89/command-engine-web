package net.irregularhaguruma.engine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StConfig {
    @Value("${st.key}")
    private String key;
    @Value("${st.r18}")
    private String r18;
    @Value("${st.size1200}")
    private String size1200;

    public String getKey() {
        return key;
    }

    public String getR18() {
        return r18;
    }

    public String getSize1200() {
        return size1200;
    }

    public String isR18() {
        return "apikey="+key
                +"&size1200="+size1200;
    }
    @Override
    public String toString() {
        return "apikey="+key
                +"&r18="+r18
                +"&size1200="+size1200;
    }
}
