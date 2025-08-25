# ServiceCredentialTypeApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listServiceCredentialTypes**](ServiceCredentialTypeApi.md#listServiceCredentialTypes) | **GET** /service_credential_types | List ServiceCredentialTypes |
| [**showServiceCredentialType**](ServiceCredentialTypeApi.md#showServiceCredentialType) | **GET** /service_credential_types/{id} | Show an existing ServiceCredentialType |


<a id="listServiceCredentialTypes"></a>
# **listServiceCredentialTypes**
> ServiceCredentialTypesCollection listServiceCredentialTypes(limit, offset, filter, sortBy)

List ServiceCredentialTypes

Returns an array of ServiceCredentialType objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceCredentialTypeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceCredentialTypeApi apiInstance = new ServiceCredentialTypeApi(defaultClient);
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      ServiceCredentialTypesCollection result = apiInstance.listServiceCredentialTypes(limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceCredentialTypeApi#listServiceCredentialTypes");
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

[**ServiceCredentialTypesCollection**](ServiceCredentialTypesCollection.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceCredentialTypes collection |  -  |

<a id="showServiceCredentialType"></a>
# **showServiceCredentialType**
> ServiceCredentialType showServiceCredentialType(id)

Show an existing ServiceCredentialType

Returns a ServiceCredentialType object

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ServiceCredentialTypeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    ServiceCredentialTypeApi apiInstance = new ServiceCredentialTypeApi(defaultClient);
    String id = "id_example"; // String | ID of the resource
    try {
      ServiceCredentialType result = apiInstance.showServiceCredentialType(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ServiceCredentialTypeApi#showServiceCredentialType");
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

[**ServiceCredentialType**](ServiceCredentialType.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | ServiceCredentialType info |  -  |
| **404** | Not found |  -  |

