# ServiceInventoryApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listServiceInventories**](ServiceInventoryApi.md#listServiceInventories) | **GET** /service_inventories | List ServiceInventories |
| [**listServiceInventoryTags**](ServiceInventoryApi.md#listServiceInventoryTags) | **GET** /service_inventories/{id}/tags | List Tags for ServiceInventory |
| [**showServiceInventory**](ServiceInventoryApi.md#showServiceInventory) | **GET** /service_inventories/{id} | Show an existing ServiceInventory |
| [**tagServiceInventory**](ServiceInventoryApi.md#tagServiceInventory) | **POST** /service_inventories/{id}/tag | Tag a ServiceInventory |
| [**untagServiceInventory**](ServiceInventoryApi.md#untagServiceInventory) | **POST** /service_inventories/{id}/untag | Untag a ServiceInventory |


<a id="listServiceInventories"></a>
# **listServiceInventories**
> ServiceInventoriesCollection listServiceInventories(limit, offset, filter, sortBy)

List ServiceInventories

Returns an array of ServiceInventory objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInventoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInventoryApi apiInstance = new ServiceInventoryApi(defaultClient);
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      ServiceInventoriesCollection result = apiInstance.listServiceInventories(limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInventoryApi#listServiceInventories");
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

[**ServiceInventoriesCollection**](ServiceInventoriesCollection.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceInventories collection |  -  |

<a id="listServiceInventoryTags"></a>
# **listServiceInventoryTags**
> TagsCollection listServiceInventoryTags(id, limit, offset, filter, sortBy)

List Tags for ServiceInventory

Returns an array of Tag objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInventoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInventoryApi apiInstance = new ServiceInventoryApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      TagsCollection result = apiInstance.listServiceInventoryTags(id, limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInventoryApi#listServiceInventoryTags");
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
| **limit** | **Integer**| The numbers of items to return per page. | [optional] [default to 100] |
| **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] [default to 0] |
| **filter** | [**Object**](.md)| Filter for querying collections. | [optional] |
| **sortBy** | [**Object**](.md)| The list of attribute and order to sort the result set by. | [optional] |

### Return type

[**TagsCollection**](TagsCollection.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tags collection |  -  |
| **404** | Not found |  -  |

<a id="showServiceInventory"></a>
# **showServiceInventory**
> ServiceInventory showServiceInventory(id)

Show an existing ServiceInventory

Returns a ServiceInventory object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInventoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInventoryApi apiInstance = new ServiceInventoryApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    try {
      ServiceInventory result = apiInstance.showServiceInventory(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInventoryApi#showServiceInventory");
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

[**ServiceInventory**](ServiceInventory.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceInventory info |  -  |
| **404** | Not found |  -  |

<a id="tagServiceInventory"></a>
# **tagServiceInventory**
> List&lt;Tag&gt; tagServiceInventory(id, tag)

Tag a ServiceInventory

Tags a ServiceInventory object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInventoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInventoryApi apiInstance = new ServiceInventoryApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    List<Tag> tag = Arrays.asList(); // List<Tag> | Tag attributes to add
    try {
      List<Tag> result = apiInstance.tagServiceInventory(id, tag);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInventoryApi#tagServiceInventory");
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
| **tag** | [**List&lt;Tag&gt;**](Tag.md)| Tag attributes to add | |

### Return type

[**List&lt;Tag&gt;**](Tag.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | ServiceInventory tagged successful |  -  |
| **304** | Not modified |  -  |

<a id="untagServiceInventory"></a>
# **untagServiceInventory**
> untagServiceInventory(id, tag)

Untag a ServiceInventory

Untags a ServiceInventory object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceInventoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceInventoryApi apiInstance = new ServiceInventoryApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    List<Tag> tag = Arrays.asList(); // List<Tag> | Tag attributes to removed
    try {
      apiInstance.untagServiceInventory(id, tag);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceInventoryApi#untagServiceInventory");
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
| **tag** | [**List&lt;Tag&gt;**](Tag.md)| Tag attributes to removed | |

### Return type

null (empty response body)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | ServiceInventory untagged successfully |  -  |

