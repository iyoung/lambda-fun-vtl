package example;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

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
    String vtl = "";
    return new Response(greetingString + ", fetched VTL as: " + vtl);
  }
}
