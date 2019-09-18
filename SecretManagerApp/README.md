Consumo
```
curl http://localhost:8080/api/v1/secrets/pruebaMS

// Con el API-GATEWAY privado
curl -v https://vpce-0e470c117bd804edb-xwi82qkh.execute-api.us-west-2.vpce.amazonaws.com/test?aplicacion=pruebaMS -H 'Host: zagwumog8k.execute-api.us-west-2.amazonaws.com' -H 'Origin: desarrollo.com.pe'

// Con el API_GATEAY publico
curl -i -H "Origin: d5g2ho0d97.desarrollo.us-west-2.amazonaws.com" "https://d5g2ho0d97.execute-api.us-west-2.amazonaws.com/default/secretManagerPoc?aplicacion=pruebaMS"
```


ejecutar
```
gradle bootRun

java -jar demoSecretManager-0.0.1-SNAPSHOT.jar &
```

subir archivo
```
scp -i "~/develop/awsKeys/secretManagerPocKey.pem" build/libs/demoSecretManager-0.0.3-SNAPSHOT.jar ec2-user@34.220.145.210:~/app/
```