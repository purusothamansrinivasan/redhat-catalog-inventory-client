package models

import (
	"context"
	"github.com/mark3labs/mcp-go/mcp"
)

type Tool struct {
	Definition mcp.Tool
	Handler    func(ctx context.Context, req mcp.CallToolRequest) (*mcp.CallToolResult, error)
}

// ServiceCredentialType represents the ServiceCredentialType schema from the OpenAPI specification
type ServiceCredentialType struct {
	Archived_at string `json:"archived_at,omitempty"`
	Kind string `json:"kind,omitempty"`
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Source_created_at string `json:"source_created_at,omitempty"`
	Source_deleted_at string `json:"source_deleted_at,omitempty"`
	Description string `json:"description,omitempty"`
	Namespace string `json:"namespace,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Created_at string `json:"created_at,omitempty"`
	Name string `json:"name,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Id string `json:"id,omitempty"` // ID of the resource
	Source_ref string `json:"source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
}

// TasksCollection represents the TasksCollection schema from the OpenAPI specification
type TasksCollection struct {
	Data []Task `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// ErrorNotFounderrorsinner represents the ErrorNotFounderrorsinner schema from the OpenAPI specification
type ErrorNotFounderrorsinner struct {
	Detail string `json:"detail,omitempty"`
	Status string `json:"status,omitempty"`
}

// ServiceOfferingNode represents the ServiceOfferingNode schema from the OpenAPI specification
type ServiceOfferingNode struct {
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Source_ref string `json:"source_ref,omitempty"`
	Root_service_offering_id string `json:"root_service_offering_id,omitempty"` // ID of the resource
	Extra map[string]interface{} `json:"extra,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Source_created_at string `json:"source_created_at,omitempty"`
	Source_updated_at string `json:"source_updated_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Service_inventory_id string `json:"service_inventory_id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Service_offering_id string `json:"service_offering_id,omitempty"` // ID of the resource
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Name string `json:"name,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
}

// FullRefreshPersisterTask represents the FullRefreshPersisterTask schema from the OpenAPI specification
type FullRefreshPersisterTask struct {
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
}

// ServiceCredentialTypesCollection represents the ServiceCredentialTypesCollection schema from the OpenAPI specification
type ServiceCredentialTypesCollection struct {
	Meta CollectionMetadata `json:"meta,omitempty"`
	Data []ServiceCredentialType `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
}

// Tag represents the Tag schema from the OpenAPI specification
type Tag struct {
	Tag string `json:"tag,omitempty"`
}

// ServiceInventory represents the ServiceInventory schema from the OpenAPI specification
type ServiceInventory struct {
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Description string `json:"description,omitempty"`
	Extra map[string]interface{} `json:"extra,omitempty"`
	Source_created_at string `json:"source_created_at,omitempty"`
	Source_ref string `json:"source_ref,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Source_updated_at string `json:"source_updated_at,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Name string `json:"name,omitempty"`
}

// IncrementalRefreshUploadTask represents the IncrementalRefreshUploadTask schema from the OpenAPI specification
type IncrementalRefreshUploadTask struct {
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
}

// FullRefreshUploadTask represents the FullRefreshUploadTask schema from the OpenAPI specification
type FullRefreshUploadTask struct {
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
}

// Task represents the Task schema from the OpenAPI specification
type Task struct {
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
}

// ErrorNotFound represents the ErrorNotFound schema from the OpenAPI specification
type ErrorNotFound struct {
	Errors []ErrorNotFounderrorsinner `json:"errors,omitempty"`
}

// ServiceInstancesCollection represents the ServiceInstancesCollection schema from the OpenAPI specification
type ServiceInstancesCollection struct {
	Data []ServiceInstance `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// GraphQLResponse represents the GraphQLResponse schema from the OpenAPI specification
type GraphQLResponse struct {
	Data map[string]interface{} `json:"data,omitempty"` // Results from the GraphQL query
	Errors []map[string]interface{} `json:"errors,omitempty"` // Errors resulting from the GraphQL query
}

// OrderParametersServiceOffering represents the OrderParametersServiceOffering schema from the OpenAPI specification
type OrderParametersServiceOffering struct {
	Service_parameters map[string]interface{} `json:"service_parameters,omitempty"` // JSON object with provisioning parameters
	Service_plan_id string `json:"service_plan_id,omitempty"` // ID of the resource
	Provider_control_parameters map[string]interface{} `json:"provider_control_parameters,omitempty"` // The provider specific parameters needed to provision this service. This might include namespaces, special keys
}

// CollectionMetadata represents the CollectionMetadata schema from the OpenAPI specification
type CollectionMetadata struct {
	Offset int `json:"offset,omitempty"`
	Count int `json:"count,omitempty"`
	Limit int `json:"limit,omitempty"`
}

// OrderParametersServicePlan represents the OrderParametersServicePlan schema from the OpenAPI specification
type OrderParametersServicePlan struct {
	Provider_control_parameters map[string]interface{} `json:"provider_control_parameters,omitempty"` // The provider specific parameters needed to provision this service. This might include namespaces, special keys
	Service_parameters map[string]interface{} `json:"service_parameters,omitempty"` // JSON object with provisioning parameters
}

// ServiceOffering represents the ServiceOffering schema from the OpenAPI specification
type ServiceOffering struct {
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Source_created_at string `json:"source_created_at,omitempty"`
	Source_ref string `json:"source_ref,omitempty"` // The native reference used by the Source to refer to this object
	Name string `json:"name,omitempty"`
	Service_inventory_id string `json:"service_inventory_id,omitempty"` // ID of the resource
	Documentation_url string `json:"documentation_url,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Extra map[string]interface{} `json:"extra,omitempty"` // Extra information about this object in JSON format
	Long_description string `json:"long_description,omitempty"`
	Distributor string `json:"distributor,omitempty"`
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Description string `json:"description,omitempty"`
	Display_name string `json:"display_name,omitempty"`
	Support_url string `json:"support_url,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Source_deleted_at string `json:"source_deleted_at,omitempty"`
}

// Source represents the Source schema from the OpenAPI specification
type Source struct {
	Info map[string]interface{} `json:"info,omitempty"`
	Previous_sha string `json:"previous_sha,omitempty"`
	Cloud_connector_id string `json:"cloud_connector_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Name string `json:"name,omitempty"`
	Availability_status string `json:"availability_status,omitempty"`
	Last_successful_refresh_at string `json:"last_successful_refresh_at,omitempty"`
	Refresh_task_id string `json:"refresh_task_id,omitempty"`
	Uid string `json:"uid,omitempty"`
	Refresh_started_at string `json:"refresh_started_at,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Last_available_at string `json:"last_available_at,omitempty"`
	Last_checked_at string `json:"last_checked_at,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Refresh_finished_at string `json:"refresh_finished_at,omitempty"`
	Previous_size int `json:"previous_size,omitempty"`
	Refresh_state string `json:"refresh_state,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Last_refresh_message string `json:"last_refresh_message,omitempty"`
	Availability_message string `json:"availability_message,omitempty"`
	Enabled bool `json:"enabled,omitempty"`
}

// ServiceInstance represents the ServiceInstance schema from the OpenAPI specification
type ServiceInstance struct {
	Source_deleted_at string `json:"source_deleted_at,omitempty"`
	Name string `json:"name,omitempty"`
	External_url string `json:"external_url,omitempty"`
	Service_inventory_id string `json:"service_inventory_id,omitempty"` // ID of the resource
	Source_created_at string `json:"source_created_at,omitempty"`
	Service_offering_id string `json:"service_offering_id,omitempty"` // ID of the resource
	Archived_at string `json:"archived_at,omitempty"`
	Extra map[string]interface{} `json:"extra,omitempty"` // Extra information about this object in JSON format
	Service_plan_id string `json:"service_plan_id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Source_ref string `json:"source_ref,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Root_service_instance_id string `json:"root_service_instance_id,omitempty"` // ID of the resource
	Id string `json:"id,omitempty"` // ID of the resource
}

// SourcesCollection represents the SourcesCollection schema from the OpenAPI specification
type SourcesCollection struct {
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
	Data []Source `json:"data,omitempty"`
}

// ServiceInventoriesCollection represents the ServiceInventoriesCollection schema from the OpenAPI specification
type ServiceInventoriesCollection struct {
	Data []ServiceInventory `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// ServiceCredential represents the ServiceCredential schema from the OpenAPI specification
type ServiceCredential struct {
	Description string `json:"description,omitempty"`
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Service_credential_type_id string `json:"service_credential_type_id,omitempty"` // ID of the resource
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Source_ref string `json:"source_ref,omitempty"`
	Source_updated_at string `json:"source_updated_at,omitempty"`
	Type_name string `json:"type_name,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Name string `json:"name,omitempty"`
	Source_created_at string `json:"source_created_at,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
}

// ServiceInstanceNodesCollection represents the ServiceInstanceNodesCollection schema from the OpenAPI specification
type ServiceInstanceNodesCollection struct {
	Data []ServiceInstanceNode `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// ServiceCredentialsCollection represents the ServiceCredentialsCollection schema from the OpenAPI specification
type ServiceCredentialsCollection struct {
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
	Data []ServiceCredential `json:"data,omitempty"`
}

// AppliedInventoriesParametersServicePlan represents the AppliedInventoriesParametersServicePlan schema from the OpenAPI specification
type AppliedInventoriesParametersServicePlan struct {
	Service_parameters map[string]interface{} `json:"service_parameters,omitempty"` // The provider specific parameters needed to compute list of used service inventories
}

// ServiceOfferingIcon represents the ServiceOfferingIcon schema from the OpenAPI specification
type ServiceOfferingIcon struct {
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Archived_at string `json:"archived_at,omitempty"`
	Source_ref string `json:"source_ref,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Data string `json:"data,omitempty"` // Raw icon data
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
}

// ServiceOfferingIconsCollection represents the ServiceOfferingIconsCollection schema from the OpenAPI specification
type ServiceOfferingIconsCollection struct {
	Data []ServiceOfferingIcon `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// GraphQLRequest represents the GraphQLRequest schema from the OpenAPI specification
type GraphQLRequest struct {
	Operationname string `json:"operationName,omitempty"` // If the Query contains several named operations, the operationName controls which one should be executed
	Query string `json:"query"` // The GraphQL query
	Variables map[string]interface{} `json:"variables,omitempty"` // Optional Query variables
}

// ServiceInstanceNode represents the ServiceInstanceNode schema from the OpenAPI specification
type ServiceInstanceNode struct {
	Extra map[string]interface{} `json:"extra,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Name string `json:"name,omitempty"`
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Service_inventory_id string `json:"service_inventory_id,omitempty"` // ID of the resource
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Service_instance_id string `json:"service_instance_id,omitempty"` // ID of the resource
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Source_ref string `json:"source_ref,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Created_at string `json:"created_at,omitempty"`
	Root_service_instance_id string `json:"root_service_instance_id,omitempty"` // ID of the resource
	Source_created_at string `json:"source_created_at,omitempty"`
	Source_updated_at string `json:"source_updated_at,omitempty"`
}

// OrderServiceOffering200response represents the OrderServiceOffering200response schema from the OpenAPI specification
type OrderServiceOffering200response struct {
	Task_id string `json:"task_id,omitempty"`
}

// TagsCollection represents the TagsCollection schema from the OpenAPI specification
type TagsCollection struct {
	Data []Tag `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// ServiceOfferingsCollection represents the ServiceOfferingsCollection schema from the OpenAPI specification
type ServiceOfferingsCollection struct {
	Data []ServiceOffering `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// CollectionLinks represents the CollectionLinks schema from the OpenAPI specification
type CollectionLinks struct {
	Last string `json:"last,omitempty"`
	Next string `json:"next,omitempty"`
	Prev string `json:"prev,omitempty"`
	First string `json:"first,omitempty"`
}

// Tenant represents the Tenant schema from the OpenAPI specification
type Tenant struct {
	External_tenant string `json:"external_tenant,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Name string `json:"name,omitempty"`
	Description string `json:"description,omitempty"`
}

// ServicePlansCollection represents the ServicePlansCollection schema from the OpenAPI specification
type ServicePlansCollection struct {
	Data []ServicePlan `json:"data,omitempty"`
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
}

// TowingTask represents the TowingTask schema from the OpenAPI specification
type TowingTask struct {
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
}

// LaunchJobTask represents the LaunchJobTask schema from the OpenAPI specification
type LaunchJobTask struct {
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
}

// CheckAvailabilityTask represents the CheckAvailabilityTask schema from the OpenAPI specification
type CheckAvailabilityTask struct {
	Completed_at string `json:"completed_at,omitempty"`
	Message string `json:"message,omitempty"`
	Id string `json:"id,omitempty"` // UUID of task
	Output map[string]interface{} `json:"output,omitempty"`
	Controller_message_id string `json:"controller_message_id,omitempty"`
	Target_source_ref string `json:"target_source_ref,omitempty"`
	Updated_at string `json:"updated_at,omitempty"`
	Child_task_id string `json:"child_task_id,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	State string `json:"state,omitempty"`
	Target_type string `json:"target_type,omitempty"`
	Owner string `json:"owner,omitempty"`
	Status string `json:"status,omitempty"`
	Input map[string]interface{} `json:"input,omitempty"`
	Name string `json:"name,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	TypeField string `json:"type,omitempty"`
}

// ServiceOfferingNodesCollection represents the ServiceOfferingNodesCollection schema from the OpenAPI specification
type ServiceOfferingNodesCollection struct {
	Links CollectionLinks `json:"links,omitempty"`
	Meta CollectionMetadata `json:"meta,omitempty"`
	Data []ServiceOfferingNode `json:"data,omitempty"`
}

// ServicePlan represents the ServicePlan schema from the OpenAPI specification
type ServicePlan struct {
	Description string `json:"description,omitempty"`
	Extra map[string]interface{} `json:"extra,omitempty"` // Extra information about this object in JSON format
	Source_id string `json:"source_id,omitempty"` // ID of the resource
	Refresh_state_part_id string `json:"refresh_state_part_id,omitempty"` // ID of the resource
	Updated_at string `json:"updated_at,omitempty"`
	Created_at string `json:"created_at,omitempty"`
	Archived_at string `json:"archived_at,omitempty"`
	Resource_version string `json:"resource_version,omitempty"`
	Source_ref string `json:"source_ref,omitempty"`
	Source_deleted_at string `json:"source_deleted_at,omitempty"`
	Service_offering_id string `json:"service_offering_id,omitempty"` // ID of the resource
	Create_json_schema map[string]interface{} `json:"create_json_schema,omitempty"`
	Last_seen_at string `json:"last_seen_at,omitempty"`
	Name string `json:"name,omitempty"`
	Source_created_at string `json:"source_created_at,omitempty"`
	Id string `json:"id,omitempty"` // ID of the resource
	Update_json_schema string `json:"update_json_schema,omitempty"`
}
