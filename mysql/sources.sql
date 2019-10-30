CREATE DATABASE secrets;
USE secrets;
CREATE TABLE IF NOT EXISTS PROPERTIES (
  KY         VARCHAR(300),
  VALUE       VARCHAR(300),
  APPLICATION VARCHAR(128),
  PROFILE     VARCHAR(128),
  LABEL       VARCHAR(128),
  PRIMARY KEY (`KY`, `APPLICATION`, `PROFILE`, `LABEL`)
);
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KY, VALUE)
VALUES ('demo', 'default', 'master', 'app.greet.name', 'Demo');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KY, VALUE)
VALUES ('config-client', 'desarrollo', 'master', 'aws.usr', 'Demo');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KY, VALUE)
VALUES ('config-client', 'desarrollo', 'master', 'aws.pwd', 'DemoPwd');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KY, VALUE)
VALUES ('config-client', 'produccion', 'master', 'aws.usr', 'DemoProd');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KY, VALUE)
VALUES ('config-client', 'produccion', 'master', 'aws.pwd', 'DemoPwdProd');