#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package driver;

import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocket;
import com.sun.media.jfxmedia.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ChromeDevTools {

    public static String getDebuggerAddressUrl() throws FileNotFoundException {
        String urlString = "";
        File file = new File(System.getProperty("user.dir") + "/target/chromedriver.log");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.contains("debuggerAddress")){
                urlString = "http://" + line.substring(line.indexOf("localhost"),line.length()-1 );
                break;
            }
        }
        sc.close();
        return urlString;
    }

    public static int getWebSocketDebuggerPort() throws FileNotFoundException {
        String url = getDebuggerAddressUrl();
        int port = Integer.parseInt(url.substring(url.lastIndexOf(":")+1));
        return port;
    }

    public static String getWebSocketDebuggerUrl() throws IOException {
        util.printCurrentThread();
        String webSocketDebuggerUrl = "";
        try
        {
            URL url = new URL(getDebuggerAddressUrl()+"/json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String json = org.apache.commons.io.IOUtils.toString(reader);
            JSONArray jsonArray = new JSONArray(json);
            System.out.println(jsonArray);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if(jsonObject.getString("type").equals("page")){
                    webSocketDebuggerUrl = jsonObject.getString("webSocketDebuggerUrl");
                    System.out.println("webSocketDebuggerUrl: " + webSocketDebuggerUrl);
                    break;
                }
            }
        }
        catch (FileNotFoundException e) {
            throw e;
        }
        if(webSocketDebuggerUrl.equals(""))
            throw new RuntimeException("webSocketDebuggerUrl not found");
        return webSocketDebuggerUrl;
    }

    public static String getIdWebSocketDebugger() throws IOException {
        String url = getWebSocketDebuggerUrl();
        return url.substring(url.lastIndexOf("/"));
    }

    public static void sendWSMessage(String url,String message, int messageTimeoutInSecs) throws IOException, WebSocketException, InterruptedException {
        util.printCurrentThread();
        WebSocket ws = null;
        final Object waitCoordinator =  new Object();
        JSONObject jsonObject = new JSONObject(message);
        final int messageId = jsonObject.getInt("id");
        if(ws==null){
            ws = new WebSocketFactory()
                    .createSocket(url)
                    .addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket ws, String message) {
                            System.out.println(message);
                            if(new JSONObject(message).getString("method").equals("Network.requestIntercepted   ")){
                                System.out.println("found");
                            }
                            // Received a response. Print the received message.
                            if(new JSONObject(message).getInt("id")==messageId){
                                synchronized (waitCoordinator) {
                                    waitCoordinator.notifyAll();
                                }
                            }
                        }
                    })
                    .connect();
        }
        ws.sendText(message);
        synchronized (waitCoordinator) {
            waitCoordinator.wait(messageTimeoutInSecs*1000);
        }
    }

    public static void sendWSMessage(String url,String message) throws IOException, WebSocketException, InterruptedException {
        util.printCurrentThread();
        WebSocket ws = null;
        final Object waitCoordinator =  new Object();
        JSONObject jsonObject = new JSONObject(message);
        final int messageId = jsonObject.getInt("id");
        ws = new WebSocketFactory()
                .createSocket(url)
                .addListener(new WebSocketAdapter() {
                    @Override
                    public void onTextMessage(WebSocket ws, String message) {
                        System.out.println(message);
                        if(new JSONObject(message).getString("method").equals("Network.requestIntercepted   ")){
                            System.out.println("found");
                        }
                        // Received a response. Print the received message.
                        if(new JSONObject(message).getInt("id")==messageId){
                            synchronized (waitCoordinator) {
                                waitCoordinator.notifyAll();
                            }
                        }
                    }
                })
                .connect();
        ws.sendText(message);
        synchronized (waitCoordinator) {
            waitCoordinator.wait(5*1000);
        }
    }

    public static void sendWSMessage(String message) throws IOException, WebSocketException, InterruptedException {
        util.printCurrentThread();
        WebSocket ws = null;
        final Object waitCoordinator =  new Object();
        JSONObject jsonObject = new JSONObject(message);
        final int messageId = jsonObject.getInt("id");
        ws = new WebSocketFactory()
                .createSocket(getWebSocketDebuggerUrl())
                .addListener(new WebSocketAdapter() {
                    @Override
                    public void onTextMessage(WebSocket ws, String message) {
                        System.out.println(message);
                        if(new JSONObject(message).getString("method").equals("Network.requestIntercepted   ")){
                            System.out.println("found");
                        }
                        // Received a response. Print the received message.
                        if(new JSONObject(message).getInt("id")==messageId){
                            synchronized (waitCoordinator) {
                                waitCoordinator.notifyAll();
                            }
                        }
                    }
                })
                .connect();
        ws.sendText(message);
        synchronized (waitCoordinator) {
            waitCoordinator.wait(3*1000);
        }
    }

    private void waitFor(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
