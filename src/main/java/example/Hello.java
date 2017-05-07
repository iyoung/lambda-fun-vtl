package example;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
