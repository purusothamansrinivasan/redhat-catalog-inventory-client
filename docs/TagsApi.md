# TagsApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listTags**](TagsApi.md#listTags) | **GET** /tags | List Tags |


<a id="listTags"></a>
# **listTags**
> TagsCollection listTags(limit, offset, filter, sortBy)

List Tags

Returns an array of Tag objects

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TagsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    TagsApi apiInstance = new TagsApi(defaultClient);
    Integer limit = 100; // Integer | The numbers of items to return per page.
    Integer offset = 0; // Integer | The number of items to skip before starting to collect the result set.
    Object filter = null; // Object | Filter for querying collections.
    Object sortBy = null; // Object | The list of attribute and order to sort the result set by.
    try {
      TagsCollection result = apiInstance.listTags(limit, offset, filter, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TagsApi#listTags");
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

