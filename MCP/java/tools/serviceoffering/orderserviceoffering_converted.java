/**
 * MCP Server function for Order an existing ServiceOffering
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

class Post_Service_Offerings_Id_OrderMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_Service_Offerings_Id_OrderHandler(MCPServer.APIConfig config) {
        return (request) -> {
            try {
                Map<String, Object> args = request.getArguments();
                if (args == null) {
                    return new MCPServer.MCPToolResult("Invalid arguments object", true);
                }
                
                List<String> queryParams = new ArrayList<>();
        if (args.containsKey("id")) {
            queryParams.add("id=" + args.get("id"));
        }
        if (args.containsKey("service_plan_id")) {
            queryParams.add("service_plan_id=" + args.get("service_plan_id"));
        }
        if (args.containsKey("provider_control_parameters")) {
            queryParams.add("provider_control_parameters=" + args.get("provider_control_parameters"));
        }
        if (args.containsKey("service_parameters")) {
            queryParams.add("service_parameters=" + args.get("service_parameters"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_service_offerings_id_order" + queryString;
                
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
    
    public static MCPServer.Tool createPost_Service_Offerings_Id_OrderTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> idProperty = new HashMap<>();
        idProperty.put("type", "string");
        idProperty.put("required", true);
        idProperty.put("description", "ID of the resource");
        properties.put("id", idProperty);
        Map<String, Object> service_plan_idProperty = new HashMap<>();
        service_plan_idProperty.put("type", "string");
        service_plan_idProperty.put("required", false);
        service_plan_idProperty.put("description", "Input parameter: ID of the resource");
        properties.put("service_plan_id", service_plan_idProperty);
        Map<String, Object> provider_control_parametersProperty = new HashMap<>();
        provider_control_parametersProperty.put("type", "string");
        provider_control_parametersProperty.put("required", false);
        provider_control_parametersProperty.put("description", "Input parameter: The provider specific parameters needed to provision this service. This might include namespaces, special keys");
        properties.put("provider_control_parameters", provider_control_parametersProperty);
        Map<String, Object> service_parametersProperty = new HashMap<>();
        service_parametersProperty.put("type", "string");
        service_parametersProperty.put("required", false);
        service_parametersProperty.put("description", "Input parameter: JSON object with provisioning parameters");
        properties.put("service_parameters", service_parametersProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_service_offerings_id_order",
            "Order an existing ServiceOffering",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_Service_Offerings_Id_OrderHandler(config));
    }
    
}