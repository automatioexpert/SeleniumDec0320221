#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package driver;

import org.apache.commons.codec.binary.Base64;

public class BuilderMessages {

    public static String buildNetWorkEnableMessage(){
        String message = "{${symbol_escape}"id${symbol_escape}":1,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Network.enable${symbol_escape}",${symbol_escape}"params${symbol_escape}":{${symbol_escape}"maxTotalBufferSize${symbol_escape}":10000000,${symbol_escape}"maxResourceBufferSize${symbol_escape}":5000000}}";
        System.out.println(message);
        return message;
    }

    public static String buildGeoLocationMessage(String latitude, String longitude){
        String message = String.format("{${symbol_escape}"id${symbol_escape}":3,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Emulation.setGeolocationOverride${symbol_escape}",${symbol_escape}"params${symbol_escape}":{${symbol_escape}"latitude${symbol_escape}":%s,${symbol_escape}"longitude${symbol_escape}":%s,${symbol_escape}"accuracy${symbol_escape}":100}}",latitude,longitude);
        System.out.println(message);
        return message;
    }

    public static String buildRequestInterceptorEnabledMessage(){
        String message = String.format("{${symbol_escape}"id${symbol_escape}":4,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Network.setRequestInterceptionEnabled${symbol_escape}",${symbol_escape}"params${symbol_escape}":{${symbol_escape}"enabled${symbol_escape}":true}}");
        System.out.println(message);
        return message;
    }

    public static String buildRequestInterceptorPatternMessage(String pattern, String documentType){
        String message = String.format("{${symbol_escape}"id${symbol_escape}":5,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Network.setRequestInterception${symbol_escape}",${symbol_escape}"params${symbol_escape}":{${symbol_escape}"patterns${symbol_escape}":[{${symbol_escape}"urlPattern${symbol_escape}":${symbol_escape}"%s${symbol_escape}",${symbol_escape}"resourceType${symbol_escape}":${symbol_escape}"%s${symbol_escape}"}]}}",pattern,documentType);
        System.out.println(message);
        return message;
    }

    public static String buildBasicHttpAuthenticationMessage(String username,String password){
        byte[] encodedBytes = Base64.encodeBase64(String.format("%s:%s",username,password).getBytes());
        String base64EncodedCredentials = new String(encodedBytes);
        String message = String.format("{${symbol_escape}"id${symbol_escape}":2,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Network.setExtraHTTPHeaders${symbol_escape}",${symbol_escape}"params${symbol_escape}":{${symbol_escape}"headers${symbol_escape}":{${symbol_escape}"Authorization${symbol_escape}":${symbol_escape}"Basic %s${symbol_escape}"}}}",base64EncodedCredentials);
        System.out.println(message);
        return message;
    }

    public static String buildNetworkEmulationOffline(){
        String message = String.format("{${symbol_escape}"id${symbol_escape}": 7,${symbol_escape}"method${symbol_escape}": ${symbol_escape}"Network.emulateNetworkConditions${symbol_escape}",${symbol_escape}"params${symbol_escape}": {${symbol_escape}"offline${symbol_escape}": true,${symbol_escape}"latency${symbol_escape}": 10000,${symbol_escape}"downloadThroughput${symbol_escape}":1 ,${symbol_escape}"uploadThroughput${symbol_escape}": 1}}");
        System.out.println(message);
        return message;
    }

    public static String buildBrowserClose(){
        String message = String.format("{ ${symbol_escape}"id${symbol_escape}":8,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Browser.close${symbol_escape}"}");
        System.out.println(message);
        return message;
    }

    public static String buildBrowserCrash(){
        String message = String.format("{ ${symbol_escape}"id${symbol_escape}":8,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Browser.crash${symbol_escape}"}");
        System.out.println(message);
        return message;
    }

    public static String buildNetworksetBlockedURLs(){
        String message = String.format("{ ${symbol_escape}"id${symbol_escape}":8,${symbol_escape}"method${symbol_escape}":${symbol_escape}"Network.setBlockedURLs${symbol_escape}",${symbol_escape}"params${symbol_escape}": {${symbol_escape}"urls${symbol_escape}": [${symbol_escape}"*${symbol_escape}"]}}");
        System.out.println(message);
        return message;
    }
}


