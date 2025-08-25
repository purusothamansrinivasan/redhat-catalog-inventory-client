/**
 * MCP Server function for Update an existing Task
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

class Patch_Tasks_IdMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPatch_Tasks_IdHandler(MCPServer.APIConfig config) {
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
        if (args.containsKey("completed_at")) {
            queryParams.add("completed_at=" + args.get("completed_at"));
        }
        if (args.containsKey("message")) {
            queryParams.add("message=" + args.get("message"));
        }
        if (args.containsKey("controller_message_id")) {
            queryParams.add("controller_message_id=" + args.get("controller_message_id"));
        }
        if (args.containsKey("target_source_ref")) {
            queryParams.add("target_source_ref=" + args.get("target_source_ref"));
        }
        if (args.containsKey("updated_at")) {
            queryParams.add("updated_at=" + args.get("updated_at"));
        }
        if (args.containsKey("child_task_id")) {
            queryParams.add("child_task_id=" + args.get("child_task_id"));
        }
        if (args.containsKey("created_at")) {
            queryParams.add("created_at=" + args.get("created_at"));
        }
        if (args.containsKey("state")) {
            queryParams.add("state=" + args.get("state"));
        }
        if (args.containsKey("target_type")) {
            queryParams.add("target_type=" + args.get("target_type"));
        }
        if (args.containsKey("owner")) {
            queryParams.add("owner=" + args.get("owner"));
        }
        if (args.containsKey("status")) {
            queryParams.add("status=" + args.get("status"));
        }
        if (args.containsKey("name")) {
            queryParams.add("name=" + args.get("name"));
        }
        if (args.containsKey("archived_at")) {
            queryParams.add("archived_at=" + args.get("archived_at"));
        }
        if (args.containsKey("source_id")) {
            queryParams.add("source_id=" + args.get("source_id"));
        }
        if (args.containsKey("type")) {
            queryParams.add("type=" + args.get("type"));
        }
        if (args.containsKey("output")) {
            queryParams.add("output=" + args.get("output"));
        }
        if (args.containsKey("input")) {
            queryParams.add("input=" + args.get("input"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/patch_tasks_id" + queryString;
                
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
    
    public static MCPServer.Tool createPatch_Tasks_IdTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> idProperty = new HashMap<>();
        idProperty.put("type", "string");
        idProperty.put("required", true);
        idProperty.put("description", "UUID of task");
        properties.put("id", idProperty);
        Map<String, Object> completed_atProperty = new HashMap<>();
        completed_atProperty.put("type", "string");
        completed_atProperty.put("required", false);
        completed_atProperty.put("description", "");
        properties.put("completed_at", completed_atProperty);
        Map<String, Object> messageProperty = new HashMap<>();
        messageProperty.put("type", "string");
        messageProperty.put("required", false);
        messageProperty.put("description", "");
        properties.put("message", messageProperty);
        Map<String, Object> controller_message_idProperty = new HashMap<>();
        controller_message_idProperty.put("type", "string");
        controller_message_idProperty.put("required", false);
        controller_message_idProperty.put("description", "");
        properties.put("controller_message_id", controller_message_idProperty);
        Map<String, Object> target_source_refProperty = new HashMap<>();
        target_source_refProperty.put("type", "string");
        target_source_refProperty.put("required", false);
        target_source_refProperty.put("description", "");
        properties.put("target_source_ref", target_source_refProperty);
        Map<String, Object> updated_atProperty = new HashMap<>();
        updated_atProperty.put("type", "string");
        updated_atProperty.put("required", false);
        updated_atProperty.put("description", "");
        properties.put("updated_at", updated_atProperty);
        Map<String, Object> child_task_idProperty = new HashMap<>();
        child_task_idProperty.put("type", "string");
        child_task_idProperty.put("required", false);
        child_task_idProperty.put("description", "");
        properties.put("child_task_id", child_task_idProperty);
        Map<String, Object> created_atProperty = new HashMap<>();
        created_atProperty.put("type", "string");
        created_atProperty.put("required", false);
        created_atProperty.put("description", "");
        properties.put("created_at", created_atProperty);
        Map<String, Object> stateProperty = new HashMap<>();
        stateProperty.put("type", "string");
        stateProperty.put("required", false);
        stateProperty.put("description", "");
        properties.put("state", stateProperty);
        Map<String, Object> target_typeProperty = new HashMap<>();
        target_typeProperty.put("type", "string");
        target_typeProperty.put("required", false);
        target_typeProperty.put("description", "");
        properties.put("target_type", target_typeProperty);
        Map<String, Object> ownerProperty = new HashMap<>();
        ownerProperty.put("type", "string");
        ownerProperty.put("required", false);
        ownerProperty.put("description", "");
        properties.put("owner", ownerProperty);
        Map<String, Object> statusProperty = new HashMap<>();
        statusProperty.put("type", "string");
        statusProperty.put("required", false);
        statusProperty.put("description", "");
        properties.put("status", statusProperty);
        Map<String, Object> nameProperty = new HashMap<>();
        nameProperty.put("type", "string");
        nameProperty.put("required", false);
        nameProperty.put("description", "");
        properties.put("name", nameProperty);
        Map<String, Object> archived_atProperty = new HashMap<>();
        archived_atProperty.put("type", "string");
        archived_atProperty.put("required", false);
        archived_atProperty.put("description", "");
        properties.put("archived_at", archived_atProperty);
        Map<String, Object> source_idProperty = new HashMap<>();
        source_idProperty.put("type", "string");
        source_idProperty.put("required", false);
        source_idProperty.put("description", "Input parameter: ID of the resource");
        properties.put("source_id", source_idProperty);
        Map<String, Object> typeProperty = new HashMap<>();
        typeProperty.put("type", "string");
        typeProperty.put("required", false);
        typeProperty.put("description", "");
        properties.put("type", typeProperty);
        Map<String, Object> outputProperty = new HashMap<>();
        outputProperty.put("type", "string");
        outputProperty.put("required", false);
        outputProperty.put("description", "");
        properties.put("output", outputProperty);
        Map<String, Object> inputProperty = new HashMap<>();
        inputProperty.put("type", "string");
        inputProperty.put("required", false);
        inputProperty.put("description", "");
        properties.put("input", inputProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "patch_tasks_id",
            "Update an existing Task",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPatch_Tasks_IdHandler(config));
    }
    
}