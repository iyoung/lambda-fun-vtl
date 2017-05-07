package example;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;

import java.io.StringWriter;

/*
Tested with
{
  "firstName":"value1",
  "lastName" : "value2"
}
*/

public class Hello implements RequestHandler<Request, Response> {

  public Response handleRequest(Request request, Context context) {
    String greetingString = String.format("Hello %s %s.", request.firstName, request.lastName);
    String vtl = "Hello $name!  Welcome to Velocity!";
    VelocityEngine ve = new VelocityEngine();
    ve.init();
    VelocityContext velocityContext = new VelocityContext();
    velocityContext.put("name", request.firstName);
    RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
    Template t = new Template();
    t.setRuntimeServices(runtimeServices);
    t.setData(vtl);
    t.initDocument();
    StringWriter writer = new StringWriter();
    t.merge( velocityContext, writer );
    return new Response(writer.toString());
  }
}
