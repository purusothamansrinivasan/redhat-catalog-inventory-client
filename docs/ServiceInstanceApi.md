# ServiceInstanceApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listServiceInstances**](ServiceInstanceApi.md#listServiceInstances) | **GET** /service_instances | List ServiceInstances |
| [**showServiceInstance**](ServiceInstanceApi.md#showServiceInstance) | **GET** /service_instances/{id} | Show an existing ServiceInstance |


<a id="listServiceInstances"></a>
# **listServiceInstances**
> ServiceInstancesCollection listServiceInstances(limit, offset, filter, sortBy)

List ServiceInstances

Returns an array of ServiceInstance objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInstanceApi apiInstance = new ServiceInstanceApi(defaultClient);
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      ServiceInstancesCollection result = apiInstance.listServiceInstances(limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInstanceApi#listServiceInstances");
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

[**ServiceInstancesCollection**](ServiceInstancesCollection.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceInstances collection |  -  |

<a id="showServiceInstance"></a>
# **showServiceInstance**
> ServiceInstance showServiceInstance(id)

Show an existing ServiceInstance

Returns a ServiceInstance object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInstanceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInstanceApi apiInstance = new ServiceInstanceApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    try {
      ServiceInstance result = apiInstance.showServiceInstance(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInstanceApi#showServiceInstance");
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

[**ServiceInstance**](ServiceInstance.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceInstance info |  -  |
| **404** | Not found |  -  |

