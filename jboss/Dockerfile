FROM jboss/wildfly

COPY springConfigServer-0.0.2.war /opt/jboss/wildfly/standalone/deployments/springConfigServer.war
#ADD secretManagerApp-0.0.1.war /opt/jboss/wildfly/standalone/deployments/

ENV ENVIRONMENT=desarrollo

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin123. --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

EXPOSE 8080
EXPOSE 9990