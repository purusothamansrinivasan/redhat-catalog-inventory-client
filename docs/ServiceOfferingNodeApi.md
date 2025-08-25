# ServiceOfferingNodeApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listServiceOfferingNodes**](ServiceOfferingNodeApi.md#listServiceOfferingNodes) | **GET** /service_offering_nodes | List ServiceOfferingNodes |
| [**showServiceOfferingNode**](ServiceOfferingNodeApi.md#showServiceOfferingNode) | **GET** /service_offering_nodes/{id} | Show an existing ServiceOfferingNode |


<a id="listServiceOfferingNodes"></a>
# **listServiceOfferingNodes**
> ServiceOfferingNodesCollection listServiceOfferingNodes(limit, offset, filter, sortBy)

List ServiceOfferingNodes

Returns an array of ServiceOfferingNode objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceOfferingNodeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceOfferingNodeApi apiInstance = new ServiceOfferingNodeApi(defaultClient);
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      ServiceOfferingNodesCollection result = apiInstance.listServiceOfferingNodes(limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceOfferingNodeApi#listServiceOfferingNodes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **limit** | **Integer**| The numbers of items to return per page. | [optional] [default to 100] |
| **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [default to 0] |
| **filter** | [**Object**](.md)| Filter for querying collections. | [optional] |
| **sortBy** | [**Object**](.md)| The list of attribute and order to sort the result set by. | [optional] |

### Return type

[**ServiceOfferingNodesCollection**](ServiceOfferingNodesCollection.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceOfferingNodes collection |  -  |

<a id="showServiceOfferingNode"></a>
# **showServiceOfferingNode**
> ServiceOfferingNode showServiceOfferingNode(id)

Show an existing ServiceOfferingNode

Returns a ServiceOfferingNode object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceOfferingNodeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceOfferingNodeApi apiInstance = new ServiceOfferingNodeApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    try {
      ServiceOfferingNode result = apiInstance.showServiceOfferingNode(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceOfferingNodeApi#showServiceOfferingNode");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| ID of the resource | |

### Return type

[**ServiceOfferingNode**](ServiceOfferingNode.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceOfferingNode info |  -  |
| **404** | Not found |  -  |

