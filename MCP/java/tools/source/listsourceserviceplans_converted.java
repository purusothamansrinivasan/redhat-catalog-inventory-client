/**
 * MCP Server function for List ServicePlans for Source
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

class Get_Sources_Id_Service_PlansMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getGet_Sources_Id_Service_PlansHandler(MCPServer.APIConfig config) {
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
        if (args.containsKey("limit")) {
            queryParams.add("limit=" + args.get("limit"));
        }
        if (args.containsKey("offset")) {
            queryParams.add("offset=" + args.get("offset"));
        }
        if (args.containsKey("filter")) {
            queryParams.add("filter=" + args.get("filter"));
        }
        if (args.containsKey("sort_by")) {
            queryParams.add("sort_by=" + args.get("sort_by"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/get_sources_id_service_plans" + queryString;
                
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
    
    public static MCPServer.Tool createGet_Sources_Id_Service_PlansTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> idProperty = new HashMap<>();
        idProperty.put("type", "string");
        idProperty.put("required", true);
        idProperty.put("description", "ID of the resource");
        properties.put("id", idProperty);
        Map<String, Object> limitProperty = new HashMap<>();
        limitProperty.put("type", "string");
        limitProperty.put("required", false);
        limitProperty.put("description", "The numbers of items to return per page.");
        properties.put("limit", limitProperty);
        Map<String, Object> offsetProperty = new HashMap<>();
        offsetProperty.put("type", "string");
        offsetProperty.put("required", false);
        offsetProperty.put("description", "The number of items to skip before starting to collect the result set.");
        properties.put("offset", offsetProperty);
        Map<String, Object> filterProperty = new HashMap<>();
        filterProperty.put("type", "string");
        filterProperty.put("required", false);
        filterProperty.put("description", "Filter for querying collections.");
        properties.put("filter", filterProperty);
        Map<String, Object> sort_byProperty = new HashMap<>();
        sort_byProperty.put("type", "string");
        sort_byProperty.put("required", false);
        sort_byProperty.put("description", "The list of attribute and order to sort the result set by.");
        properties.put("sort_by", sort_byProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "get_sources_id_service_plans",
            "List ServicePlans for Source",
            parameters
        );
        
        return new MCPServer.Tool(definition, getGet_Sources_Id_Service_PlansHandler(config));
    }
    
}