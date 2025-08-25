package tools

import (
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"bytes"

	"github.com/catalog-inventory/mcp-server/config"
	"github.com/catalog-inventory/mcp-server/models"
	"github.com/mark3labs/mcp-go/mcp"
)

func UpdatetaskHandler(cfg *config.APIConfig) func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
	return func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
		args, ok := request.Params.Arguments.(map[string]any)
		if !ok {
			return mcp.NewToolResultError("Invalid arguments object"), nil
		}
		idVal, ok := args["id"]
		if !ok {
			return mcp.NewToolResultError("Missing required path parameter: id"), nil
		}
		id, ok := idVal.(string)
		if !ok {
			return mcp.NewToolResultError("Invalid path parameter: id"), nil
		}
		// Create properly typed request body using the generated schema
		var requestBody models.Task
		
		// Optimized: Single marshal/unmarshal with JSON tags handling field mapping
		if argsJSON, err := json.Marshal(args); err == nil {
			if err := json.Unmarshal(argsJSON, &requestBody); err != nil {
				return mcp.NewToolResultError(fmt.Sprintf("Failed to convert arguments to request type: %v", err)), nil
			}
		} else {
			return mcp.NewToolResultError(fmt.Sprintf("Failed to marshal arguments: %v", err)), nil
		}
		
		bodyBytes, err := json.Marshal(requestBody)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to encode request body", err), nil
		}
		url := fmt.Sprintf("%s/tasks/%s", cfg.BaseURL, id)
		req, err := http.NewRequest("PATCH", url, bytes.NewBuffer(bodyBytes))
		req.Header.Set("Content-Type", "application/json")
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to create request", err), nil
		}
		// Set authentication based on auth type
		if cfg.BasicAuth != "" {
			req.Header.Set("Authorization", fmt.Sprintf("Basic %s", cfg.BasicAuth))
		}
		req.Header.Set("Accept", "application/json")

		resp, err := http.DefaultClient.Do(req)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Request failed", err), nil
		}
		defer resp.Body.Close()

		body, err := io.ReadAll(resp.Body)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to read response body", err), nil
		}

		if resp.StatusCode >= 400 {
			return mcp.NewToolResultError(fmt.Sprintf("API error: %s", body)), nil
		}
		// Use properly typed response
		var result map[string]interface{}
		if err := json.Unmarshal(body, &result); err != nil {
			// Fallback to raw text if unmarshaling fails
			return mcp.NewToolResultText(string(body)), nil
		}

		prettyJSON, err := json.MarshalIndent(result, "", "  ")
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to format JSON", err), nil
		}

		return mcp.NewToolResultText(string(prettyJSON)), nil
	}
}

func CreateUpdatetaskTool(cfg *config.APIConfig) models.Tool {
	tool := mcp.NewTool("patch_tasks_id",
		mcp.WithDescription("Update an existing Task"),
		mcp.WithString("id", mcp.Required(), mcp.Description("UUID of task")),
		mcp.WithString("completed_at", mcp.Description("")),
		mcp.WithString("message", mcp.Description("")),
		mcp.WithString("id", mcp.Description("Input parameter: UUID of task")),
		mcp.WithObject("output", mcp.Description("")),
		mcp.WithString("controller_message_id", mcp.Description("")),
		mcp.WithString("target_source_ref", mcp.Description("")),
		mcp.WithString("updated_at", mcp.Description("")),
		mcp.WithString("child_task_id", mcp.Description("")),
		mcp.WithString("created_at", mcp.Description("")),
		mcp.WithString("state", mcp.Description("")),
		mcp.WithString("target_type", mcp.Description("")),
		mcp.WithString("owner", mcp.Description("")),
		mcp.WithString("status", mcp.Description("")),
		mcp.WithObject("input", mcp.Description("")),
		mcp.WithString("name", mcp.Description("")),
		mcp.WithString("archived_at", mcp.Description("")),
		mcp.WithString("source_id", mcp.Description("Input parameter: ID of the resource")),
		mcp.WithString("type", mcp.Description("")),
	)

	return models.Tool{
		Definition: tool,
		Handler:    UpdatetaskHandler(cfg),
	}
}
