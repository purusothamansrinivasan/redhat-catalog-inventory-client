# DefaultApi

All URIs are relative to *https://cloud.redhat.com//api/catalog-inventory/v1.0*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDocumentation**](DefaultApi.md#getDocumentation) | **GET** /openapi.json | Return this API document in JSON format |
| [**postGraphQL**](DefaultApi.md#postGraphQL) | **POST** /graphql | Perform a GraphQL Query |


<a id="getDocumentation"></a>
# **getDocumentation**
> Object getDocumentation()

Return this API document in JSON format

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      Object result = apiInstance.getDocumentation();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getDocumentation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The API document for this version of the API |  -  |

<a id="postGraphQL"></a>
# **postGraphQL**
> GraphQLResponse postGraphQL(graphQLRequest)

Perform a GraphQL Query

Performs a GraphQL Query

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://cloud.redhat.com//api/catalog-inventory/v1.0");
    
    // Configure HTTP basic authorization: UserSecurity
    HttpBasicAuth UserSecurity = (HttpBasicAuth) defaultClient.getAuthentication("UserSecurity");
    UserSecurity.setUsername("YOUR USERNAME");
    UserSecurity.setPassword("YOUR PASSWORD");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    GraphQLRequest graphQLRequest = new GraphQLRequest(); // GraphQLRequest | GraphQL Query Request
    try {
      GraphQLResponse result = apiInstance.postGraphQL(graphQLRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#postGraphQL");
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
| **graphQLRequest** | [**GraphQLRequest**](GraphQLRequest.md)| GraphQL Query Request | |

### Return type

[**GraphQLResponse**](GraphQLResponse.md)

### Authorization

[UserSecurity](../README.md#UserSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | GraphQL Query Response |  -  |

