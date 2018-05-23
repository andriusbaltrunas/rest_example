import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by andriusbaltrunas on 5/23/2018.
 */
@ApplicationPath("/rest")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){
        packages("rest");
    }
}
