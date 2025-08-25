/**
 * MCP Server function for Perform a GraphQL Query
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.function.Function;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

class Post_GraphqlMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_GraphqlHandler(MCPServer.APIConfig config) {
        return (request) -> {
            try {
                Map<String, Object> args = request.getArguments();
                if (args == null) {
                    return new MCPServer.MCPToolResult("Invalid arguments object", true);
                }
                
                List<String> queryParams = new ArrayList<>();
        if (args.containsKey("operationName")) {
            queryParams.add("operationName=" + args.get("operationName"));
        }
        if (args.containsKey("query")) {
            queryParams.add("query=" + args.get("query"));
        }
        if (args.containsKey("variables")) {
            queryParams.add("variables=" + args.get("variables"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_graphql" + queryString;
                
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + config.getApiKey())
                    .header("Accept", "application/json")
                    .GET()
                    .build();
                
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                
                if (response.statusCode() >= 400) {
                    return new MCPServer.MCPToolResult("API error: " + response.body(), true);
                }
                
                // Pretty print JSON
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.body());
                String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
                
                return new MCPServer.MCPToolResult(prettyJson);
                
            } catch (IOException | InterruptedException e) {
                return new MCPServer.MCPToolResult("Request failed: " + e.getMessage(), true);
            } catch (Exception e) {
                return new MCPServer.MCPToolResult("Unexpected error: " + e.getMessage(), true);
            }
        };
    }
    
    public static MCPServer.Tool createPost_GraphqlTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> operationNameProperty = new HashMap<>();
        operationNameProperty.put("type", "string");
        operationNameProperty.put("required", false);
        operationNameProperty.put("description", "Input parameter: If the Query contains several named operations, the operationName controls which one should be executed");
        properties.put("operationName", operationNameProperty);
        Map<String, Object> queryProperty = new HashMap<>();
        queryProperty.put("type", "string");
        queryProperty.put("required", true);
        queryProperty.put("description", "Input parameter: The GraphQL query");
        properties.put("query", queryProperty);
        Map<String, Object> variablesProperty = new HashMap<>();
        variablesProperty.put("type", "string");
        variablesProperty.put("required", false);
        variablesProperty.put("description", "Input parameter: Optional Query variables");
        properties.put("variables", variablesProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_graphql",
            "Perform a GraphQL Query",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_GraphqlHandler(config));
    }
    
}