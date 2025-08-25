/**
 * Main MCP Server - Handles MCP JSON-RPC protocol
 */

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

// Import Get_Sources_IdMCPTool - included in same package
// Import Get_Sources_Id_Service_InstancesMCPTool - included in same package
// Import Patch_Sources_Id_Incremental_RefreshMCPTool - included in same package
// Import Get_Sources_Id_Service_PlansMCPTool - included in same package
// Import Get_Sources_Id_TasksMCPTool - included in same package
// Import Get_SourcesMCPTool - included in same package
// Import Get_Sources_Id_Service_InventoriesMCPTool - included in same package
// Import Get_Sources_Id_Service_Offering_NodesMCPTool - included in same package
// Import Get_Sources_Id_Service_OfferingsMCPTool - included in same package
// Import Patch_Sources_Id_RefreshMCPTool - included in same package
// Import Get_TagsMCPTool - included in same package
// Import Post_GraphqlMCPTool - included in same package
// Import Get_Service_Offering_Nodes_IdMCPTool - included in same package
// Import Get_Service_Offering_NodesMCPTool - included in same package
// Import Get_Service_Inventories_IdMCPTool - included in same package
// Import Post_Service_Inventories_Id_UntagMCPTool - included in same package
// Import Get_Service_InventoriesMCPTool - included in same package
// Import Get_Service_Inventories_Id_TagsMCPTool - included in same package
// Import Post_Service_Inventories_Id_TagMCPTool - included in same package
// Import Get_Service_Credentials_IdMCPTool - included in same package
// Import Get_Service_CredentialsMCPTool - included in same package
// Import Get_Service_Credential_TypesMCPTool - included in same package
// Import Get_Service_Credential_Types_IdMCPTool - included in same package
// Import Patch_Tasks_IdMCPTool - included in same package
// Import Get_Tasks_IdMCPTool - included in same package
// Import Get_TasksMCPTool - included in same package
// Import Get_Service_Offerings_Id_Service_InstancesMCPTool - included in same package
// Import Post_Service_Offerings_Id_OrderMCPTool - included in same package
// Import Get_Service_Offerings_Id_Service_PlansMCPTool - included in same package
// Import Get_Service_Offerings_Id_Service_Offering_NodesMCPTool - included in same package
// Import Post_Service_Offerings_Id_Applied_Inventories_TagsMCPTool - included in same package
// Import Get_Service_OfferingsMCPTool - included in same package
// Import Get_Service_Offerings_IdMCPTool - included in same package
// Import Get_Service_InstancesMCPTool - included in same package
// Import Get_Service_Instances_IdMCPTool - included in same package
// Import Get_Service_Plans_IdMCPTool - included in same package
// Import Get_Service_PlansMCPTool - included in same package
// Import Get_Openapi_JsonMCPTool - included in same package

public class MCPServer {
    
    // Common classes that all tool classes use
    public static class APIConfig {
        private final String baseUrl;
        private final String apiKey;
        
        public APIConfig(String baseUrl, String apiKey) {
            this.baseUrl = baseUrl;
            this.apiKey = apiKey;
        }
        
        public String getBaseUrl() { return baseUrl; }
        public String getApiKey() { return apiKey; }
    }
    
    public static class MCPRequest {
        private Map<String, Object> params;
        
        public Map<String, Object> getParams() { return params; }
        public void setParams(Map<String, Object> params) { this.params = params; }
        
        @SuppressWarnings("unchecked")
        public Map<String, Object> getArguments() {
            if (params != null && params.containsKey("arguments")) {
                return (Map<String, Object>) params.get("arguments");
            }
            return new HashMap<>();
        }
    }
    
    public static class MCPToolResult {
        private final String content;
        private final boolean isError;
        
        public MCPToolResult(String content, boolean isError) {
            this.content = content;
            this.isError = isError;
        }
        
        public MCPToolResult(String content) {
            this(content, false);
        }
        
        public String getContent() { return content; }
        public boolean isError() { return isError; }
    }
    
    public static class ToolDefinition {
        private final String name;
        private final String description;
        private final Map<String, Object> parameters;
        
        public ToolDefinition(String name, String description, Map<String, Object> parameters) {
            this.name = name;
            this.description = description;
            this.parameters = parameters;
        }
        
        public String getName() { return name; }
        public String getDescription() { return description; }
        public Map<String, Object> getParameters() { return parameters; }
    }
    
    public static class Tool {
        private final ToolDefinition definition;
        private final Function<MCPRequest, MCPToolResult> handler;
        
        public Tool(ToolDefinition definition, Function<MCPRequest, MCPToolResult> handler) {
            this.definition = definition;
            this.handler = handler;
        }
        
        public ToolDefinition getDefinition() { return definition; }
        public Function<MCPRequest, MCPToolResult> getHandler() { return handler; }
    }
    
    private static final ObjectMapper mapper = new ObjectMapper();
    private static List<Tool> tools = new ArrayList<>();
    private static APIConfig config;
    
