package co.com.devco.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@RestController
@RequestMapping("/api/v1")
public class DemoRestControler {

    final static Logger log = LoggerFactory.getLogger(DemoRestControler.class);

    @Value("${aws.usr}")
    private String usr;

    @Value("${aws.pwd}")
    private String pwd;

    @GetMapping("/secrets/{app}")
    public ResponseEntity<String> getUsersById(@PathVariable(value = "app") String appName) {
        try {
            String region = "us-west-2";
            String secretId = "webapp-cercania/secrets";

            BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(usr, pwd);

            ClientConfiguration clientConfiguration = new ClientConfiguration();

            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                    .withRegion(region)
                    .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                    .withClientConfiguration(clientConfiguration)
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