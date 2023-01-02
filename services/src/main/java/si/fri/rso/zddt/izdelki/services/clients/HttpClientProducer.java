//package si.fri.rso.zddt.izdelki.services.clients;
//
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContexts;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.net.ssl.SSLContext;
//import javax.ws.rs.Produces;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//
//public class HttpClientProducer {
//
//    private static final int DEFAULT_POOL_MAX_CONNECTIONS = 5;
//
//    @Produces
//    @ApplicationScoped
//    public HttpClient httpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//
//        SSLContext sslContext = SSLContexts.custom()
//                .loadTrustMaterial(null, (certificate, authType) -> true)
//                .build();
//
//        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
//        Registry socketFactorRegistry = RegistryBuilder.create()
//                .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                .register("https", socketFactory)
//                .build();
//
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactorRegistry);
//        connectionManager.setMaxTotal(DEFAULT_POOL_MAX_CONNECTIONS);
//
//        return HttpClients.custom()
//                .setSSLContext(sslContext)
//                .setConnectionManager(connectionManager)
//                .build();
//    }
//}