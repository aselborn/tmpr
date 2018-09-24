package tmpr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/tmp")
@Produces(MediaType.APPLICATION_JSON)
public interface TemprService {

    @GET
    @Path("/ping")
    public PingResponse ping();

    @GET
    @Path("/current")
    public TemperatureResponse currentTemperature();

}
