package co.com.devco.demo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DemoRestControler {

    final static Logger log = LoggerFactory.getLogger(DemoRestControler.class);

    @Value("${aws.usr:default}")
    private String usr;

    @Value("${aws.pwd:defaultPwd}")
    private String pwd;

    @GetMapping("/secrets/{app}")
    public ResponseEntity<String> getUsersById(@PathVariable(value = "app") String appName) {
        try {
            String region = "us-east-1";
            String secretId = appName;

            //Consumo de spring config
            //TODO: Consumo como client

            //Consumo de SecretManager
            AWSCredentials credentials = new BasicAWSCredentials(usr, pwd);
            AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                    .withRegion(region)
                    .withCredentials(credentialsProvider)
                    .build();

            GetSecretValueRequest secretRequest = new GetSecretValueRequest().withSecretId(secretId);

            String secretResponse = client.getSecretValue(secretRequest).getSecretString();

            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SecretAWS secrets = objectMapper.readValue(secretResponse, SecretAWS.class);

            return ResponseEntity.ok().body("Los secretos son: " + secrets);

        }catch (Exception err){
            err.printStackTrace();
            return ResponseEntity.ok().body(err.getMessage() + "--- usr:" + usr + " pwd:" + pwd);
        }
    }
}