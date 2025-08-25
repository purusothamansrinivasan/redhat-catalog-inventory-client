package main

import (
	"github.com/catalog-inventory/mcp-server/config"
	"github.com/catalog-inventory/mcp-server/models"
	tools_source "github.com/catalog-inventory/mcp-server/tools/source"
	tools_graphql "github.com/catalog-inventory/mcp-server/tools/graphql"
	tools_servicecredential "github.com/catalog-inventory/mcp-server/tools/servicecredential"
	tools_serviceoffering "github.com/catalog-inventory/mcp-server/tools/serviceoffering"
	tools_tags "github.com/catalog-inventory/mcp-server/tools/tags"
	tools_serviceinstance "github.com/catalog-inventory/mcp-server/tools/serviceinstance"
	tools_task "github.com/catalog-inventory/mcp-server/tools/task"
	tools_servicecredentialtype "github.com/catalog-inventory/mcp-server/tools/servicecredentialtype"
	tools_serviceplan "github.com/catalog-inventory/mcp-server/tools/serviceplan"
	tools_serviceinventory "github.com/catalog-inventory/mcp-server/tools/serviceinventory"
	tools_openapi_json "github.com/catalog-inventory/mcp-server/tools/openapi_json"
	tools_serviceofferingnode "github.com/catalog-inventory/mcp-server/tools/serviceofferingnode"
)

func GetAll(cfg *config.APIConfig) []models.Tool {
	return []models.Tool{
		tools_source.CreateListsourceserviceofferingnodesTool(cfg),
		tools_source.CreateListsourceserviceinventoriesTool(cfg),
		tools_source.CreateShowsourceTool(cfg),
		tools_source.CreateListsourceserviceinstancesTool(cfg),
		tools_source.CreateListsourcesTool(cfg),
		tools_graphql.CreatePostgraphqlTool(cfg),
		tools_servicecredential.CreateShowservicecredentialTool(cfg),
		tools_serviceoffering.CreateListserviceofferingserviceplansTool(cfg),
		tools_tags.CreateListtagsTool(cfg),
		tools_serviceinstance.CreateListserviceinstancesTool(cfg),
		tools_serviceoffering.CreateAppliedinventoriestagsforserviceofferingTool(cfg),
		tools_source.CreateIncrementalrefreshsourceTool(cfg),
		tools_source.CreateListsourceserviceplansTool(cfg),
		tools_task.CreateShowtaskTool(cfg),
		tools_task.CreateUpdatetaskTool(cfg),
		tools_servicecredentialtype.CreateListservicecredentialtypesTool(cfg),
		tools_servicecredentialtype.CreateShowservicecredentialtypeTool(cfg),
		tools_serviceoffering.CreateOrderserviceofferingTool(cfg),
		tools_serviceplan.CreateListserviceplansTool(cfg),
		tools_serviceinventory.CreateTagserviceinventoryTool(cfg),
		tools_serviceoffering.CreateShowserviceofferingTool(cfg),
		tools_openapi_json.CreateGetdocumentationTool(cfg),
		tools_serviceinventory.CreateShowserviceinventoryTool(cfg),
		tools_source.CreateListsourceserviceofferingsTool(cfg),
		tools_task.CreateListtasksTool(cfg),
		tools_source.CreateRefreshsourceTool(cfg),
		tools_source.CreateListsourcetasksTool(cfg),
		tools_servicecredential.CreateListservicecredentialsTool(cfg),
		tools_serviceofferingnode.CreateShowserviceofferingnodeTool(cfg),
		tools_serviceinventory.CreateListserviceinventoriesTool(cfg),
		tools_serviceoffering.CreateListserviceofferingsTool(cfg),
		tools_serviceinstance.CreateShowserviceinstanceTool(cfg),
		tools_serviceinventory.CreateUntagserviceinventoryTool(cfg),
		tools_serviceoffering.CreateListserviceofferingserviceofferingnodesTool(cfg),
		tools_serviceoffering.CreateListserviceofferingserviceinstancesTool(cfg),
		tools_serviceplan.CreateShowserviceplanTool(cfg),
		tools_serviceinventory.CreateListserviceinventorytagsTool(cfg),
		tools_serviceofferingnode.CreateListserviceofferingnodesTool(cfg),
	}
}
