

# Task


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**archivedAt** | **OffsetDateTime** |  |  [optional] [readonly] |
|**childTaskId** | **UUID** |  |  [optional] [readonly] |
|**completedAt** | **OffsetDateTime** |  |  [optional] |
|**controllerMessageId** | **UUID** |  |  [optional] [readonly] |
|**createdAt** | **OffsetDateTime** |  |  [optional] [readonly] |
|**id** | **UUID** | UUID of task |  [optional] [readonly] |
|**input** | **Object** |  |  [optional] [readonly] |
|**message** | **String** |  |  [optional] |
|**name** | **String** |  |  [optional] |
|**output** | **Object** |  |  [optional] |
|**owner** | **String** |  |  [optional] [readonly] |
|**sourceId** | **String** | ID of the resource |  [optional] [readonly] |
|**state** | [**StateEnum**](#StateEnum) |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  [optional] |
|**targetSourceRef** | **String** |  |  [optional] |
|**targetType** | **String** |  |  [optional] |
|**type** | **String** |  |  [optional] |
|**updatedAt** | **OffsetDateTime** |  |  [optional] [readonly] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| PENDING | &quot;pending&quot; |
| QUEUED | &quot;queued&quot; |
| RUNNING | &quot;running&quot; |
| TIMEDOUT | &quot;timedout&quot; |
| COMPLETED | &quot;completed&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| OK | &quot;ok&quot; |
| WARN | &quot;warn&quot; |
| UNCHANGED | &quot;unchanged&quot; |
| ERROR | &quot;error&quot; |