    public static void main(String[] args) {
        try {
            // Initialize configuration
            String baseUrl = System.getenv("API_BASE_URL");
            String apiKey = System.getenv("API_KEY");
            
            if (baseUrl == null || apiKey == null) {
                System.err.println("Error: Please set API_BASE_URL and API_KEY environment variables");
                System.exit(1);
            }
            
            config = new APIConfig(baseUrl, apiKey);
            
            // Register all tools
            tools = Arrays.asList(
            Get_Sources_IdMCPTool.createGet_Sources_IdTool(config),
            Get_Sources_Id_Service_InstancesMCPTool.createGet_Sources_Id_Service_InstancesTool(config),
            Patch_Sources_Id_Incremental_RefreshMCPTool.createPatch_Sources_Id_Incremental_RefreshTool(config),
            Get_Sources_Id_Service_PlansMCPTool.createGet_Sources_Id_Service_PlansTool(config),
            Get_Sources_Id_TasksMCPTool.createGet_Sources_Id_TasksTool(config),
            Get_SourcesMCPTool.createGet_SourcesTool(config),
            Get_Sources_Id_Service_InventoriesMCPTool.createGet_Sources_Id_Service_InventoriesTool(config),
            Get_Sources_Id_Service_Offering_NodesMCPTool.createGet_Sources_Id_Service_Offering_NodesTool(config),
            Get_Sources_Id_Service_OfferingsMCPTool.createGet_Sources_Id_Service_OfferingsTool(config),
            Patch_Sources_Id_RefreshMCPTool.createPatch_Sources_Id_RefreshTool(config),
            Get_TagsMCPTool.createGet_TagsTool(config),
            Post_GraphqlMCPTool.createPost_GraphqlTool(config),
            Get_Service_Offering_Nodes_IdMCPTool.createGet_Service_Offering_Nodes_IdTool(config),
            Get_Service_Offering_NodesMCPTool.createGet_Service_Offering_NodesTool(config),
            Get_Service_Inventories_IdMCPTool.createGet_Service_Inventories_IdTool(config),
            Post_Service_Inventories_Id_UntagMCPTool.createPost_Service_Inventories_Id_UntagTool(config),
            Get_Service_InventoriesMCPTool.createGet_Service_InventoriesTool(config),
            Get_Service_Inventories_Id_TagsMCPTool.createGet_Service_Inventories_Id_TagsTool(config),
            Post_Service_Inventories_Id_TagMCPTool.createPost_Service_Inventories_Id_TagTool(config),
            Get_Service_Credentials_IdMCPTool.createGet_Service_Credentials_IdTool(config),
            Get_Service_CredentialsMCPTool.createGet_Service_CredentialsTool(config),
            Get_Service_Credential_TypesMCPTool.createGet_Service_Credential_TypesTool(config),
            Get_Service_Credential_Types_IdMCPTool.createGet_Service_Credential_Types_IdTool(config),
            Patch_Tasks_IdMCPTool.createPatch_Tasks_IdTool(config),
            Get_Tasks_IdMCPTool.createGet_Tasks_IdTool(config),
            Get_TasksMCPTool.createGet_TasksTool(config),
            Get_Service_Offerings_Id_Service_InstancesMCPTool.createGet_Service_Offerings_Id_Service_InstancesTool(config),
            Post_Service_Offerings_Id_OrderMCPTool.createPost_Service_Offerings_Id_OrderTool(config),
            Get_Service_Offerings_Id_Service_PlansMCPTool.createGet_Service_Offerings_Id_Service_PlansTool(config),
            Get_Service_Offerings_Id_Service_Offering_NodesMCPTool.createGet_Service_Offerings_Id_Service_Offering_NodesTool(config),
            Post_Service_Offerings_Id_Applied_Inventories_TagsMCPTool.createPost_Service_Offerings_Id_Applied_Inventories_TagsTool(config),
            Get_Service_OfferingsMCPTool.createGet_Service_OfferingsTool(config),
            Get_Service_Offerings_IdMCPTool.createGet_Service_Offerings_IdTool(config),
            Get_Service_InstancesMCPTool.createGet_Service_InstancesTool(config),
            Get_Service_Instances_IdMCPTool.createGet_Service_Instances_IdTool(config),
            Get_Service_Plans_IdMCPTool.createGet_Service_Plans_IdTool(config),
            Get_Service_PlansMCPTool.createGet_Service_PlansTool(config),
            Get_Openapi_JsonMCPTool.createGet_Openapi_JsonTool(config)
            );
            
            System.err.println("MCP Server started with " + tools.size() + " tools");
            
            // Start JSON-RPC server
            runServer();
            
        } catch (Exception e) {
            System.err.println("Failed to start MCP server: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void runServer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = reader.readLine()) != null) {
            JsonNode request = null;
            try {
                request = mapper.readTree(line);
                JsonNode response = handleRequest(request);
                
                if (response != null) {
                    System.out.println(mapper.writeValueAsString(response));
                }
                
            } catch (Exception e) {
                // Send error response
                ObjectNode errorResponse = mapper.createObjectNode();
                errorResponse.put("jsonrpc", "2.0");
                if (request != null && request.has("id")) {
                    errorResponse.put("id", request.get("id").asText());
                } else {
                    errorResponse.putNull("id");
                }
                
                ObjectNode error = mapper.createObjectNode();
                error.put("code", -32603);
                error.put("message", "Internal error: " + e.getMessage());
                errorResponse.set("error", error);
                
                System.out.println(mapper.writeValueAsString(errorResponse));
            }
        }
    }
    
    private static JsonNode handleRequest(JsonNode request) {
        if (!request.has("method")) {
            return createErrorResponse(request, -32600, "Invalid Request");
        }
        
        String method = request.get("method").asText();
        JsonNode params = request.get("params");
        String id = request.has("id") ? request.get("id").asText() : null;
        
        switch (method) {
            case "initialize":
                return handleInitialize(id);
            case "tools/list":
                return handleToolsList(id);
            case "tools/call":
                return handleToolsCall(id, params);
            default:
                return createErrorResponse(request, -32601, "Method not found");
        }
    }
    
    private static JsonNode handleInitialize(String id) {
        ObjectNode response = mapper.createObjectNode();
        response.put("jsonrpc", "2.0");
        response.put("id", id);
        
        ObjectNode result = mapper.createObjectNode();
        result.put("protocolVersion", "2024-11-05");
        
        ObjectNode capabilities = mapper.createObjectNode();
        ObjectNode toolsCapability = mapper.createObjectNode();
        toolsCapability.put("listChanged", false);
        capabilities.set("tools", toolsCapability);
        result.set("capabilities", capabilities);
        
        ObjectNode serverInfo = mapper.createObjectNode();
        serverInfo.put("name", "Opsera MCP Server");
        serverInfo.put("version", "1.0.0");
        result.set("serverInfo", serverInfo);
        
        response.set("result", result);
        return response;
    }
    
    private static JsonNode handleToolsList(String id) {
        ObjectNode response = mapper.createObjectNode();
        response.put("jsonrpc", "2.0");
        response.put("id", id);
        
        ObjectNode result = mapper.createObjectNode();
        ArrayNode toolsArray = mapper.createArrayNode();
        
        for (Tool tool : tools) {
            ObjectNode toolDef = mapper.createObjectNode();
            toolDef.put("name", tool.getDefinition().getName());
            toolDef.put("description", tool.getDefinition().getDescription());
            
            // Convert parameters to JSON
            ObjectNode inputSchema = mapper.valueToTree(tool.getDefinition().getParameters());
            toolDef.set("inputSchema", inputSchema);
            
            toolsArray.add(toolDef);
        }
        
        result.set("tools", toolsArray);
        response.set("result", result);
        return response;
    }
    
    private static JsonNode handleToolsCall(String id, JsonNode params) {
        if (!params.has("name")) {
            return createErrorResponse(null, -32602, "Invalid params: missing 'name'");
        }
        
        String toolName = params.get("name").asText();
        JsonNode arguments = params.has("arguments") ? params.get("arguments") : mapper.createObjectNode();
        
        // Find the tool
        Tool tool = null;
        for (Tool t : tools) {
            if (t.getDefinition().getName().equals(toolName)) {
                tool = t;
                break;
            }
        }
        
        if (tool == null) {
            return createErrorResponse(null, -32602, "Tool not found: " + toolName);
        }
        
        try {
            // Convert arguments to Map
            Map<String, Object> argsMap = mapper.convertValue(arguments, Map.class);
            
            // Create MCP request
            MCPRequest mcpRequest = new MCPRequest();
            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("arguments", argsMap);
            mcpRequest.setParams(requestParams);
            
            // Execute tool
            MCPToolResult result = tool.getHandler().apply(mcpRequest);
            
            // Create response
            ObjectNode response = mapper.createObjectNode();
            response.put("jsonrpc", "2.0");
            response.put("id", id);
            
            ObjectNode resultObj = mapper.createObjectNode();
            ArrayNode content = mapper.createArrayNode();
            
            ObjectNode textContent = mapper.createObjectNode();
            textContent.put("type", "text");
            textContent.put("text", result.getContent());
            content.add(textContent);
            
            resultObj.set("content", content);
            resultObj.put("isError", result.isError());
            
            response.set("result", resultObj);
            return response;
            
        } catch (Exception e) {
            return createErrorResponse(null, -32603, "Tool execution failed: " + e.getMessage());
        }
    }
    
    private static JsonNode createErrorResponse(JsonNode request, int code, String message) {
        ObjectNode response = mapper.createObjectNode();
        response.put("jsonrpc", "2.0");
        response.put("id", request != null && request.has("id") ? request.get("id").asText() : null);
        
        ObjectNode error = mapper.createObjectNode();
        error.put("code", code);
        error.put("message", message);
        response.set("error", error);
        
        return response;
    }
}